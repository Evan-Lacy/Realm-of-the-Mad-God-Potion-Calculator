package edu.bsu.cs222;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.InputStream;

public class XmlReader {

    public Document readXml(String file) throws ParserConfigurationException, SAXException, IOException {
        Document document;
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(file);
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        document = builder.parse(inputStream);
        return document;
    }

}