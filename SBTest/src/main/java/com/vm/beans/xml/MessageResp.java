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
@XmlRootElement(name = "MESSAGEACK")
@XmlAccessorType(XmlAccessType.FIELD)
public class MessageResp {

    @XmlElement(name = "Error")
    private Error error;
    @XmlElement(name = "GUID")
    private List<Guid> guid;

    @XmlElement(name = "Err")
    private Err err;

    /**
     * @return the guid
     */
    public List<Guid> getGuid() {
        return guid;
    }

    /**
     * @param guid the guid to set
     */
    public void setGuid(List<Guid> guid) {
        this.guid = guid;
    }

    /**
     * @return the err
     */
    public Err getErr() {
        return err;
    }

    /**
     * @param err the err to set
     */
    public void setErr(Err err) {
        this.err = err;
    }

}
