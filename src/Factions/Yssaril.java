package Factions;

import Units.Unit;
import Units.UnitNames;

public class Yssaril extends Faction {

    public Yssaril(){
        super();
        //flagship
        flagship = new Unit.Builder(UnitNames.FLAGSHIP)
                .addSpaceCombatValue(5,2)
                .build();
    }
}
