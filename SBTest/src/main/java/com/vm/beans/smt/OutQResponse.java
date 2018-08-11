/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vm.beans.smt;

/**
 *
 * @author VINODH
 */
public class OutQResponse {
    
    public String queueName;
    public String size;
    public String consumerCount;
    public String processCount;
    public String userId;
    public String name;

    public OutQResponse() {
    }

    public OutQResponse(String queueName, String size, String consumerCount, String processCount, String userId, String name) {
        this.queueName = queueName;
        this.size = size;
        this.consumerCount = consumerCount;
        this.processCount = processCount;
        this.userId = userId;
        this.name = name;
    }

    public String getQueueName() {
        return queueName;
    }

    public void setQueueName(String queueName) {
        this.queueName = queueName;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getConsumerCount() {
        return consumerCount;
    }

    public void setConsumerCount(String consumerCount) {
        this.consumerCount = consumerCount;
    }

    public String getProcessCount() {
        return processCount;
    }

    public void setProcessCount(String processCount) {
        this.processCount = processCount;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "OutQResponse{" + "queueName=" + queueName + ", size=" + size + ", consumerCount=" + consumerCount + ", processCount=" + processCount + ", userId=" + userId + ", name=" + name + '}';
    }
    
}
