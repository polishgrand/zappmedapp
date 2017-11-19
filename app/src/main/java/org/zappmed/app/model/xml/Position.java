package org.zappmed.app.model.xml;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Position {

    @JacksonXmlProperty(localName = "transactionId")
    private String transactionID;

    @JacksonXmlProperty(localName = "Quantity")
    private int quantity;

    public String getTransactionID() {
        return transactionID;
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public String toString() {
        return "\tPosition {" +
                "\n\t\ttransactionID = '" + transactionID + '\'' +
                ",\n\t\tquantity = " + quantity + "\' }";
    }
}