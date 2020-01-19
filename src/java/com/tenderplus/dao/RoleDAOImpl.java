/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tenderplus.dao;

import com.tenderplus.entities.Role;
import com.tenderplus.util.HibernateUtil;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.Dependent;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import org.hibernate.HibernateException;
import org.hibernate.Session;

@Named
@Dependent
public class RoleDAOImpl extends GenericDAOImpl<Role> implements RoleDAO,Serializable{
    
    
}
