package Controllers;

import GUI.OptionData;
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

        if ((!defender.getUnitList().containsPlanetaryShield() || planetaryShieldCancelled) && !bombardmentCancelled){
            attackerMainProcess();
        }
    }

    public void attackerPreProcess(){
        //Blitz
        if (attacker.getOptionData().get(OptionData.BLITZ)){
            Abilities.blitz(attacker);
        }

        //Plasma scoring
        if (attacker.getOptionData().get(OptionData.PLASMASCORING)){
            attacker.addOneDiceToBestUnit(CombatType.BOMBARDMENT);
        }

        //Strike wing ambush
        if (attacker.getOptionData().get(OptionData.STRIKEWINGAMBUSH)){
            attacker.addOneDiceToBestUnit(CombatType.BOMBARDMENT);
        }

        //Disable
        if (attacker.getOptionData().get(OptionData.DISABLE)){
            defender.disablePDS();
        }

        //Argent flight commander
        if (attacker.getOptionData().get(OptionData.ARGENTFLIGHTCOMMANDER)){
            attacker.addOneDiceToBestUnit(CombatType.BOMBARDMENT);
        }

        //L1Z1X commander
        if (attacker.getOptionData().get(OptionData.L1Z1XCOMMANDER)){
            planetaryShieldCancelled = true;
        }

        //warsuns
        if (attacker.getUnitList().containsName(UnitName.WARSUN)){
            planetaryShieldCancelled = true;
        }
    }

    public void defensePreProcess(){
        //Bunker
        if (defender.getOptionData().get(OptionData.BUNKER)){
            attacker.changeHitValueOfAllUnits(CombatType.BOMBARDMENT, 4);
        }

        //Convention of war
        //assumes all planets are cultural if checked
        if (defender.getOptionData().get(OptionData.CONVENTIONSOFWAR)){
            bombardmentCancelled = true;
        }
    }

    public void attackerMainProcess(){
        //start rolling
        for (Unit unit : attacker.getUnitArrayList()) {
            ArrayList<Integer> diceRolls = new ArrayList<>();

            //roll amount of dice necessary for one unit
            for (int i = 0; i < unit.getNumDiceRollsBombardment(); i++) {
                diceRolls.add(Roller.diceRoll());
            }

            //Check re-roll conditions
            //Jol Nar commander
            if (attacker.getOptionData().get(OptionData.JOLNARCOMMANDER)) {
                Roller.reRollMissedDice(CombatType.BOMBARDMENT, diceRolls, unit);
            }

            //Check number of hits from this unit
            for (Integer roll : diceRolls) {
                if (roll >= unit.getHitValueBombardment()) {
                    attacker.addNumHits(1);
                }
            }

        }
    }
}
