import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

import java.io.File;
import java.io.IOException;

public class XML_READ {
    public static void main(String[] args) {
        File xmlFile = new File("students.xml");

        try {
            Document students = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(xmlFile);
            System.out.println(students.getDocumentElement().getNodeName());

            NodeList studentsArray = students.getElementsByTagName("student");

            for (int i = 0; i < studentsArray.getLength(); i++) {
                if (studentsArray.item(i).getNodeType() == Node.ELEMENT_NODE) {
                    printStudent((Element) studentsArray.item(i));
                }
            }
        } catch (IOException | ParserConfigurationException | SAXException e) {
            e.printStackTrace();
        }
    }

    private static void printStudent(Element student) {
        System.out.println("Student id: " + student.getElementsByTagName("id").item(0).getTextContent());
        System.out.println("        firstname: " + student.getElementsByTagName("firstname").item(0).getTextContent());
        System.out.println("        lastname: " + student.getElementsByTagName("lastname").item(0).getTextContent());
        System.out.println("        subject: " + student.getElementsByTagName("subject").item(0).getTextContent());
        System.out.println("        marks: " + student.getElementsByTagName("marks").item(0).getTextContent());
    }
}
