package Controllers;

import Factions.FactionEnum;
import GUI.OptionData;
import Player.Player;
import Units.Unit;
import Units.UnitName;

import java.util.ArrayList;

/**
 * Class for all actions to do with rolling dice
 */
public class Roller {

    Player currentPlayer;
    CombatType combatType;

    public Roller(Player currentPlayer, CombatType combatType) {
        this.currentPlayer = currentPlayer;
        this.combatType = combatType;
    }

    /**
     * Method to run through the main combat process
     */
    public void mainProcess(){

        //Start the rolling for each unit
        for (Unit unit : currentPlayer.getUnitArrayList()) {
            ArrayList<Integer> diceRolls = new ArrayList<>();

            //roll amount of dice necessary for one unit
            for (int i=0; i<unit.getNumDiceRolls(combatType); i++){
                diceRolls.add(diceRoll());
            }

            //Check re-roll conditions
            checkForJolNarCommander(combatType, diceRolls, unit);
            checkForFireTeam(combatType, diceRolls, unit);

            //Check number of hits from this unit
            for (Integer roll : diceRolls) {
                if(roll >= unit.getHitValue(combatType)){
                    currentPlayer.addNumHits(1);
                }

                //Check for special types of hits
                checkForArgentFlightDestroyers(combatType, unit, roll);
                checkForJolNarFlagship(combatType, unit, roll);
                checkForL1Z1XFlagship(combatType, unit, roll);
            }
        }
    }

    /**
     * gets random number from 1 to 10
     * @return random number from 1 to 10
     */
    private int diceRoll(){
        return (int) Math.floor(Math.random()*10)+1;
    }

    /**
     * Rerolls all dice that are currently missing for a unit given this type of combat
     * @param combatType the current type of combat
     * @param diceRolls the list of dice rolls of which the missed dice will be rerolled
     * @param unit the unit whose dice are being rerolled
     */
    private void reRollMissedDice(CombatType combatType, ArrayList<Integer> diceRolls, Unit unit) {
        for (int i = 0; i < diceRolls.size(); i++) {
            if (diceRolls.get(i) < unit.getHitValue(combatType)) {
                diceRolls.set(i, diceRoll());
            }
        }
    }

    private void checkForJolNarCommander(CombatType combatType, ArrayList<Integer> diceRolls, Unit unit) {
        if (currentPlayer.getOptionData().get(OptionData.JOLNARCOMMANDER) && (combatType == CombatType.AFB || combatType == CombatType.BOMBARDMENT || combatType == CombatType.SPACECANNON))
            reRollMissedDice(combatType, diceRolls, unit);
    }

    private void checkForFireTeam(CombatType combatType, ArrayList<Integer> diceRolls, Unit unit) {
        if (currentPlayer.getOptionData().get(OptionData.FIRETEAM) && combatType == CombatType.GROUNDCOMBAT)
            reRollMissedDice(combatType, diceRolls, unit);
    }

    private void checkForArgentFlightDestroyers(CombatType combatType, Unit unit, Integer roll) {
        if(currentPlayer.getFactionEnum() == FactionEnum.ARGENTFLIGHT && unit.getName() == UnitName.DESTROYER && unit.isUpgraded() && roll >= 9 && combatType == CombatType.AFB)
            currentPlayer.addNumInfantryHits(1);
    }

    private void checkForJolNarFlagship(CombatType combatType, Unit unit, Integer roll) {
        if(currentPlayer.getFactionEnum() == FactionEnum.JOLNAR && unit.getName() == UnitName.FLAGSHIP && roll >= 9 && combatType == CombatType.SPACECOMBAT) {
            currentPlayer.addNumHits(2);
        }
    }

    private void checkForL1Z1XFlagship(CombatType combatType, Unit unit, Integer roll) {
        if(currentPlayer.getFactionEnum() == FactionEnum.L1Z1X && currentPlayer.getUnitList().containsName(UnitName.FLAGSHIP) && unit.isFlagshipOrDreadnought() && roll >= unit.getHitValueSpaceCombat() && combatType == CombatType.SPACECOMBAT) {
            currentPlayer.addNumHits(-1);
            currentPlayer.addNumNonFighterHits(1);
        }
    }
}
