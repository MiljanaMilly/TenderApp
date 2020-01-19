/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tenderplus.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Milly2
 */
@Entity
@Table(name = "tender_delovi")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TenderDelovi.findAll", query = "SELECT t FROM TenderDelovi t")
    , @NamedQuery(name = "TenderDelovi.findByTenderDeloviId", query = "SELECT t FROM TenderDelovi t WHERE t.tenderDeloviId = :tenderDeloviId")})
public class TenderDelovi implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "tender_delovi_id")
    private Integer tenderDeloviId;
    @JoinColumn(name = "tender_id", referencedColumnName = "tenderi_id")
    @ManyToOne(optional = false)
    private Tenderi tenderId;
    @JoinColumn(name = "delovi_id", referencedColumnName = "delovi_id")
    @ManyToOne(optional = false)
    private Delovi deloviId;

    public TenderDelovi() {
    }

    public TenderDelovi(Integer tenderDeloviId) {
        this.tenderDeloviId = tenderDeloviId;
    }

    public Integer getTenderDeloviId() {
        return tenderDeloviId;
    }

    public void setTenderDeloviId(Integer tenderDeloviId) {
        this.tenderDeloviId = tenderDeloviId;
    }

    public Tenderi getTenderId() {
        return tenderId;
    }

    public void setTenderId(Tenderi tenderId) {
        this.tenderId = tenderId;
    }

    public Delovi getDeloviId() {
        return deloviId;
    }

    public void setDeloviId(Delovi deloviId) {
        this.deloviId = deloviId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tenderDeloviId != null ? tenderDeloviId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TenderDelovi)) {
            return false;
        }
        TenderDelovi other = (TenderDelovi) object;
        if ((this.tenderDeloviId == null && other.tenderDeloviId != null) || (this.tenderDeloviId != null && !this.tenderDeloviId.equals(other.tenderDeloviId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.tenderplus.entities.TenderDelovi[ tenderDeloviId=" + tenderDeloviId + " ]";
    }
    
}
