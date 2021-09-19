package Player;

import Controllers.CombatType;
import Factions.FactionEnum;
import GUIData.OptionData;
import Units.Unit;
import Units.UnitList;
import Units.UnitName;

import java.util.ArrayList;
import java.util.EnumMap;

public abstract class Player {

    protected UnitList unitList;

    protected int numHits;
    protected int numInfantryHits;
    protected int numSustainDamageHits;
    protected int numNonFighterHits;

    protected FactionEnum factionEnum;
    protected EnumMap<OptionData, Boolean> optionData;

    //Main constructor
    protected Player(FactionEnum factionEnum, EnumMap<OptionData, Boolean> optionData) {
        this.factionEnum = factionEnum;
        this.optionData = optionData;
    }

    /**
     * adds the titans hero unit to the list of units
     */
    public void addUnitTitansHero(){
        unitList.add(new Unit.Builder(UnitName.OTHER)
                .addSpaceCannonValue(5,3)
                .build());
    }

    /**
     * adds the experimental battlestation unit to the list of units
     */
    public void addUnitExperimentalBattlestation(){
        unitList.add(new Unit.Builder(UnitName.OTHER)
                .addSpaceCannonValue(5,3)
                .build());
    }

    /**
     * stops all pds from firing and turns off planetary shield
     */
    public void disablePDS(){
        for (Unit unit: unitList.getUnitArrayList()){
            if (unit.getName()==UnitName.PDS){
                unit.setNumDiceRollsSpaceCannon(0);
                unit.setHitValueSpaceCannon(0);
                unit.setPlanetaryShield(false);
            }
        }
    }

    /**
     * adds a dice to the best possible unit given this stage of combat
     * @param combatType the current stage of combat
     */
    public void addOneDiceToBestUnit(CombatType combatType){
        Unit lowestHitValue = unitList.get(0);
        for (Unit unit : unitList.getUnitArrayList()) {
            if ((unit.getHitValue(combatType) < lowestHitValue.getHitValue(combatType) && unit.getHitValue(combatType) != 0) || lowestHitValue.getHitValue(combatType) == 0) {
                lowestHitValue = unit;
            }
        }
        if (lowestHitValue.getHitValue(combatType) != 0) {
            lowestHitValue.addNumDiceRolls(combatType, 1);
        }
    }

    /**
     * adds a dice to all units of a specific type given this stage of combat
     * @param combatType the current stage of combat
     * @param unitName name of unit
     */
    public void addDiceToSpecificUnitType(CombatType combatType, UnitName unitName){
        for (Unit unit : unitList.getUnitArrayList()) {
            if (unit.getName() == unitName && unit.getNumDiceRolls(combatType) != 0) {
                unit.addNumDiceRolls(combatType, 1);
            }
        }
    }

    /**
     * adds to all units in this stage of combat
     * @param combatType the current stage of combat
     * @param addAmount amount added to the units hit values
     */
    public void changeHitValueOfAllUnits(CombatType combatType, int addAmount){
        for (Unit unit : unitList.getUnitArrayList()) {
            if (unit.getHitValue(combatType) != 0) {
                unit.addHitValue(combatType, addAmount);
            }
        }
    }

    /**
     * Modifies hit value of all units of a specific type in this stage of combat
     * @param combatType the current stage of combat
     * @param addAmount amount added to the units hit values
     * @param unitName name of unit
     */
    public void changeHitValueOfAllUnitsOfSpecificType(CombatType combatType, int addAmount, UnitName unitName){
        for (Unit unit : unitList.getUnitArrayList()) {
            if (unit.getName() == unitName && unit.getHitValue(combatType) != 0) {
                unit.addHitValue(combatType, addAmount);
            }
        }
    }

    public int getNumHits() {
        return numHits;
    }

    public int getNumInfantryHits() {
        return numInfantryHits;
    }

    public int getNumSustainDamageHits() {
        return numSustainDamageHits;
    }

    public int getNumNonFighterHits() {
        return numNonFighterHits;
    }

    public UnitList getUnitList(){
        return unitList;
    }

    public ArrayList<Unit> getUnitArrayList(){
        return unitList.getUnitArrayList();
    }

    public FactionEnum getFactionEnum() {
        return factionEnum;
    }

    public EnumMap<OptionData, Boolean> getOptionData() {
        return optionData;
    }

    public void addNumHits(int numHits){
        this.numHits+=numHits;
    }

    public void addNumInfantryHits(int numInfantryHits){
        this.numInfantryHits+=numInfantryHits;
    }

    public void addNumSustainDamageHits(int numSustainDamageHits){
        this.numSustainDamageHits+=numSustainDamageHits;
    }

    public void addNumNonFighterHits(int numNonFighterHits){
        this.numNonFighterHits+=numNonFighterHits;
    }

}
