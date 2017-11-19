package org.zappmed.app.model.xml;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Notes {

    @JacksonXmlElementWrapper(localName = "notes", useWrapping = false)
    private List<Note> note;

    public List<Note> getNote() {
        return note;
    }
}
