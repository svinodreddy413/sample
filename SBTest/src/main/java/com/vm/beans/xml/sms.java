/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vm.beans.xml;

import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author VMHDCLAP030
 */
@XmlRootElement(name = "SMS")
@XmlAccessorType(XmlAccessType.FIELD)
public class sms {

    @XmlAttribute(name = "UDH")
    private String udh;
    @XmlAttribute(name = "CODING")
    private int coding;
    @XmlAttribute(name = "TEXT")
    private String text;
    @XmlAttribute(name = "PROPERTY")
    private String property;
    @XmlAttribute(name = "ID")
    private String id;
    @XmlAttribute(name = "DLR")
    private String dlr;
    @XmlAttribute(name = "VALIDITY")
    private String validity;

    @XmlElement(name = "ADDRESS")
    private List<Address> address;

    /**
     * @return the udh
     */
    public String getUdh() {
        return udh;
    }

    /**
     * @param udh the udh to set
     */
    public void setUdh(String udh) {
        this.udh = udh;
    }

    /**
     * @return the coding
     */
    public int getCoding() {
        return coding;
    }

    /**
     * @param coding the coding to set
     */
    public void setCoding(int coding) {
        this.coding = coding;
    }

    /**
     * @return the text
     */
    public String getText() {
        return text;
    }

    /**
     * @param text the text to set
     */
    public void setText(String text) {
        this.text = text;
    }

    /**
     * @return the property
     */
    public String getProperty() {
        return property;
    }

    /**
     * @param property the property to set
     */
    public void setProperty(String property) {
        this.property = property;
    }

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the dlr
     */
    public String getDlr() {
        return dlr;
    }

    /**
     * @param dlr the dlr to set
     */
    public void setDlr(String dlr) {
        this.dlr = dlr;
    }

    /**
     * @return the validity
     */
    public String getValidity() {
        return validity;
    }

    /**
     * @param validity the validity to set
     */
    public void setValidity(String validity) {
        this.validity = validity;
    }

    /**
     * @return the address
     */
    public List<Address> getAddress() {
        return address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(List<Address> address) {
        this.address = address;
    }
}
