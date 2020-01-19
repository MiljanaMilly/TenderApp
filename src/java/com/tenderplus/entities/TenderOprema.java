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
@Table(name = "tender_oprema")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TenderOprema.findAll", query = "SELECT t FROM TenderOprema t")
    , @NamedQuery(name = "TenderOprema.findByTenderOpremaId", query = "SELECT t FROM TenderOprema t WHERE t.tenderOpremaId = :tenderOpremaId")})
public class TenderOprema implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "tender_oprema_id")
    private Integer tenderOpremaId;
    @JoinColumn(name = "tender_id", referencedColumnName = "tenderi_id")
    @ManyToOne(optional = false)
    private Tenderi tenderId;
    @JoinColumn(name = "oprema_id", referencedColumnName = "oprema_id")
    @ManyToOne(optional = false)
    private Oprema opremaId;

    public TenderOprema() {
    }

    public TenderOprema(Integer tenderOpremaId) {
        this.tenderOpremaId = tenderOpremaId;
    }

    public Integer getTenderOpremaId() {
        return tenderOpremaId;
    }

    public void setTenderOpremaId(Integer tenderOpremaId) {
        this.tenderOpremaId = tenderOpremaId;
    }

    public Tenderi getTenderId() {
        return tenderId;
    }

    public void setTenderId(Tenderi tenderId) {
        this.tenderId = tenderId;
    }

    public Oprema getOpremaId() {
        return opremaId;
    }

    public void setOpremaId(Oprema opremaId) {
        this.opremaId = opremaId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tenderOpremaId != null ? tenderOpremaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TenderOprema)) {
            return false;
        }
        TenderOprema other = (TenderOprema) object;
        if ((this.tenderOpremaId == null && other.tenderOpremaId != null) || (this.tenderOpremaId != null && !this.tenderOpremaId.equals(other.tenderOpremaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.tenderplus.entities.TenderOprema[ tenderOpremaId=" + tenderOpremaId + " ]";
    }
    
}
