package Controllers;

import GUIData.AttackerOptions;
import GUIData.DefenderOptions;
import GUIData.FactionEnum;
import Units.Unit;
import Units.UnitNames;

import java.util.ArrayList;

public class AFBController extends Controller{

    public AFBController(){
        super();
    }

    @Override
    public void startProcess() {
        //Strike wing ambush

        //Argent flight commander

        //Jol-Nar commander

        attackerHitCalculator();
        numHitsDefender = defenderHitCalculator();
    }

    public void attackerHitCalculator(){

        //Check for pre-combat modifiers
        //Argent Flight Promissory note
        if (AttackerOptions.isStrikeWingAmbushAttackerCheckbox()) {
            addOneDice();
        }
        //Argent Flight commander
        if (AttackerOptions.isArgentFlightCommanderAttackerCheckbox()) {
            addOneDice();
        }

        //Start the rolling for each unit
        for (Unit unit : attacker) {
            ArrayList<Integer> diceRolls = new ArrayList<>();

            //roll amount of dice necessary for one unit
            for (int i=0; i<unit.getNumDiceRollsAFB(); i++){
                diceRolls.add(diceRoll());
            }

            //Check re-roll conditions
            //Jol Nar commander
            if (AttackerOptions.isJolNarCommanderAttackerCheckbox()) {
                reRollMissedDice(diceRolls, unit);
            }

            //Check number of hits from this unit
            for (Integer roll : diceRolls) {
                if(roll >= unit.getHitValueAFB()){
                    numHitsAttacker++;
                }
                //Argent Flight special destroyers
                strikeWingAlpha(roll, unit);
            }
        }

        //Check for post-combat modifiers
        //Argent Flight faction ability
        raidFormation();
    }

    private int defenderHitCalculator() {
        int numHits = 0;

        for (Unit unit : defender){
            for (int i=0; i<unit.getNumDiceRollsAFB(); i++){
                if (diceRoll() >= unit.getHitValueAFB()){
                    numHits++;
                }
            }
        }

        return numHits;
    }

    private void addOneDice() {
    }

    private void reRollMissedDice(ArrayList<Integer> diceRolls, Unit unit) {
    }

    private void strikeWingAlpha(int roll, Unit unit){
        if(AttackerOptions.getAttackerFactionCB() == FactionEnum.ARGENTFLIGHT && unit.getName() == UnitNames.DESTROYERUPGRADE){
            if(roll >= 9){
                numInfantryHitsAttacker++;
            }
        }
    }

    private void raidFormation(){
        if(AttackerOptions.getAttackerFactionCB() == FactionEnum.ARGENTFLIGHT && numHitsAttacker > DefenderOptions.getDefenderFighterCB()){
            numSustainDamageHitsAttacker = numHitsAttacker - DefenderOptions.getDefenderFighterCB();
        }
    }

}
