/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import com.tenderplus.controllers.ServiseriController;
import com.tenderplus.dao.ZaposleniDAO;
import com.tenderplus.dao.ZaposleniDAOImpl;
import com.tenderplus.entities.Serviseri;
import com.tenderplus.entities.Zaposleni;
import java.awt.BorderLayout;
import java.util.List;

/**
 *
 * @author Milly2
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ServiseriController sc = new ServiseriController();
        Serviseri s = sc.findServiseriBySID(Integer.valueOf("2"));
        System.out.println(s.toString());

    }
}
