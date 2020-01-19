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
@Table(name = "potrosni_materijal")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PotrosniMaterijal.findAll", query = "SELECT p FROM PotrosniMaterijal p")
    , @NamedQuery(name = "PotrosniMaterijal.findByPotrosniId", query = "SELECT p FROM PotrosniMaterijal p WHERE p.potrosniId = :potrosniId")
    , @NamedQuery(name = "PotrosniMaterijal.findByNazivMaterijala", query = "SELECT p FROM PotrosniMaterijal p WHERE p.nazivMaterijala = :nazivMaterijala")
    , @NamedQuery(name = "PotrosniMaterijal.findBySerijskiBroj", query = "SELECT p FROM PotrosniMaterijal p WHERE p.serijskiBroj = :serijskiBroj")
    , @NamedQuery(name = "PotrosniMaterijal.findByCenaPoKomadu", query = "SELECT p FROM PotrosniMaterijal p WHERE p.cenaPoKomadu = :cenaPoKomadu")})
public class PotrosniMaterijal implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "potrosni_id")
    private Integer potrosniId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "naziv_materijala")
    private String nazivMaterijala;
    @Size(max = 50)
    @Column(name = "serijski_broj")
    private String serijskiBroj;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cena_po_komadu")
    private long cenaPoKomadu;
    @JoinColumn(name = "proizvodjac_id", referencedColumnName = "proizvodjac_id")
    @ManyToOne(optional = false)
    private Proizvodjac proizvodjacId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "potrosniId")
    private List<TenderPotrosniMaterijal> tenderPotrosniMaterijalList;

    public PotrosniMaterijal() {
    }

    public PotrosniMaterijal(Integer potrosniId) {
        this.potrosniId = potrosniId;
    }

    public PotrosniMaterijal(Integer potrosniId, String nazivMaterijala, long cenaPoKomadu) {
        this.potrosniId = potrosniId;
        this.nazivMaterijala = nazivMaterijala;
        this.cenaPoKomadu = cenaPoKomadu;
    }

    public Integer getPotrosniId() {
        return potrosniId;
    }

    public void setPotrosniId(Integer potrosniId) {
        this.potrosniId = potrosniId;
    }

    public String getNazivMaterijala() {
        return nazivMaterijala;
    }

    public void setNazivMaterijala(String nazivMaterijala) {
        this.nazivMaterijala = nazivMaterijala;
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

    public Proizvodjac getProizvodjacId() {
        return proizvodjacId;
    }

    public void setProizvodjacId(Proizvodjac proizvodjacId) {
        this.proizvodjacId = proizvodjacId;
    }

    @XmlTransient
    public List<TenderPotrosniMaterijal> getTenderPotrosniMaterijalList() {
        return tenderPotrosniMaterijalList;
    }

    public void setTenderPotrosniMaterijalList(List<TenderPotrosniMaterijal> tenderPotrosniMaterijalList) {
        this.tenderPotrosniMaterijalList = tenderPotrosniMaterijalList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (potrosniId != null ? potrosniId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PotrosniMaterijal)) {
            return false;
        }
        PotrosniMaterijal other = (PotrosniMaterijal) object;
        if ((this.potrosniId == null && other.potrosniId != null) || (this.potrosniId != null && !this.potrosniId.equals(other.potrosniId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.tenderplus.entities.PotrosniMaterijal[ potrosniId=" + potrosniId + " ]";
    }
    
}
