package Controllers;

import Factions.ArgentFlight;
import GUI.OptionData;
import Units.Unit;
import Units.UnitName;
import Player.*;

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
        preProcess(attacker);
        preProcess(defender);

        mainProcess(attacker);
        mainProcess(defender);

        postProcess(attacker, defender);
        postProcess(defender, attacker);
    }

    /**
     * Method to run through all pre-combat modifiers
     */
    public void preProcess(Player currentPlayer){
        //Argent Flight Promissory note
        if (currentPlayer.getOptionData().get(OptionData.STRIKEWINGAMBUSH)) {
            currentPlayer.addOneDiceToBestUnit(CombatType.AFB);
        }
        //Argent Flight commander
        if (currentPlayer.getOptionData().get(OptionData.ARGENTFLIGHTCOMMANDER)) {
            currentPlayer.addOneDiceToBestUnit(CombatType.AFB);
        }
    }

    /**
     * Method to run through the main combat process
     */
    private void mainProcess(Player currentPlayer) {
        //Start the rolling for each unit
        for (Unit unit : currentPlayer.getUnitArrayList()) {
            ArrayList<Integer> diceRolls = new ArrayList<>();

            //roll amount of dice necessary for one unit
            for (int i=0; i<unit.getNumDiceRollsAFB(); i++){
                diceRolls.add(Roller.diceRoll());
            }

            //Check re-roll conditions
            //Jol Nar commander
            if (currentPlayer.getOptionData().get(OptionData.JOLNARCOMMANDER)) {
                Roller.reRollMissedDice(CombatType.AFB, diceRolls, unit);
            }

            //Check number of hits from this unit
            for (Integer roll : diceRolls) {
                if(roll >= unit.getHitValueAFB()){
                    currentPlayer.addNumHits(1);
                }
                //Argent Flight special destroyers
                if(currentPlayer.getFaction() instanceof ArgentFlight && unit.getName() == UnitName.DESTROYER && unit.isUpgraded() && roll >= 9) {
                    currentPlayer.addNumInfantryHits(1);
                }
            }
        }
    }

    /**
     * Method to run through all post-combat modifiers
     */
    private void postProcess(Player currentPlayer, Player otherPlayer) {
        //Argent Flight faction ability
        if(currentPlayer.getFaction() instanceof ArgentFlight) {
            Abilities.raidFormation(currentPlayer, otherPlayer);
        }
    }
}
