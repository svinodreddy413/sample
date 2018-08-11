/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vm.beans;

import java.util.List;

/**
 *
 * @author VINODH
 */
public class EsmeList {

    public String username;
    public int noofsessions;
    public List<EsmeSessionInfo> esmesessioninfo;

    public EsmeList() {
    }

    public EsmeList(String username, int noofsessions, List<EsmeSessionInfo> esmesessioninfo) {
        this.username = username;
        this.noofsessions = noofsessions;
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

    public List<EsmeSessionInfo> getEsmesessioninfo() {
        return esmesessioninfo;
    }

    public void setEsmesessioninfo(List<EsmeSessionInfo> esmesessioninfo) {
        this.esmesessioninfo = esmesessioninfo;
    }

    @Override
    public String toString() {
        return "EsmeList{" + "username=" + username + ", noofsessions=" + noofsessions + ", esmesessioninfo=" + esmesessioninfo + '}';
    }
    
}
