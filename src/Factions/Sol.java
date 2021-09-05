package Factions;

import Units.Unit;
import Units.UnitName;

public class Sol extends Faction{

    public Sol(){
        super();
        //flagship
        flagship = new Unit.Builder(UnitName.FLAGSHIP)
                .addSpaceCombatValue(5,2)
                .build();
        //special units
        infantry.setGroundCombatValue(7,1);
        infantryUpgrade.setGroundCombatValue(6,1);
        //upgraded carriers have sd
    }
}
