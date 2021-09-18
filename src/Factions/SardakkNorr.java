package Factions;

import Controllers.CombatType;
import Player.Player;
import Units.Unit;
import Units.UnitName;

public class SardakkNorr extends Faction{

    public SardakkNorr() {
        super();
        //Flagship
        //Apply +1 to the result of each of your other ship's combat rolls in this system.
        flagship.setSpaceCombatValue(6, 2);

        //Special units
        dreadnought.setBombardmentValue(4,2);
        //Special abilities
        unrelenting();
    }

    private void unrelenting() {
        flagship.setHitValueSpaceCombat(flagship.getHitValueSpaceCombat()-1);
        warsun.setHitValueSpaceCombat(warsun.getHitValueSpaceCombat()-1);
        dreadnought.setHitValueSpaceCombat(dreadnought.getHitValueSpaceCombat()-1);
        carrier.setHitValueSpaceCombat(carrier.getHitValueSpaceCombat()-1);
        cruiser.setHitValueSpaceCombat(cruiser.getHitValueSpaceCombat()-1);
        destroyer.setHitValueSpaceCombat(destroyer.getHitValueSpaceCombat()-1);
        fighter.setHitValueSpaceCombat(fighter.getHitValueSpaceCombat()-1);
        infantry.setHitValueGroundCombat(infantry.getHitValueGroundCombat()-1);
        mech.setHitValueGroundCombat(mech.getHitValueGroundCombat()-1);
    }

    public void upgradeDreadnought(){
        dreadnought = new Unit.Builder(UnitName.DREADNOUGHT)
                .addSpaceCombatValue(4, 1)
                .addBombardmentValue(4, 2)
                .build();
    }

    public void upgradeCarrier(){
        carrier = new Unit.Builder(UnitName.CARRIER)
                .addSpaceCombatValue(8, 1)
                .build();
    }

    public void upgradeCruiser(){
        cruiser = new Unit.Builder(UnitName.CRUISER)
                .addIsUpgraded()
                .addSpaceCombatValue(5,1)
                .build();
    }

    public void upgradeDestroyer(){
        destroyer = new Unit.Builder(UnitName.DESTROYER)
                .addIsUpgraded()
                .addSpaceCombatValue(7,1)
                .addAFBValue(6,3)
                .build();
    }

    public void upgradeFighter(){
        fighter = new Unit.Builder(UnitName.FIGHTER)
                .addIsUpgraded()
                .addSpaceCombatValue(7,1)
                .build();
    }

    public void upgradeInfantry(){
        infantry = new Unit.Builder(UnitName.INFANTRY)
                .addIsUpgraded()
                .addGroundCombatValue(6,1)
                .build();
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
