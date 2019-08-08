package edu.bsu.cs222;

import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.net.URL;
import java.util.*;

public class UIController implements Initializable{

    public ComboBox classSelectBox;
    public ImageView classImage;
    public Spinner<Integer> currentLifeText;
    public Spinner<Integer> currentManaText;
    public Spinner<Integer> currentDefText;
    public Spinner<Integer> currentAtkText;
    public Spinner<Integer> currentSpdText;
    public Spinner<Integer> currentDexText;
    public Spinner<Integer> currentWisText;
    public Spinner<Integer> currentVitText;
    public TextField maxLifeText;
    public TextField maxManaText;
    public TextField maxDefText;
    public TextField maxAtkText;
    public TextField maxSpdText;
    public TextField maxDexText;
    public TextField maxWisText;
    public TextField maxVitText;
    public TextField lifeToMaxText;
    public TextField manaToMaxText;
    public TextField defToMaxText;
    public TextField atkToMaxText;
    public TextField spdToMaxText;
    public TextField dexToMaxText;
    public TextField wisToMaxText;
    public TextField vitToMaxText;
    public TextField totalLifeToMaxText;
    public TextField totalManaToMaxText;
    public TextField totalDefToMaxText;
    public TextField totalAtkToMaxText;
    public TextField totalSpdToMaxText;
    public TextField totalDexToMaxText;
    public TextField totalWisToMaxText;
    public TextField totalVitToMaxText;

    private UIOutputController outputController = new UIOutputController();
    private UIInputController inputController = new UIInputController();
    private PotionCalculator calculate = new PotionCalculator();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            outputController.setUp();
        } catch(ParserConfigurationException e){
            e.printStackTrace();
        } catch(SAXException e) {
            e.printStackTrace();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    public void switchCurrentClass() {
        outputController.setClassName(classSelectBox.getValue().toString());
        outputController.setStartingStats();
        outputController.setMaxStats();
        outputController.setAllPotions();
        switchClassImage();
        switchMaxStatsText();
        switchCurrentStatsText();
        switchToMaxText();
        switchTotalToMaxText();
    }

    //refactor
    public void switchClassImage() {
        Image image = new Image("/Sprites/" + outputController.currentClassName + ".png");
        classImage.setImage(image);
    }

    //refactor
    public void switchMaxStatsText() {
        maxLifeText.setText(convertToString(outputController.maxLife));
        maxManaText.setText(convertToString(outputController.maxMana));
        maxDefText.setText(convertToString(outputController.maxDef));
        maxAtkText.setText(convertToString(outputController.maxAtk));
        maxSpdText.setText(convertToString(outputController.maxSpd));
        maxDexText.setText(convertToString(outputController.maxDex));
        maxWisText.setText(convertToString(outputController.maxWis));
        maxVitText.setText(convertToString(outputController.maxVit));
    }

    //refactor
    public void switchCurrentStatsText() {
        SpinnerValueFactory<Integer> lifeFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, outputController.maxLife, outputController.currentLife);
        currentLifeText.setValueFactory(lifeFactory);
        SpinnerValueFactory<Integer> manaFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, outputController.maxMana, outputController.currentMana);
        currentManaText.setValueFactory(manaFactory);
        SpinnerValueFactory<Integer> defFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, outputController.maxDef, outputController.currentDef);
        currentDefText.setValueFactory(defFactory);
        SpinnerValueFactory<Integer> atkFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, outputController.maxAtk, outputController.currentAtk);
        currentAtkText.setValueFactory(atkFactory);
        SpinnerValueFactory<Integer> spdFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, outputController.maxSpd, outputController.currentSpd);
        currentSpdText.setValueFactory(spdFactory);
        SpinnerValueFactory<Integer> dexFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, outputController.maxDex, outputController.currentDex);
        currentDexText.setValueFactory(dexFactory);
        SpinnerValueFactory<Integer> wisFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, outputController.maxWis, outputController.currentWis);
        currentWisText.setValueFactory(wisFactory);
        SpinnerValueFactory<Integer> vitFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, outputController.maxVit, outputController.currentVit);
        currentVitText.setValueFactory(vitFactory);
    }

    //refactor
    public void switchToMaxText() {
        lifeToMaxText.setText(convertToString(outputController.lifePotions));
        manaToMaxText.setText(convertToString(outputController.manaPotions));
        defToMaxText.setText(convertToString(outputController.defPotions));
        atkToMaxText.setText(convertToString(outputController.atkPotions));
        spdToMaxText.setText(convertToString(outputController.spdPotions));
        dexToMaxText.setText(convertToString(outputController.dexPotions));
        wisToMaxText.setText(convertToString(outputController.wisPotions));
        vitToMaxText.setText(convertToString(outputController.vitPotions));
    }

    public void totalMaxText(){

    }
        //refactor
    public void switchTotalToMaxText () {
        totalLifeToMaxText.setText(convertToString(outputController.lifePotions));
        totalManaToMaxText.setText(convertToString(outputController.lifePotions));
        totalDefToMaxText.setText(convertToString(outputController.lifePotions));
        totalAtkToMaxText.setText(convertToString(outputController.lifePotions));
        totalSpdToMaxText.setText(convertToString(outputController.lifePotions));
        totalDexToMaxText.setText(convertToString(outputController.lifePotions));
        totalWisToMaxText.setText(convertToString(outputController.lifePotions));
        totalVitToMaxText.setText(convertToString(outputController.lifePotions));
    }


    //should refactor this
    public String convertToString(int integer) {
        String intToString;
        intToString = Integer.toString(integer);
        return intToString;
    }

    public void tryAndCatch(){
        String variableOne =null;
        String variableTwo = null;
        String variableThree = null;
        String variableFour = null;
        String variableFive = null;
        String variableSix = null;
        try {
            outputController.variableOne = variableTwo.getValue();
            outputController.variableThree = calculate.setMax(outputController.variableFour).setCurrent(outputController.variableOne).addFivePotions();
            variableFive.setText(convertToString(outputController.variableThree));
        } catch(NullPointerException e) {
            outputController.variableOne = 0;
        }
    }

    //these need refactored vvvvvvvv
    public void updateLife() {
        try {
            outputController.currentLife = currentLifeText.getValue();
            outputController.lifePotions = calculate.setMax(outputController.maxLife).setCurrent(outputController.currentLife).addFivePotions();
            lifeToMaxText.setText(convertToString(outputController.lifePotions));
        } catch(NullPointerException e) {
            outputController.currentLife = 0;
        }
    }

    public void updateMana() {
        try {
            outputController.currentMana = currentManaText.getValue();
            outputController.manaPotions = calculate.setMax(outputController.maxMana).setCurrent(outputController.currentMana).addFivePotions();
            manaToMaxText.setText(convertToString(outputController.manaPotions));
        } catch (NullPointerException e) {
            outputController.currentMana = 0;
        }
    }

    public void updateDef() {
        try {
            outputController.currentDef = currentDefText.getValue();
            outputController.defPotions = calculate.setMax(outputController.maxDef).setCurrent(outputController.currentDef).addOnePotions();
            defToMaxText.setText(convertToString(outputController.defPotions));
        } catch(NullPointerException e) {
            outputController.currentDef = 0;
        }
    }

    public void updateAtk() {
        try {
            outputController.currentAtk = currentAtkText.getValue();
            outputController.atkPotions = calculate.setMax(outputController.maxAtk).setCurrent(outputController.currentAtk).addOnePotions();
            atkToMaxText.setText(convertToString(outputController.atkPotions));
        } catch(NullPointerException e) {
            outputController.currentAtk = 0;
        }
    }

    public void updateSpd() {
        try {
            outputController.currentSpd = currentSpdText.getValue();
            outputController.spdPotions = calculate.setMax(outputController.maxSpd).setCurrent(outputController.currentSpd).addOnePotions();
            spdToMaxText.setText(convertToString(outputController.spdPotions));
        } catch(NullPointerException e) {
            outputController.currentSpd = 0;
        }
    }

    public void updateDex() {
        try {
            outputController.currentDex = currentDexText.getValue();
            outputController.dexPotions = calculate.setMax(outputController.maxDex).setCurrent(outputController.currentDex).addOnePotions();
            dexToMaxText.setText(convertToString(outputController.dexPotions));
        } catch(NullPointerException e) {
            outputController.currentDex = 0;
        }
    }

    public void updateWis() {
        try {
            outputController.currentWis = currentWisText.getValue();
            outputController.wisPotions = calculate.setMax(outputController.maxWis).setCurrent(outputController.currentWis).addOnePotions();
            wisToMaxText.setText(convertToString(outputController.wisPotions));
        } catch(NullPointerException e) {
            outputController.currentWis = 0;
        }
    }

    public void updateVit() {
        try {
            outputController.currentVit = currentVitText.getValue();
            outputController.vitPotions = calculate.setMax(outputController.maxVit).setCurrent(outputController.currentVit).addOnePotions();
            vitToMaxText.setText(convertToString(outputController.vitPotions));
        } catch(NullPointerException e) {
            outputController.currentVit = 0;
        }
    }

}