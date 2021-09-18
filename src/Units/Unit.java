package Units;

import Controllers.CombatType;

import java.util.Objects;

public class Unit {

    private UnitName name;

    //hit values for each stage of combat
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

    private boolean isUpgraded;
    private boolean isPlanetaryShield;

    /**
     * gets values for fields from Builder object
     * @param builder a Builder class
     */
    public Unit(Builder builder){
        this.name = builder.name;
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
        this.isPlanetaryShield = builder.isPlanetaryShield;
        this.isUpgraded = builder.isUpgraded;
    }

    /**
     * copies a existing unit
     * @param master a existing unit
     */
    public Unit(Unit master){
        this.name = master.name;
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
        this.isPlanetaryShield = master.isPlanetaryShield;
        this.isUpgraded = master.isUpgraded;
    }

    public static class Builder{
        private final UnitName name;

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

        private boolean isUpgraded = false;
        private boolean isPlanetaryShield = false;

        /**
         * fills mandatory fields
         * @param name the unit name
         */
        public Builder(UnitName name){
            this.name=name;
        }

        /**
         * adds space combat ability to unit
         * @param hitValue what the unit hits on
         * @param numDiceRoll how many dice the unit rolls
         * @return the builder
         */
        public Builder addSpaceCombatValue(int hitValue, int numDiceRoll){
            this.hitValueSpaceCombat = hitValue;
            this.numDiceRollsSpaceCombat = numDiceRoll;
            return this;
        }

        /**
         * adds space cannon ability to unit
         * @param hitValue what the unit hits on
         * @param numDiceRoll how many dice the unit rolls
         * @return the builder
         */
        public Builder addSpaceCannonValue(int hitValue, int numDiceRoll){
            this.hitValueSpaceCannon = hitValue;
            this.numDiceRollsSpaceCannon = numDiceRoll;
            return this;
        }

        /**
         * adds AFB ability to unit
         * @param hitValue what the unit hits on
         * @param numDiceRoll how many dice the unit rolls
         * @return the builder
         */
        public Builder addAFBValue(int hitValue, int numDiceRoll){
            this.hitValueAFB = hitValue;
            this.numDiceRollsAFB = numDiceRoll;
            return this;
        }

        /**
         * adds ground combat ability to unit
         * @param hitValue what the unit hits on
         * @param numDiceRoll how many dice the unit rolls
         * @return the builder
         */
        public Builder addGroundCombatValue(int hitValue, int numDiceRoll){
            this.hitValueGroundCombat = hitValue;
            this.numDiceRollsGroundCombat = numDiceRoll;
            return this;
        }

        /**
         * adds bombardment ability to unit
         * @param hitValue what the unit hits on
         * @param numDiceRoll how many dice the unit rolls
         * @return the builder
         */
        public Builder addBombardmentValue(int hitValue, int numDiceRoll){
            this.hitValueBombardment = hitValue;
            this.numDiceRollsBombardment = numDiceRoll;
            return this;
        }

        /**
         * adds planetary defense to a unit
         * @return the builder
         */
        public Builder addIsPlanetaryShield(){
            this.isPlanetaryShield = true;
            return this;
        }

        /**
         * adds upgrade to a unit
         * @return the builder
         */
        public Builder addIsUpgraded(){
            this.isUpgraded = true;
            return this;
        }

        /**
         * builds the unit
         * @return the unit
         */
        public Unit build(){
            return new Unit(this);
        }

    }

    public void setBombardmentValue(int hitValueBombardment, int numDiceRollsBombardment) {
        this.hitValueBombardment = hitValueBombardment;
        this.numDiceRollsBombardment = numDiceRollsBombardment;
    }

    public void setGroundCombatValue(int hitValueGroundCombat, int numDiceRollsGroundCombat) {
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

    public int getHitValue(CombatType combatType) {
        return switch (combatType) {
            case AFB -> hitValueAFB;
            case BOMBARDMENT -> hitValueBombardment;
            case GROUNDCOMBAT -> hitValueGroundCombat;
            case SPACECOMBAT -> hitValueSpaceCombat;
            case SPACECANNON -> hitValueSpaceCannon;
        };
    }

    public int getNumDiceRolls(CombatType combatType) {
        return switch (combatType) {
            case AFB -> numDiceRollsAFB;
            case BOMBARDMENT -> numDiceRollsBombardment;
            case GROUNDCOMBAT -> numDiceRollsGroundCombat;
            case SPACECOMBAT -> numDiceRollsSpaceCombat;
            case SPACECANNON -> numDiceRollsSpaceCannon;
        };
    }

    public void addNumDiceRolls(CombatType combatType, int numDice) {
        switch (combatType) {
            case AFB -> numDiceRollsAFB += numDice;
            case BOMBARDMENT -> numDiceRollsBombardment += numDice;
            case GROUNDCOMBAT -> numDiceRollsGroundCombat += numDice;
            case SPACECOMBAT -> numDiceRollsSpaceCombat += numDice;
            case SPACECANNON -> numDiceRollsSpaceCannon += numDice;
        }
    }

    public void addHitValue(CombatType combatType, int hitVal) {
        switch (combatType) {
            case AFB -> hitValueAFB += hitVal;
            case BOMBARDMENT -> hitValueBombardment += hitVal;
            case GROUNDCOMBAT -> hitValueGroundCombat += hitVal;
            case SPACECOMBAT -> hitValueSpaceCombat += hitVal;
            case SPACECANNON -> hitValueSpaceCannon += hitVal;
        }
    }

    public boolean isNonFighterShip(){
        return name == UnitName.CARRIER ||
                name == UnitName.CRUISER ||
                name == UnitName.FLAGSHIP ||
                name == UnitName.DESTROYER ||
                name == UnitName.DREADNOUGHT ||
                name == UnitName.WARSUN;
    }

    public boolean isShip(){
        return isNonFighterShip() || name == UnitName.FIGHTER;
    }

    public boolean isFlagshipOrDreadnought(){
        return name == UnitName.FLAGSHIP || name == UnitName.DREADNOUGHT;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Unit unit = (Unit) o;
        return name == unit.name;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    //getters and setters for fields
    public UnitName getName() {
        return name;
    }

    public void setName(UnitName name) {
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

    public boolean isUpgraded() {
        return isUpgraded;
    }

    public void setUpgraded(boolean upgraded) {
        isUpgraded = upgraded;
    }

    public boolean isPlanetaryShield() {
        return isPlanetaryShield;
    }

    public void setPlanetaryShield(boolean planetaryShield) {
        this.isPlanetaryShield = planetaryShield;
    }

}
