package Controllers;

import GUIData.AttackerOptions;
import GUIData.DefenderOptions;
import Units.Unit;
import Units.UnitNames;

public class SpaceCannonDefenseController extends Controller{

    public SpaceCannonDefenseController(){
        super();
    }

    @Override
    public void startProcess() {
        //Plasma scoring
        if (DefenderOptions.isPlasmaScoringDefenderCheckbox()){
            addOneDiceToUnit(CombatType.SPACECANNON, defender);
        }

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

         hitCalculator();
    }

    public void hitCalculator(){
        for (Unit unit : defender) {
            for (int i = 0; i < unit.getNumDiceRollsSpaceCannon(); i++) {
                if (diceRoll() >= unit.getHitValueSpaceCannon()) {
                    numHitsDefender++;
                } else {

                    //Jol-Nar commander
                    if (DefenderOptions.isJolNarCommanderDefenderCheckbox()) {
                        if (diceRoll() >= unit.getHitValueSpaceCannon()) {
                            numHitsDefender++;
                        }
                    }
                }
            }
        }
    }

}
