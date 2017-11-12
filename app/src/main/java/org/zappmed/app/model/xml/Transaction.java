package org.zappmed.app.model.xml;

import java.util.ArrayList;
import java.util.List;

public class Transaction {
    private String customerLogin;
    private String customerEmail;
    private String recipientName;
    private String recipientPhone;
    private String recipientAddress;
    private String recipientZip;
    private String recipientCity;
    private String deliveryType;

    private List<Order> orderList;
    private List<Note> noteList;

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

    public List<Order> getOrderList() {
        if (orderList == null) {
            orderList = new ArrayList<>();
        }
        return this.orderList;
    }

    public List<Note> getNoteList() {
        if (noteList == null) {
            noteList = new ArrayList<>();
        }
        return this.noteList;
    }
}
