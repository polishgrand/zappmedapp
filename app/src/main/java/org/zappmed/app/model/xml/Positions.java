package org.zappmed.app.model.xml;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Positions {

    @JacksonXmlElementWrapper(localName = "positions", useWrapping = false)
    private List<Position> position;

    public List<Position> getPosition() {
        return position;
    }
}
