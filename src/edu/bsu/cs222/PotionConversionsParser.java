package edu.bsu.cs222;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PotionConversionsParser {

    private List<PotionConversionsClass> potionList = new ArrayList<>();

    private double toLife;
    private double toMana;
    private double toDef;
    private double toAtk;
    private double toDex;
    private double toSpd;
    private double toVit;
    private double toWis;

    private int numberOfPotions = 8;

    public List<PotionConversionsClass> createPotionConversion(Document document) throws ParserConfigurationException, IOException, SAXException {
        NodeList classStats = document.getElementsByTagName("item");
        for (int i = 0; i < numberOfPotions; i++) {
            Element item = (Element) classStats.item(i);
            getConversions(item);
            setConversions(item);
        }
        return potionList;
    }

    //Refactor
    private void getConversions(Element item) {
        toLife = Double.parseDouble(item.getAttribute("toLife"));
        toMana = Double.parseDouble(item.getAttribute("toMana"));
        toDef = Double.parseDouble(item.getAttribute("toDef"));
        toAtk = Double.parseDouble(item.getAttribute("toAtk"));
        toDex = Double.parseDouble(item.getAttribute("toDex"));
        toSpd = Double.parseDouble(item.getAttribute("toSpd"));
        toVit = Double.parseDouble(item.getAttribute("toVit"));
        toWis = Double.parseDouble(item.getAttribute("toWis"));
    }

    //can remove getStats with public void getStat(String stat)
    //Interger.parseInt(item.getAttribute(stat);
    //create a map to prevent from having to write out same thing 8 times

    //Refactor
    private void setConversions(Element item) {
        String potionName = item.getAttribute("potion");
        PotionConversionsClass potion = PotionConversionsClass.create()
                .setPotionName(potionName)
                .setToLife(toLife)
                .setToMana(toMana)
                .setToDef(toDef)
                .setToAtk(toAtk)
                .setToDex(toDex)
                .setToSpd(toSpd)
                .setToVit(toVit)
                .setToWis(toWis)
                .build();
        potionList.add(potion);
    }
}
