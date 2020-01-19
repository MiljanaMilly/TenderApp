/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tenderplus.entities;

import java.io.Serializable;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Milly2
 */
@Entity
@Table(name = "zaposleni")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Zaposleni.findAll", query = "SELECT z FROM Zaposleni z")
    , @NamedQuery(name = "Zaposleni.findByZaposleniId", query = "SELECT z FROM Zaposleni z WHERE z.zaposleniId = :zaposleniId")
    , @NamedQuery(name = "Zaposleni.findByIme", query = "SELECT z FROM Zaposleni z WHERE z.ime = :ime")
    , @NamedQuery(name = "Zaposleni.findByPrezime", query = "SELECT z FROM Zaposleni z WHERE z.prezime = :prezime")
    , @NamedQuery(name = "Zaposleni.findByEmail", query = "SELECT z FROM Zaposleni z WHERE z.email = :email")
    , @NamedQuery(name = "Zaposleni.findByAdresa", query = "SELECT z FROM Zaposleni z WHERE z.adresa = :adresa")
    , @NamedQuery(name = "Zaposleni.findByTelefon", query = "SELECT z FROM Zaposleni z WHERE z.telefon = :telefon")})
@Named
@SessionScoped
public class Zaposleni implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "zaposleni_id")
    private Integer zaposleniId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "ime")
    private String ime;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "prezime")
    private String prezime;
    @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Neispravan email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "adresa")
    private String adresa;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "telefon")
    private String telefon;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "zaposleniId")
    private List<Serviseri> serviseriList;
    @JoinColumn(name = "login_zaposleni_id", referencedColumnName = "login_zaposleni_id")
    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    private LoginZaposleni loginZaposleniId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "odgovornoLiceId")
    private List<Tenderi> tenderiList;

    public Zaposleni() {
    }

    public Zaposleni(Integer zaposleniId) {
        this.zaposleniId = zaposleniId;
    }

    public Zaposleni( String ime, String prezime, String email, String adresa, String telefon) {
        this.ime = ime;
        this.prezime = prezime;
        this.email = email;
        this.adresa = adresa;
        this.telefon = telefon;
    }

    public Integer getZaposleniId() {
        return zaposleniId;
    }

    public void setZaposleniId(Integer zaposleniId) {
        this.zaposleniId = zaposleniId;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    @XmlTransient
    public List<Serviseri> getServiseriList() {
        return serviseriList;
    }

    public void setServiseriList(List<Serviseri> serviseriList) {
        this.serviseriList = serviseriList;
    }

    public LoginZaposleni getLoginZaposleniId() {
        return loginZaposleniId;
    }

    public void setLoginZaposleniId(LoginZaposleni loginZaposleniId) {
        this.loginZaposleniId = loginZaposleniId;
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
        hash += (zaposleniId != null ? zaposleniId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Zaposleni)) {
            return false;
        }
        Zaposleni other = (Zaposleni) object;
        if ((this.zaposleniId == null && other.zaposleniId != null) || (this.zaposleniId != null && !this.zaposleniId.equals(other.zaposleniId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.tenderplus.entities.Zaposleni[ zaposleniId=" + zaposleniId + " ]";
    }
    
}
