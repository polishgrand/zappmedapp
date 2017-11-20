package org.zappmed.app.model.xml;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.itextpdf.text.Paragraph;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Subtransaction {

    @JacksonXmlProperty(localName = "transactionId")
    private String transactionID;

    @JacksonXmlProperty(localName = "Name")
    private String name;

    @JacksonXmlProperty(localName = "OrderId")
    private String OrderId;

    private int quantity;

    public Subtransaction() {
    }

    public void setTransactionID(String transactionID) {
        this.transactionID = transactionID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setOrderId(String orderId) {
        OrderId = orderId;
    }


    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getTransactionID() {
        return transactionID;
    }

    public String getName() {
        return name;
    }

    public String getOrderId() {
        return OrderId;
    }

    @Override
    public String toString() {
        return "\tSubtransaction {" +
                "\n\t\ttransactionID = '" + transactionID + '\'' +
                ",\n\t\tname = '" + name + '\'' +
                ",\n\t\tOrderId = '" + OrderId + "\' }";
    }

    public Paragraph toPDFString() {

        Paragraph subtransactionParagraph = new Paragraph();
        subtransactionParagraph.add(name + " (" + OrderId + ")" + " - Ilość: " + getQuantity() + " szt.");
        subtransactionParagraph.setSpacingBefore(0);
        subtransactionParagraph.setSpacingAfter(0);
        return subtransactionParagraph;
    }
}
