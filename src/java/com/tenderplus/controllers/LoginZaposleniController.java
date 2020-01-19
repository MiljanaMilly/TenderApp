/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tenderplus.controllers;

import com.tenderplus.dao.LoginZaposleniDAO;
import com.tenderplus.dao.LoginZaposleniDAOImpl;
import com.tenderplus.entities.LoginZaposleni;
import com.tenderplus.entities.Role;
import com.tenderplus.exceptions.LoginException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.ListIterator;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@SessionScoped

public class LoginZaposleniController implements Serializable {

    @Inject
    private LoginZaposleni loginKorisnik;

    @Inject
    private LoginZaposleniDAO lgza;

    LoginZaposleniDAO lgz = new LoginZaposleniDAOImpl();

    public LoginZaposleniController() {

    }

    public LoginZaposleni getLoginKorisnik() {
        return loginKorisnik;
    }

    public void setLoginKorisnik(LoginZaposleni loginKorisnik) {
        this.loginKorisnik = loginKorisnik;
    }

    public String proveraLogin(String username, String password) {

        try {
            if (lgz.findUser(username, password)) {
                return "index.jsp";
            }
        } catch (LoginException ex) {
            return "loginerror.jsp";
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return "loginerror.jsp";
    }

    public boolean proveraRole(String username, String password) {
        ArrayList lista = null;
        Role r = new Role();

        try {
            lista = (ArrayList) lgz.findUserRole(username, password);

            ListIterator li = lista.listIterator();
            while (li.hasNext()) {

                r.setNaziv(li.next().toString());
            }
            if (r.getNaziv().equalsIgnoreCase("Menadzer")) {
                return true;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return false;

    }

    public LoginZaposleni sacuvajLoginPodatke(LoginZaposleni loginz) {
        lgz.save(loginz);
        return loginz;
    }

    public void obrisiLoginPodatke(LoginZaposleni loginz) {
        lgz.delete(loginz);
    }

    public LoginZaposleni updateLoginPodatke(LoginZaposleni loginz) {
        lgz.merge(loginz);
        return loginz;

    }
}
