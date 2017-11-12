package org.zappmed.app.model.xml;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.util.ArrayList;
import java.util.List;

@JacksonXmlRootElement(localName = "transactions")
public class Transactions {

    @JacksonXmlProperty(localName = "range")
    private Range range;

//    @JacksonXmlElementWrapper(localName = "transaction", useWrapping = false)
//    private List<Transaction> transactionList;

    public Transactions() {
    }

    public Range getRange() {
        return range;
    }

//    public List<Transaction> getTransactionList() {
//        if (transactionList == null) {
//            transactionList = new ArrayList<>();
//        }
//        return this.transactionList;
//    }

    @Override
    public String toString() {
        return "Transactions{" +
                "range=" + range +
                //", transactionList=" + transactionList +
                '}';
    }
}