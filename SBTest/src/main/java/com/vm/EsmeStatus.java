/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vm;

/**
 *
 * @author VINODH
 */
public class EsmeStatus {

    public String source;
    public String userId;
    public String systemId;
    public String port;
    public String host;
    public String bindtype;
    public String time;
    public String status;
    public String sessionId;
    public String name;
    
     public EsmeStatus(){
         
     }

    public EsmeStatus(String source, String userId, String systemId, String port, String host, String bindtype, String time, String status, String sessionId, String name) {
        this.source = source;
        this.userId = userId;
        this.systemId = systemId;
        this.port = port;
        this.host = host;
        this.bindtype = bindtype;
        this.time = time;
        this.status = status;
        this.sessionId = sessionId;
        this.name = name;
    }

    @Override
    public String toString() {
        return "EsmeStatus{" + "source=" + source + ", userId=" + userId + ", systemId=" + systemId + ", port=" + port + ", host=" + host + ", bindtype=" + bindtype + ", time=" + time + ", status=" + status + ", sessionId=" + sessionId + ", name=" + name + '}';
    }

}
