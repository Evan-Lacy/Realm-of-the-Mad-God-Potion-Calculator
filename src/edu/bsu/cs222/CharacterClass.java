package edu.bsu.cs222;

public class CharacterClass {

    public static final class Builder {
        private String className;
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

        private Builder() {}

        public Builder setClassName(String className) {
            this.className = className;
            return this;
        }

        public Builder setLife(int life) {
            this.life = life;
            return this;
        }

        public Builder setMaxLife(int maxLife) {
            this.maxLife = maxLife;
            return this;
        }

        public Builder setMana(int mana) {
            this.mana = mana;
            return this;
        }

        public Builder setMaxMana(int maxMana) {
            this.maxMana = maxMana;
            return this;
        }

        public Builder setDef(int def) {
            this.def = def;
            return this;
        }

        public Builder setMaxDef(int maxDef) {
            this.maxDef = maxDef;
            return this;
        }

        public Builder setAtk(int atk) {
            this.atk = atk;
            return this;
        }

        public Builder setMaxAtk(int maxAtk) {
            this.maxAtk = maxAtk;
            return this;
        }

        public Builder setDex(int dex) {
            this.dex = dex;
            return this;
        }

        public Builder setMaxDex(int maxDex) {
            this.maxDex = maxDex;
            return this;
        }

        public Builder setSpd(int spd) {
            this.spd = spd;
            return this;
        }

        public Builder setMaxSpd(int maxSpd) {
            this.maxSpd = maxSpd;
            return this;
        }

        public Builder setVit(int vit) {
            this.vit = vit;
            return this;
        }

        public Builder setMaxVit(int maxVit) {
            this.maxVit = maxVit;
            return this;
        }

        public Builder setWis(int wis) {
            this.wis = wis;
            return this;
        }

        public Builder setMaxWis(int maxWis) {
            this.maxWis = maxWis;
            return this;
        }

        public CharacterClass build() {
            return new CharacterClass(this);
        }
    }

    public static Builder create() {
        return new Builder();
    }

    public final String className;
    public final int life;
    public final int maxLife;
    public final int mana;
    public final int maxMana;
    public final int def;
    public final int maxDef;
    public final int atk;
    public final int maxAtk;
    public final int dex;
    public final int maxDex;
    public final int spd;
    public final int maxSpd;
    public final int vit;
    public final int maxVit;
    public final int wis;
    public final int maxWis;

    public CharacterClass(Builder builder) {
        this.className = builder.className;
        this.life = builder.life;
        this.maxLife = builder.maxLife;
        this.mana = builder.mana;
        this.maxMana = builder.maxMana;
        this.def = builder.def;
        this.maxDef = builder.maxDef;
        this.atk = builder.atk;
        this.maxAtk = builder.maxAtk;
        this.dex = builder.dex;
        this.maxDex = builder.maxDex;
        this.spd = builder.spd;
        this.maxSpd = builder.maxSpd;
        this.vit = builder.vit;
        this.maxVit = builder.maxVit;
        this.wis = builder.wis;
        this.maxWis = builder.maxWis;
    }
}