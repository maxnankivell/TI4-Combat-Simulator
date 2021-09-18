package Controllers;

import Factions.ArgentFlight;
import Factions.JolNar;
import Factions.L1Z1X;
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
            switch (combatType){
                case AFB -> {
                    //Jol Nar commander
                    if (currentPlayer.getOptionData().get(OptionData.JOLNARCOMMANDER)) {
                        reRollMissedDice(CombatType.AFB, diceRolls, unit);
                    }
                }
                case BOMBARDMENT -> {
                    //Jol Nar commander
                    if (currentPlayer.getOptionData().get(OptionData.JOLNARCOMMANDER)) {
                        reRollMissedDice(CombatType.BOMBARDMENT, diceRolls, unit);
                    }
                }
                case GROUNDCOMBAT -> {
                    //Fire team
                    if (currentPlayer.getOptionData().get(OptionData.FIRETEAM)) {
                        reRollMissedDice(CombatType.GROUNDCOMBAT, diceRolls, unit);
                    }
                }
                case SPACECOMBAT -> {}
                case SPACECANNON -> {
                    //Jol Nar commander
                    if (currentPlayer.getOptionData().get(OptionData.JOLNARCOMMANDER)) {
                        reRollMissedDice(CombatType.SPACECANNON, diceRolls, unit);
                    }
                }
            }

            //Check number of hits from this unit
            for (Integer roll : diceRolls) {
                if(roll >= unit.getHitValue(combatType)){
                    currentPlayer.addNumHits(1);
                }

                switch (combatType){
                    case AFB -> {
                        //Argent Flight special destroyers
                        if(currentPlayer.getFaction() instanceof ArgentFlight && unit.getName() == UnitName.DESTROYER && unit.isUpgraded() && roll >= 9) {
                            currentPlayer.addNumInfantryHits(1);
                        }
                    }
                    case BOMBARDMENT -> {}
                    case GROUNDCOMBAT -> {}
                    case SPACECOMBAT -> {
                        //JolNar Flagship
                        if(currentPlayer.getFaction() instanceof JolNar && unit.getName() == UnitName.FLAGSHIP && roll >= 9) {
                            currentPlayer.addNumHits(2);
                        }
                        //L1Z1X Flagship
                        if(currentPlayer.getFaction() instanceof L1Z1X && currentPlayer.getUnitList().containsName(UnitName.FLAGSHIP) && unit.isFlagshipOrDreadnought() && roll >= unit.getHitValueSpaceCombat()) {
                            currentPlayer.addNumHits(-1);
                            currentPlayer.addNumNonFighterHits(1);
                        }
                    }
                    case SPACECANNON -> {}
                }
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
}
