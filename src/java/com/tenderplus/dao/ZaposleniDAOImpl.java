/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tenderplus.dao;

import com.sun.xml.wss.logging.LogDomainConstants;
import com.tenderplus.entities.LoginZaposleni;
import com.tenderplus.entities.Zaposleni;
import com.tenderplus.util.HibernateUtil;
import java.awt.AWTEventMulticaster;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;

@Named
@SessionScoped
public class ZaposleniDAOImpl extends GenericDAOImpl<Zaposleni> implements ZaposleniDAO, Serializable {

    private Session session;

    @Override
    public ArrayList findAllZaposleni() {
        session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        ArrayList list = null;
        try {
            tx = session.beginTransaction();

            String hsql = "select z.zaposleni_id, z.ime, z.prezime, z.email, z.adresa, z.telefon, u.username, r.naziv "
                    + "from zaposleni z"
                    + " join login_zaposleni u on z.login_zaposleni_id = u.login_zaposleni_id"
                    + " join role r on r.role_id = u.role_id";

            Query q = session.createSQLQuery(hsql);
            q.setResultTransformer(Transformers.aliasToBean(Zaposleni.class));
            list = (ArrayList) q.list();

            ListIterator li = list.listIterator();
            while (li.hasNext()) {
                System.out.println(li.next());
            }
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
    public void deleteById(Integer id) {
        session = HibernateUtil.getSessionFactory().openSession();
        List<Zaposleni> listaZaBrisanje = null;
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            listaZaBrisanje = session.createCriteria(Zaposleni.class).add(Restrictions.eq("zaposleniId", id)).list();
            for (Zaposleni z : listaZaBrisanje) {
                session.delete(z);
            }

            tx.commit();
        } catch (HibernateException ex) {
            tx.rollback();
            ex.printStackTrace();
        } finally {
            session.close();
        }
    }
    @Override
    public Zaposleni findZaposleniById(Integer id){
        session = HibernateUtil.getSessionFactory().openSession();
        List<Zaposleni> lista = null;
        try {
            
            lista = session.createCriteria(Zaposleni.class).add(Restrictions.eq("zaposleniId", id)).list();
            Zaposleni z = lista.get(0);
            return z;
            
        } catch (HibernateException ex) {
            
            ex.printStackTrace();
        } finally {
            session.close();
        }
        return null;
    }
}
