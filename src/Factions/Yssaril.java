package Factions;

import Units.Unit;
import Units.UnitName;

public class Yssaril extends Faction {

    public Yssaril(){
        super();
        //flagship
        flagship = new Unit.Builder(UnitName.FLAGSHIP)
                .addSpaceCombatValue(5,2)
                .build();
    }
}
