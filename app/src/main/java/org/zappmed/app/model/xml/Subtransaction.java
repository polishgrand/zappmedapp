package org.zappmed.app.model.xml;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Paragraph;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Subtransaction {

    @JacksonXmlProperty(localName = "transactionId")
    private String transactionID;

    @JacksonXmlProperty(localName = "Name")
    private String name;

    @JacksonXmlProperty(localName = "OrderId")
    private String OrderId;

    public Subtransaction() {
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
        subtransactionParagraph.add(name + " (" + OrderId + ")");
        return subtransactionParagraph;
    }
}
