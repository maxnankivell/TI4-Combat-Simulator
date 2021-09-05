package Controllers;

import GUIData.AttackerOptions;
import GUIData.DefenderOptions;
import Units.Unit;
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
            changeHitValueOfAllUnits(CombatType.SPACECANNON, defender, 1);
        }

        //Disable
        if (AttackerOptions.isDisableLabelAttackerCheckbox()){
           disablePDS(defender);
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
            addUnitTitansHero(defender);
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

    /**
     * stops all pds from firing and turns off planetary shield
     */
    public void disablePDS(ArrayList<Unit> player){
        for (Unit unit: player){
            if (unit.getName()== UnitName.PDS){
                unit.setNumDiceRollsSpaceCannon(0);
                unit.setPlanetaryDefense(false);
            }
        }
    }

    public void addUnitTitansHero(ArrayList<Unit> player){
        player.add(new Unit.Builder(UnitName.OTHER)
                .addSpaceCannonValue(5,3)
                .build());
    }

}
