package Factions;

import Units.Unit;
import Units.UnitNames;

public class JolNar extends Faction{

    public JolNar() {
        super();
        //Flagship
        //When making a combat roll for this ship, each result of 9 or 10, before applying modifiers,
        // produces 2 additional hits.
        flagship = new Unit.Builder(UnitNames.FLAGSHIP)
                .addSpaceCannonValue(6,2)
                .build();
        //Special units
        //Your infantry on a planet with a mech are not affected by your FRAGILE faction ability.
        //Special abilities
        fragile();
    }

    private void fragile() {
        flagship.setHitValueSpaceCombat(flagship.getHitValueSpaceCombat()+1);
        warsun.setHitValueSpaceCombat(warsun.getHitValueSpaceCombat()+1);
        dreadnought.setHitValueSpaceCombat(dreadnought.getHitValueSpaceCombat()+1);
        dreadnoughtUpgrade.setHitValueSpaceCombat(dreadnoughtUpgrade.getHitValueSpaceCombat()+1);
        carrier.setHitValueSpaceCombat(carrier.getHitValueSpaceCombat()+1);
        carrierUpgrade.setHitValueSpaceCombat(carrierUpgrade.getHitValueSpaceCombat()+1);
        cruiser.setHitValueSpaceCombat(cruiser.getHitValueSpaceCombat()+1);
        cruiserUpgrade.setHitValueSpaceCombat(cruiserUpgrade.getHitValueSpaceCombat()+1);
        destroyer.setHitValueSpaceCombat(destroyer.getHitValueSpaceCombat()+1);
        destroyerUpgrade.setHitValueSpaceCombat(destroyerUpgrade.getHitValueSpaceCombat()+1);
        fighter.setHitValueSpaceCombat(fighter.getHitValueSpaceCombat()+1);
        fighterUpgrade.setHitValueSpaceCombat(fighterUpgrade.getHitValueSpaceCombat()+1);
        infantry.setHitValueGroundCombat(infantry.getHitValueGroundCombat()+1);
        infantryUpgrade.setHitValueGroundCombat(infantryUpgrade.getHitValueGroundCombat()+1);
        mech.setHitValueGroundCombat(mech.getHitValueGroundCombat()+1);
    }
}
