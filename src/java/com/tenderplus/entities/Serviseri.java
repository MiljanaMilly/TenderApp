/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tenderplus.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Milly2
 */
@Entity
@Table(name = "serviseri")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Serviseri.findAll", query = "SELECT s FROM Serviseri s")
    , @NamedQuery(name = "Serviseri.findByServiseriId", query = "SELECT s FROM Serviseri s WHERE s.serviseriId = :serviseriId")
    , @NamedQuery(name = "Serviseri.findByBrojLicence", query = "SELECT s FROM Serviseri s WHERE s.brojLicence = :brojLicence")
    , @NamedQuery(name = "Serviseri.findByVaziDo", query = "SELECT s FROM Serviseri s WHERE s.vaziDo = :vaziDo")})
@Named
@SessionScoped
public class Serviseri implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "serviseri_id")
    private Integer serviseriId;
    @Size(max = 30)
    @Column(name = "broj_licence")
    private String brojLicence;
    @Column(name = "vazi_do")
    @Temporal(TemporalType.DATE)
    private Date vaziDo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "serviserId")
    private List<Servis> servisList;
    @JoinColumn(name = "zaposleni_id", referencedColumnName = "zaposleni_id")
    @ManyToOne(optional = false)
    private Zaposleni zaposleniId;

    public Serviseri() {
    }

    public Serviseri(Integer serviseriId) {
        this.serviseriId = serviseriId;
    }

    public Integer getServiseriId() {
        return serviseriId;
    }

    public void setServiseriId(Integer serviseriId) {
        this.serviseriId = serviseriId;
    }

    public String getBrojLicence() {
        return brojLicence;
    }

    public void setBrojLicence(String brojLicence) {
        this.brojLicence = brojLicence;
    }

    public Date getVaziDo() {
        return vaziDo;
    }

    public void setVaziDo(Date vaziDo) {
        this.vaziDo = vaziDo;
    }

    @XmlTransient
    public List<Servis> getServisList() {
        return servisList;
    }

    public void setServisList(List<Servis> servisList) {
        this.servisList = servisList;
    }

    public Zaposleni getZaposleniId() {
        return zaposleniId;
    }

    public void setZaposleniId(Zaposleni zaposleniId) {
        this.zaposleniId = zaposleniId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (serviseriId != null ? serviseriId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Serviseri)) {
            return false;
        }
        Serviseri other = (Serviseri) object;
        if ((this.serviseriId == null && other.serviseriId != null) || (this.serviseriId != null && !this.serviseriId.equals(other.serviseriId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.tenderplus.entities.Serviseri[ serviseriId=" + serviseriId + " ]";
    }
    
}
