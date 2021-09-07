package Controllers;

import Factions.*;
import GUIData.AttackerOptions;
import GUIData.DefenderOptions;
import GUIData.FactionEnum;
import Player.Player;
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
        if(attacker1.getFaction() instanceof Winnu && attacker1.getUnitList().containsName(UnitName.FLAGSHIP)){
            winnuFlagship(attacker1.getUnitList(), defender1.getUnitList());
        }

        if(AttackerOptions.isFighterPrototypeAttackerCheckbox()){
            attacker1.changeHitValueOfAllUnitsOfSpecificType(CombatType.SPACECOMBAT,-2, UnitName.FIGHTER, UnitName.FIGHTERUPGRADE);
        }
        if(AttackerOptions.isMoraleBoostAttackerCheckbox()){
            attacker1.changeHitValueOfAllUnits(CombatType.SPACECOMBAT, -1);
        }
        if(AttackerOptions.isWinnuCommanderAttackerCheckbox()){
            attacker1.changeHitValueOfAllUnits(CombatType.SPACECOMBAT, -2);
        }
        if(AttackerOptions.isProphecyOfIxthAttackerCheckbox()){
            attacker1.changeHitValueOfAllUnitsOfSpecificType(CombatType.SPACECOMBAT,-1, UnitName.FIGHTER, UnitName.FIGHTERUPGRADE);
        }
        if(attacker1.getFaction() instanceof SardakkNorr && attacker1.getUnitList().containsName(UnitName.FLAGSHIP)){
            sardakNorrFlagship(attacker1);
        }

        if(attacker1.getFaction() instanceof NaazRokha && attacker1.getUnitList().containsName(UnitName.FLAGSHIP)){
            attacker1.addDiceToSpecificUnitType(CombatType.SPACECOMBAT,UnitName.MECH, UnitName.MECH);
        }
        if(AttackerOptions.isBaronyAgentAttackerCheckbox()){
            attacker1.addOneDiceToBestUnit(CombatType.SPACECOMBAT);
        }
    }

    /**
     * Method to run through the main combat process for the attacker
     */
    public void attackerMainProcess(){

        //Start the rolling for each unit
        for (Unit unit : attacker1.getUnitArrayList()) {
            ArrayList<Integer> diceRolls = new ArrayList<>();

            //roll amount of dice necessary for one unit
            for (int i=0; i<unit.getNumDiceRollsSpaceCombat(); i++){
                diceRolls.add(diceRoll());
            }

            //Check re-roll conditions

            //Check number of hits from this unit
            for (Integer roll : diceRolls) {
                if(roll >= unit.getHitValueSpaceCombat()){
                    attacker1.addNumHits(1);
                }

                //JolNar Flagship
                if(attacker1.getFaction() instanceof JolNar && unit.getName() == UnitName.FLAGSHIP && roll >= 9) {
                    attacker1.addNumHits(2);
                }
                //L1Z1X Flagship
                if(attacker1.getFaction() instanceof L1Z1X && attacker1.getUnitList().containsName(UnitName.FLAGSHIP)) {
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
        if(defender1.getFaction() instanceof Winnu && defender1.getUnitList().containsName(UnitName.FLAGSHIP)){
            winnuFlagship(defender1.getUnitList(), attacker1.getUnitList());
        }

        if(DefenderOptions.isFighterPrototypeDefenderCheckbox()){
            defender1.changeHitValueOfAllUnitsOfSpecificType(CombatType.SPACECOMBAT,-2, UnitName.FIGHTER, UnitName.FIGHTERUPGRADE);
        }
        if(DefenderOptions.isMoraleBoostDefenderCheckbox()){
            defender1.changeHitValueOfAllUnits(CombatType.SPACECOMBAT, -1);
        }
        if(DefenderOptions.isWinnuCommanderDefenderCheckbox()){
            defender1.changeHitValueOfAllUnits(CombatType.SPACECOMBAT, -2);
        }
        if(DefenderOptions.isProphecyOfIxthDefenderCheckbox()){
            defender1.changeHitValueOfAllUnitsOfSpecificType(CombatType.SPACECOMBAT, -1, UnitName.FIGHTER, UnitName.FIGHTERUPGRADE);
        }
        if(DefenderOptions.getDefenderFactionCB() == FactionEnum.SARDAKKNORR && defender1.getUnitList().containsName(UnitName.FLAGSHIP)){
            sardakNorrFlagship(defender1);
        }

        if(defender1.getFaction() instanceof NaazRokha && defender1.getUnitList().containsName(UnitName.FLAGSHIP)){
            defender1.addDiceToSpecificUnitType(CombatType.SPACECOMBAT, UnitName.MECH, UnitName.MECH);
        }
        if(DefenderOptions.isBaronyAgentDefenderCheckbox()){
            defender1.addOneDiceToBestUnit(CombatType.SPACECOMBAT);
        }
    }

    /**
     * Method to run through the main combat process for the defender
     */
    private void defenderMainProcess() {

        //Start the rolling for each unit
        for (Unit unit : defender1.getUnitArrayList()) {
            ArrayList<Integer> diceRolls = new ArrayList<>();

            //roll amount of dice necessary for one unit
            for (int i=0; i<unit.getNumDiceRollsSpaceCombat(); i++){
                diceRolls.add(diceRoll());
            }

            //Check re-roll conditions

            //Check number of hits from this unit
            for (Integer roll : diceRolls) {
                if(roll >= unit.getHitValueSpaceCombat()){
                    defender1.addNumHits(1);
                }

                //JolNar Flagship
                if(defender1.getFaction() instanceof JolNar && unit.getName() == UnitName.FLAGSHIP && roll >= 9) {
                    defender1.addNumHits(1);
                }
                //L1Z1X Flagship
                if(defender1.getFaction() instanceof L1Z1X && defender1.getUnitList().containsName(UnitName.FLAGSHIP)) {
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

    private void sardakNorrFlagship(Player player){
        player.changeHitValueOfAllUnits(CombatType.SPACECOMBAT, -1);
        for (Unit unit : player.getUnitArrayList()) {
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
                attacker1.addNumHits(-1);
                attacker1.addNumNonFighterHits(1);
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
                defender1.addNumHits(-1);
                defender1.addNumNonFighterHits(1);
            }
        }
    }
}
