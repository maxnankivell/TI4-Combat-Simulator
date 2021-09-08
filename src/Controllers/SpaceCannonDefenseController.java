package Controllers;

import GUIData.AttackerOptions;
import GUIData.DefenderOptions;
import Player.Player;
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
        if (AttackerOptions.isAntimassDeflectorAttackerCheckbox()){
            defenderNonShips.changeHitValueOfAllUnits(CombatType.SPACECANNON, 1);
        }

        //Disable
        if (AttackerOptions.isDisableLabelAttackerCheckbox()){
           defenderNonShips.disablePDS();
        }
    }

    /**
     * Method to run through all pre-combat modifiers for the defender
     */
    public void defenderPreProcess(){
        //Titans hero
        if (DefenderOptions.isTitansHeroDefenderCheckbox()){
            defenderNonShips.addUnitTitansHero();
        }

        //Check for pre-combat modifiers
        //Plasma scoring
        if (DefenderOptions.isPlasmaScoringDefenderCheckbox()){
            defenderNonShips.addOneDiceToBestUnit(CombatType.SPACECANNON);
        }

        //Argent flight commander
        if (DefenderOptions.isArgentFlightCommanderDefenderCheckbox()){
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
                diceRolls.add(diceRoll());
            }

            //Check re-roll conditions
            //Jol Nar commander
            if (AttackerOptions.isJolNarCommanderAttackerCheckbox()) {
                diceRolls = reRollMissedDice(CombatType.SPACECANNON, diceRolls, unit);
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
