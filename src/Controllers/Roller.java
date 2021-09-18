package Controllers;

import Units.Unit;

import java.util.ArrayList;

/**
 * Class for all actions to do with rolling dice
 */
public class Roller {

    /**
     * gets random number from 1 to 10
     * @return random number from 1 to 10
     */
    public static int diceRoll(){
        return (int) Math.floor(Math.random()*10)+1;
    }

    /**
     * Rerolls all dice that are currently missing for a unit given this type of combat
     * @param combatType the current type of combat
     * @param diceRolls the list of dice rolls of which the missed dice will be rerolled
     * @param unit the unit whose dice are being rerolled
     */
    public static void reRollMissedDice(CombatType combatType, ArrayList<Integer> diceRolls, Unit unit) {
        for (int i = 0; i < diceRolls.size(); i++) {
            if (diceRolls.get(i) < unit.getHitValue(combatType)) {
                diceRolls.set(i, diceRoll());
            }
        }
    }
}
