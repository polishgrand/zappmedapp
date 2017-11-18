package org.zappmed.app.model.xml;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Transaction {


    @JacksonXmlProperty(localName = "Id")
    private String id;

    @JacksonXmlProperty(localName = "Name")
    private String name;

    @JacksonXmlProperty(localName = "OrderId")
    private String orderId;

    @JacksonXmlProperty(localName = "CustomerLogin")
    private String customerLogin;

    @JacksonXmlProperty(localName = "CustomerEmail")
    private String customerEmail;

    @JacksonXmlProperty(localName = "RecipientName")
    private String recipientName;

    @JacksonXmlProperty(localName = "RecipientPhone")
    private String recipientPhone;

    @JacksonXmlProperty(localName = "RecipientAddress")
    private String recipientAddress;

    @JacksonXmlProperty(localName = "RecipientZip")
    private String recipientZip;

    @JacksonXmlProperty(localName = "RecipientCity")
    private String recipientCity;

    @JacksonXmlProperty(localName = "DeliveryType")
    private String deliveryType;

    @JacksonXmlElementWrapper(localName = "subtransaction", useWrapping = false)
    private List<Subtransacion> subtransacions;

    @JacksonXmlElementWrapper(localName = "position", useWrapping = false)
    private List<Position> positions;

    @JacksonXmlProperty(localName = "from")
    private List<Note> noteList;

    public Transaction() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getCustomerLogin() {
        return customerLogin;
    }

    public void setCustomerLogin(String customerLogin) {
        this.customerLogin = customerLogin;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getRecipientName() {
        return recipientName;
    }

    public void setRecipientName(String recipientName) {
        this.recipientName = recipientName;
    }

    public String getRecipientPhone() {
        return recipientPhone;
    }

    public void setRecipientPhone(String recipientPhone) {
        this.recipientPhone = recipientPhone;
    }

    public String getRecipientAddress() {
        return recipientAddress;
    }

    public void setRecipientAddress(String recipientAddress) {
        this.recipientAddress = recipientAddress;
    }

    public String getRecipientZip() {
        return recipientZip;
    }

    public void setRecipientZip(String recipientZip) {
        this.recipientZip = recipientZip;
    }

    public String getRecipientCity() {
        return recipientCity;
    }

    public void setRecipientCity(String recipientCity) {
        this.recipientCity = recipientCity;
    }

    public String getDeliveryType() {
        return deliveryType;
    }

    public void setDeliveryType(String deliveryType) {
        this.deliveryType = deliveryType;
    }

    public List<Subtransacion> getSubtransacions() {
        return subtransacions;
    }

    public void setSubtransacions(List<Subtransacion> subtransacions) {
        this.subtransacions = subtransacions;
    }

    public List<Position> getPositions() {
        return positions;
    }

    public void setPositions(List<Position> positions) {
        this.positions = positions;
    }

    public List<Note> getNoteList() {
        return noteList;
    }

    public void setNoteList(List<Note> noteList) {
        this.noteList = noteList;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", orderId='" + orderId + '\'' +
                ", customerLogin='" + customerLogin + '\'' +
                ", customerEmail='" + customerEmail + '\'' +
                ", recipientName='" + recipientName + '\'' +
                ", recipientPhone='" + recipientPhone + '\'' +
                ", recipientAddress='" + recipientAddress + '\'' +
                ", recipientZip='" + recipientZip + '\'' +
                ", recipientCity='" + recipientCity + '\'' +
                ", deliveryType='" + deliveryType + '\'' +
                '}';
    }
}
