package utilities;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import jdk.nashorn.internal.parser.JSONParser;
import org.json.simple.JSONObject;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ConfigReader {
    private JsonNode data;

    public ConfigReader(String filePath) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            FileReader fileReader = new FileReader(filePath);
            data = objectMapper.readTree(fileReader);
            fileReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getUsername() {
        return data.get("username").asText();
    }

    public String getPassword() {
        return data.get("password").asText();
    }

    public String getInvalidUsername() {
        return data.get("invalidUsername").asText();
    }

    public String getInvalidPassword() {
        return data.get("invalidPassword").asText();
    }
    public String getUrl() {
        return data.get("url").asText();
    }

    public String getFirstName() {
        return data.get("firstName").asText();
    }

    public String getLastName() {
        return data.get("lastName").asText();
    }

    public String getPostalCode() {
        return data.get("postalCode").asText();
    }
}
