/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vm.controller;

import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author VINODH
 */
@RestController
@RequestMapping("/smslistener/sl/v1/mo/sms/partnername")
public class CustomRestReq {

    @RequestMapping(method = RequestMethod.GET, path = "/dc1", produces = MediaType.APPLICATION_JSON)
    public String get(@RequestParam("message_id") String messageId, @RequestParam("device_address") String deviceAddress,
            @RequestParam("inbound_address") String inboundAddr, @RequestParam("message_orig") String message,
            @RequestParam("carrier") String carrier) {
        
        System.out.println("=======================================================================================");
        
        System.out.println("message_id  : --->  " + messageId);
        System.out.println("device_address  : --->  " + deviceAddress);
        System.out.println("inbound_address   : --->  " + inboundAddr);
        System.out.println("message_orig   : --->  " + message);
        System.out.println("carrier  : --->  " + carrier);
        
        System.out.println("=======================================================================================");
        return "SUCCESS";
    }

}
