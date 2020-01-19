/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tenderplus.controllers;

import com.tenderplus.dao.DeloviDAO;
import com.tenderplus.dao.DeloviDAOImpl;
import com.tenderplus.entities.Delovi;
import java.util.List;

/**
 *
 * @author Milly
 */
public class DeloviController {
        public List<Delovi> pregledDelova(){
        DeloviDAO ddao = new DeloviDAOImpl();
        return ddao.readAll(Delovi.class);
    }
}
