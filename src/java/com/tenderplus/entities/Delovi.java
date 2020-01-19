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
@Table(name = "delovi")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Delovi.findAll", query = "SELECT d FROM Delovi d")
    , @NamedQuery(name = "Delovi.findByDeloviId", query = "SELECT d FROM Delovi d WHERE d.deloviId = :deloviId")
    , @NamedQuery(name = "Delovi.findByNaziv", query = "SELECT d FROM Delovi d WHERE d.naziv = :naziv")
    , @NamedQuery(name = "Delovi.findBySerijskiBroj", query = "SELECT d FROM Delovi d WHERE d.serijskiBroj = :serijskiBroj")
    , @NamedQuery(name = "Delovi.findByCenaPoKomadu", query = "SELECT d FROM Delovi d WHERE d.cenaPoKomadu = :cenaPoKomadu")})
public class Delovi implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "delovi_id")
    private Integer deloviId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "naziv")
    private String naziv;
    @Size(max = 50)
    @Column(name = "serijski_broj")
    private String serijskiBroj;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cena_po_komadu")
    private long cenaPoKomadu;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "deloviId")
    private List<TenderDelovi> tenderDeloviList;
    @JoinColumn(name = "proizvodjac_id", referencedColumnName = "proizvodjac_id")
    @ManyToOne(optional = false)
    private Proizvodjac proizvodjacId;

    public Delovi() {
    }

    public Delovi(Integer deloviId) {
        this.deloviId = deloviId;
    }

    public Delovi(Integer deloviId, String naziv, long cenaPoKomadu) {
        this.deloviId = deloviId;
        this.naziv = naziv;
        this.cenaPoKomadu = cenaPoKomadu;
    }

    public Integer getDeloviId() {
        return deloviId;
    }

    public void setDeloviId(Integer deloviId) {
        this.deloviId = deloviId;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getSerijskiBroj() {
        return serijskiBroj;
    }

    public void setSerijskiBroj(String serijskiBroj) {
        this.serijskiBroj = serijskiBroj;
    }

    public long getCenaPoKomadu() {
        return cenaPoKomadu;
    }

    public void setCenaPoKomadu(long cenaPoKomadu) {
        this.cenaPoKomadu = cenaPoKomadu;
    }

    @XmlTransient
    public List<TenderDelovi> getTenderDeloviList() {
        return tenderDeloviList;
    }

    public void setTenderDeloviList(List<TenderDelovi> tenderDeloviList) {
        this.tenderDeloviList = tenderDeloviList;
    }

    public Proizvodjac getProizvodjacId() {
        return proizvodjacId;
    }

    public void setProizvodjacId(Proizvodjac proizvodjacId) {
        this.proizvodjacId = proizvodjacId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (deloviId != null ? deloviId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Delovi)) {
            return false;
        }
        Delovi other = (Delovi) object;
        if ((this.deloviId == null && other.deloviId != null) || (this.deloviId != null && !this.deloviId.equals(other.deloviId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.tenderplus.entities.Delovi[ deloviId=" + deloviId + " ]";
    }
    
}
