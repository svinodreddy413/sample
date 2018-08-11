/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vm.beans;

import java.io.Serializable;

/**
 *
 * @author VINOD REDDY
 */
public class IncomingQueueResp implements Serializable {
    
    private static final long serialVersionUID = 112234444455L;

    private String queuename;
    private String user;
    private int consumers;
    private int pendingmessages;
    private int dequedmessages;
    private int processedmessages;

    public IncomingQueueResp() {
    }

    public IncomingQueueResp(String queuename, String user, int consumers, int pendingmessages, int dequedmessages, int processedmessages) {
        this.queuename = queuename;
        this.user = user;
        this.consumers = consumers;
        this.pendingmessages = pendingmessages;
        this.dequedmessages = dequedmessages;
        this.processedmessages = processedmessages;
    }

    public String getQueuename() {
        return queuename;
    }

    public void setQueuename(String queuename) {
        this.queuename = queuename;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public int getConsumers() {
        return consumers;
    }

    public void setConsumers(int consumers) {
        this.consumers = consumers;
    }

    public int getPendingmessages() {
        return pendingmessages;
    }

    public void setPendingmessages(int pendingmessages) {
        this.pendingmessages = pendingmessages;
    }

    public int getDequedmessages() {
        return dequedmessages;
    }

    public void setDequedmessages(int dequedmessages) {
        this.dequedmessages = dequedmessages;
    }

    public int getProcessedmessages() {
        return processedmessages;
    }

    public void setProcessedmessages(int processedmessages) {
        this.processedmessages = processedmessages;
    }

    @Override
    public String toString() {
        return "IncomingQueueResp{" + "queuename=" + queuename + ", user=" + user + ", consumers=" + consumers + ", pendingmessages=" + pendingmessages + ", dequedmessages=" + dequedmessages + ", processedmessages=" + processedmessages + '}';
    }

}
