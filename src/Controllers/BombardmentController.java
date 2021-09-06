package Controllers;

import GUIData.AttackerOptions;
import GUIData.DefenderOptions;
import Units.Unit;
import Units.UnitName;

import java.util.ArrayList;

public class BombardmentController extends Controller{
    private boolean planetaryShieldCancelled = false;
    private boolean bombardmentCancelled = false;

    public BombardmentController(){
        super();
    }

    @Override
    public void startProcess() {
        attackerPreProcess();
        defensePreProcess();

        if ((!defender.containsPlanetryShield() || planetaryShieldCancelled) && !bombardmentCancelled){
            attackerMainProcess();
        }
    }

    public void attackerPreProcess(){
        //Blitz
        if (AttackerOptions.isBlitzAttackerCheckbox()){
            blitz();
        }

        //Plasma scoring
        if (AttackerOptions.isPlasmaScoringAttackerCheckbox()){
            attacker.addOneDiceToBestUnit(CombatType.BOMBARDMENT);
        }

        //Strike wing ambush
        if (AttackerOptions.isStrikeWingAmbushAttackerCheckbox()){
            attacker.addOneDiceToBestUnit(CombatType.BOMBARDMENT);
        }

        //Disable
        if (AttackerOptions.isDisableLabelAttackerCheckbox()){
            defender.disablePDS();
        }

        //Argent flight commander
        if (AttackerOptions.isArgentFlightCommanderAttackerCheckbox()){
            attacker.addOneDiceToBestUnit(CombatType.BOMBARDMENT);
        }

        //L1Z1X commander
        if (AttackerOptions.isL1Z1XCommanderAttackerCheckbox()){
            planetaryShieldCancelled = true;
        }

        //warsuns
        if (attacker.containsName(UnitName.WARSUN)){
            planetaryShieldCancelled = true;
        }
    }

    public void defensePreProcess(){
        //Bunker
        if (DefenderOptions.isBunkerLabelDefenderCheckbox()){
            attacker.changeHitValueOfAllUnits(CombatType.BOMBARDMENT, 4);
        }

        //Convention of war
        //assumes all planets are cultural if checked
        if (DefenderOptions.isConventionsOfWarDefenderCheckbox()){
            bombardmentCancelled = true;
        }
    }

    public void attackerMainProcess(){
        /**
         * test
         */
        System.out.println("Attacker");
        //start rolling
        for (Unit unit : attacker.getUnitArrayList()) {
            /**
             * test
             */
            System.out.println(unit.getName());
            System.out.println(unit.getHitValueBombardment() + " - " + unit.getNumDiceRollsBombardment());

            ArrayList<Integer> diceRolls = new ArrayList<>();

            //roll amount of dice necessary for one unit
            for (int i = 0; i < unit.getNumDiceRollsBombardment(); i++) {
                diceRolls.add(diceRoll());
            }

            /**
             * test
             */
            System.out.println(diceRolls);

            //Check re-roll conditions
            //Jol Nar commander
            if (AttackerOptions.isJolNarCommanderAttackerCheckbox()) {
                diceRolls = reRollMissedDice(CombatType.BOMBARDMENT, diceRolls, unit);
            }

            //Check number of hits from this unit
            for (Integer roll : diceRolls) {
                if (roll >= unit.getHitValueBombardment()) {
                    numHitsAttacker++;
                }
            }

        }
    }

    public void blitz(){
        for (Unit unit : attacker.getUnitArrayList()){
            if (unit.isNonFighterShip() && unit.getNumDiceRollsBombardment()==0){
                unit.setBombardmentValue(6,1);
            }
        }
    }

}
