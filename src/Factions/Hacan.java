package Factions;

import Units.Unit;
import Units.UnitNames;

public class Hacan extends Faction{
    private Unit flagship;

    public Hacan(){
        super();
        //flagship
        flagship = new Unit.Builder(UnitNames.FLAGSHIP)
                .addSpaceCombatValue(7,2)
                .build();
    }
}
