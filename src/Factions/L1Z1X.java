package Factions;

import Units.Unit;
import Units.UnitName;

public class L1Z1X extends Faction{

    public L1Z1X(){
        super();
        //flagship
        //During a space combat, hits produced by this ship and by your dreadnoughts in this system must be assigned to
        // non-fighter ships if able.
        flagship = new Unit.Builder(UnitName.FLAGSHIP)
                .addSpaceCombatValue(5,2)
                .build();
        //special units
        dreadnought.setSpaceCombatValue(5,1);
        dreadnought.setBombardmentValue(5,1);
        dreadnoughtUpgrade.setSpaceCombatValue(4,1);
        dreadnoughtUpgrade.setBombardmentValue(4,1);
        mech.setBombardmentValue(8,1);
    }
}
