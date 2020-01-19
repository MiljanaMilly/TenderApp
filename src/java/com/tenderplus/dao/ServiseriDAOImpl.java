/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tenderplus.dao;

import com.tenderplus.entities.Serviseri;
import com.tenderplus.util.HibernateUtil;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

@Named
@SessionScoped
public class ServiseriDAOImpl extends GenericDAOImpl<Serviseri> implements ServiseriDAO,Serializable {
    private Session session;
   
    
    @Override
    public Serviseri findServiserByServiseriId(Integer id){
        session = HibernateUtil.getSessionFactory().openSession();
        Serviseri s = new Serviseri();
        try {
            
            s = (Serviseri)session.createCriteria(Serviseri.class).add(Restrictions.eq("serviseriId", id)).uniqueResult();
            
            return s;
            
        } catch (HibernateException ex) {
            
            ex.printStackTrace();
        } finally {
            session.close();
        }
        return null;
    }

    @Override
    public Serviseri findServiserByZaposleniId(Integer id) {
        session = HibernateUtil.getSessionFactory().openSession();
        Serviseri s = new Serviseri();
        try {
            
            s = (Serviseri)session.createCriteria(Serviseri.class).add(Restrictions.eq("zaposleniId.zaposleniId", id)).uniqueResult();
            
            return s;
            
        } catch (HibernateException ex) {
            
            ex.printStackTrace();
        } finally {
            session.close();
        }
        return null;
    }
    
}
