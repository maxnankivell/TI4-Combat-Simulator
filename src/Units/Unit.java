package Units;

public class Unit {

    private UnitNames name;

    private int hitValueSpaceCombat;
    private int numDiceRollsSpaceCombat;
    private int hitValueSpaceCannon;
    private int numDiceRollsSpaceCannon;
    private int hitValueAFB;
    private int numDiceRollsAFB;
    private int hitValueGroundCombat;
    private int numDiceRollsGroundCombat;
    private int hitValueBombardment;
    private int numDiceRollsBombardment;

    private boolean planetaryDefense;

    public Unit(Builder builder){
        this.hitValueSpaceCombat = builder.hitValueSpaceCombat;
        this.numDiceRollsSpaceCombat = builder.numDiceRollsSpaceCombat;
        this.hitValueSpaceCannon = builder.hitValueSpaceCannon;
        this.numDiceRollsSpaceCannon = builder.numDiceRollsSpaceCannon;
        this.hitValueAFB = builder.hitValueAFB;
        this.numDiceRollsAFB = builder.numDiceRollsAFB;
        this.hitValueGroundCombat = builder.hitValueGroundCombat;
        this.numDiceRollsGroundCombat = builder.numDiceRollsGroundCombat;
        this.hitValueBombardment = builder.hitValueBombardment;
        this.numDiceRollsBombardment = builder.numDiceRollsBombardment;
        this.planetaryDefense = builder.planetaryDefense;
    }

    public Unit(Unit master){
        this.hitValueSpaceCombat = master.hitValueSpaceCombat;
        this.numDiceRollsSpaceCombat = master.numDiceRollsSpaceCombat;
        this.hitValueSpaceCannon = master.hitValueSpaceCannon;
        this.numDiceRollsSpaceCannon = master.numDiceRollsSpaceCannon;
        this.hitValueAFB = master.hitValueAFB;
        this.numDiceRollsAFB = master.numDiceRollsAFB;
        this.hitValueGroundCombat = master.hitValueGroundCombat;
        this.numDiceRollsGroundCombat = master.numDiceRollsGroundCombat;
        this.hitValueBombardment = master.hitValueBombardment;
        this.numDiceRollsBombardment = master.numDiceRollsBombardment;
        this.planetaryDefense = master.planetaryDefense;
    }

    public static class Builder{
        private UnitNames name;

        private int hitValueSpaceCombat = 0;
        private int numDiceRollsSpaceCombat = 0;
        private int hitValueSpaceCannon = 0;
        private int numDiceRollsSpaceCannon = 0;
        private int hitValueAFB = 0;
        private int numDiceRollsAFB = 0;
        private int hitValueGroundCombat = 0;
        private int numDiceRollsGroundCombat = 0;
        private int hitValueBombardment = 0;
        private int numDiceRollsBombardment = 0;

        private boolean planetaryDefense = false;

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

        public Builder addGroundCombatValue(int hitValue, int numDiceRoll){
            this.hitValueGroundCombat = hitValue;
            this.numDiceRollsGroundCombat = numDiceRoll;
            return this;
        }

        public Builder addBombardmentValue(int hitValue, int numDiceRoll){
            this.hitValueBombardment = hitValue;
            this.numDiceRollsBombardment = numDiceRoll;
            return this;
        }

        public Builder addPlanetaryDefense(){
            this.planetaryDefense = true;
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

    public int getHitValueGroundCombat() {
        return hitValueGroundCombat;
    }

    public void setHitValueGroundCombat(int hitValueGroundCombat) {
        this.hitValueGroundCombat = hitValueGroundCombat;
    }

    public int getNumDiceRollsGroundCombat() {
        return numDiceRollsGroundCombat;
    }

    public void setNumDiceRollsGroundCombat(int numDiceRollsGroundCombat) {
        this.numDiceRollsGroundCombat = numDiceRollsGroundCombat;
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

    public boolean hasPlanetaryDefense() {
        return planetaryDefense;
    }

    public void setPlanetaryDefense(boolean planetaryDefense) {
        this.planetaryDefense = planetaryDefense;
    }

    public void setBombardmentValue(int hitValueBombardment, int numDiceRollsBombardment) {
        this.hitValueBombardment = hitValueBombardment;
        this.numDiceRollsBombardment = numDiceRollsBombardment;
    }


    public void setGroundCombatValue(int hitValueGroundCombat, int numDiceRollsGroundComba) {
        this.hitValueGroundCombat = hitValueGroundCombat;
        this.numDiceRollsGroundCombat = numDiceRollsGroundCombat;
    }

    public void setAFBValue(int hitValueAFB, int numDiceRollsAFB) {
        this.hitValueAFB = hitValueAFB;
        this.numDiceRollsAFB = numDiceRollsAFB;
    }

    public void setSpaceCannonValue(int hitValueSpaceCannon, int numDiceRollsSpaceCannon) {
        this.hitValueSpaceCannon = hitValueSpaceCannon;
        this.numDiceRollsSpaceCannon = numDiceRollsSpaceCannon;
    }

    public void setSpaceCombatValue(int hitValueSpaceCombat, int numDiceRollsSpaceCombat) {
        this.hitValueSpaceCombat = hitValueSpaceCombat;
        this.numDiceRollsSpaceCombat = numDiceRollsSpaceCombat;
    }

}
