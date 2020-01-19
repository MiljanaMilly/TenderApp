/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tenderplus.entities;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Milly2
 */
@Entity
@Table(name = "servis")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Servis.findAll", query = "SELECT s FROM Servis s")
    , @NamedQuery(name = "Servis.findByServisId", query = "SELECT s FROM Servis s WHERE s.servisId = :servisId")
    , @NamedQuery(name = "Servis.findByDatumIzdavanja", query = "SELECT s FROM Servis s WHERE s.datumIzdavanja = :datumIzdavanja")
    , @NamedQuery(name = "Servis.findByDatumNaloga", query = "SELECT s FROM Servis s WHERE s.datumNaloga = :datumNaloga")
    , @NamedQuery(name = "Servis.findByNalogIspunjen", query = "SELECT s FROM Servis s WHERE s.nalogIspunjen = :nalogIspunjen")})
public class Servis implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "servis_id")
    private Integer servisId;
    @Column(name = "datum_izdavanja")
    @Temporal(TemporalType.DATE)
    private Date datumIzdavanja;
    @Column(name = "datum_naloga")
    @Temporal(TemporalType.DATE)
    private Date datumNaloga;
    @Column(name = "nalog_ispunjen")
    private Boolean nalogIspunjen;
    @JoinColumn(name = "serviser_id", referencedColumnName = "serviseri_id")
    @ManyToOne(optional = false)
    private Serviseri serviserId;
    @JoinColumn(name = "kupac_id", referencedColumnName = "kupac_id")
    @ManyToOne(optional = false)
    private Kupci kupacId;

    public Servis() {
    }

    public Servis(Integer servisId) {
        this.servisId = servisId;
    }

    public Integer getServisId() {
        return servisId;
    }

    public void setServisId(Integer servisId) {
        this.servisId = servisId;
    }

    public Date getDatumIzdavanja() {
        return datumIzdavanja;
    }

    public void setDatumIzdavanja(Date datumIzdavanja) {
        this.datumIzdavanja = datumIzdavanja;
    }

    public Date getDatumNaloga() {
        return datumNaloga;
    }

    public void setDatumNaloga(Date datumNaloga) {
        this.datumNaloga = datumNaloga;
    }

    public Boolean getNalogIspunjen() {
        return nalogIspunjen;
    }

    public void setNalogIspunjen(Boolean nalogIspunjen) {
        this.nalogIspunjen = nalogIspunjen;
    }

    public Serviseri getServiserId() {
        return serviserId;
    }

    public void setServiserId(Serviseri serviserId) {
        this.serviserId = serviserId;
    }

    public Kupci getKupacId() {
        return kupacId;
    }

    public void setKupacId(Kupci kupacId) {
        this.kupacId = kupacId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (servisId != null ? servisId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Servis)) {
            return false;
        }
        Servis other = (Servis) object;
        if ((this.servisId == null && other.servisId != null) || (this.servisId != null && !this.servisId.equals(other.servisId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.tenderplus.entities.Servis[ servisId=" + servisId + " ]";
    }
    
}
