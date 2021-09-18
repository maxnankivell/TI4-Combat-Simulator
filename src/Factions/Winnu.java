package Factions;

import Player.Player;
import Units.Unit;
import Units.UnitName;

public class Winnu extends Faction {

    public Winnu(){
        super();
        //flagship
        //When this unit makes a combat roll, it rolls a number of dice equal to the number of
        // your opponent's non-fighter ships in this system.
        flagship.setSpaceCombatValue(5, 0);

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
}
