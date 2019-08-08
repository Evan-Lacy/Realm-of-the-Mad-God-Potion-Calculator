package edu.bsu.cs222;

import org.junit.Assert;
import org.junit.Test;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class UIControllerTest {
    UIOutputController outputController = new UIOutputController();

    @Test
    public void testLifeMarketConversions() throws ParserConfigurationException, IOException, SAXException{
        outputController.lifePotions = 19;
        outputController.manaPotions = 12;
        outputController.defPotions = 40;
        outputController.atkPotions = 7;
        outputController.spdPotions = 24;
        outputController.dexPotions = 21;
        outputController.vitPotions = 37;
        outputController.wisPotions = 21;
        outputController.setUp();
        double tempLife = (double) outputController.lifePotions * outputController.potionConversionsList.get(0).toLife;
        double tempMana = (double) outputController.manaPotions * outputController.potionConversionsList.get(1).toLife;
        double tempDef = (double) outputController.defPotions * outputController.potionConversionsList.get(2).toLife;
        double tempAtk = (double) outputController.atkPotions * outputController.potionConversionsList.get(3).toLife;
        double tempSpd = (double) outputController.spdPotions * outputController.potionConversionsList.get(4).toLife;
        double tempDex =  (double) outputController.dexPotions * outputController.potionConversionsList.get(5).toLife;
        double tempWis =  (double) outputController.wisPotions * outputController.potionConversionsList.get(6).toLife;
        double tempVit =  (double) outputController.vitPotions * outputController.potionConversionsList.get(7).toLife;

        double temp = tempLife + tempMana + tempDef + tempAtk + tempSpd + tempDex + tempWis + tempVit;
        temp = Math.ceil(temp);
        Assert.assertEquals(46, temp, 0);
    }

}
