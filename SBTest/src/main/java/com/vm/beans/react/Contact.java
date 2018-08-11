/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vm.beans.react;

/**
 *
 * @author indian
 */
public class Contact {
    public String _id;
    public Name name;
    public String phone;
    public String email;
    
    public Contact() {
        
    }

    public Contact(String _id, Name name, String phone, String email) {
        this.name = name;
        this.phone = phone;
        this.email = email;
        this._id = _id;
    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getId() {
        return _id;
    }

    public void setId(String _id) {
        this._id = _id;
    }

    @Override
    public String toString() {
        return "Contact{" + "_id=" + _id + ", name=" + name + ", phone=" + phone + ", email=" + email + '}';
    }

    
    
}
