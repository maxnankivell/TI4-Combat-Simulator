package Controllers;

import GUIData.AttackerOptions;
import GUIData.DefenderOptions;
import GUIData.FactionEnum;
import Units.Unit;
import Units.UnitNames;

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
        attackerPreProcess();
        defenderPreProcess();
        defenderMainProcess();
    }

    /**
     * Method to run through all pre-combat modifiers for the attacker
     */
    public void attackerPreProcess(){
        //Check for pre-combat modifiers
        //Antimass deflector
        if (AttackerOptions.isAntimassDeflectorAttackerCheckbox()){
            changeHitValueOfAllUnits(CombatType.SPACECANNON, defender, 1);
        }

        //Disable
        if (AttackerOptions.isDisableLabelAttackerCheckbox()){
            for (Unit unit: defender){
                if (unit.getName()== UnitNames.PDS){
                    unit.setNumDiceRollsSpaceCannon(0);
                    unit.setPlanetaryDefense(false);
                }
            }
        }
    }

    /**
     * Method to run through all pre-combat modifiers for the defender
     */
    public void defenderPreProcess(){
        //Check for pre-combat modifiers
        //Plasma scoring
        if (DefenderOptions.isPlasmaScoringDefenderCheckbox()){
            addOneDiceToUnit(CombatType.SPACECANNON, defender);
        }

        //Argent flight commander
        if (DefenderOptions.isArgentFlightCommanderDefenderCheckbox()){
            addOneDiceToUnit(CombatType.SPACECANNON, defender);
        }

        //Titans hero
        if (DefenderOptions.isTitansHeroDefenderCheckbox()){
            defender.add(new Unit.Builder(UnitNames.OTHER)
                    .addSpaceCannonValue(5,3)
                    .build());
        }
    }

    /**
     * Method to run through the main combat process for the defender
     */
    public void defenderMainProcess(){
        //start rolling
        for (Unit unit: defender){
            ArrayList<Integer> diceRolls = new ArrayList<>();

            //roll amount of dice necessary for one unit
            for (int i=0; i<unit.getNumDiceRollsSpaceCannon(); i++){
                diceRolls.add(diceRoll());
            }

            //Check re-roll conditions
            //Jol Nar commander
            if (AttackerOptions.isJolNarCommanderAttackerCheckbox()) {
                diceRolls = reRollMissedDice(CombatType.SPACECANNON, diceRolls, unit);
            }

            //Check number of hits from this unit
            for (Integer roll : diceRolls) {
                if(roll >= unit.getHitValueSpaceCannon()){
                    numHitsDefender++;
                }
            }
        }
    }

}
