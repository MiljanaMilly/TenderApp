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
@Table(name = "proizvodjac")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Proizvodjac.findAll", query = "SELECT p FROM Proizvodjac p")
    , @NamedQuery(name = "Proizvodjac.findByProizvodjacId", query = "SELECT p FROM Proizvodjac p WHERE p.proizvodjacId = :proizvodjacId")
    , @NamedQuery(name = "Proizvodjac.findByNazivProizvodjaca", query = "SELECT p FROM Proizvodjac p WHERE p.nazivProizvodjaca = :nazivProizvodjaca")
    , @NamedQuery(name = "Proizvodjac.findByPibProizvodjaca", query = "SELECT p FROM Proizvodjac p WHERE p.pibProizvodjaca = :pibProizvodjaca")
    , @NamedQuery(name = "Proizvodjac.findByTracunProizvodjaca", query = "SELECT p FROM Proizvodjac p WHERE p.tracunProizvodjaca = :tracunProizvodjaca")
    , @NamedQuery(name = "Proizvodjac.findByDrzavaProizvodjaca", query = "SELECT p FROM Proizvodjac p WHERE p.drzavaProizvodjaca = :drzavaProizvodjaca")})
public class Proizvodjac implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "proizvodjac_id")
    private Integer proizvodjacId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "naziv_proizvodjaca")
    private String nazivProizvodjaca;
    @Size(max = 50)
    @Column(name = "pib_proizvodjaca")
    private String pibProizvodjaca;
    @Size(max = 50)
    @Column(name = "tracun_proizvodjaca")
    private String tracunProizvodjaca;
    @Size(max = 50)
    @Column(name = "drzava_proizvodjaca")
    private String drzavaProizvodjaca;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "proizvodjacId")
    private List<Oprema> opremaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "proizvodjacId")
    private List<Delovi> deloviList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "proizvodjacId")
    private List<PotrosniMaterijal> potrosniMaterijalList;

    public Proizvodjac() {
    }

    public Proizvodjac(Integer proizvodjacId) {
        this.proizvodjacId = proizvodjacId;
    }

    public Proizvodjac(Integer proizvodjacId, String nazivProizvodjaca) {
        this.proizvodjacId = proizvodjacId;
        this.nazivProizvodjaca = nazivProizvodjaca;
    }

    public Integer getProizvodjacId() {
        return proizvodjacId;
    }

    public void setProizvodjacId(Integer proizvodjacId) {
        this.proizvodjacId = proizvodjacId;
    }

    public String getNazivProizvodjaca() {
        return nazivProizvodjaca;
    }

    public void setNazivProizvodjaca(String nazivProizvodjaca) {
        this.nazivProizvodjaca = nazivProizvodjaca;
    }

    public String getPibProizvodjaca() {
        return pibProizvodjaca;
    }

    public void setPibProizvodjaca(String pibProizvodjaca) {
        this.pibProizvodjaca = pibProizvodjaca;
    }

    public String getTracunProizvodjaca() {
        return tracunProizvodjaca;
    }

    public void setTracunProizvodjaca(String tracunProizvodjaca) {
        this.tracunProizvodjaca = tracunProizvodjaca;
    }

    public String getDrzavaProizvodjaca() {
        return drzavaProizvodjaca;
    }

    public void setDrzavaProizvodjaca(String drzavaProizvodjaca) {
        this.drzavaProizvodjaca = drzavaProizvodjaca;
    }

    @XmlTransient
    public List<Oprema> getOpremaList() {
        return opremaList;
    }

    public void setOpremaList(List<Oprema> opremaList) {
        this.opremaList = opremaList;
    }

    @XmlTransient
    public List<Delovi> getDeloviList() {
        return deloviList;
    }

    public void setDeloviList(List<Delovi> deloviList) {
        this.deloviList = deloviList;
    }

    @XmlTransient
    public List<PotrosniMaterijal> getPotrosniMaterijalList() {
        return potrosniMaterijalList;
    }

    public void setPotrosniMaterijalList(List<PotrosniMaterijal> potrosniMaterijalList) {
        this.potrosniMaterijalList = potrosniMaterijalList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (proizvodjacId != null ? proizvodjacId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Proizvodjac)) {
            return false;
        }
        Proizvodjac other = (Proizvodjac) object;
        if ((this.proizvodjacId == null && other.proizvodjacId != null) || (this.proizvodjacId != null && !this.proizvodjacId.equals(other.proizvodjacId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.tenderplus.entities.Proizvodjac[ proizvodjacId=" + proizvodjacId + " ]";
    }
    
}
