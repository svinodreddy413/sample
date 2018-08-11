/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vm.beans;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author VINODH
 */
public class EsmeResp {
    
    public String username;
    public int noofsessions;
    public String action;
    public EsmeSessionInfo esmesessioninfo;

    public EsmeResp(String username, int noofsessions, String action, EsmeSessionInfo esmesessioninfo) {
        this.username = username;
        this.noofsessions = noofsessions;
        this.action = action;
        this.esmesessioninfo = esmesessioninfo;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getNoofsessions() {
        return noofsessions;
    }

    public void setNoofsessions(int noofsessions) {
        this.noofsessions = noofsessions;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public EsmeSessionInfo getEsmesessioninfo() {
        return esmesessioninfo;
    }

    public void setEsmesessioninfo(EsmeSessionInfo esmesessioninfo) {
        this.esmesessioninfo = esmesessioninfo;
    }

    @Override
    public String toString() {
        return "EsmeResp{" + "username=" + username + ", noofsessions=" + noofsessions + ", action=" + action + ", esmesessioninfo=" + esmesessioninfo + '}';
    }

}
