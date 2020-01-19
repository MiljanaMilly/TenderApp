/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tenderplus.dao;

import com.tenderplus.entities.Serviseri;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named
@SessionScoped
public interface ServiseriDAO extends GenericDAO<Serviseri> {
    public Serviseri findServiserByServiseriId(Integer id);
    public Serviseri findServiserByZaposleniId(Integer id);
}
