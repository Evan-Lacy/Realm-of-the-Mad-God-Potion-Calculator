package edu.bsu.cs222;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PotionConversionsView {

    private PotionConversionsParser parser = new PotionConversionsParser();
    private XmlReader reader = new XmlReader();

    private int numberOfPotions = 8;
    private Map<String, PotionConversionsClass> potionConversionsView = new HashMap<String, PotionConversionsClass>();

    public Map<String, PotionConversionsClass> createClassView(List<PotionConversionsClass> potionConversionsList) throws ParserConfigurationException, IOException, SAXException {
        potionConversionsList = parser.createPotionConversion(reader.readXml("XML/potionPrices.xml"));
        for (int i = 0; i < numberOfPotions; i++) {
            potionConversionsView.put(potionConversionsList.get(i).potionName, potionConversionsList.get(i));
        }
        return potionConversionsView;
    }
}
