/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tenderplus.dao;

import java.util.List;

/**
 *
 * @author Milly2
 * @param <T>
 */
public interface GenericDAO<T> {
    List<T> readAll(Class<T> c);
    T save(T obj);
    void persist(T obj);
    void saveOrUpdate(T obj);
    void update(T obj);
    void delete(T obj);
    T merge(T obj);
}
