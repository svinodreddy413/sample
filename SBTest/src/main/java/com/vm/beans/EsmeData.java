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
public class EsmeData {
    String userId;
    int Count;

    public EsmeData(String userId, int Count) {
        this.userId = userId;
        this.Count = Count;
    }
    
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public int getCount() {
        return Count;
    }

    public void setCount(int Count) {
        this.Count = Count;
    }

    @Override
    public String toString() {
        return "EsmeData{" + "userId=" + userId + ", Count=" + Count + '}';
    }
    
    
}
