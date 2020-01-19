/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tenderplus.dao;

import com.tenderplus.entities.Zaposleni;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named
@SessionScoped
public interface ZaposleniDAO extends GenericDAO<Zaposleni> {
    public ArrayList findAllZaposleni();
    public void deleteById(Integer id);
    public Zaposleni findZaposleniById(Integer id);
}
