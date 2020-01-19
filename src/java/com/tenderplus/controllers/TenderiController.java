/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tenderplus.controllers;

import com.tenderplus.dao.TenderiDAO;
import com.tenderplus.dao.TenderiDAOImpl;
import com.tenderplus.entities.Tenderi;
import java.util.List;

/**
 *
 * @author Milly
 */
public class TenderiController {
    public List<Tenderi> pregledTendera(){
        TenderiDAO tdao = new TenderiDAOImpl();
        return tdao.readAll(Tenderi.class);
    }
}
