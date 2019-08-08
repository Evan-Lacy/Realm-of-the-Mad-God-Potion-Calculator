package edu.bsu.cs222;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ClassParser {

    private List<CharacterClass> classList = new ArrayList<>();

    private int life;
    private int maxLife;
    private int mana;
    private int maxMana;
    private int def;
    private int maxDef;
    private int atk;
    private int maxAtk;
    private int dex;
    private int maxDex;
    private int spd;
    private int maxSpd;
    private int wis;
    private int maxWis;
    private int vit;
    private int maxVit;

    private int numberOfCharacters = 14;

    public List<CharacterClass> createClasses(Document document) throws ParserConfigurationException, IOException, SAXException {
        NodeList classStats = document.getElementsByTagName("item");
        for (int i = 0; i < numberOfCharacters; i++) {
            Element item = (Element) classStats.item(i);
            getStats(item);
            setStats(item);
        }
        return classList;
    }

    //Refactor
    private void getStats(Element item) {
        life = Integer.parseInt(item.getAttribute("life"));
        maxLife = Integer.parseInt(item.getAttribute("maxLife"));
        mana = Integer.parseInt(item.getAttribute("mana"));
        maxMana = Integer.parseInt(item.getAttribute("maxMana"));
        def = Integer.parseInt(item.getAttribute("def"));
        maxDef = Integer.parseInt(item.getAttribute("maxDef"));
        atk = Integer.parseInt(item.getAttribute("atk"));
        maxAtk = Integer.parseInt(item.getAttribute("maxAtk"));
        dex = Integer.parseInt(item.getAttribute("dex"));
        maxDex = Integer.parseInt(item.getAttribute("maxDex"));
        spd = Integer.parseInt(item.getAttribute("spd"));
        maxSpd = Integer.parseInt(item.getAttribute("maxSpd"));
        wis = Integer.parseInt(item.getAttribute("wis"));
        maxWis = Integer.parseInt(item.getAttribute("maxWis"));
        vit = Integer.parseInt(item.getAttribute("vit"));
        maxVit = Integer.parseInt(item.getAttribute("maxVit"));
    }

    //can remove getStats with public void getStat(String stat)
        //Interger.parseInt(item.getAttribute(stat);
    //create a map or something to prevent myself from having to write out all 16 lines every time

    //Refactor
    private void setStats(Element item) {
        String className = item.getAttribute("class");
        CharacterClass character = CharacterClass.create()
                .setClassName(className)
                .setLife(life)
                .setMaxLife(maxLife)
                .setMana(mana)
                .setMaxMana(maxMana)
                .setDef(def)
                .setMaxDef(maxDef)
                .setAtk(atk)
                .setMaxAtk(maxAtk)
                .setDex(dex)
                .setMaxDex(maxDex)
                .setSpd(spd)
                .setMaxSpd(maxSpd)
                .setWis(wis)
                .setMaxWis(maxWis)
                .setVit(vit)
                .setMaxVit(maxVit)
                .build();
        classList.add(character);
    }
}