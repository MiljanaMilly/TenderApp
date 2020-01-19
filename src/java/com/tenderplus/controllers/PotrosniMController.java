/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tenderplus.controllers;

import com.tenderplus.dao.PotrosniMaterijalDAO;
import com.tenderplus.dao.PotrosniMaterijalDAOImpl;
import com.tenderplus.entities.PotrosniMaterijal;
import java.util.List;

/**
 *
 * @author Milly
 */
public class PotrosniMController {
    public List<PotrosniMaterijal> pregledPotrosnogMaterijala(){
        PotrosniMaterijalDAO pmdao = new PotrosniMaterijalDAOImpl();
        return pmdao.readAll(PotrosniMaterijal.class);
    }
}
