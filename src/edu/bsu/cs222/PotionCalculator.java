package edu.bsu.cs222;

public class PotionCalculator {
    private int potionsNeeded;

    public Max setMax(int max) {
        return new Max(max);
    }

    public final class Max {
        private int max;
        private Max(int max) { this.max = max; }

        public Current setCurrent(int current) { return new Current(current); }

        public final class Current {
            private int current;
            private Current(int current) { this.current = current; }
            public int addOnePotions() { //In Realm defense, attack, speed, dexterity, wisdom, and vitality only add one to the current stat
                potionsNeeded = max - current;
                return potionsNeeded;
            }
            public int addFivePotions() { //In realm Life, and Mana add five to the current stat
                double potionsCalc;
                potionsCalc = (max - current) / 5.0;
                potionsNeeded = (int) Math.ceil(potionsCalc);
                return potionsNeeded;
            }
        }
    }
}