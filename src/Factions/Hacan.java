package Factions;

import Units.Unit;
import Units.UnitName;

public class Hacan extends Faction{

    public Hacan(){
        super();
        //flagship
        flagship = new Unit.Builder(UnitName.FLAGSHIP)
                .addSpaceCombatValue(7,2)
                .build();
    }
}
