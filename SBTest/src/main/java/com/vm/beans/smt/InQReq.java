/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vm.beans.smt;

/**
 *
 * @author VINODH
 */
public class InQReq {
    
    public String loginuserid;

    public String getLoginuserid() {
        return loginuserid;
    }

    public void setLoginuserid(String loginuserid) {
        this.loginuserid = loginuserid;
    }

    @Override
    public String toString() {
        return "InQReq{" + "loginuserid=" + loginuserid + '}';
    }
    
}
