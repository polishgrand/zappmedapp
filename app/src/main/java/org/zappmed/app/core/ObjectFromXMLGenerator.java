package org.zappmed.app.core;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.apache.commons.lang3.StringUtils;
import org.zappmed.app.model.xml.Transaction;
import org.zappmed.app.model.xml.Transactions;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ObjectFromXMLGenerator {

    private Transactions model;

    public Transactions getModel() {
        return model;
    }
    public void generateModelFromXML() {
        ObjectMapper objectMapper = new XmlMapper();
        try {
            model = objectMapper.readValue(
                    StringUtils.toEncodedString(Files.readAllBytes(Paths.get("C:\\Users\\polishgrand\\Documents\\GitHub\\zappmedapp\\app\\src\\main\\resources\\test_data.xml")), StandardCharsets.UTF_8),
                    Transactions.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
