package Controllers;

import GUIData.AttackerOptions;
import GUIData.DefenderOptions;
import GUIData.FactionEnum;
import Units.Unit;
import Units.UnitList;
import Units.UnitName;

import java.util.ArrayList;

public class AFBController extends Controller{

    public AFBController(){
        super();
    }

    /**
     * method to run through the AFB process
     */
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
        //Argent Flight Promissory note
        if (AttackerOptions.isStrikeWingAmbushAttackerCheckbox()) {
            attacker.addOneDiceToBestUnit(CombatType.AFB);
        }
        //Argent Flight commander
        if (AttackerOptions.isArgentFlightCommanderAttackerCheckbox()) {
            attacker.addOneDiceToBestUnit(CombatType.AFB);
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
            for (int i=0; i<unit.getNumDiceRollsAFB(); i++){
                diceRolls.add(diceRoll());
            }

            //Check re-roll conditions
            //Jol Nar commander
            if (AttackerOptions.isJolNarCommanderAttackerCheckbox()) {
                diceRolls = reRollMissedDice(CombatType.AFB, diceRolls, unit);
            }

            //Check number of hits from this unit
            for (Integer roll : diceRolls) {
                if(roll >= unit.getHitValueAFB()){
                    numHitsAttacker++;
                }
                //Argent Flight special destroyers
                if(AttackerOptions.getAttackerFactionCB() == FactionEnum.ARGENTFLIGHT) {
                    numInfantryHitsAttacker =+ strikeWingAlpha(roll, unit);
                }
            }
        }
    }

    /**
     * Method to run through all post-combat modifiers for the attacker
     */
    public void attackerPostProcess(){
        //Argent Flight faction ability
        if(AttackerOptions.getAttackerFactionCB() == FactionEnum.ARGENTFLIGHT) {
            raidFormationAttacker();
        }
    }

    /**
     * Method to run through all pre-combat modifiers for the defender
     */
    private void defenderPreProcess() {
        //Argent Flight Promissory note
        if (DefenderOptions.isStrikeWingAmbushDefenderCheckbox()) {
            defender.addOneDiceToBestUnit(CombatType.AFB);
        }
        //Argent Flight commander
        if (DefenderOptions.isArgentFlightCommanderDefenderCheckbox()) {
            defender.addOneDiceToBestUnit(CombatType.AFB);
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
            for (int i=0; i<unit.getNumDiceRollsAFB(); i++){
                diceRolls.add(diceRoll());
            }

            //Check re-roll conditions
            //Jol Nar commander
            if (DefenderOptions.isJolNarCommanderDefenderCheckbox()) {
                diceRolls = reRollMissedDice(CombatType.AFB, diceRolls, unit);
            }

            //Check number of hits from this unit
            for (Integer roll : diceRolls) {
                if(roll >= unit.getHitValueAFB()){
                    numHitsDefender++;
                }
                //Argent Flight special destroyers
                if(DefenderOptions.getDefenderFactionCB() == FactionEnum.ARGENTFLIGHT) {
                    numInfantryHitsDefender += strikeWingAlpha(roll, unit);
                }
            }
        }
    }

    /**
     * Method to run through all post-combat modifiers for the defender
     */
    private void defenderPostProcess() {
        //Argent Flight faction ability
        if(DefenderOptions.getDefenderFactionCB() == FactionEnum.ARGENTFLIGHT) {
            raidFormationDefender();
        }
    }

    /**
     * Method for the Argent Flight unique destroyers
     * @param roll the number that was rolled by the destroyer being passed in
     * @param unit the destroyer being passed in
     * @return if the roll was a critical or not
     */
    private int strikeWingAlpha(int roll, Unit unit){
        if(unit.getName() == UnitName.DESTROYERUPGRADE && roll >= 9){
            return 1;
        }
        return 0;
    }

    /**
     * Method for the Argent Flight unique ability
     */
    private void raidFormationAttacker(){
        if(numHitsAttacker > DefenderOptions.getDefenderFighterCB()){
            numSustainDamageHitsAttacker = numHitsAttacker - DefenderOptions.getDefenderFighterCB();
        }
    }

    /**
     * Method for the Argent Flight unique ability
     */
    private void raidFormationDefender(){
        if(numHitsDefender > AttackerOptions.getAttackerFighterCB()){
            numSustainDamageHitsDefender = numHitsDefender - AttackerOptions.getAttackerFighterCB();
        }
    }

}
