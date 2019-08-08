package edu.bsu.cs222;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CharacterView {

    private ClassParser parser = new ClassParser();
    private XmlReader reader = new XmlReader();

    private int numberOfCharacters = 14;
    private Map<String, CharacterClass> classView = new HashMap<String, CharacterClass>();

    public Map<String, CharacterClass> createClassView(List<CharacterClass> classList) throws ParserConfigurationException, IOException, SAXException {
        classList = parser.createClasses(reader.readXml("XML/classStats.xml"));
        for (int i = 0; i < numberOfCharacters; i++) {
            classView.put(classList.get(i).className, classList.get(i));
        }
        return classView;
    }
}