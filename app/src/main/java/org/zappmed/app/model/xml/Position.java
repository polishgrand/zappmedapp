package org.zappmed.app.model.xml;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Position {

    @JacksonXmlProperty(localName = "transactionId")
    private String transactionID;

    @JacksonXmlProperty(localName = "Quantity")
    private int quantity;

    public Position() {
    }

    public String getTransactionID() {
        return transactionID;
    }

    public void setTransactionID(String transactionID) {
        this.transactionID = transactionID;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Position{" +
                "transactionID='" + transactionID + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}