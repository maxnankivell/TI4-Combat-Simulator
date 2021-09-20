package Factions;

import Units.Unit;
import Units.UnitName;

public abstract class Faction {
    protected Unit flagship;
    protected Unit warsun;
    protected Unit dreadnought;
    protected Unit carrier;
    protected Unit cruiser;
    protected Unit destroyer;
    protected Unit fighter;
    protected Unit mech;
    protected Unit infantry;
    protected Unit pds;

    /**
     * creates each unit with the default unit values
     */
    public Faction() {
        flagship = new Unit.Builder(UnitName.FLAGSHIP)
                .addSpaceCombatValue(7, 2)
                .build();
        warsun = new Unit.Builder(UnitName.WARSUN)
                .addSpaceCombatValue(3, 3)
                .addBombardmentValue(3, 3)
                .build();
        dreadnought = new Unit.Builder(UnitName.DREADNOUGHT)
                .addSpaceCombatValue(5, 1)
                .addBombardmentValue(5, 1)
                .build();
        carrier = new Unit.Builder(UnitName.CARRIER)
                .addSpaceCombatValue(9, 1)
                .build();
        cruiser = new Unit.Builder(UnitName.CRUISER)
                .addSpaceCombatValue(7, 1)
                .build();
        destroyer = new Unit.Builder(UnitName.DESTROYER)
                .addSpaceCombatValue(9, 1)
                .addAFBValue(9, 2)
                .build();
        fighter = new Unit.Builder(UnitName.FIGHTER)
                .addSpaceCombatValue(9, 1)
                .build();
        pds = new Unit.Builder(UnitName.PDS)
                .addSpaceCannonValue(6, 1)
                .addIsPlanetaryShield()
                .build();
        infantry = new Unit.Builder(UnitName.INFANTRY)
                .addGroundCombatValue(8, 1)
                .build();
        mech = new Unit.Builder(UnitName.MECH)
                .addGroundCombatValue(6, 1)
                .build();
    }

    public void upgradeFlagship(){ }

    public void upgradeDreadnought(){
        dreadnought = new Unit.Builder(UnitName.DREADNOUGHT)
                .addIsUpgraded()
                .addSpaceCombatValue(5, 1)
                .addBombardmentValue(5, 1)
                .build();
    }

    public void upgradeCarrier(){
        carrier = new Unit.Builder(UnitName.CARRIER)
                .addIsUpgraded()
                .addSpaceCombatValue(9, 1)
                .build();
    }

    public void upgradeCruiser(){
        cruiser = new Unit.Builder(UnitName.CRUISER)
                .addIsUpgraded()
                .addSpaceCombatValue(6,1)
                .build();
    }

    public void upgradeDestroyer(){
        destroyer = new Unit.Builder(UnitName.DESTROYER)
                .addIsUpgraded()
                .addSpaceCombatValue(8,1)
                .addAFBValue(6,3)
                .build();
    }

    public void upgradeFighter(){
        fighter = new Unit.Builder(UnitName.FIGHTER)
                .addIsUpgraded()
                .addSpaceCombatValue(8,1)
                .build();
    }

    public void upgradePds(){
        pds = new Unit.Builder(UnitName.PDS)
                .addIsUpgraded()
                .addSpaceCannonValue(5,1)
                .addIsPlanetaryShield()
                .build();
    }

    public void upgradeInfantry(){
        infantry = new Unit.Builder(UnitName.INFANTRY)
                .addIsUpgraded()
                .addGroundCombatValue(7,1)
                .build();
    }


    //getters and setters for each unit

    public Unit getFlagship() {
        return flagship;
    }

    public void setFlagship(Unit flagship) {
        this.flagship = flagship;
    }

    public Unit getWarsun() {
        return warsun;
    }

    public void setWarsun(Unit warsun) {
        this.warsun = warsun;
    }

    public Unit getDreadnought() {
        return dreadnought;
    }

    public void setDreadnought(Unit dreadnought) {
        this.dreadnought = dreadnought;
    }

    public Unit getCarrier() {
        return carrier;
    }

    public void setCarrier(Unit carrier) {
        this.carrier = carrier;
    }

    public Unit getCruiser() {
        return cruiser;
    }

    public void setCruiser(Unit cruiser) {
        this.cruiser = cruiser;
    }

    public Unit getDestroyer() {
        return destroyer;
    }

    public void setDestroyer(Unit destroyer) {
        this.destroyer = destroyer;
    }

    public Unit getFighter() {
        return fighter;
    }

    public void setFighter(Unit fighter) {
        this.fighter = fighter;
    }

    public Unit getMech() {
        return mech;
    }

    public void setMech(Unit mech) {
        this.mech = mech;
    }

    public Unit getInfantry() {
        return infantry;
    }

    public void setInfantry(Unit infantry) {
        this.infantry = infantry;
    }

    public Unit getPds() {
        return pds;
    }

    public void setPds(Unit pds) {
        this.pds = pds;
    }
}
