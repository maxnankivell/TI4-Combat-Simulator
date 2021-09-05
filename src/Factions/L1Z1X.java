package Factions;

import Units.Unit;
import Units.UnitNames;

public class L1Z1X extends Faction{

    public L1Z1X(){
        super();
        //flagship
        flagship = new Unit.Builder(UnitNames.FLAGSHIP)
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
