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
        attackerProcess();
        defenderProcess();
    }

    public void attackerProcess(){

        //Check for pre-combat modifiers
        //Argent Flight Promissory note
        if (AttackerOptions.isStrikeWingAmbushAttackerCheckbox()) {
            addOneDiceToUnit(CombatType.AFB, attacker);
        }
        //Argent Flight commander
        if (AttackerOptions.isArgentFlightCommanderAttackerCheckbox()) {
            addOneDiceToUnit(CombatType.AFB, attacker);
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
                if(AttackerOptions.getAttackerFactionCB() == FactionEnum.ARGENTFLIGHT) {
                    strikeWingAlpha(roll, unit);
                }
            }
        }

        //Check for post-combat modifiers
        //Argent Flight faction ability
        if(AttackerOptions.getAttackerFactionCB() == FactionEnum.ARGENTFLIGHT) {
            raidFormation();
        }
    }

    private void defenderProcess() {

        //Check for pre-combat modifiers
        //Argent Flight Promissory note
        if (DefenderOptions.isStrikeWingAmbushDefenderCheckbox()) {
            addOneDiceToUnit(CombatType.AFB, defender);
        }
        //Argent Flight commander
        if (DefenderOptions.isArgentFlightCommanderDefenderCheckbox()) {
            addOneDiceToUnit(CombatType.AFB, defender);
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
            if (DefenderOptions.isJolNarCommanderDefenderCheckbox()) {
                reRollMissedDice(diceRolls, unit);
            }

            //Check number of hits from this unit
            for (Integer roll : diceRolls) {
                if(roll >= unit.getHitValueAFB()){
                    numHitsAttacker++;
                }
                //Argent Flight special destroyers
                if(DefenderOptions.getDefenderFactionCB() == FactionEnum.ARGENTFLIGHT) {
                    strikeWingAlpha(roll, unit);
                }
            }
        }

        //Check for post-combat modifiers
        //Argent Flight faction ability
        if(DefenderOptions.getDefenderFactionCB() == FactionEnum.ARGENTFLIGHT) {
            raidFormation();
        }
    }

    private void reRollMissedDice(ArrayList<Integer> diceRolls, Unit unit) {
    }

    private void strikeWingAlpha(int roll, Unit unit){
        if(unit.getName() == UnitNames.DESTROYERUPGRADE && roll >= 9){
            numInfantryHitsAttacker++;
        }
    }

    private void raidFormation(){
        if(numHitsAttacker > DefenderOptions.getDefenderFighterCB()){
            numSustainDamageHitsAttacker = numHitsAttacker - DefenderOptions.getDefenderFighterCB();
        }
    }

}
