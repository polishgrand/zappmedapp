package org.zappmed.app.model.xml;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.util.ArrayList;
import java.util.List;

@JacksonXmlRootElement(localName = "transactions")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Transactions {

    @JacksonXmlProperty(localName = "range")
    private Range range;

    @JacksonXmlElementWrapper(localName = "transaction", useWrapping = false)
    private List<Transaction> transaction;

    public Range getRange() {
        return range;
    }

    public List<Transaction> getTransaction() {
        return transaction;
    }
}