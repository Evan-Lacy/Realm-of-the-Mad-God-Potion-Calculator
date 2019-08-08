package edu.bsu.cs222;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UIOutputController {
    private CharacterView view = new CharacterView();
    private ClassParser parser = new ClassParser();
    private PotionConversionsParser conversionsParser = new PotionConversionsParser();
    private XmlReader read = new XmlReader();
    private PotionCalculator calculate = new PotionCalculator();

    private Document classStatsXML;
    private Document potionPricesXML;
    public List<CharacterClass> classList = new ArrayList<>();
    public Map<String, CharacterClass> classView = new HashMap<String, CharacterClass>();
    public List<PotionConversionsClass> potionConversionsList = new ArrayList<>();

    public String currentClassName = "Class";

    public int currentLife = 0;
    public int currentMana = 0;
    public int currentDef = 0;
    public int currentAtk = 0;
    public int currentSpd = 0;
    public int currentDex = 0;
    public int currentWis = 0;
    public int currentVit = 0;

    public int maxLife = 0;
    public int maxMana = 0;
    public int maxDef = 0;
    public int maxAtk = 0;
    public int maxSpd = 0;
    public int maxDex = 0;
    public int maxWis = 0;
    public int maxVit = 0;
    public int minimumStats = 0;

    public int lifePotions = 0;
    public int manaPotions = 0;
    public int defPotions = 0;
    public int atkPotions = 0;
    public int dexPotions = 0;
    public int spdPotions = 0;
    public int wisPotions = 0;
    public int vitPotions = 0;

    public void setUp() throws IOException, SAXException, ParserConfigurationException {
        classStatsXML = read.readXml("XML/classStats.xml");
        potionPricesXML = read.readXml("XML/potionPrices.xml");
        classList = parser.createClasses(classStatsXML);
        classView = view.createClassView(classList);
        potionConversionsList = conversionsParser.createPotionConversion(potionPricesXML);
    }

    public void setClassName(String className) {
        try {
            currentClassName = className;
        } catch (NullPointerException e) {
            currentClassName = "Class";
        }
    }

    public void setStartingStats() {
        currentLife = classView.get(currentClassName).life;
        currentMana = classView.get(currentClassName).mana;
        currentDef = classView.get(currentClassName).def;
        currentAtk = classView.get(currentClassName).atk;
        currentSpd = classView.get(currentClassName).spd;
        currentDex = classView.get(currentClassName).dex;
        currentWis = classView.get(currentClassName).wis;
        currentVit = classView.get(currentClassName).vit;
    }

    public void setMaxStats() {
        maxLife = classView.get(currentClassName).maxLife;
        maxMana = classView.get(currentClassName).maxMana;
        maxDef = classView.get(currentClassName).maxDef;
        maxAtk = classView.get(currentClassName).maxAtk;
        maxSpd = classView.get(currentClassName).maxSpd;
        maxDex = classView.get(currentClassName).maxDex;
        maxWis = classView.get(currentClassName).maxWis;
        maxVit = classView.get(currentClassName).maxVit;
    }

    public void setAllPotions() {
        setLifePotions();
        setManaPotions();
        setDefPotions();
        setAtkPotions();
        setSpdPotions();
        setDexPotions();
        setWisPotions();
        setVitPotions();
    }

    public void setLifePotions() {
        lifePotions = calculate.setMax(maxLife).setCurrent(currentLife).addFivePotions();
    }

    public void setManaPotions() {
        manaPotions = calculate.setMax(maxMana).setCurrent(currentMana).addFivePotions();
    }

    public void setDefPotions() {
        defPotions = calculate.setMax(maxDef).setCurrent(currentDef).addOnePotions();
    }

    public void setAtkPotions() {
        atkPotions = calculate.setMax(maxAtk).setCurrent(currentAtk).addOnePotions();
    }

    public void setSpdPotions() {
        spdPotions = calculate.setMax(maxSpd).setCurrent(currentSpd).addOnePotions();
    }

    public void setDexPotions() {
        dexPotions = calculate.setMax(maxDex).setCurrent(currentDex).addOnePotions();
    }

    public void setWisPotions() {
        wisPotions = calculate.setMax(maxWis).setCurrent(currentWis).addOnePotions();
    }

    public void setVitPotions() {
        vitPotions = calculate.setMax(maxVit).setCurrent(currentVit).addOnePotions();
    }

}
