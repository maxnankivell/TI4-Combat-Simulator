package Factions;

import Player.Player;
import Units.Unit;
import Units.UnitName;

public class ArgentFlight extends Faction {

    public ArgentFlight() {
        super();
        //Flagship is default stats other players cannot use space cannon against your ships in this system

        //Special units
        destroyer.setSpaceCombatValue(8,1);
        destroyer.setAFBValue(9,2);

        //When this unit uses AFB, each result of 9 or 10 also destroys 1 of your opponent's infantry
        //in the space area of the active system
        //When 1 or more of your units uses ANTI-FIGHTER BARRAGE, for each hit produced in excess of your
        //opponent's Fighters, choose 1 of your opponent's ships that has SUSTAIN DAMAGE to become damaged.
    }

    public void upgradeDestroyer(){
        destroyer = new Unit.Builder(UnitName.DESTROYER)
                .addIsUpgraded()
                .addSpaceCombatValue(7,1)
                .addAFBValue(6,3)
                .build();
    }

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
}
