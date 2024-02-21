package org.example;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.FileWriter;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String xmlFilename = "data.xml";
        String jsonFilename = "data2.json";

        List<Employee> list = XmlToJsonParser.parseXML(xmlFilename);
        String json = listToJson(list);
        writeString(jsonFilename, json);
    }

    public static String listToJson(List<Employee> list) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        return gson.toJson(list);
    }

    public static void writeString(String filename, String content) {
        try (FileWriter writer = new FileWriter(filename)) {
            writer.write(content);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
