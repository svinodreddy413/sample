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
public class BlockingQueueResp {
    
    public String user;
    public String senderid;
    public String message;
    public String receivedtime;
    public String status;

    public BlockingQueueResp(String user, String senderid, String message, String receivedtime, String status) {
        this.user = user;
        this.senderid = senderid;
        this.message = message;
        this.receivedtime = receivedtime;
        this.status = status;
    }
    
    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getSenderid() {
        return senderid;
    }

    public void setSenderid(String senderid) {
        this.senderid = senderid;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getReceivedtime() {
        return receivedtime;
    }

    public void setReceivedtime(String receivedtime) {
        this.receivedtime = receivedtime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "BlockingQueueResp{" + "user=" + user + ", senderid=" + senderid + ", message=" + message + ", receivedtime=" + receivedtime + ", status=" + status + '}';
    }
    
}
