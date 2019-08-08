package edu.bsu.cs222;

public class PotionConversionsClass {

    public static final class Builder {
        private String potionName;
        private double toLife;
        private double toMana;
        private double toDef;
        private double toAtk;
        private double toDex;
        private double toSpd;
        private double toWis;
        private double toVit;

        private Builder() {}

        public Builder setPotionName(String potionName) {
            this.potionName = potionName;
            return this;
        }

        public Builder setToLife(double toLife) {
            this.toLife = toLife;
            return this;
        }

        public Builder setToMana(double toMana) {
            this.toMana = toMana;
            return this;
        }

        public Builder setToDef(double toDef) {
            this.toDef = toDef;
            return this;
        }

        public Builder setToAtk(double toAtk) {
            this.toAtk = toAtk;
            return this;
        }

        public Builder setToDex(double toDex) {
            this.toDex = toDex;
            return this;
        }

        public Builder setToSpd(double toSpd) {
            this.toSpd = toSpd;
            return this;
        }

        public Builder setToVit(double toVit) {
            this.toVit = toVit;
            return this;
        }

        public Builder setToWis(double toWis) {
            this.toWis = toWis;
            return this;
        }

        public PotionConversionsClass build() {
            return new PotionConversionsClass(this);
        }
    }

    public static Builder create() {
        return new Builder();
    }

    public final String potionName;
    public final double toLife;
    public final double toMana;
    public final double toDef;
    public final double toAtk;
    public final double toDex;
    public final double toSpd;
    public final double toVit;
    public final double toWis;


    public PotionConversionsClass(Builder builder) {
        this.potionName = builder.potionName;
        this.toLife = builder.toLife;
        this.toMana = builder.toMana;
        this.toDef = builder.toDef;
        this.toAtk = builder.toAtk;
        this.toDex = builder.toDex;
        this.toSpd = builder.toSpd;
        this.toVit = builder.toVit;
        this.toWis = builder.toWis;
    }
}
