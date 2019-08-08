package edu.bsu.cs222;

import org.junit.Assert;
import org.junit.Test;

public class PotionCalculatorTest {
    PotionCalculator potion = new PotionCalculator();

    @Test
    public void PotionCalculateFiveTest() {
        Assert.assertEquals(potion.setMax(300).setCurrent(200).addFivePotions(), 20);
    }

    @Test
    public void PotionCalculateFiveImperfect() {
        Assert.assertEquals(potion.setMax(301).setCurrent(200).addFivePotions(), 21);
    }

    @Test
    public void PotionCalculateOne() {
        Assert.assertEquals(potion.setMax(20).setCurrent(0).addOnePotions(), 20);
    }
}