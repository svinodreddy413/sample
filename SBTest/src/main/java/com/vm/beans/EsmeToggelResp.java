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
public class EsmeToggelResp {
    
    public int sessionid;
    public String mode;
    public int bindstatus;
    
    public EsmeToggelResp() {
        
    }

    public EsmeToggelResp(int sessionid, String mode, int bindstatus) {
        this.sessionid = sessionid;
        this.mode = mode;
        this.bindstatus = bindstatus;
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

    @Override
    public String toString() {
        return "EsmeToggelResp{" + "sessionid=" + sessionid + ", mode=" + mode + ", bindstatus=" + bindstatus + '}';
    }
    
}
