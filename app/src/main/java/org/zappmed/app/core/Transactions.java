package org.zappmed.app.core;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@XmlRootElement
public class Transactions {

    private Date dateFrom;
    private Date dateTo;
    private String section;
    private List<Transaction> transactionList = new ArrayList<>();


    public Date getDateFrom() {
        return dateFrom;
    }

    @XmlElement(name = "from")
    public void setDateFrom(Date dateFrom) {
        this.dateFrom = dateFrom;
    }

    public Date getDateTo() {
        return dateTo;
    }

    @XmlElement(name = "to")
    public void setDateTo(Date dateTo) {
        this.dateTo = dateTo;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public List<Transaction> getTransactionList() {
        return transactionList;
    }

    public void setTransactionList(ArrayList transactionList) {
        this.transactionList = transactionList;
    }
}
