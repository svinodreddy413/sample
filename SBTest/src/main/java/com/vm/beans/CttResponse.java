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
public class CttResponse implements Serializable {
    
    private static final long serialVersionUID = 112234444455L;
    
    int id;
    String campaignId;
    int campaignType;
    int messagesCount;
    int status;
    String insertTime;
    int processedCount;
    String resumedTime;

    public CttResponse(int id, String campaignId, int campaignType, int messagesCount, int status, String insertTime, int processedCount, String resumedTime) {
        this.id = id;
        this.campaignId = campaignId;
        this.campaignType = campaignType;
        this.messagesCount = messagesCount;
        this.status = status;
        this.insertTime = insertTime;
        this.processedCount = processedCount;
        this.resumedTime = resumedTime;
    }

    public CttResponse() {
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCampaignId() {
        return campaignId;
    }

    public void setCampaignId(String campaignId) {
        this.campaignId = campaignId;
    }

    public int getCampaignType() {
        return campaignType;
    }

    public void setCampaignType(int campaignType) {
        this.campaignType = campaignType;
    }

    public int getMessagesCount() {
        return messagesCount;
    }

    public void setMessagesCount(int messagesCount) {
        this.messagesCount = messagesCount;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getInsertTime() {
        return insertTime;
    }

    public void setInsertTime(String insertTime) {
        this.insertTime = insertTime;
    }

    public int getProcessedCount() {
        return processedCount;
    }

    public void setProcessedCount(int processedCount) {
        this.processedCount = processedCount;
    }

    public String getResumedTime() {
        return resumedTime;
    }

    public void setResumedTime(String resumedTime) {
        this.resumedTime = resumedTime;
    }

    @Override
    public String toString() {
        return "CttResponse{" + "id=" + id + ", campaignId=" + campaignId + ", campaignType=" + campaignType + ", messagesCount=" + messagesCount + ", status=" + status + ", insertTime=" + insertTime + ", processedCount=" + processedCount + ", resumedTime=" + resumedTime + '}';
    }
    
}
