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
public class ManageQResponse {
    
    public String queueName;
    public String size;
    public String consumerCount;
    public String processCount;

    public ManageQResponse() {
    }

    public ManageQResponse(String queueName, String size, String consumerCount, String processCount) {
        this.queueName = queueName;
        this.size = size;
        this.consumerCount = consumerCount;
        this.processCount = processCount;
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

    @Override
    public String toString() {
        return "ManageQResponse{" + "queueName=" + queueName + ", size=" + size + ", consumerCount=" + consumerCount + ", processCount=" + processCount + '}';
    }
    
}
