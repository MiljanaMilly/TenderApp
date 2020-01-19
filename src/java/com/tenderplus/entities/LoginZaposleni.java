/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tenderplus.entities;

import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.RequestScoped;
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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Milly2
 */
@Entity
@Table(name = "login_zaposleni")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LoginZaposleni.findAll", query = "SELECT l FROM LoginZaposleni l")
    , @NamedQuery(name = "LoginZaposleni.findByLoginZaposleniId", query = "SELECT l FROM LoginZaposleni l WHERE l.loginZaposleniId = :loginZaposleniId")
    , @NamedQuery(name = "LoginZaposleni.findByUsername", query = "SELECT l FROM LoginZaposleni l WHERE l.username = :username")
    , @NamedQuery(name = "LoginZaposleni.findByPassword", query = "SELECT l FROM LoginZaposleni l WHERE l.password = :password")})
@Named
@SessionScoped
public class LoginZaposleni implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "login_zaposleni_id")
    private Integer loginZaposleniId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "username")
    private String username;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "password")
    private String password;
    @JoinColumn(name = "role_id", referencedColumnName = "role_id")
    @ManyToOne(optional = false)
    private Role roleId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "loginZaposleniId")
    private List<Zaposleni> zaposleniList;

    public LoginZaposleni() {
    }

    public LoginZaposleni(Integer loginZaposleniId) {
        this.loginZaposleniId = loginZaposleniId;
    }

    public LoginZaposleni(Integer loginZaposleniId, String username, String password) {
        this.loginZaposleniId = loginZaposleniId;
        this.username = username;
        this.password = password;
    }

    public Integer getLoginZaposleniId() {
        return loginZaposleniId;
    }

    public void setLoginZaposleniId(Integer loginZaposleniId) {
        this.loginZaposleniId = loginZaposleniId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRoleId() {
        return roleId;
    }

    public void setRoleId(Role roleId) {
        this.roleId = roleId;
    }

    @XmlTransient
    public List<Zaposleni> getZaposleniList() {
        return zaposleniList;
    }

    public void setZaposleniList(List<Zaposleni> zaposleniList) {
        this.zaposleniList = zaposleniList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (loginZaposleniId != null ? loginZaposleniId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LoginZaposleni)) {
            return false;
        }
        LoginZaposleni other = (LoginZaposleni) object;
        if ((this.loginZaposleniId == null && other.loginZaposleniId != null) || (this.loginZaposleniId != null && !this.loginZaposleniId.equals(other.loginZaposleniId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return loginZaposleniId + "";
    }
    
}
