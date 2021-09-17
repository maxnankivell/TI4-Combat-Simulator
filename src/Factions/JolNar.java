package Factions;

import Units.Unit;
import Units.UnitName;

public class JolNar extends Faction{

    public JolNar() {
        super();
        //Flagship
        //When making a combat roll for this ship, each result of 9 or 10, before applying modifiers,
        // produces 2 additional hits.
        flagship.setSpaceCombatValue(6, 2);

        //Special abilities
        fragile();

        //Your infantry on a planet with a mech are not affected by your FRAGILE faction ability.
    }

    private void fragile() {
        flagship.setHitValueSpaceCombat(flagship.getHitValueSpaceCombat()+1);
        warsun.setHitValueSpaceCombat(warsun.getHitValueSpaceCombat()+1);
        dreadnought.setHitValueSpaceCombat(dreadnought.getHitValueSpaceCombat()+1);
        carrier.setHitValueSpaceCombat(carrier.getHitValueSpaceCombat()+1);
        cruiser.setHitValueSpaceCombat(cruiser.getHitValueSpaceCombat()+1);
        destroyer.setHitValueSpaceCombat(destroyer.getHitValueSpaceCombat()+1);
        fighter.setHitValueSpaceCombat(fighter.getHitValueSpaceCombat()+1);
        infantry.setHitValueGroundCombat(infantry.getHitValueGroundCombat()+1);
        mech.setHitValueGroundCombat(mech.getHitValueGroundCombat()+1);

    }

    public void upgradeDreadnought(){
        dreadnought = new Unit.Builder(UnitName.DREADNOUGHT)
                .addSpaceCombatValue(6, 1)
                .addBombardmentValue(5, 1)
                .build();
    }

    public void upgradeCarrier(){
        carrier = new Unit.Builder(UnitName.CARRIER)
                .addSpaceCombatValue(10, 1)
                .build();
    }

    public void upgradeCruiser(){
        cruiser = new Unit.Builder(UnitName.CRUISER)
                .addIsUpgraded()
                .addSpaceCombatValue(7,1)
                .build();
    }

    public void upgradeDestroyer(){
        destroyer = new Unit.Builder(UnitName.DESTROYER)
                .addIsUpgraded()
                .addSpaceCombatValue(9,1)
                .addAFBValue(6,3)
                .build();
    }

    public void upgradeFighter(){
        fighter = new Unit.Builder(UnitName.FIGHTER)
                .addIsUpgraded()
                .addSpaceCombatValue(9,1)
                .build();
    }

    public void upgradeInfantry(){
        infantry = new Unit.Builder(UnitName.INFANTRY)
                .addIsUpgraded()
                .addGroundCombatValue(8,1)
                .build();
    }
}
