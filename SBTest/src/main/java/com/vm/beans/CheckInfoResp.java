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
public class CheckInfoResp {
    
    public String mobilenumber;
    public String action;

    public CheckInfoResp(String mobilenumber, String action) {
        this.mobilenumber = mobilenumber;
        this.action = action;
    }
    
    public String getMobilenumber() {
        return mobilenumber;
    }

    public void setMobilenumber(String mobilenumber) {
        this.mobilenumber = mobilenumber;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    @Override
    public String toString() {
        return "CheckInfoResp{" + "mobilenumber=" + mobilenumber + ", action=" + action + '}';
    }
    
}
