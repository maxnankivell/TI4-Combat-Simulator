package Controllers;

import GUIData.AttackerOptions;
import GUIData.DefenderOptions;
import GUIData.FactionEnum;
import Units.Unit;
import Units.UnitName;

import java.util.ArrayList;

public class SpaceCombatController extends Controller{

    public SpaceCombatController(){
        super();
    }

    @Override
    public void startProcess() {
        //War funding

        //Barony agent

        //Fighter prototype

        //Morale boost

        //Winnu commander

        //Prophecy of ixth

        //Defending in a nebula

        //Jol Nar flagship

        //Naaz Rokha flagship

        //Sardakk Norr flagship

        //Winnu flagship

        //L1Z1X flagship

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
        if(AttackerOptions.getAttackerFactionCB() == FactionEnum.WINNU && Controller.containsName(UnitName.FLAGSHIP, attacker)){
            winnuFlagship(attacker, defender);
        }

        if(AttackerOptions.isFighterPrototypeAttackerCheckbox()){
            changeHitValueOfAllUnitsOfSpecificType(CombatType.SPACECOMBAT, attacker, -2, UnitName.FIGHTER, UnitName.FIGHTERUPGRADE);
        }
        if(AttackerOptions.isMoraleBoostAttackerCheckbox()){
            changeHitValueOfAllUnits(CombatType.SPACECOMBAT, attacker, -1);
        }
        if(AttackerOptions.isWinnuCommanderAttackerCheckbox()){
            changeHitValueOfAllUnits(CombatType.SPACECOMBAT, attacker, -2);
        }
        if(AttackerOptions.isProphecyOfIxthAttackerCheckbox()){
            changeHitValueOfAllUnitsOfSpecificType(CombatType.SPACECOMBAT, attacker, -1, UnitName.FIGHTER, UnitName.FIGHTERUPGRADE);
        }
        if(AttackerOptions.getAttackerFactionCB() == FactionEnum.SARDAKKNORR && Controller.containsName(UnitName.FLAGSHIP, attacker)){
            changeHitValueOfAllUnits(CombatType.SPACECOMBAT, attacker, -1);
        }

        if(AttackerOptions.getAttackerFactionCB() == FactionEnum.NAAZROKHA && Controller.containsName(UnitName.FLAGSHIP, attacker)){
            addDiceToSpecificUnitType(CombatType.SPACECOMBAT, attacker, UnitName.MECH, UnitName.MECH);
        }
        if(AttackerOptions.isBaronyAgentAttackerCheckbox()){
            addOneDiceToUnit(CombatType.SPACECOMBAT, attacker);
        }
    }

    private void sardakkFlagship(ArrayList<Unit> Units) {
    }

    /**
     * Method to run through the main combat process for the attacker
     */
    public void attackerMainProcess(){
        //Start the rolling for each unit
        for (Unit unit : attacker) {
            ArrayList<Integer> diceRolls = new ArrayList<>();

            //roll amount of dice necessary for one unit
            for (int i=0; i<unit.getNumDiceRollsAFB(); i++){
                diceRolls.add(diceRoll());
            }

            //Check re-roll conditions

            //Check number of hits from this unit
            for (Integer roll : diceRolls) {
                if(roll >= unit.getHitValueAFB()){
                    numHitsAttacker++;
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
        if(DefenderOptions.getDefenderFactionCB() == FactionEnum.WINNU && Controller.containsName(UnitName.FLAGSHIP, attacker)){
            winnuFlagship(defender, attacker);
        }

        if(DefenderOptions.isFighterPrototypeDefenderCheckbox()){
            changeHitValueOfAllUnitsOfSpecificType(CombatType.SPACECOMBAT, defender, -2, UnitName.FIGHTER, UnitName.FIGHTERUPGRADE);
        }
        if(DefenderOptions.isMoraleBoostDefenderCheckbox()){
            changeHitValueOfAllUnits(CombatType.SPACECOMBAT, defender, -1);
        }
        if(DefenderOptions.isWinnuCommanderDefenderCheckbox()){
            changeHitValueOfAllUnits(CombatType.SPACECOMBAT, defender, -2);
        }
        if(DefenderOptions.isProphecyOfIxthDefenderCheckbox()){
            changeHitValueOfAllUnitsOfSpecificType(CombatType.SPACECOMBAT, defender, -1, UnitName.FIGHTER, UnitName.FIGHTERUPGRADE);
        }
        if(DefenderOptions.getDefenderFactionCB() == FactionEnum.SARDAKKNORR && Controller.containsName(UnitName.FLAGSHIP, attacker)){
            changeHitValueOfAllUnits(CombatType.SPACECOMBAT, defender, -1);
        }

        if(DefenderOptions.getDefenderFactionCB() == FactionEnum.NAAZROKHA && Controller.containsName(UnitName.FLAGSHIP, attacker)){
            addDiceToSpecificUnitType(CombatType.SPACECOMBAT, defender, UnitName.MECH, UnitName.MECH);
        }
        if(DefenderOptions.isBaronyAgentDefenderCheckbox()){
            addOneDiceToUnit(CombatType.SPACECOMBAT, defender);
        }
    }

    /**
     * Method to run through the main combat process for the defender
     */
    private void defenderMainProcess() {
        //Start the rolling for each unit
        for (Unit unit : attacker) {
            ArrayList<Integer> diceRolls = new ArrayList<>();

            //roll amount of dice necessary for one unit
            for (int i=0; i<unit.getNumDiceRollsAFB(); i++){
                diceRolls.add(diceRoll());
            }

            //Check re-roll conditions

            //Check number of hits from this unit
            for (Integer roll : diceRolls) {
                if(roll >= unit.getHitValueAFB()){
                    numHitsAttacker++;
                }
            }
        }
    }

    /**
     * Method to run through all post-combat modifiers for the defender
     */
    private void defenderPostProcess() {
    }

    /**
     * Method to set the number of dice the winnu flagship will roll
     * @param myUnits Arraylist of the current players units
     * @param opponentUnits Arraylist of the opponent players units
     */
    private void winnuFlagship(ArrayList<Unit> myUnits, ArrayList<Unit> opponentUnits) {
        for (Unit unit : myUnits) {
            if(unit.getName() == UnitName.FLAGSHIP){
                unit.setNumDiceRollsSpaceCombat(Controller.numOfNonFighterShips(opponentUnits));
            }
        }
    }
}
