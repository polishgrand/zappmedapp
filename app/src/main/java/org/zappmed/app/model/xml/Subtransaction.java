package org.zappmed.app.model.xml;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.BaseFont;

import java.awt.font.TextAttribute;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Subtransaction {

    @JacksonXmlProperty(localName = "transactionId")
    private String transactionID;

    @JacksonXmlProperty(localName = "Name")
    private String name;

    @JacksonXmlProperty(localName = "OrderId")
    private String OrderId;

    private int quantity;

    private String baseFontPath = "font/arial.ttf";

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
        if (quantity!=1) {
            try {
                subtransactionParagraph.setFont(new Font(BaseFont.createFont(baseFontPath, BaseFont.IDENTITY_H, BaseFont.EMBEDDED), 11, Font.BOLD|Font.UNDERLINE));
            } catch (DocumentException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        subtransactionParagraph.add(name + " (" + OrderId + ")" + " - Ilość: " + getQuantity() + " szt.");
        subtransactionParagraph.setSpacingBefore(0);
        subtransactionParagraph.setSpacingAfter(0);
        return subtransactionParagraph;
    }
}
