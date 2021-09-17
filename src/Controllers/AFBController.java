package Controllers;

import Factions.ArgentFlight;
import GUI.OptionData;
import Units.Unit;
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
        if (attacker.getOptionData().get(OptionData.STRIKEWINGAMBUSH)) {
            attacker.addOneDiceToBestUnit(CombatType.AFB);
        }
        //Argent Flight commander
        if (attacker.getOptionData().get(OptionData.ARGENTFLIGHTCOMMANDER)) {
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
                diceRolls.add(Roller.diceRoll());
            }

            //Check re-roll conditions
            //Jol Nar commander
            if (attacker.getOptionData().get(OptionData.JOLNARCOMMANDER)) {
                Roller.reRollMissedDice(CombatType.AFB, diceRolls, unit);
            }

            //Check number of hits from this unit
            for (Integer roll : diceRolls) {
                if(roll >= unit.getHitValueAFB()){
                    attacker.addNumHits(1);
                }
                //Argent Flight special destroyers
                if(attacker.getFaction() instanceof ArgentFlight && unit.getName() == UnitName.DESTROYER && unit.isUpgraded() && roll >= 9) {
                    attacker.addNumInfantryHits(1);
                }
            }
        }
    }

    /**
     * Method to run through all post-combat modifiers for the attacker
     */
    public void attackerPostProcess(){
        //Argent Flight faction ability
        if(attacker.getFaction() instanceof ArgentFlight) {
            Abilities.raidFormation(attacker, defender);
        }
    }

    /**
     * Method to run through all pre-combat modifiers for the defender
     */
    private void defenderPreProcess() {
        //Argent Flight Promissory note
        if (defender.getOptionData().get(OptionData.STRIKEWINGAMBUSH)) {
            defender.addOneDiceToBestUnit(CombatType.AFB);
        }
        //Argent Flight commander
        if (defender.getOptionData().get(OptionData.ARGENTFLIGHTCOMMANDER)) {
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
                diceRolls.add(Roller.diceRoll());
            }

            //Check re-roll conditions
            //Jol Nar commander
            if (defender.getOptionData().get(OptionData.JOLNARCOMMANDER)) {
                Roller.reRollMissedDice(CombatType.AFB, diceRolls, unit);
            }

            //Check number of hits from this unit
            for (Integer roll : diceRolls) {
                if(roll >= unit.getHitValueAFB()){
                    defender.addNumHits(1);
                }
                //Argent Flight special destroyers
                if(defender.getFaction() instanceof ArgentFlight && unit.getName() == UnitName.DESTROYER && unit.isUpgraded() && roll >= 9) {
                    defender.addNumInfantryHits(1);
                }
            }
        }
    }

    /**
     * Method to run through all post-combat modifiers for the defender
     */
    private void defenderPostProcess() {
        //Argent Flight faction ability
        if(defender.getFaction() instanceof ArgentFlight) {
            Abilities.raidFormation(defender, attacker);
        }
    }
}
