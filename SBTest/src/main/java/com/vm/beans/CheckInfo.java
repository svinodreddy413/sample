/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vm.beans;

/**
 *
 * @author VINOD REDDY
 */
public class CheckInfo {
   
    public String mobilenumbers;

    public String getMobilenumbers() {
        return mobilenumbers;
    }

    public void setMobilenumbers(String mobilenumbers) {
        this.mobilenumbers = mobilenumbers;
    }

    @Override
    public String toString() {
        return "CheckInfo{" + "mobilenumbers=" + mobilenumbers + '}';
    }
    
}
