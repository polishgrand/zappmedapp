package org.zappmed.app.model.xml;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;

import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Transaction {

    private int transactionID;

    @JacksonXmlProperty(localName = "Id")
    private String id;

    @JacksonXmlProperty(localName = "parentId")
    private String parentId;

    @JacksonXmlProperty(localName = "RecipientCompanyName")
    private String RecipientCompanyName;

    @JacksonXmlProperty(localName = "RecipientCountryCode")
    private String RecipientCountryCode;

    @JacksonXmlProperty(localName = "RecipientCountryName")
    private String RecipientCountryName;

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

    @JacksonXmlProperty(localName = "subtransactions")
    private Subtransactions subtransactions;

    @JacksonXmlProperty(localName = "positions")
    private Positions positions;

    @JacksonXmlProperty(localName = "notes")
    private Notes notes;


    public int getTransactionID() {
        return transactionID;
    }

    public void setTransactionID(int transactionID) {
        this.transactionID = transactionID;
    }

    public String getId() {
        return id;
    }

    public void setSubtransactions(Subtransactions subtransactions) {
        this.subtransactions = subtransactions;
    }

    public String getParentId() {
        return parentId;
    }

    public String getRecipientCompanyName() {
        return RecipientCompanyName;
    }

    public String getRecipientCountryCode() {
        return RecipientCountryCode;
    }

    public String getRecipientCountryName() {
        return RecipientCountryName;
    }

    public String getName() {
        return name;
    }

    public String getOrderId() {
        return orderId;
    }

    public String getCustomerLogin() {
        return customerLogin;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public String getRecipientName() {
        return recipientName;
    }

    public String getRecipientPhone() {
        return recipientPhone;
    }

    public String getRecipientAddress() {
        return recipientAddress;
    }

    public String getRecipientZip() {
        return recipientZip;
    }

    public String getRecipientCity() {
        return recipientCity;
    }

    public String getDeliveryType() {
        return deliveryType;
    }

    public Subtransactions getSubtransactions() {
        return subtransactions;
    }

    public Positions getPositions() {
        return positions;
    }

    public Notes getNotes() {
        return notes;
    }

    @Override
    public String toString() {
        return "Transaction {" +
                "\n\tid = '" + id + '\'' +
                ",\n\tname = '" + name + '\'' +
                ",\n\torderId = '" + orderId + '\'' +
                ",\n\tcustomerLogin = '" + customerLogin + '\'' +
                ",\n\tcustomerEmail = '" + customerEmail + '\'' +
                ",\n\trecipientName = '" + recipientName + '\'' +
                ",\n\trecipientPhone = '" + recipientPhone + '\'' +
                ",\n\trecipientAddress = '" + recipientAddress + '\'' +
                ",\n\trecipientZip = '" + recipientZip + '\'' +
                ",\n\trecipientCity = '" + recipientCity + '\'' +
                ",\n\tdeliveryType = '" + deliveryType + "\' }";
    }

    public Paragraph toPDFString() {

        Paragraph transactionParagraph = new Paragraph();
        if (customerLogin == null)
        {
            transactionParagraph.add(transactionID + ". Kupujący: niezarejestrowany - " + recipientName + ";");
        } else {
            transactionParagraph.add(transactionID + ". Kupujący: " + customerLogin + " - " + recipientName + ";");
        }
        transactionParagraph.add(Chunk.NEWLINE);
        transactionParagraph.add("Adresat: " + recipientAddress + ", " + recipientZip + ", " + recipientCity + ";");
        transactionParagraph.add(Chunk.NEWLINE);
        transactionParagraph.add("Sposób dostawy: " + deliveryType + ";");
        return transactionParagraph;
    }
}
