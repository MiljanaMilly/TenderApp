/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tenderplus.controllers;

import com.tenderplus.dao.OpremaDAO;
import com.tenderplus.dao.OpremaDAOImpl;
import com.tenderplus.entities.Oprema;
import java.util.List;

/**
 *
 * @author Milly
 */
public class OpremaController {
    
    public List<Oprema> pregledOpreme(){
        OpremaDAO odao = new OpremaDAOImpl();
        return odao.readAll(Oprema.class);
    }
}
