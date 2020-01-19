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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "oprema")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Oprema.findAll", query = "SELECT o FROM Oprema o")
    , @NamedQuery(name = "Oprema.findByOpremaId", query = "SELECT o FROM Oprema o WHERE o.opremaId = :opremaId")
    , @NamedQuery(name = "Oprema.findByNazivOpreme", query = "SELECT o FROM Oprema o WHERE o.nazivOpreme = :nazivOpreme")
    , @NamedQuery(name = "Oprema.findByAlimsresenjebroj", query = "SELECT o FROM Oprema o WHERE o.alimsresenjebroj = :alimsresenjebroj")
    , @NamedQuery(name = "Oprema.findBySerijskiBroj", query = "SELECT o FROM Oprema o WHERE o.serijskiBroj = :serijskiBroj")
    , @NamedQuery(name = "Oprema.findByLager", query = "SELECT o FROM Oprema o WHERE o.lager = :lager")})
public class Oprema implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "oprema_id")
    private Integer opremaId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "naziv_opreme")
    private String nazivOpreme;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "Alims_resenje_broj")
    private String alimsresenjebroj;
    @Size(max = 50)
    @Column(name = "serijski_broj")
    private String serijskiBroj;
    @Column(name = "lager")
    private Integer lager;
    @JoinColumn(name = "tip_opreme", referencedColumnName = "tip_id")
    @ManyToOne(optional = false)
    private TipOpreme tipOpreme;
    @JoinColumn(name = "proizvodjac_id", referencedColumnName = "proizvodjac_id")
    @ManyToOne(optional = false)
    private Proizvodjac proizvodjacId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "opremaId")
    private List<TenderOprema> tenderOpremaList;

    public Oprema() {
    }

    public Oprema(Integer opremaId) {
        this.opremaId = opremaId;
    }

    public Oprema(Integer opremaId, String nazivOpreme, String alimsresenjebroj) {
        this.opremaId = opremaId;
        this.nazivOpreme = nazivOpreme;
        this.alimsresenjebroj = alimsresenjebroj;
    }

    public Integer getOpremaId() {
        return opremaId;
    }

    public void setOpremaId(Integer opremaId) {
        this.opremaId = opremaId;
    }

    public String getNazivOpreme() {
        return nazivOpreme;
    }

    public void setNazivOpreme(String nazivOpreme) {
        this.nazivOpreme = nazivOpreme;
    }

    public String getAlimsresenjebroj() {
        return alimsresenjebroj;
    }

    public void setAlimsresenjebroj(String alimsresenjebroj) {
        this.alimsresenjebroj = alimsresenjebroj;
    }

    public String getSerijskiBroj() {
        return serijskiBroj;
    }

    public void setSerijskiBroj(String serijskiBroj) {
        this.serijskiBroj = serijskiBroj;
    }

    public Integer getLager() {
        return lager;
    }

    public void setLager(Integer lager) {
        this.lager = lager;
    }

    public TipOpreme getTipOpreme() {
        return tipOpreme;
    }

    public void setTipOpreme(TipOpreme tipOpreme) {
        this.tipOpreme = tipOpreme;
    }

    public Proizvodjac getProizvodjacId() {
        return proizvodjacId;
    }

    public void setProizvodjacId(Proizvodjac proizvodjacId) {
        this.proizvodjacId = proizvodjacId;
    }

    @XmlTransient
    public List<TenderOprema> getTenderOpremaList() {
        return tenderOpremaList;
    }

    public void setTenderOpremaList(List<TenderOprema> tenderOpremaList) {
        this.tenderOpremaList = tenderOpremaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (opremaId != null ? opremaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Oprema)) {
            return false;
        }
        Oprema other = (Oprema) object;
        if ((this.opremaId == null && other.opremaId != null) || (this.opremaId != null && !this.opremaId.equals(other.opremaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.tenderplus.entities.Oprema[ opremaId=" + opremaId + " ]";
    }
    
}
