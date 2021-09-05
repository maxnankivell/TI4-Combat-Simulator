package Controllers;

import GUIData.AttackerOptions;
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
        if(AttackerOptions.getAttackerFactionCB() == FactionEnum.WINNU){
            winnuFlagship(attacker, defender);
        }
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
        int numOpponentCapitalShips = 0;

        for (Unit unit : opponentUnits) {
            if(unit.isNonFighterShip()){
                numOpponentCapitalShips++;
            }
        }

        for (Unit unit : myUnits) {
            if(unit.getName() == UnitName.FLAGSHIP){
                unit.setNumDiceRollsSpaceCombat(numOpponentCapitalShips);
            }
        }
    }
}
