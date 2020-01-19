/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tenderplus.dao;

import com.tenderplus.entities.LoginZaposleni;
import com.tenderplus.exceptions.LoginException;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named
@SessionScoped
public interface LoginZaposleniDAO extends GenericDAO<LoginZaposleni> {
    public boolean findUser(String username, String password) throws LoginException;
    public List findUserRole(String username, String password);
    public LoginZaposleni findUserObject(LoginZaposleni lz);
    //public void deleteById(LoginZaposleni lg);
}
