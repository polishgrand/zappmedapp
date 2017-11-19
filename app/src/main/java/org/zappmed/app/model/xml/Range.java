package org.zappmed.app.model.xml;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import java.util.Date;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Range {

    @JacksonXmlProperty(localName = "from")
    private Date dateFrom;

    @JacksonXmlProperty(localName = "to")
    private Date dateTo;

    @JacksonXmlProperty(localName = "sections")
    private String section;

    public Date getDateFrom() {
        return dateFrom;
    }

    public Date getDateTo() {
        return dateTo;
    }

    public String getSection() {
        return section;
    }

    @Override
    public String toString() {
        return "Range {" +
                "\n\tdateFrom = " + dateFrom +
                ",\n\tdateTo = " + dateTo +
                ",\n\tsection = '" + section + "\' }";
    }
}
