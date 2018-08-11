package com.neo.xml;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "LOG")
public class PduLog implements Log, Cloneable {

    private String id;
    private String receivedDate;
    private String systemId;
    private String senderId;
    private String msisdn;
    private String message;
    private String priority;
    private byte delivery;
    private byte dataCoding;
    private byte esmClass;
    private String messageId;
    private String refId;
    private String udh;
    private String tlv;
    private String scheduleDeliveryTime;
    private String validityPeriod;
    private String prStatus = "process";
    private String source = "SMPP";
    private int charCount = 0;
    private int operatorid = 0;
    private int countryCode = 0;
    private CmdType cmdType = CmdType.NONE;

    @XmlAttribute(name = "TYPE")
    public CmdType getType() {
        return this.cmdType;
    }

    public void setType(CmdType cmdType) {
        this.cmdType = cmdType;
    }

    public String getReceivedDate() {
        return this.receivedDate;
    }

    @XmlElement(name = "DATE")
    public void setReceivedDate(String receivedDate) {
        this.receivedDate = receivedDate;
    }

    public String getSystemId() {
        return this.systemId;
    }

    @XmlElement(name = "USERID")
    public void setSystemId(String systemId) {
        this.systemId = systemId;
    }

    public String getSenderId() {
        return this.senderId;
    }

    @XmlElement(name = "SENDERID")
    public void setSenderId(String senderId) {
        this.senderId = senderId;
    }

    public String getMsisdn() {
        return this.msisdn;
    }

    @XmlElement(name = "MOBILENO")
    public void setMsisdn(String msisdn) {
        this.msisdn = msisdn;
    }

    public String getMessage() {
        return this.message;
    }

    @XmlElement(name = "MESSAGE")
    public void setMessage(String message) {
        this.message = message;
    }

    public String getPriority() {
        return this.priority;
    }

    @XmlElement(name = "PRIORITY")
    public void setPriority(String priority) {
        this.priority = priority;
    }

    public byte getDelivery() {
        return this.delivery;
    }

    @XmlElement(name = "DELIVERY")
    public void setDelivery(byte delivery) {
        this.delivery = delivery;
    }

    public byte getDataCoding() {
        return this.dataCoding;
    }

    @XmlElement(name = "DATACODING")
    public void setDataCoding(byte dataCoding) {
        this.dataCoding = dataCoding;
    }

    public String getRefId() {
        return this.refId;
    }

    @XmlElement(name = "REFID")
    public void setRefId(String refId) {
        this.refId = refId;
    }

    public String getMessageId() {
        return this.messageId;
    }

    @XmlElement(name = "MSGID")
    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }

    public String getUdh() {
        return this.udh;
    }

    @XmlElement(name = "UDH")
    public void setUdh(String udh) {
        this.udh = udh;
    }

    public String getTLV() {
        return this.tlv;
    }

    @XmlElement(name = "TLV")
    public void setTLV(String tlv) {
        this.tlv = tlv;
    }

    public String toString() {
        return "PduLog{cmdType=" + this.cmdType + ",id=" + this.id + ", receivedDate=" + this.receivedDate + ", systemId=" + this.systemId + ", senderId=" + this.senderId + ", msisdn=" + this.msisdn + ", message=" + this.message + ", priority=" + this.priority + ", delivery=" + this.delivery + ", dataCoding=" + this.dataCoding + ", esmClass=" + this.esmClass + ", messageId=" + this.messageId + ", refId=" + this.refId + ", udh=" + this.udh + ", tlv=" + this.tlv + ", scheduleDeliveryTime=" + this.scheduleDeliveryTime + ", validityPeriod=" + this.validityPeriod + ", prStatus=" + this.prStatus + '}';
    }

    public byte getEsmClass() {
        return this.esmClass;
    }

    @XmlElement(name = "ESMCLASS")
    public void setEsmClass(byte esmClass) {
        this.esmClass = esmClass;
    }

    public String getScheduleDeliveryTime() {
        return this.scheduleDeliveryTime;
    }

    @XmlElement(name = "SCHEDULEDELIVERYTIME")
    public void setScheduleDeliveryTime(String scheduleDeliveryTime) {
        this.scheduleDeliveryTime = scheduleDeliveryTime;
    }

    public String getValidityPeriod() {
        return this.validityPeriod;
    }

    @XmlElement(name = "VALIDITYPERIOD")
    public void setValidityPeriod(String validityPeriod) {
        this.validityPeriod = validityPeriod;
    }

    public String getPrStatus() {
        return this.prStatus;
    }

    @XmlElement(name = "PRSTATUS")
    public void setPrStatus(String prStatus) {
        this.prStatus = prStatus;
    }

    public Object clone()
            throws CloneNotSupportedException {
        return super.clone();
    }

    public String getId() {
        return this.id;
    }

    @XmlElement(name = "ID")
    public void setId(String id) {
        this.id = id;
    }

    public String getCdr() {
        StringBuilder buff = new StringBuilder();
        switch (this.cmdType) {
            case SUBMIT_SM:
                return "cmdType=" + this.cmdType + ",id=" + this.id + ", receivedDate=" + this.receivedDate + ", systemId=" + this.systemId + ", senderId=" + this.senderId + ", msisdn=" + this.msisdn + ", message=" + this.message.replaceAll(System.getProperty("line.separator"), "@NL@").replaceAll(",", "@COMMA@") + ", priority=" + this.priority + ", delivery=" + this.delivery + ", dataCoding=" + this.dataCoding + ", esmClass=" + this.esmClass + ", messageId=" + this.messageId + ", refId=" + this.refId + ", udh=" + this.udh + ", tlv=" + this.tlv + ", scheduleDeliveryTime=" + this.scheduleDeliveryTime + ", validityPeriod=" + this.validityPeriod + ", prStatus=" + this.prStatus + ", source=" + this.source + ", charcount=" + this.charCount + ", operatorid=" + this.operatorid + ", countrycode=" + this.countryCode;
            case SUBMIT_PR:
                return "cmdType=" + this.cmdType + ",id=" + this.id + ", receivedDate=" + this.receivedDate + ", systemId=" + this.systemId + ", messageId=" + this.messageId + ", refId=" + this.refId + ",prStatus=" + this.prStatus + ", source=" + this.source;
            case DLR:
                return "cmdType=" + this.cmdType + ",id=" + this.id + ", receivedDate=" + this.receivedDate + ", systemId=" + this.systemId + ", senderId=" + this.senderId + ", msisdn=" + this.msisdn + ", message=" + this.message.replaceAll(",", "@COMMA@") + ", delivery=" + this.delivery + ", dataCoding=" + this.dataCoding + ", esmClass=" + this.esmClass + ", messageId=" + this.messageId + ", refId=" + this.refId + ", prStatus=" + this.prStatus + ", source=" + this.source;
        }
        return "PduLog{cmdType=" + this.cmdType + ",id=" + this.id + ", receivedDate=" + this.receivedDate + ", systemId=" + this.systemId + ", senderId=" + this.senderId + ", msisdn=" + this.msisdn + ", message=" + this.message + ", priority=" + this.priority + ", delivery=" + this.delivery + ", dataCoding=" + this.dataCoding + ", esmClass=" + this.esmClass + ", messageId=" + this.messageId + ", refId=" + this.refId + ", udh=" + this.udh + ", tlv=" + this.tlv + ", scheduleDeliveryTime=" + this.scheduleDeliveryTime + ", validityPeriod=" + this.validityPeriod + ", prStatus=" + this.prStatus + ", source=" + this.source + ", charcount=" + this.charCount + '}';
    }

    public String getSource() {
        return this.source;
    }

    @XmlElement(name = "SOURCE")
    public void setSource(String source) {
        this.source = source;
    }

    public int getCharCount() {
        return this.charCount;
    }

    @XmlElement(name = "CHARCOUNT")
    public void setCharCount(int charCount) {
        this.charCount = charCount;
    }

    public int getOperatorid() {
        return this.operatorid;
    }

    @XmlElement(name = "OPERATORID")
    public void setOperatorid(int operatorid) {
        this.operatorid = operatorid;
    }

    public int getCountryCode() {
        return this.countryCode;
    }

    @XmlElement(name = "COUNTRYCODE")
    public void setCountryCode(int countryCode) {
        this.countryCode = countryCode;
    }
}
