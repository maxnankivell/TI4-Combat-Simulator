package Controllers;

import GUI.OptionData;
import Player.*;
import Units.Unit;

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

        preProcess(defender, attacker);
        preProcess(attacker, defender);

        mainProcess(defender);
    }

    /**
     * Method to run through all pre-combat modifiers
     */
    public void preProcess(Player currentPlayer, Player otherPlayer){

        if (currentPlayer.getRole() == PlayerRole.DEFENDER) {
            //Titans hero
            if (currentPlayer.getOptionData().get(OptionData.TITANSHERO)) {
                defenderNonShips.addUnitTitansHero();
            }

            //Check for pre-combat modifiers
            //Plasma scoring
            if (currentPlayer.getOptionData().get(OptionData.PLASMASCORING)) {
                defenderNonShips.addOneDiceToBestUnit(CombatType.SPACECANNON);
            }

            //Argent flight commander
            if (currentPlayer.getOptionData().get(OptionData.ARGENTFLIGHTCOMMANDER)) {
                defenderNonShips.addOneDiceToBestUnit(CombatType.SPACECANNON);
            }
        }

        if (currentPlayer.getRole() == PlayerRole.ATTACKER) {
            //Check for pre-combat modifiers
            //Antimass deflector
            if (currentPlayer.getOptionData().get(OptionData.ANTIMASSDEFLECTOR)) {
                defenderNonShips.changeHitValueOfAllUnits(CombatType.SPACECANNON, 1);
            }

            //Disable
            if (currentPlayer.getOptionData().get(OptionData.DISABLE)) {
                defenderNonShips.disablePDS();
            }
        }
    }

    /**
     * Method to run through the main combat process
     */
    public void mainProcess(Player currentPlayer) {
        //start rolling
        for (Unit unit : defenderNonShips.getUnitArrayList()) {

            ArrayList<Integer> diceRolls = new ArrayList<>();

            //roll amount of dice necessary for one unit
            for (int i = 0; i < unit.getNumDiceRollsSpaceCannon(); i++) {
                diceRolls.add(Roller.diceRoll());
            }

            //Check re-roll conditions
            //Jol Nar commander
            if (currentPlayer.getOptionData().get(OptionData.JOLNARCOMMANDER)) {
                Roller.reRollMissedDice(CombatType.SPACECANNON, diceRolls, unit);
            }

            //Check number of hits from this unit
            for (Integer roll : diceRolls) {
                if (roll >= unit.getHitValueSpaceCannon()) {
                    currentPlayer.addNumHits(1);
                }
            }

        }
    }


}
