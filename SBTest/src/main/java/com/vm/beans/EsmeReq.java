/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vm.beans;

/**
 *
 * @author VINODH
 */
public class EsmeReq {
    String loginuserid;
    
    public EsmeReq() {
        
    }

    public EsmeReq(String loginuserid) {
        this.loginuserid = loginuserid;
    }

    
    public String getLoginuserid() {
        return loginuserid;
    }

    public void setLoginuserid(String loginuserid) {
        this.loginuserid = loginuserid;
    }

    @Override
    public String toString() {
        return "EsmeReq{" + "loginuserid=" + loginuserid + '}';
    }
    
    
}
