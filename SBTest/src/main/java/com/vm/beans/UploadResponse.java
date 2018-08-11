/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vm.beans;

import java.io.Serializable;

/**
 *
 * @author VINODH
 */
public class UploadResponse implements Serializable {
    
    private static final long serialVersionUID = 112234444455L;
    
    public String status;
    public int count;
    public String uniqueId;

    public UploadResponse(String status, int count, String uniqueId) {
        this.status = status;
        this.count = count;
        this.uniqueId = uniqueId;
    }

    public String getUniqueId() {
        return uniqueId;
    }

    public void setUniqueId(String uniqueId) {
        this.uniqueId = uniqueId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "UploadResponse{" + "status=" + status + ", count=" + count + ", uniqueId=" + uniqueId + '}';
    }

}
