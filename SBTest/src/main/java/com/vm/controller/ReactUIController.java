/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vm.controller;

import com.vm.beans.react.Contact;
import com.vm.beans.react.Name;
import java.util.HashMap;
import java.util.Map;
import javax.ws.rs.core.MediaType;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.util.Random;
import java.util.List;
import java.util.ArrayList;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

/**
 *
 * @author indian
 */
@RestController
@RequestMapping("api")
public class ReactUIController {

    @RequestMapping(value = "/contacts", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON)
    public List<Contact> getContacts() {
        System.out.println("---------------------------    getContacts()    -----------------------------------------------");
        List<Contact> list = new ArrayList();
        Contact contact = null;
        Name name = null;

        Random rand = new Random();
        int randomNum = rand.nextInt((4 - 1) + 1) + 1;
        for (int i = 1; i < 5; i++) {
            name = getName(i);
            contact = new Contact("" + i, name, "9440649401" + i, name.getFirst() + "@gmail.com");
            list.add(contact);
        }
        return list;
    }

    public Name getName(int i) {
        switch (i) {
            case 1:
                return new Name("vinod", "reddy");
            case 2:
                return new Name("supriya", "Sampathi");
            case 3:
                return new Name("vinod", "sunkari");
            case 4:
                return new Name("Phani", "B");
            default:
                break;
        }
        return null;
    }

    @RequestMapping(value = "/contacts/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON)
    public Contact getContact(@PathVariable("id") Integer id) {
        System.out.println("Get Contact : -- > "+id);
        Contact contact = null;
        Name name = getName(id);
        contact = new Contact("" + id, name, "9440649401" + id, name.getFirst() + "@gmail.com");
        return contact;
    }
    
    @RequestMapping(value = "/contacts/{id}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON)
    public Contact updateContact(@PathVariable("id") Integer id, @RequestBody @Validated Contact con) {
        System.out.println("Update Contact : -- > "+id +" && Contact : --> "+con);
        Contact contact = null;
        Name name = getName(id);
        contact = new Contact("" + id, name, "9440649401" + id, name.getFirst() + "@gmail.com");
        return contact;
    }
    
    @RequestMapping(value = "/contacts/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON)
    public void deleteContact(@PathVariable("id") Integer id) {
        System.out.println("Delete Contact : -- > "+id);
        System.out.println("Deleted successfully");
    }
    
    @RequestMapping(value = "/contacts", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON)
    public void saveContact(@RequestBody @Validated Contact con) {
        System.out.println("Save New Contact : Contact : --> "+con);
        
    }

}
