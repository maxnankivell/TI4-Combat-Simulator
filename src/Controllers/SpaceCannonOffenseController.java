package Controllers;

import Factions.ArgentFlight;
import GUI.OptionData;
import Units.Unit;
import Units.UnitName;

import java.util.ArrayList;

public class SpaceCannonOffenseController extends Controller{
    private boolean attackerCancelled = false;
    private boolean defenderCancelled = false;

    public SpaceCannonOffenseController(){
        super();
    }

    @Override
    public void startProcess() {
        attackerPreProcess();
        defenderPreProcess();

        if (!attackerCancelled){
            attackerMainProcess();
        }
        if (!defenderCancelled){
            defenderMainProcess();
        }
    }

    /**
     * Method to run through all pre-combat modifiers for the attacker
     */
    public void attackerPreProcess(){
        //Plasma scoring
        if (attacker.getOptionData().get(OptionData.PLASMASCORING)){
            attacker.addOneDiceToBestUnit(CombatType.SPACECANNON);
        }

        //Antimass deflector
        if (attacker.getOptionData().get(OptionData.ANTIMASSDEFLECTOR)){
            defender.changeHitValueOfAllUnits(CombatType.SPACECANNON, 1);
        }

        //Strike wing ambuscade
        if (attacker.getOptionData().get(OptionData.STRIKEWINGAMBUSH)){
            attacker.addOneDiceToBestUnit(CombatType.SPACECANNON);
        }

        //Solar flare
        if (attacker.getOptionData().get(OptionData.SOLARFLAIR)){
            defenderCancelled = true;
        }

        //Argent flight commander
        if (attacker.getOptionData().get(OptionData.ARGENTFLIGHTCOMMANDER)){
            attacker.addOneDiceToBestUnit(CombatType.SPACECANNON);
        }

        //Argent flight flagship
        if (attacker.getFaction() instanceof ArgentFlight && attacker.getUnitList().containsName(UnitName.FLAGSHIP)){
            defenderCancelled = true;
        }
    }

    /**
     * Method to run through all pre-combat modifiers for the defender
     */
    public void defenderPreProcess(){
        //Experimental battlestation
        if (defender.getOptionData().get(OptionData.EXPERIMENTALBATTLESTATION)){
            defender.addUnitExperimentalBattlestation();
        }

        //Titans Hero
        if (defender.getOptionData().get(OptionData.TITANSHERO)){
            defender.addUnitTitansHero();
        }

        //Plasma scoring
        if (defender.getOptionData().get(OptionData.PLASMASCORING)){
            defender.addOneDiceToBestUnit(CombatType.SPACECANNON);
        }

        //Antimass deflector
        if (defender.getOptionData().get(OptionData.ANTIMASSDEFLECTOR)){
            attacker.changeHitValueOfAllUnits(CombatType.SPACECANNON, 1);
        }

        //Strike wing ambuscade
        if (defender.getOptionData().get(OptionData.STRIKEWINGAMBUSH)){
            defender.addOneDiceToBestUnit(CombatType.SPACECANNON);
        }

        //Argent flight commander
        if (defender.getOptionData().get(OptionData.ARGENTFLIGHTCOMMANDER)){
            defender.addOneDiceToBestUnit(CombatType.SPACECANNON);
        }

        //Argent flight flagship
        if (defender.getFaction() instanceof ArgentFlight && defender.getUnitList().containsName(UnitName.FLAGSHIP)){
            attackerCancelled = true;
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
            for (int i = 0; i < unit.getNumDiceRollsSpaceCannon(); i++) {
                diceRolls.add(Roller.diceRoll());
            }

            //Check re-roll conditions
            //Jol Nar commander
            if (attacker.getOptionData().get(OptionData.JOLNARCOMMANDER)) {
                Roller.reRollMissedDice(CombatType.SPACECANNON, diceRolls, unit);
            }

            //Check number of hits from this unit
            for (Integer roll : diceRolls) {
                if (roll >= unit.getHitValueSpaceCannon()) {
                    attacker.addNumHits(1);
                }
            }
        }
    }

    /**
     * Method to run through the main combat process for the defender
     */
    public void defenderMainProcess() {
        //start rolling
        for (Unit unit : defender.getUnitArrayList()) {
            ArrayList<Integer> diceRolls = new ArrayList<>();

            //roll amount of dice necessary for one unit
            for (int i = 0; i < unit.getNumDiceRollsSpaceCannon(); i++) {
                diceRolls.add(Roller.diceRoll());
            }

            //Check re-roll conditions
            //Jol Nar commander
            if (defender.getOptionData().get(OptionData.JOLNARCOMMANDER)) {
                Roller.reRollMissedDice(CombatType.SPACECANNON, diceRolls, unit);
            }

            //Check number of hits from this unit
            for (Integer roll : diceRolls) {
                if (roll >= unit.getHitValueSpaceCannon()) {
                    defender.addNumHits(1);
                }
            }
        }
    }

}
