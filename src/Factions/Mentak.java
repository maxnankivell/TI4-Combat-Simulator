package Factions;

import Units.Unit;
import Units.UnitNames;

public class Mentak extends Faction{

    public Mentak(){
        super();
        //flagship
        flagship = new Unit.Builder(UnitNames.FLAGSHIP)
                .addSpaceCombatValue(7,2)
                .build();
    }
}
