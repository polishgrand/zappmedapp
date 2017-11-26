package org.zappmed.app.core.products;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import java.net.URL;
import java.nio.file.Files;
import java.util.Map;

public class ProductBase {

    //private String basePath = "C:\\Users\\polishgrand\\Documents\\GitHub\\zappmedapp\\app\\src\\main\\resources\\jsonbasefile\\database.json";
    private String basePath = "/jsonbasefile/database.json";

    private Map<String,Object> baseProductMap;

    public String getBasePath() {
        return basePath;
    }

    public void setBasePath(String basePath) {
        basePath = basePath;
    }

    public Map<String, Object> getBaseProductMap() {
        return baseProductMap;
    }

    public void setBaseProductMap(Map<String, Object> baseProductMap) {
        this.baseProductMap = baseProductMap;
    }

    public void generateMap() {
        try {
            InputStream jsonStream = ProductBase.class.getResourceAsStream(basePath);
            BufferedInputStream jsonReader = new BufferedInputStream(jsonStream);
            ObjectMapper mapper = new ObjectMapper();

            baseProductMap = mapper.readValue(jsonReader ,new TypeReference<Map<String, Object>>() {});
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}