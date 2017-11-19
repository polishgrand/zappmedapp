package org.zappmed.app.model.xml;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Subtransactions {

    @JacksonXmlElementWrapper(localName = "subtransactions", useWrapping = false)
    private List<Subtransaction> subtransaction;

    public void setSubtransaction(List<Subtransaction> subtransaction) {
        this.subtransaction = subtransaction;
    }

    public List<Subtransaction> getSubtransaction() {
        return subtransaction;
    }
}
