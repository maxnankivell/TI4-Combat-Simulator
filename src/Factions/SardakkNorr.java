package Factions;

import Units.Unit;
import Units.UnitNames;

public class SardakkNorr extends Faction{
    private Unit flagship;

    public SardakkNorr() {
        super();
        //Flagship
        //Apply +1 to the result of each of your other ship's combat rolls in this system.
        flagship = new Unit.Builder(UnitNames.FLAGSHIP)
                .addSpaceCannonValue(6,2)
                .build();
        //Special units
        dreadnought.setBombardmentValue(4,2);
        dreadnoughtUpgrade.setBombardmentValue(4,2);
        //Special abilities
        unrelenting();
    }

    private void unrelenting() {
        flagship.setHitValueSpaceCombat(flagship.getHitValueSpaceCombat()-1);
        warsun.setHitValueSpaceCombat(warsun.getHitValueSpaceCombat()-1);
        dreadnought.setHitValueSpaceCombat(dreadnought.getHitValueSpaceCombat()-1);
        dreadnoughtUpgrade.setHitValueSpaceCombat(dreadnoughtUpgrade.getHitValueSpaceCombat()-1);
        carrier.setHitValueSpaceCombat(carrier.getHitValueSpaceCombat()-1);
        carrierUpgrade.setHitValueSpaceCombat(carrierUpgrade.getHitValueSpaceCombat()-1);
        cruiser.setHitValueSpaceCombat(cruiser.getHitValueSpaceCombat()-1);
        cruiserUpgrade.setHitValueSpaceCombat(cruiserUpgrade.getHitValueSpaceCombat()-1);
        destroyer.setHitValueSpaceCombat(destroyer.getHitValueSpaceCombat()-1);
        destroyerUpgrade.setHitValueSpaceCombat(destroyerUpgrade.getHitValueSpaceCombat()-1);
        fighter.setHitValueSpaceCombat(fighter.getHitValueSpaceCombat()-1);
        fighterUpgrade.setHitValueSpaceCombat(fighterUpgrade.getHitValueSpaceCombat()-1);
        infantry.setHitValueGroundCombat(infantry.getHitValueGroundCombat()-1);
        infantryUpgrade.setHitValueGroundCombat(infantryUpgrade.getHitValueGroundCombat()-1);
        mech.setHitValueGroundCombat(mech.getHitValueGroundCombat()-1);
    }

}
