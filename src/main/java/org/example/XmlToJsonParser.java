package org.example;

import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class XmlToJsonParser {

    public static List<Employee> parseXML(String filename) {
        List<Employee> employees = new ArrayList<>();
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(new File(filename));
            document.getDocumentElement().normalize();
            NodeList nodeList = document.getElementsByTagName("employee");

            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    Employee employee = new Employee();
                    employee.setId(Long.parseLong(element.getElementsByTagName("id").item(0).getTextContent()));
                    employee.setFirstName(element.getElementsByTagName("firstName").item(0).getTextContent());
                    employee.setLastName(element.getElementsByTagName("lastName").item(0).getTextContent());
                    employee.setCountry(element.getElementsByTagName("country").item(0).getTextContent());
                    employee.setAge(Integer.parseInt(element.getElementsByTagName("age").item(0).getTextContent()));
                    employees.add(employee);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return employees;
    }
}
