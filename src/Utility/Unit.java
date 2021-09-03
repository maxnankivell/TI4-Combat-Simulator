package Utility;

public class Unit {

    private UnitNames name;

    private int hitValueSpaceCombat;
    private int numDiceRollsSpaceCombat;
    private int hitValueSpaceCannon;
    private int numDiceRollsSpaceCannon;
    private int hitValueAFB;
    private int numDiceRollsAFB;
    private int hitValueInvasion;
    private int numDiceRollsInvasion;
    private int hitValueBombardment;
    private int numDiceRollsBombardment;

    public Unit(Builder builder){
        this.hitValueSpaceCombat = builder.hitValueSpaceCombat;
        this.numDiceRollsSpaceCombat = builder.numDiceRollsSpaceCombat;
        this.hitValueSpaceCannon = builder.hitValueSpaceCannon;
        this.numDiceRollsSpaceCannon = builder.numDiceRollsSpaceCannon;
        this.hitValueAFB = builder.hitValueAFB;
        this.numDiceRollsAFB = builder.numDiceRollsAFB;
        this.hitValueInvasion = builder.hitValueInvasion;
        this.numDiceRollsInvasion = builder.numDiceRollsInvasion;
        this.hitValueBombardment = builder.hitValueBombardment;
        this.numDiceRollsBombardment = builder.numDiceRollsBombardment;
    }

    public static class Builder{
        private UnitNames name;

        private int hitValueSpaceCombat = 0;
        private int numDiceRollsSpaceCombat = 0;
        private int hitValueSpaceCannon = 0;
        private int numDiceRollsSpaceCannon = 0;
        private int hitValueAFB = 0;
        private int numDiceRollsAFB = 0;
        private int hitValueInvasion = 0;
        private int numDiceRollsInvasion = 0;
        private int hitValueBombardment = 0;
        private int numDiceRollsBombardment = 0;

        public Builder(UnitNames name){
            this.name=name;
        }

        public Builder addSpaceCombatValue(int hitValue, int numDiceRoll){
            this.hitValueSpaceCombat = hitValue;
            this.numDiceRollsSpaceCombat = numDiceRoll;
            return this;
        }

        public Builder addSpaceCannonValue(int hitValue, int numDiceRoll){
            this.hitValueSpaceCannon = hitValue;
            this.numDiceRollsSpaceCannon = numDiceRoll;
            return this;
        }

        public Builder addAFBValue(int hitValue, int numDiceRoll){
            this.hitValueAFB = hitValue;
            this.numDiceRollsAFB = numDiceRoll;
            return this;
        }

        public Builder addInvasionValue(int hitValue, int numDiceRoll){
            this.hitValueInvasion = hitValue;
            this.numDiceRollsInvasion = numDiceRoll;
            return this;
        }

        public Builder addBombardmentValue(int hitValue, int numDiceRoll){
            this.hitValueBombardment = hitValue;
            this.numDiceRollsBombardment = numDiceRoll;
            return this;
        }

        public Unit build(){
            return new Unit(this);
        }

    }

    public UnitNames getName() {
        return name;
    }

    public void setName(UnitNames name) {
        this.name = name;
    }

    public int getHitValueSpaceCombat() {
        return hitValueSpaceCombat;
    }

    public void setHitValueSpaceCombat(int hitValueSpaceCombat) {
        this.hitValueSpaceCombat = hitValueSpaceCombat;
    }

    public int getNumDiceRollsSpaceCombat() {
        return numDiceRollsSpaceCombat;
    }

    public void setNumDiceRollsSpaceCombat(int numDiceRollsSpaceCombat) {
        this.numDiceRollsSpaceCombat = numDiceRollsSpaceCombat;
    }

    public int getHitValueSpaceCannon() {
        return hitValueSpaceCannon;
    }

    public void setHitValueSpaceCannon(int hitValueSpaceCannon) {
        this.hitValueSpaceCannon = hitValueSpaceCannon;
    }

    public int getNumDiceRollsSpaceCannon() {
        return numDiceRollsSpaceCannon;
    }

    public void setNumDiceRollsSpaceCannon(int numDiceRollsSpaceCannon) {
        this.numDiceRollsSpaceCannon = numDiceRollsSpaceCannon;
    }

    public int getHitValueAFB() {
        return hitValueAFB;
    }

    public void setHitValueAFB(int hitValueAFB) {
        this.hitValueAFB = hitValueAFB;
    }

    public int getNumDiceRollsAFB() {
        return numDiceRollsAFB;
    }

    public void setNumDiceRollsAFB(int numDiceRollsAFB) {
        this.numDiceRollsAFB = numDiceRollsAFB;
    }

    public int getHitValueInvasion() {
        return hitValueInvasion;
    }

    public void setHitValueInvasion(int hitValueInvasion) {
        this.hitValueInvasion = hitValueInvasion;
    }

    public int getNumDiceRollsInvasion() {
        return numDiceRollsInvasion;
    }

    public void setNumDiceRollsInvasion(int numDiceRollsInvasion) {
        this.numDiceRollsInvasion = numDiceRollsInvasion;
    }

    public int getHitValueBombardment() {
        return hitValueBombardment;
    }

    public void setHitValueBombardment(int hitValueBombardment) {
        this.hitValueBombardment = hitValueBombardment;
    }

    public int getNumDiceRollsBombardment() {
        return numDiceRollsBombardment;
    }

    public void setNumDiceRollsBombardment(int numDiceRollsBombardment) {
        this.numDiceRollsBombardment = numDiceRollsBombardment;
    }
}
