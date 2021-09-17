package Controllers;

import Factions.SardakkNorr;
import Player.Player;
import Units.Unit;
import Units.UnitName;

public class Abilities {

    /**
     * Method for the Argent Flight unique ability
     */
    public static void raidFormation(Player currentPlayer, Player otherPlayer){
        if(currentPlayer.getNumHits() > (otherPlayer.getUnitList().numberOfType(UnitName.FIGHTER))){
            currentPlayer.addNumSustainDamageHits((currentPlayer.getNumHits() - (otherPlayer.getUnitList().numberOfType(UnitName.FIGHTER))));
        }
    }

    /**
     * method for the action card blitz
     * @param player the player who is using blitz
     */
    public static void blitz(Player player){
        for (Unit unit : player.getUnitArrayList()){
            if (unit.isNonFighterShip() && unit.getNumDiceRollsBombardment()==0){
                unit.setBombardmentValue(6,1);
            }
        }
    }

    /**
     * Method for the Sardakk Norr flagship
     * @param player the player using the method
     */
    public static void sardakkNorrFlagship(Player player){
        player.changeHitValueOfAllUnits(CombatType.SPACECOMBAT, -1);
        for (Unit unit : player.getUnitArrayList()) {
            if(unit.getName() == UnitName.FLAGSHIP){
                unit.setHitValueSpaceCombat(unit.getHitValueSpaceCombat()+1);
            }
        }
    }

    /**
     * Method to set the number of dice the winnu flagship will roll
     * @param currentPlayer current player
     * @param otherPlayer Other player
     */
    public static void winnuFlagship(Player currentPlayer, Player otherPlayer) {
        for (Unit unit : currentPlayer.getUnitArrayList()) {
            if(unit.getName() == UnitName.FLAGSHIP){
                unit.setNumDiceRollsSpaceCombat(otherPlayer.getUnitList().numOfNonFighterShips());
            }
        }
    }

    /**
     * subtracts one from all opposing player ground units hit values
     * if the current player is Sardakk Norr then add one to
     * all current player ground units hit values
     * @param currentPlayer the current player
     * @param otherPlayer the other player
     */
    public static void tekklarLegion(Player currentPlayer, Player otherPlayer){
        currentPlayer.changeHitValueOfAllUnits(CombatType.GROUNDCOMBAT, -1);
        if (otherPlayer.getFaction() instanceof SardakkNorr){
            otherPlayer.changeHitValueOfAllUnits(CombatType.GROUNDCOMBAT, 1);
        }
    }
}
