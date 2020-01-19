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
@Table(name = "tender_potrosni_materijal")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TenderPotrosniMaterijal.findAll", query = "SELECT t FROM TenderPotrosniMaterijal t")
    , @NamedQuery(name = "TenderPotrosniMaterijal.findByTenderPotrosniId", query = "SELECT t FROM TenderPotrosniMaterijal t WHERE t.tenderPotrosniId = :tenderPotrosniId")})
public class TenderPotrosniMaterijal implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "tender_potrosni_id")
    private Integer tenderPotrosniId;
    @JoinColumn(name = "tender_id", referencedColumnName = "tenderi_id")
    @ManyToOne(optional = false)
    private Tenderi tenderId;
    @JoinColumn(name = "potrosni_id", referencedColumnName = "potrosni_id")
    @ManyToOne(optional = false)
    private PotrosniMaterijal potrosniId;

    public TenderPotrosniMaterijal() {
    }

    public TenderPotrosniMaterijal(Integer tenderPotrosniId) {
        this.tenderPotrosniId = tenderPotrosniId;
    }

    public Integer getTenderPotrosniId() {
        return tenderPotrosniId;
    }

    public void setTenderPotrosniId(Integer tenderPotrosniId) {
        this.tenderPotrosniId = tenderPotrosniId;
    }

    public Tenderi getTenderId() {
        return tenderId;
    }

    public void setTenderId(Tenderi tenderId) {
        this.tenderId = tenderId;
    }

    public PotrosniMaterijal getPotrosniId() {
        return potrosniId;
    }

    public void setPotrosniId(PotrosniMaterijal potrosniId) {
        this.potrosniId = potrosniId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tenderPotrosniId != null ? tenderPotrosniId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TenderPotrosniMaterijal)) {
            return false;
        }
        TenderPotrosniMaterijal other = (TenderPotrosniMaterijal) object;
        if ((this.tenderPotrosniId == null && other.tenderPotrosniId != null) || (this.tenderPotrosniId != null && !this.tenderPotrosniId.equals(other.tenderPotrosniId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.tenderplus.entities.TenderPotrosniMaterijal[ tenderPotrosniId=" + tenderPotrosniId + " ]";
    }
    
}
