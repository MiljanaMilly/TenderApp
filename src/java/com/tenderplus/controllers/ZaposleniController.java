/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tenderplus.controllers;

import com.tenderplus.dao.ZaposleniDAO;
import com.tenderplus.dao.ZaposleniDAOImpl;
import com.tenderplus.entities.LoginZaposleni;
import com.tenderplus.entities.Role;
import com.tenderplus.entities.Zaposleni;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.validation.ConstraintViolationException;

@Named
@SessionScoped
public class ZaposleniController implements Serializable {

    @Inject
    private Zaposleni zaposleni;

    //@Inject
    //private ZaposleniDAO zapDAO;
    private ZaposleniDAO zaposleniDAO = new ZaposleniDAOImpl();

    public ZaposleniController() {
    }

    public Zaposleni getZaposleni() {
        return zaposleni;
    }

    public void setZaposleni(Zaposleni zaposleni) {
        this.zaposleni = zaposleni;
    }

    public List findAllZaposleni() {
        List<Zaposleni> lista = null;
        ArrayList<Zaposleni> listB = null;
        try {

            lista = zaposleniDAO.readAll(Zaposleni.class);
            for (Zaposleni z : lista) {

                System.out.println(z.toString());

            }

        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("Greska findALLZaposleni");
        }

        return lista;
    }

    public void obrisiZaposlenog(Integer broj) {
        try {
            zaposleniDAO.deleteById(broj);

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    public String dodajZaposlenog(Zaposleni z) {
        try {
            zaposleniDAO.save(z);
            return "menadzment_page_zaposleni.jsp";
        } catch(ConstraintViolationException evl){
            evl.printStackTrace();
        }catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("Dao -Dodaj zaposlenog");
        }
        return "dodaj_zaposlenog.jsp";
    }

    public Zaposleni findZaposleni(Integer id) {
        return zaposleniDAO.findZaposleniById(id);
    }

    public Zaposleni updateZaposleni(Zaposleni z) {
        try {
            return zaposleniDAO.merge(z);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

}
