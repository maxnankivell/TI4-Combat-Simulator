package Controllers;

import GUI.OptionData;
import Player.Player;
import Units.Unit;

import javax.swing.*;
import java.util.ArrayList;

public class SpaceCannonDefenseController extends Controller{
    private Player defenderNonShips;

    public SpaceCannonDefenseController(){
        super();
    }

    /**
     * method to run through the space cannon defense process
     */
    @Override
    public void startProcess() {
        defenderNonShips = new Player(defender);
        defenderNonShips.getUnitList().removeShips();

        defenderPreProcess();
        attackerPreProcess();
        defenderMainProcess();
    }

    /**
     * Method to run through all pre-combat modifiers for the attacker
     */
    public void attackerPreProcess(){
        //Check for pre-combat modifiers
        //Antimass deflector
        if (attacker.getOptionData().get(OptionData.ANTIMASSDEFLECTOR)){
            defenderNonShips.changeHitValueOfAllUnits(CombatType.SPACECANNON, 1);
        }

        //Disable
        if (attacker.getOptionData().get(OptionData.DISABLE)){
           defenderNonShips.disablePDS();
        }
    }

    /**
     * Method to run through all pre-combat modifiers for the defender
     */
    public void defenderPreProcess(){
        //Titans hero
        if (defender.getOptionData().get(OptionData.TITANSHERO)){
            defenderNonShips.addUnitTitansHero();
        }

        //Check for pre-combat modifiers
        //Plasma scoring
        if (defender.getOptionData().get(OptionData.PLASMASCORING)){
            defenderNonShips.addOneDiceToBestUnit(CombatType.SPACECANNON);
        }

        //Argent flight commander
        if (defender.getOptionData().get(OptionData.ARGENTFLIGHTCOMMANDER)){
            defenderNonShips.addOneDiceToBestUnit(CombatType.SPACECANNON);
        }
    }

    /**
     * Method to run through the main combat process for the defender
     */
    public void defenderMainProcess() {
        //start rolling
        for (Unit unit : defenderNonShips.getUnitArrayList()) {

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
