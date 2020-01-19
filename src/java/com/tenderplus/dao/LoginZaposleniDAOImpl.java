/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tenderplus.dao;

import com.tenderplus.entities.LoginZaposleni;
import com.tenderplus.entities.Zaposleni;
import com.tenderplus.exceptions.LoginException;
import com.tenderplus.util.HibernateUtil;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

@Named
@SessionScoped
public class LoginZaposleniDAOImpl extends GenericDAOImpl<LoginZaposleni> implements LoginZaposleniDAO, Serializable {

    private Session session;

    @Override
    public boolean findUser(String username, String password) throws LoginException {
        session = HibernateUtil.getSessionFactory().openSession();

        try {
           
            List<LoginZaposleni> results = session.createCriteria(LoginZaposleni.class)
                    .add(Restrictions
                            .and(Restrictions.eq("username", username),Restrictions.eq("password", password) ))
                    .list();
            System.out.println("nema rezultata");

            if (!results.isEmpty()) {
                System.out.println(results.toString());
                return true;

            }
        } catch (HibernateException ex) {
            ex.printStackTrace();

        } finally {
            session.close();
        }
        throw new LoginException("Korisnicko ime/lozinka nisu validni!");

    }

    @Override
    public List findUserRole(String username, String password) {
        session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        List list = null;
        try {
            tx = session.beginTransaction();
            String hsql = "select r.naziv from Role r join login_zaposleni u on r.role_id = u.role_id where username= :username and password= :password";

            Query q = session.createSQLQuery(hsql);
            q.setParameter("username", username).setParameter("password", password);

            list = q.list();
            tx.commit();

        } catch (HibernateException ex) {
            tx.rollback();
            ex.printStackTrace();
        } finally {

            session.close();
        }
        return list;

    }

    @Override
    public LoginZaposleni findUserObject(LoginZaposleni lz) {
        session = HibernateUtil.getSessionFactory().openSession();
        LoginZaposleni logzap = null;
        try {

            List<LoginZaposleni> results = session.createCriteria(LoginZaposleni.class)
                    .add(Restrictions
                            .and(Restrictions.ilike("username", lz.getUsername()), Restrictions.ilike("password", lz.getPassword()))).list();
            logzap = results.get(0);

        } catch (HibernateException ex) {
            ex.printStackTrace();

        } finally {
            session.close();
        }
        return logzap;
    }

//    public void deleteById(Integer id){
//    session = HibernateUtil.getSessionFactory().openSession();
//        Transaction tx = null;
//        
//        try {
//            tx = session.beginTransaction();
//            session.createCriteria(LoginZaposleni.class).add(Restrictions.eq("loginZaposleniId", id));
//            tx.commit();
//
//        } catch (HibernateException ex) {
//            tx.rollback();
//            ex.printStackTrace();
//        } finally {
//
//            session.close();
//        }
//        
//    }
}
