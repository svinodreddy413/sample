/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vm.beans.xml;

import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author VMHDCLAP030
 */
@XmlRootElement(name = "MESSAGE")
@XmlAccessorType(XmlAccessType.FIELD)
public class MessageReq {

    @XmlElement(name = "USER")
    private User user;
    @XmlElement(name = "SMS")
    private List<sms> sms;

    /**
     * @return the sms
     */
    public List<sms> getSms() {
        return sms;
    }

    /**
     * @param sms the sms to set
     */
    public void setSms(List<sms> sms) {
        this.sms = sms;
    }

    /**
     * @return the user
     */
    public User getUser() {
        return user;
    }

    /**
     * @param user the user to set
     */
    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "MessageReq{" + "user=" + user + ", sms=" + sms + '}';
    }

}
