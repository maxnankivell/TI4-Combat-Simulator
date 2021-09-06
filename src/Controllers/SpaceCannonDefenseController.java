package Controllers;

import GUIData.AttackerOptions;
import GUIData.DefenderOptions;
import Units.Unit;
import Units.UnitList;
import Units.UnitName;

import java.util.ArrayList;

public class SpaceCannonDefenseController extends Controller{

    public SpaceCannonDefenseController(){
        super();
    }

    /**
     * method to run through the space cannon defense process
     */
    @Override
    public void startProcess() {
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
            defender.changeHitValueOfAllUnits(CombatType.SPACECANNON, 1);
        }

        //Disable
        if (AttackerOptions.isDisableLabelAttackerCheckbox()){
           defender.disablePDS();
        }
    }

    /**
     * Method to run through all pre-combat modifiers for the defender
     */
    public void defenderPreProcess(){
        //Check for pre-combat modifiers
        //Plasma scoring
        if (DefenderOptions.isPlasmaScoringDefenderCheckbox()){
            defender.addOneDiceToBestUnit(CombatType.SPACECANNON);
        }

        //Argent flight commander
        if (DefenderOptions.isArgentFlightCommanderDefenderCheckbox()){
            defender.addOneDiceToBestUnit(CombatType.SPACECANNON);
        }

        //Titans hero
        if (DefenderOptions.isTitansHeroDefenderCheckbox()){
            addUnitTitansHero(defender);
        }
    }

    /**
     * Method to run through the main combat process for the defender
     */
    public void defenderMainProcess(){
        //start rolling
        for (Unit unit: defender.getUnitArrayList()){
            ArrayList<Integer> diceRolls = new ArrayList<>();

            if (!unit.isShip()) {

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
                        numHitsDefender++;
                    }
                }

            }
        }
    }


}
