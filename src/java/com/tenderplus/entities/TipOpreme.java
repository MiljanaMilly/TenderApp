/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tenderplus.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Milly2
 */
@Entity
@Table(name = "tip_opreme")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipOpreme.findAll", query = "SELECT t FROM TipOpreme t")
    , @NamedQuery(name = "TipOpreme.findByTipId", query = "SELECT t FROM TipOpreme t WHERE t.tipId = :tipId")
    , @NamedQuery(name = "TipOpreme.findByTipOpreme", query = "SELECT t FROM TipOpreme t WHERE t.tipOpreme = :tipOpreme")})
public class TipOpreme implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "tip_id")
    private Integer tipId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "tip_opreme")
    private String tipOpreme;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipOpreme")
    private List<Oprema> opremaList;

    public TipOpreme() {
    }

    public TipOpreme(Integer tipId) {
        this.tipId = tipId;
    }

    public TipOpreme(Integer tipId, String tipOpreme) {
        this.tipId = tipId;
        this.tipOpreme = tipOpreme;
    }

    public Integer getTipId() {
        return tipId;
    }

    public void setTipId(Integer tipId) {
        this.tipId = tipId;
    }

    public String getTipOpreme() {
        return tipOpreme;
    }

    public void setTipOpreme(String tipOpreme) {
        this.tipOpreme = tipOpreme;
    }

    @XmlTransient
    public List<Oprema> getOpremaList() {
        return opremaList;
    }

    public void setOpremaList(List<Oprema> opremaList) {
        this.opremaList = opremaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tipId != null ? tipId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipOpreme)) {
            return false;
        }
        TipOpreme other = (TipOpreme) object;
        if ((this.tipId == null && other.tipId != null) || (this.tipId != null && !this.tipId.equals(other.tipId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return tipOpreme;
    }
    
}
