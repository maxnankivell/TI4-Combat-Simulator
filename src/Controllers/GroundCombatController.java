package Controllers;

import Factions.JolNar;
import Factions.NaazRokha;
import GUI.OptionData;
import Units.Unit;
import Units.UnitName;

import java.util.ArrayList;

public class GroundCombatController extends Controller{

    public GroundCombatController(){
        super();
    }

    @Override
    public void startProcess() {
        attackPreProcess();
        defenderPreProcess();

        attackerMainProcess();
        defenderMainProcess();
    }

    /**
     * Method to run through all pre-combat modifiers for the attacker
     */
    public void attackPreProcess(){
        //Tekklar legion
        if (attacker.getOptionData().get(OptionData.TEKKLARLEGION)){
            Abilities.tekklarLegion(attacker, defender);
        }

        //Sol agent
        if (attacker.getOptionData().get(OptionData.SOLAGENT)){
            attacker.addOneDiceToBestUnit(CombatType.GROUNDCOMBAT);
        }

        //Morale boost
        if (attacker.getOptionData().get(OptionData.MORALEBOOST)){
            attacker.changeHitValueOfAllUnits(CombatType.GROUNDCOMBAT, -1);
        }

        //Winnu commander
        if (attacker.getOptionData().get(OptionData.WINNUCOMMANDER)){
            attacker.changeHitValueOfAllUnits(CombatType.GROUNDCOMBAT, -2);
        }

        //Jol Nar mech
        if (attacker.getFaction() instanceof JolNar && attacker.getUnitList().containsName(UnitName.MECH)){
            attacker.changeHitValueOfAllUnitsOfSpecificType(CombatType.GROUNDCOMBAT, -1, UnitName.INFANTRY);
        }

        //Naaz Rokha flagship
        if (attacker.getFaction() instanceof NaazRokha && attacker.getUnitList().containsName(UnitName.FLAGSHIP)){
            attacker.addDiceToSpecificUnitType(CombatType.GROUNDCOMBAT, UnitName.MECH);
        }
    }

    /**
     * Method to run through all pre-combat modifiers for the defender
     */
    public void defenderPreProcess(){
        //Magen defense grid
        if (defender.getOptionData().get(OptionData.MAGENDEFENSEGRID)){
            defender.addNumHits(1);
        }

        //Tekklar legion
        if (defender.getOptionData().get(OptionData.TEKKLARLEGION)){
            Abilities.tekklarLegion(defender, attacker);
        }

        //Sol agent
        if (defender.getOptionData().get(OptionData.SOLAGENT)){
            defender.addOneDiceToBestUnit(CombatType.GROUNDCOMBAT);
        }

        //Morale boost
        if (defender.getOptionData().get(OptionData.MORALEBOOST)){
            defender.changeHitValueOfAllUnits(CombatType.GROUNDCOMBAT, -1);
        }

        //Winnu commander
        if (defender.getOptionData().get(OptionData.WINNUCOMMANDER)){
            defender.changeHitValueOfAllUnits(CombatType.GROUNDCOMBAT, -2);
        }

        //Defending in nebula
        if (defender.getOptionData().get(OptionData.DEFENDINGINNEBULA)){
            defender.changeHitValueOfAllUnits(CombatType.GROUNDCOMBAT, -1);
        }

        //Jol Nar mech
        if (defender.getFaction() instanceof JolNar && defender.getUnitList().containsName(UnitName.MECH)){
            defender.changeHitValueOfAllUnitsOfSpecificType(CombatType.GROUNDCOMBAT,-1, UnitName.INFANTRY);
        }

        //Naaz Rokha flagship
        if (defender.getFaction() instanceof NaazRokha && defender.getUnitList().containsName(UnitName.FLAGSHIP)){
            defender.addDiceToSpecificUnitType(CombatType.GROUNDCOMBAT, UnitName.MECH);
        }
    }

    /**
     * Method to run through the main combat process for the attacker
     */
    public void attackerMainProcess(){
        //start rolling
        for (Unit unit : attacker.getUnitArrayList()) {
            ArrayList<Integer> diceRolls = new ArrayList<>();

            //roll amount of dice necessary for one unit
            for (int i = 0; i < unit.getNumDiceRollsGroundCombat(); i++) {
                diceRolls.add(Roller.diceRoll());
            }

            //Check re-roll conditions
            //Fire team
            if (attacker.getOptionData().get(OptionData.FIRETEAM)) {
                Roller.reRollMissedDice(CombatType.GROUNDCOMBAT, diceRolls, unit);
            }

            //Check number of hits from this unit
            for (Integer roll : diceRolls) {
                if (roll >= unit.getHitValueGroundCombat()) {
                    attacker.addNumHits(1);
                }
            }

        }
    }

    /**
     * Method to run through the main combat process for the defender
     */
    public void defenderMainProcess(){
        //start rolling
        for (Unit unit : defender.getUnitArrayList()) {
            ArrayList<Integer> diceRolls = new ArrayList<>();

            //roll amount of dice necessary for one unit
            for (int i = 0; i < unit.getNumDiceRollsGroundCombat(); i++) {
                diceRolls.add(Roller.diceRoll());
            }

            //Check re-roll conditions
            //Fire team
            if (defender.getOptionData().get(OptionData.FIRETEAM)) {
                Roller.reRollMissedDice(CombatType.GROUNDCOMBAT, diceRolls, unit);
            }

            //Check number of hits from this unit
            for (Integer roll : diceRolls) {
                if (roll >= unit.getHitValueGroundCombat()) {
                    defender.addNumHits(1);
                }
            }

        }
    }
}
