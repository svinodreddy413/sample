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
public class EsmeSessionInfo {
    
    public int sessionid;
    public String mode;
    public int bindstatus;
    public String action;

    public EsmeSessionInfo(int sessionid, String mode, int bindstatus, String action) {
        this.sessionid = sessionid;
        this.mode = mode;
        this.bindstatus = bindstatus;
        this.action = action;
    }

    public int getSessionid() {
        return sessionid;
    }

    public void setSessionid(int sessionid) {
        this.sessionid = sessionid;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public int getBindstatus() {
        return bindstatus;
    }

    public void setBindstatus(int bindstatus) {
        this.bindstatus = bindstatus;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    @Override
    public String toString() {
        return "EsmeSessionInfo{" + "sessionid=" + sessionid + ", mode=" + mode + ", bindstatus=" + bindstatus + ", action=" + action + '}';
    }
    
}
