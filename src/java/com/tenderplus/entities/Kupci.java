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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Milly2
 */
@Entity
@Table(name = "kupci")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Kupci.findAll", query = "SELECT k FROM Kupci k")
    , @NamedQuery(name = "Kupci.findByKupacId", query = "SELECT k FROM Kupci k WHERE k.kupacId = :kupacId")
    , @NamedQuery(name = "Kupci.findByNazivKupca", query = "SELECT k FROM Kupci k WHERE k.nazivKupca = :nazivKupca")
    , @NamedQuery(name = "Kupci.findByPibKupca", query = "SELECT k FROM Kupci k WHERE k.pibKupca = :pibKupca")
    , @NamedQuery(name = "Kupci.findByTracunKupca", query = "SELECT k FROM Kupci k WHERE k.tracunKupca = :tracunKupca")
    , @NamedQuery(name = "Kupci.findByOdgovornoLice", query = "SELECT k FROM Kupci k WHERE k.odgovornoLice = :odgovornoLice")})
public class Kupci implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "kupac_id")
    private Integer kupacId;
    @Size(max = 50)
    @Column(name = "naziv_kupca")
    private String nazivKupca;
    @Size(max = 30)
    @Column(name = "pib_kupca")
    private String pibKupca;
    @Size(max = 20)
    @Column(name = "tracun_kupca")
    private String tracunKupca;
    @Size(max = 30)
    @Column(name = "odgovorno_lice")
    private String odgovornoLice;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "kupacId")
    private List<Servis> servisList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "kupciId")
    private List<Tenderi> tenderiList;

    public Kupci() {
    }

    public Kupci(Integer kupacId) {
        this.kupacId = kupacId;
    }

    public Integer getKupacId() {
        return kupacId;
    }

    public void setKupacId(Integer kupacId) {
        this.kupacId = kupacId;
    }

    public String getNazivKupca() {
        return nazivKupca;
    }

    public void setNazivKupca(String nazivKupca) {
        this.nazivKupca = nazivKupca;
    }

    public String getPibKupca() {
        return pibKupca;
    }

    public void setPibKupca(String pibKupca) {
        this.pibKupca = pibKupca;
    }

    public String getTracunKupca() {
        return tracunKupca;
    }

    public void setTracunKupca(String tracunKupca) {
        this.tracunKupca = tracunKupca;
    }

    public String getOdgovornoLice() {
        return odgovornoLice;
    }

    public void setOdgovornoLice(String odgovornoLice) {
        this.odgovornoLice = odgovornoLice;
    }

    @XmlTransient
    public List<Servis> getServisList() {
        return servisList;
    }

    public void setServisList(List<Servis> servisList) {
        this.servisList = servisList;
    }

    @XmlTransient
    public List<Tenderi> getTenderiList() {
        return tenderiList;
    }

    public void setTenderiList(List<Tenderi> tenderiList) {
        this.tenderiList = tenderiList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (kupacId != null ? kupacId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Kupci)) {
            return false;
        }
        Kupci other = (Kupci) object;
        if ((this.kupacId == null && other.kupacId != null) || (this.kupacId != null && !this.kupacId.equals(other.kupacId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.tenderplus.entities.Kupci[ kupacId=" + kupacId + " ]";
    }
    
}
