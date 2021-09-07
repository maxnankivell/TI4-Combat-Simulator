package Controllers;

import Factions.*;
import GUIData.AttackerOptions;
import GUIData.DefenderOptions;
import Player.*;
import Units.Unit;
import Units.UnitList;
import Units.UnitName;

import java.util.ArrayList;

public abstract class Controller {
    protected Player attacker1;
    protected Player defender1;
    private Object IOException;

    public Controller(){
        attacker1 = new Player(PlayerRole.ATTACKER);
        defender1 = new Player(PlayerRole.DEFENDER);

        startProcess();
    }

    public abstract void startProcess();

    /**
     * gets random number from 1 to 10
     * @return random number from 1 to 10
     */
    public int diceRoll(){
        return (int) Math.floor(Math.random()*10)+1;
    }

    /**
     * Rerolls all dice that are currently missing for a unit given this type of combat
     * @param combatType the current type of combat
     * @param diceRolls the list of dice rolls of which the missed dice will be rerolled
     * @param unit the unit whose dice are being rerolled
     */
    public ArrayList<Integer> reRollMissedDice(CombatType combatType, ArrayList<Integer> diceRolls, Unit unit) {
        switch (combatType){
            case AFB:
                for (int i = 0; i < diceRolls.size(); i++) {
                    if(diceRolls.get(i) < unit.getHitValueAFB()){
                        diceRolls.set(i, diceRoll());
                    }
                }
                break;
            case BOMBARDMENT:
                for (int i = 0; i < diceRolls.size(); i++) {
                    if(diceRolls.get(i) < unit.getHitValueBombardment()){
                        diceRolls.set(i, diceRoll());
                    }
                }
                break;
            case SPACECANNON:
                for (int i = 0; i < diceRolls.size(); i++) {
                    if(diceRolls.get(i) < unit.getHitValueSpaceCannon()){
                        diceRolls.set(i, diceRoll());
                    }
                }
                break;
            case SPACECOMBAT:
                for (int i = 0; i < diceRolls.size(); i++) {
                    if(diceRolls.get(i) < unit.getHitValueSpaceCombat()){
                        diceRolls.set(i, diceRoll());
                    }
                }
                break;
            case GROUNDCOMBAT:
                for (int i = 0; i < diceRolls.size(); i++) {
                    if(diceRolls.get(i) < unit.getHitValueGroundCombat()){
                        diceRolls.set(i, diceRoll());
                    }
                }
                break;
        }
        return  diceRolls;
    }

    public Player getAttacker1() {
        return attacker1;
    }

    public Player getDefender1() {
        return defender1;
    }
}
