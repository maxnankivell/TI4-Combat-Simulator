package Controllers;

import Factions.*;
import Factions.FactionEnum;
import GUI.OptionData;
import Units.Unit;
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
    }

    /**
     * Method to run through all pre-combat modifiers for the attacker
     */
    public void attackerPreProcess(){
        //Populate the number of dice for the winnu flagship
        if(attacker.getFaction() instanceof Winnu && attacker.getUnitList().containsName(UnitName.FLAGSHIP)){
            Abilities.winnuFlagship(attacker, defender);
        }

        if(attacker.getOptionData().get(OptionData.FIGHTERPROTOTYPE)){
            attacker.changeHitValueOfAllUnitsOfSpecificType(CombatType.SPACECOMBAT,-2, UnitName.FIGHTER);
        }
        if(attacker.getOptionData().get(OptionData.MORALEBOOST)){
            attacker.changeHitValueOfAllUnits(CombatType.SPACECOMBAT, -1);
        }
        if(attacker.getOptionData().get(OptionData.WINNUCOMMANDER)){
            attacker.changeHitValueOfAllUnits(CombatType.SPACECOMBAT, -2);
        }
        if(attacker.getOptionData().get(OptionData.PROPHECYOFIXTH)){
            attacker.changeHitValueOfAllUnitsOfSpecificType(CombatType.SPACECOMBAT,-1, UnitName.FIGHTER);
        }
        if(attacker.getFaction() instanceof SardakkNorr && attacker.getUnitList().containsName(UnitName.FLAGSHIP)){
            Abilities.sardakkNorrFlagship(attacker);
        }

        if(attacker.getFaction() instanceof NaazRokha && attacker.getUnitList().containsName(UnitName.FLAGSHIP)){
            attacker.addDiceToSpecificUnitType(CombatType.SPACECOMBAT,UnitName.MECH);
        }
        if(attacker.getOptionData().get(OptionData.BARONYAGENT)){
            attacker.addOneDiceToBestUnit(CombatType.SPACECOMBAT);
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
            for (int i=0; i<unit.getNumDiceRollsSpaceCombat(); i++){
                diceRolls.add(Roller.diceRoll());
            }

            //Check re-roll conditions

            //Check number of hits from this unit
            for (Integer roll : diceRolls) {
                if(roll >= unit.getHitValueSpaceCombat()){
                    attacker.addNumHits(1);
                }

                //JolNar Flagship
                if(attacker.getFaction() instanceof JolNar && unit.getName() == UnitName.FLAGSHIP && roll >= 9) {
                    attacker.addNumHits(2);
                }
                //L1Z1X Flagship
                if(attacker.getFaction() instanceof L1Z1X && attacker.getUnitList().containsName(UnitName.FLAGSHIP) && unit.isFlagshipOrDreadnought() && roll >= unit.getHitValueSpaceCombat()) {
                    attacker.addNumHits(-1);
                    attacker.addNumNonFighterHits(1);
                }
            }
        }
    }

    /**
     * Method to run through all pre-combat modifiers for the defender
     */
    private void defenderPreProcess() {
        //Populate the number of dice for the winnu flagship
        if(defender.getFaction() instanceof Winnu && defender.getUnitList().containsName(UnitName.FLAGSHIP)){
            Abilities.winnuFlagship(defender, attacker);
        }

        if(defender.getOptionData().get(OptionData.FIGHTERPROTOTYPE)){
            defender.changeHitValueOfAllUnitsOfSpecificType(CombatType.SPACECOMBAT,-2, UnitName.FIGHTER);
        }
        if(defender.getOptionData().get(OptionData.MORALEBOOST)){
            defender.changeHitValueOfAllUnits(CombatType.SPACECOMBAT, -1);
        }
        if(defender.getOptionData().get(OptionData.WINNUCOMMANDER)){
            defender.changeHitValueOfAllUnits(CombatType.SPACECOMBAT, -2);
        }
        if(defender.getOptionData().get(OptionData.PROPHECYOFIXTH)){
            defender.changeHitValueOfAllUnitsOfSpecificType(CombatType.SPACECOMBAT, -1, UnitName.FIGHTER);
        }
        if(defender.getFaction() instanceof SardakkNorr && defender.getUnitList().containsName(UnitName.FLAGSHIP)){
            Abilities.sardakkNorrFlagship(defender);
        }

        if(defender.getFaction() instanceof NaazRokha && defender.getUnitList().containsName(UnitName.FLAGSHIP)){
            defender.addDiceToSpecificUnitType(CombatType.SPACECOMBAT, UnitName.MECH);
        }
        if(defender.getOptionData().get(OptionData.BARONYAGENT)){
            defender.addOneDiceToBestUnit(CombatType.SPACECOMBAT);
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
            for (int i=0; i<unit.getNumDiceRollsSpaceCombat(); i++){
                diceRolls.add(Roller.diceRoll());
            }

            //Check re-roll conditions

            //Check number of hits from this unit
            for (Integer roll : diceRolls) {
                if(roll >= unit.getHitValueSpaceCombat()){
                    defender.addNumHits(1);
                }

                //JolNar Flagship
                if(defender.getFaction() instanceof JolNar && unit.getName() == UnitName.FLAGSHIP && roll >= 9) {
                    defender.addNumHits(1);
                }
                //L1Z1X Flagship
                if(defender.getFaction() instanceof L1Z1X && defender.getUnitList().containsName(UnitName.FLAGSHIP) && unit.isFlagshipOrDreadnought() && roll >= unit.getHitValueSpaceCombat()) {
                    defender.addNumHits(-1);
                    defender.addNumNonFighterHits(1);
                }
            }
        }
    }
}
