package Controllers;

import GUIData.AttackerOptions;
import GUIData.DefenderOptions;
import Player.Player;
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

        if ((!defender.getUnitList().containsPlanetryShield() || planetaryShieldCancelled) && !bombardmentCancelled){
            attackerMainProcess();
        }
    }

    public void attackerPreProcess(){
        //Blitz
        if (AttackerOptions.isBlitzAttackerCheckbox()){
            blitz(attacker);
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
        if (attacker.getUnitList().containsName(UnitName.WARSUN)){
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
        //start rolling
        for (Unit unit : attacker.getUnitArrayList()) {
            ArrayList<Integer> diceRolls = new ArrayList<>();

            //roll amount of dice necessary for one unit
            for (int i = 0; i < unit.getNumDiceRollsBombardment(); i++) {
                diceRolls.add(diceRoll());
            }

            //Check re-roll conditions
            //Jol Nar commander
            if (AttackerOptions.isJolNarCommanderAttackerCheckbox()) {
                diceRolls = reRollMissedDice(CombatType.BOMBARDMENT, diceRolls, unit);
            }

            //Check number of hits from this unit
            for (Integer roll : diceRolls) {
                if (roll >= unit.getHitValueBombardment()) {
                    attacker.addNumHits(1);
                }
            }

        }
    }

    public void blitz(Player player){
        for (Unit unit : player.getUnitArrayList()){
            if (unit.isNonFighterShip() && unit.getNumDiceRollsBombardment()==0){
                unit.setBombardmentValue(6,1);
            }
        }
    }

}
