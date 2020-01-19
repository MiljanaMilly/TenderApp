/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tenderplus.exceptions;

/**
 *
 * @author Milly
 */
public class LoginException extends Throwable {

    public LoginException() {
    }

    public LoginException(String message) {
        super(message);
    }
    
}
