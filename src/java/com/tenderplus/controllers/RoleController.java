/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tenderplus.controllers;

import com.tenderplus.dao.RoleDAO;
import com.tenderplus.dao.RoleDAOImpl;
import com.tenderplus.entities.Role;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named
@SessionScoped
public class RoleController implements Serializable{
    
    public List<Role> getRole(){
        RoleDAO rd = new RoleDAOImpl();
        List<Role> lista = rd.readAll(Role.class);
        return lista;
    }
    
    
} 
