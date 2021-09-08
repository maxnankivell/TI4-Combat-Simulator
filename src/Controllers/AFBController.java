package Controllers;

import Factions.ArgentFlight;
import GUIData.AttackerOptions;
import GUIData.DefenderOptions;
import Player.Player;
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
                    attacker.addNumHits(1);
                }
                //Argent Flight special destroyers
                if(attacker.getFaction() instanceof ArgentFlight && unit.getName() == UnitName.DESTROYERUPGRADE && roll >= 9) {
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
            attacker.addNumSustainDamageHits(raidFormation(attacker, defender));
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
                    defender.addNumHits(1);
                }
                //Argent Flight special destroyers
                if(defender.getFaction() instanceof ArgentFlight && unit.getName() == UnitName.DESTROYERUPGRADE && roll >= 9) {
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
            defender.addNumSustainDamageHits(raidFormation(defender, attacker));
        }
    }

    /**
     * Method for the Argent Flight unique ability
     * @return Number of sustain damage hits
     */
    private int raidFormation(Player currentPlayer, Player otherPlayer){
        if(currentPlayer.getNumHits() > (otherPlayer.getUnitList().numberOfType(UnitName.FIGHTER) + otherPlayer.getUnitList().numberOfType(UnitName.FIGHTERUPGRADE))){
            return (currentPlayer.getNumHits() - (otherPlayer.getUnitList().numberOfType(UnitName.FIGHTER) + otherPlayer.getUnitList().numberOfType(UnitName.FIGHTERUPGRADE)));
        }else {
            return 0;
        }
    }
}
