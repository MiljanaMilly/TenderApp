/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tenderplus.entities;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Milly2
 */
@Entity
@Table(name = "tenderi")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tenderi.findAll", query = "SELECT t FROM Tenderi t")
    , @NamedQuery(name = "Tenderi.findByTenderiId", query = "SELECT t FROM Tenderi t WHERE t.tenderiId = :tenderiId")
    , @NamedQuery(name = "Tenderi.findByDatumPodnosenjaDokumenata", query = "SELECT t FROM Tenderi t WHERE t.datumPodnosenjaDokumenata = :datumPodnosenjaDokumenata")
    , @NamedQuery(name = "Tenderi.findByDatumDonosenjaResenja", query = "SELECT t FROM Tenderi t WHERE t.datumDonosenjaResenja = :datumDonosenjaResenja")
    , @NamedQuery(name = "Tenderi.findByTenderProsao", query = "SELECT t FROM Tenderi t WHERE t.tenderProsao = :tenderProsao")})
public class Tenderi implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "tenderi_id")
    private Integer tenderiId;
    @Column(name = "datum_podnosenja_dokumenata")
    @Temporal(TemporalType.DATE)
    private Date datumPodnosenjaDokumenata;
    @Column(name = "datum_donosenja_resenja")
    @Temporal(TemporalType.DATE)
    private Date datumDonosenjaResenja;
    @Column(name = "tender_prosao")
    private Boolean tenderProsao;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tenderId")
    private List<TenderDelovi> tenderDeloviList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tenderId")
    private List<TenderOprema> tenderOpremaList;
    @JoinColumn(name = "kupci_id", referencedColumnName = "kupac_id")
    @ManyToOne(optional = false)
    private Kupci kupciId;
    @JoinColumn(name = "odgovorno_lice_id", referencedColumnName = "zaposleni_id")
    @ManyToOne(optional = false)
    private Zaposleni odgovornoLiceId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tenderId")
    private List<TenderPotrosniMaterijal> tenderPotrosniMaterijalList;

    public Tenderi() {
    }

    public Tenderi(Integer tenderiId) {
        this.tenderiId = tenderiId;
    }

    public Integer getTenderiId() {
        return tenderiId;
    }

    public void setTenderiId(Integer tenderiId) {
        this.tenderiId = tenderiId;
    }

    public Date getDatumPodnosenjaDokumenata() {
        return datumPodnosenjaDokumenata;
    }

    public void setDatumPodnosenjaDokumenata(Date datumPodnosenjaDokumenata) {
        this.datumPodnosenjaDokumenata = datumPodnosenjaDokumenata;
    }

    public Date getDatumDonosenjaResenja() {
        return datumDonosenjaResenja;
    }

    public void setDatumDonosenjaResenja(Date datumDonosenjaResenja) {
        this.datumDonosenjaResenja = datumDonosenjaResenja;
    }

    public Boolean getTenderProsao() {
        return tenderProsao;
    }

    public void setTenderProsao(Boolean tenderProsao) {
        this.tenderProsao = tenderProsao;
    }

    @XmlTransient
    public List<TenderDelovi> getTenderDeloviList() {
        return tenderDeloviList;
    }

    public void setTenderDeloviList(List<TenderDelovi> tenderDeloviList) {
        this.tenderDeloviList = tenderDeloviList;
    }

    @XmlTransient
    public List<TenderOprema> getTenderOpremaList() {
        return tenderOpremaList;
    }

    public void setTenderOpremaList(List<TenderOprema> tenderOpremaList) {
        this.tenderOpremaList = tenderOpremaList;
    }

    public Kupci getKupciId() {
        return kupciId;
    }

    public void setKupciId(Kupci kupciId) {
        this.kupciId = kupciId;
    }

    public Zaposleni getOdgovornoLiceId() {
        return odgovornoLiceId;
    }

    public void setOdgovornoLiceId(Zaposleni odgovornoLiceId) {
        this.odgovornoLiceId = odgovornoLiceId;
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
        hash += (tenderiId != null ? tenderiId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tenderi)) {
            return false;
        }
        Tenderi other = (Tenderi) object;
        if ((this.tenderiId == null && other.tenderiId != null) || (this.tenderiId != null && !this.tenderiId.equals(other.tenderiId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.tenderplus.entities.Tenderi[ tenderiId=" + tenderiId + " ]";
    }
    
}
