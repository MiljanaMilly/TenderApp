/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tenderplus.controllers;

import com.tenderplus.dao.ServiseriDAO;
import com.tenderplus.dao.ServiseriDAOImpl;
import com.tenderplus.entities.Serviseri;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@SessionScoped
public class ServiseriController implements Serializable {

    @Inject
    private Serviseri serviser;

    //@Inject
    private ServiseriDAO serviseriDAO = new ServiseriDAOImpl();

    public ServiseriController() {
    }

    public Serviseri getServiser() {
        return serviser;
    }

    public void setServiser(Serviseri serviser) {
        this.serviser = serviser;
    }

    public List<Serviseri> findAllServiseri() {
        List<Serviseri> lista = null;
        try {
            lista = serviseriDAO.readAll(Serviseri.class);
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("Greska findALLServiseri");
        }
        return lista;
    }

    public Serviseri findServiseriByZID(Integer id) {
        ServiseriDAO sdao = new ServiseriDAOImpl();
        try {
            return sdao.findServiserByZaposleniId(id);
        } catch (Exception ex) {
            ex.printStackTrace();

        }
        return null;
    }
    public Serviseri findServiseriBySID(Integer id) {
        ServiseriDAO sdao = new ServiseriDAOImpl();
        try {
            return sdao.findServiserByServiseriId(id);
        } catch (Exception ex) {
            ex.printStackTrace();

        }
        return null;
    }

    public void updateServiser(Serviseri s) {
        try {
            serviseriDAO.merge(s);
        } catch (Exception ex) {
            ex.printStackTrace();

        }

    }

    public void obrisiServisera(Serviseri s) {
        try {
            serviseriDAO.delete(s);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public String sacuvajServisera(Serviseri s) {
        try {
            serviseriDAO.save(s);
            return "menadzment_page_zaposleni.jsp";
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return "dodaj_servisera.jsp";
    }

}
