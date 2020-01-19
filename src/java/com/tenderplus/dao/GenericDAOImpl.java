/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tenderplus.dao;

import com.tenderplus.util.HibernateUtil;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Milly2
 */
public class GenericDAOImpl<T> implements GenericDAO<T> {

    private Session session;

    @Override
    public List<T> readAll(Class<T> c) {
        session = HibernateUtil.getSessionFactory().openSession();
        try {
            return session.createCriteria(c).list();
        } catch (HibernateException ex) {
            ex.printStackTrace();
        } finally {
            session.close();
        }
        return null;
    }

    @Override
    public T save(T obj) {
        session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            obj = (T) session.save(obj);
            tx.commit();
        } catch (HibernateException ex) {
            tx.rollback();
            ex.printStackTrace();
        } finally {
            session.close();
        }
        return obj;
    }

    @Override
    public void persist(T obj) {
        session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.persist(obj);
            tx.commit();
        } catch (HibernateException ex) {
            tx.rollback();
            ex.printStackTrace();
        } finally {
            session.close();
        }

    }

    @Override
    public void saveOrUpdate(T obj) {
        session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.saveOrUpdate(obj);
            tx.commit();
        } catch (HibernateException ex) {
            tx.rollback();
            ex.printStackTrace();
        } finally {
            session.close();
        }
    }

    @Override
    public void update(T obj) {
        session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.update(obj);
            tx.commit();
        } catch (HibernateException ex) {
            tx.rollback();
            ex.printStackTrace();
        } finally {
            session.close();
        }
    }

    @Override
    public void delete(T obj) {
        session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.delete(obj);
            tx.commit();
        } catch (HibernateException ex) {
            tx.rollback();
            ex.printStackTrace();
        } finally {
            session.close();
        }
    }

    @Override
    public T merge(T obj) {
        session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            obj = (T) session.merge(obj);
            tx.commit();
        } catch (HibernateException ex) {
            tx.rollback();
            ex.printStackTrace();
        } finally {
            session.close();
        }
        return obj;
    }

    
}
