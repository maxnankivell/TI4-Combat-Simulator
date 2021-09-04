package Factions;

import Units.Unit;
import Units.UnitNames;

public class Sol extends Faction{
    private Unit flagship;

    public Sol(){
        super();
        //flagship
        flagship = new Unit.Builder(UnitNames.FLAGSHIP)
                .addSpaceCombatValue(5,2)
                .build();
        //special units
        infantry.setGroundCombatValue(7,1);
        infantryUpgrade.setGroundCombatValue(6,1);
        //upgraded carriers have sd
    }
}
