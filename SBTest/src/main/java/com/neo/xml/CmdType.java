/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.neo.xml;

/**
 *
 * @author VINODH
 */
public enum CmdType {
    SUBMIT_SM("SUBMIT_SM"), SUBMIT_PR("SUBMIT_PR"), SUBMITMULTI_SM("SUBMITMULTI_SM"), DELIVER_SM("DELIVER_SM"), DLR("DLR"), DATA_SM("DATA_SM"), NONE("NONE");

    private String type;

    private CmdType(String type) {
        this.type = type;
    }

    public String getValue() {
        return this.type;
    }
}
