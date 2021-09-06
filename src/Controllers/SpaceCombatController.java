package Controllers;

import GUIData.AttackerOptions;
import GUIData.DefenderOptions;
import GUIData.FactionEnum;
import Units.Unit;
import Units.UnitList;
import Units.UnitName;

import java.util.ArrayList;

public class SpaceCombatController extends Controller{

    public SpaceCombatController(){
        super();
    }

    @Override
    public void startProcess() {
        attackerPreProcess();
        defenderPreProcess();

        attackerMainProcess();
        defenderMainProcess();

        attackerPostProcess();
        defenderPostProcess();
    }

    /**
     * Method to run through all pre-combat modifiers for the attacker
     */
    public void attackerPreProcess(){
        //Populate the number of dice for the winnu flagship
        if(AttackerOptions.getAttackerFactionCB() == FactionEnum.WINNU && attacker.containsName(UnitName.FLAGSHIP)){
            winnuFlagship(attacker, defender);
        }

        if(AttackerOptions.isFighterPrototypeAttackerCheckbox()){
            attacker.changeHitValueOfAllUnitsOfSpecificType(CombatType.SPACECOMBAT,-2, UnitName.FIGHTER, UnitName.FIGHTERUPGRADE);
        }
        if(AttackerOptions.isMoraleBoostAttackerCheckbox()){
            attacker.changeHitValueOfAllUnits(CombatType.SPACECOMBAT, -1);
        }
        if(AttackerOptions.isWinnuCommanderAttackerCheckbox()){
            attacker.changeHitValueOfAllUnits(CombatType.SPACECOMBAT, -2);
        }
        if(AttackerOptions.isProphecyOfIxthAttackerCheckbox()){
            attacker.changeHitValueOfAllUnitsOfSpecificType(CombatType.SPACECOMBAT,-1, UnitName.FIGHTER, UnitName.FIGHTERUPGRADE);
        }
        if(AttackerOptions.getAttackerFactionCB() == FactionEnum.SARDAKKNORR && attacker.containsName(UnitName.FLAGSHIP)){
            sardakNorrFlagship(attacker);
        }

        if(AttackerOptions.getAttackerFactionCB() == FactionEnum.NAAZROKHA && attacker.containsName(UnitName.FLAGSHIP)){
            attacker.addDiceToSpecificUnitType(CombatType.SPACECOMBAT,UnitName.MECH, UnitName.MECH);
        }
        if(AttackerOptions.isBaronyAgentAttackerCheckbox()){
            attacker.addOneDiceToBestUnit(CombatType.SPACECOMBAT);
        }
    }

    /**
     * Method to run through the main combat process for the attacker
     */
    public void attackerMainProcess(){

        //Start the rolling for each unit
        for (Unit unit : attacker.getUnitArrayList()) {
            ArrayList<Integer> diceRolls = new ArrayList<>();

            //roll amount of dice necessary for one unit
            for (int i=0; i<unit.getNumDiceRollsSpaceCombat(); i++){
                diceRolls.add(diceRoll());
            }

            //Check re-roll conditions

            //Check number of hits from this unit
            for (Integer roll : diceRolls) {
                if(roll >= unit.getHitValueSpaceCombat()){
                    numHitsAttacker++;
                }

                //JolNar Flagship
                if(AttackerOptions.getAttackerFactionCB() == FactionEnum.JOLNAR && unit.getName() == UnitName.FLAGSHIP && roll >= 9) {
                    numHitsAttacker += 2;
                }
                //L1Z1X Flagship
                if(AttackerOptions.getAttackerFactionCB() == FactionEnum.L1Z1X && attacker.containsName(UnitName.FLAGSHIP)) {
                    l1Z1XFlagshipAttacker(roll, unit);
                }
            }
        }
    }

    /**
     * Method to run through all post-combat modifiers for the attacker
     */
    public void attackerPostProcess(){
    }

    /**
     * Method to run through all pre-combat modifiers for the defender
     */
    private void defenderPreProcess() {
        //Populate the number of dice for the winnu flagship
        if(DefenderOptions.getDefenderFactionCB() == FactionEnum.WINNU && defender.containsName(UnitName.FLAGSHIP)){
            winnuFlagship(defender, attacker);
        }

        if(DefenderOptions.isFighterPrototypeDefenderCheckbox()){
            defender.changeHitValueOfAllUnitsOfSpecificType(CombatType.SPACECOMBAT,-2, UnitName.FIGHTER, UnitName.FIGHTERUPGRADE);
        }
        if(DefenderOptions.isMoraleBoostDefenderCheckbox()){
            defender.changeHitValueOfAllUnits(CombatType.SPACECOMBAT, -1);
        }
        if(DefenderOptions.isWinnuCommanderDefenderCheckbox()){
            defender.changeHitValueOfAllUnits(CombatType.SPACECOMBAT, -2);
        }
        if(DefenderOptions.isProphecyOfIxthDefenderCheckbox()){
            defender.changeHitValueOfAllUnitsOfSpecificType(CombatType.SPACECOMBAT, -1, UnitName.FIGHTER, UnitName.FIGHTERUPGRADE);
        }
        if(DefenderOptions.getDefenderFactionCB() == FactionEnum.SARDAKKNORR && defender.containsName(UnitName.FLAGSHIP)){
            sardakNorrFlagship(defender);
        }

        if(DefenderOptions.getDefenderFactionCB() == FactionEnum.NAAZROKHA && defender.containsName(UnitName.FLAGSHIP)){
            defender.addDiceToSpecificUnitType(CombatType.SPACECOMBAT, UnitName.MECH, UnitName.MECH);
        }
        if(DefenderOptions.isBaronyAgentDefenderCheckbox()){
            defender.addOneDiceToBestUnit(CombatType.SPACECOMBAT);
        }
    }

    /**
     * Method to run through the main combat process for the defender
     */
    private void defenderMainProcess() {

        //Start the rolling for each unit
        for (Unit unit : defender.getUnitArrayList()) {
            ArrayList<Integer> diceRolls = new ArrayList<>();

            //roll amount of dice necessary for one unit
            for (int i=0; i<unit.getNumDiceRollsSpaceCombat(); i++){
                diceRolls.add(diceRoll());
            }

            //Check re-roll conditions

            //Check number of hits from this unit
            for (Integer roll : diceRolls) {
                if(roll >= unit.getHitValueSpaceCombat()){
                    numHitsDefender++;
                }

                //JolNar Flagship
                if(DefenderOptions.getDefenderFactionCB() == FactionEnum.JOLNAR && unit.getName() == UnitName.FLAGSHIP && roll >= 9) {
                    numHitsDefender += 2;
                }
                //L1Z1X Flagship
                if(DefenderOptions.getDefenderFactionCB() == FactionEnum.L1Z1X && defender.containsName(UnitName.FLAGSHIP)) {
                    l1Z1XFlagshipDefender(roll, unit);
                }
            }
        }
    }

    /**
     * Method to run through all post-combat modifiers for the defender
     */
    private void defenderPostProcess() {
    }

    private void sardakNorrFlagship(UnitList myUnits){
        myUnits.changeHitValueOfAllUnits(CombatType.SPACECOMBAT, -1);
        for (Unit unit : myUnits.getUnitArrayList()) {
            if(unit.getName() == UnitName.FLAGSHIP){
                unit.setHitValueSpaceCombat(unit.getHitValueSpaceCombat()+1);
            }
        }
    }

    /**
     * Method to set the number of dice the winnu flagship will roll
     * @param myUnits Arraylist of the current players units
     * @param opponentUnits Arraylist of the opponent players units
     */
    private void winnuFlagship(UnitList myUnits, UnitList opponentUnits) {
        for (Unit unit : myUnits.getUnitArrayList()) {
            if(unit.getName() == UnitName.FLAGSHIP){
                unit.setNumDiceRollsSpaceCombat(opponentUnits.numOfNonFighterShips());
            }
        }
    }

    /**
     * Method for the L1Z1X Flagship that produces hits against non fighter ship
     * @param roll the number that was rolled by the unit being passed in
     * @param unit the unit being passed in
     */
    private void l1Z1XFlagshipAttacker(Integer roll, Unit unit) {
        if(unit.getName() == UnitName.FLAGSHIP || unit.getName() == UnitName.DREADNOUGHT || unit.getName() == UnitName.DREADNOUGHTUPGRADE){
            if(roll >= unit.getHitValueSpaceCombat()){
                numHitsAttacker--;
                numNonFighterHitsAttacker++;
            }
        }
    }

    /**
     * Method for the L1Z1X Flagship that produces hits against non fighter ship
     * @param roll the number that was rolled by the unit being passed in
     * @param unit the unit being passed in
     */
    private void l1Z1XFlagshipDefender(Integer roll, Unit unit) {
        if(unit.getName() == UnitName.FLAGSHIP || unit.getName() == UnitName.DREADNOUGHT || unit.getName() == UnitName.DREADNOUGHTUPGRADE){
            if(roll >= unit.getHitValueSpaceCombat()){
                numHitsDefender--;
                numNonFighterHitsDefender++;
            }
        }
    }
}
