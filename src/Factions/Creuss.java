package Factions;

import Units.Unit;
import Units.UnitNames;

public class Creuss extends Faction{
    private Unit flagship;

    public Creuss(){
        super();
        //flagship
        flagship = new Unit.Builder(UnitNames.FLAGSHIP)
                .addSpaceCombatValue(5,1)
                .build();
    }
}
