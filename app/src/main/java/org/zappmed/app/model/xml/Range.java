package org.zappmed.app.model.xml;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import java.util.Date;

public class Range {

    @JacksonXmlProperty(localName = "from")
    private Date dateFrom;

    @JacksonXmlProperty(localName = "to")
    private Date dateTo;

    @JacksonXmlProperty(localName = "sections")
    private String section;

    public Range() {
    }

    public Date getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(Date dateFrom) {
        this.dateFrom = dateFrom;
    }

    public Date getDateTo() {
        return dateTo;
    }

    public void setDateTo(Date dateTo) {
        this.dateTo = dateTo;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    @Override
    public String toString() {
        return "Range{" +
                "dateFrom=" + dateFrom +
                ", dateTo=" + dateTo +
                ", section='" + section + '\'' +
                '}';
    }
}
