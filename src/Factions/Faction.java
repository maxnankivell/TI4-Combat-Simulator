package Factions;

import Units.Unit;
import Units.UnitNames;

public abstract class Faction {
    protected Unit flagship;
    protected Unit flagshipUpgrade;
    protected Unit warsun;
    protected Unit dreadnought;
    protected Unit dreadnoughtUpgrade;
    protected Unit carrier;
    protected Unit carrierUpgrade;
    protected Unit cruiser;
    protected Unit cruiserUpgrade;
    protected Unit destroyer;
    protected Unit destroyerUpgrade;
    protected Unit fighter;
    protected Unit fighterUpgrade;
    protected Unit mech;
    protected Unit infantry;
    protected Unit infantryUpgrade;
    protected Unit pds;
    protected Unit pdsUpgrade;

    /**
     * creates each unit with the default unit values
     */
    public Faction(){
        warsun = new Unit.Builder(UnitNames.WARSUN)
                .addSpaceCombatValue(3,3)
                .addBombardmentValue(3,3)
                .build();
        dreadnought = new Unit.Builder(UnitNames.DREADNOUGHT)
                .addSpaceCombatValue(5,1)
                .addBombardmentValue(5,1)
                .build();
        dreadnoughtUpgrade = new Unit.Builder(UnitNames.DREADNOUGHTUPGRADE)
                .addSpaceCombatValue(5,1)
                .addBombardmentValue(5,1)
                .build();
        carrier = new Unit.Builder(UnitNames.CARRIER)
                .addSpaceCombatValue(9,1)
                .build();
        carrierUpgrade = new Unit.Builder(UnitNames.CARRIERUPGRADE)
                .addSpaceCombatValue(9,1)
                .build();
        cruiser = new Unit.Builder(UnitNames.CRUISER)
                .addSpaceCombatValue(7,1)
                .build();
        cruiserUpgrade = new Unit.Builder(UnitNames.CRUISERUPGRADE)
                .addSpaceCombatValue(6,1)
                .build();
        destroyer = new Unit.Builder(UnitNames.DESTROYER)
                .addSpaceCombatValue(9,1)
                .addAFBValue(9,2)
                .build();
        destroyerUpgrade = new Unit.Builder(UnitNames.DESTROYERUPGRADE)
                .addSpaceCombatValue(8,1)
                .addAFBValue(6,3)
                .build();
        fighter = new Unit.Builder(UnitNames.FIGHTER)
                .addSpaceCombatValue(9,1)
                .build();
        fighterUpgrade = new Unit.Builder(UnitNames.FIGHTERUPGRADE)
                .addSpaceCombatValue(8,1)
                .build();
        pds = new Unit.Builder(UnitNames.PDS)
                .addSpaceCombatValue(6,1)
                .build();
        pdsUpgrade = new Unit.Builder(UnitNames.PDSUPGRADE)
                .addSpaceCombatValue(5,1)
                .addPlanetaryDefense()
                .build();
        infantry = new Unit.Builder(UnitNames.INFANTRY)
                .addGroundCombatValue(8,1)
                .build();
        infantryUpgrade = new Unit.Builder(UnitNames.INFANTRYUPGRADE)
                .addGroundCombatValue(7,1)
                .build();
        mech = new Unit.Builder(UnitNames.MECH)
                .addGroundCombatValue(6,1)
                .build();
    }

    //getters and setters for each unit

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

    public Unit getDreadnoughtUpgrade() {
        return dreadnoughtUpgrade;
    }

    public void setDreadnoughtUpgrade(Unit dreadnoughtUpgrade) {
        this.dreadnoughtUpgrade = dreadnoughtUpgrade;
    }

    public Unit getCarrier() {
        return carrier;
    }

    public void setCarrier(Unit carrier) {
        this.carrier = carrier;
    }

    public Unit getCarrierUpgrade() {
        return carrierUpgrade;
    }

    public void setCarrierUpgrade(Unit carrierUpgrade) {
        this.carrierUpgrade = carrierUpgrade;
    }

    public Unit getCruiser() {
        return cruiser;
    }

    public void setCruiser(Unit cruiser) {
        this.cruiser = cruiser;
    }

    public Unit getCruiserUpgrade() {
        return cruiserUpgrade;
    }

    public void setCruiserUpgrade(Unit cruiserUpgrade) {
        this.cruiserUpgrade = cruiserUpgrade;
    }

    public Unit getDestroyer() {
        return destroyer;
    }

    public void setDestroyer(Unit destroyer) {
        this.destroyer = destroyer;
    }

    public Unit getDestroyerUpgrade() {
        return destroyerUpgrade;
    }

    public void setDestroyerUpgrade(Unit destroyerUpgrade) {
        this.destroyerUpgrade = destroyerUpgrade;
    }

    public Unit getFighter() {
        return fighter;
    }

    public void setFighter(Unit fighter) {
        this.fighter = fighter;
    }

    public Unit getFighterUpgrade() {
        return fighterUpgrade;
    }

    public void setFighterUpgrade(Unit fighterUpgrade) {
        this.fighterUpgrade = fighterUpgrade;
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

    public Unit getInfantryUpgrade() {
        return infantryUpgrade;
    }

    public void setInfantryUpgrade(Unit infantryUpgrade) {
        this.infantryUpgrade = infantryUpgrade;
    }

    public Unit getPds() {
        return pds;
    }

    public void setPds(Unit pds) {
        this.pds = pds;
    }

    public Unit getPdsUpgrade() {
        return pdsUpgrade;
    }

    public void setPdsUpgrade(Unit pdsUpgrade) {
        this.pdsUpgrade = pdsUpgrade;
    }

    public Unit getFlagship() {
        return flagship;
    }

    public void setFlagship(Unit flagship) {
        this.flagship = flagship;
    }

    public Unit getFlagshipUpgrade() {
        return flagshipUpgrade;
    }

    public void setFlagshipUpgrade(Unit flagshipUpgrade) {
        this.flagshipUpgrade = flagshipUpgrade;
    }
}
