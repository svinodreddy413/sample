/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vm.beans;

import java.io.Serializable;

/**
 *
 * @author VINODH
 */
public class UserResponse implements Serializable {
    
    private String username;
    private String password;
    private String token;
    
    public UserResponse() {
        
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "UserResponse{" + "username=" + username + ", password=" + password + ", token=" + token + '}';
    }
    
    
    
}
