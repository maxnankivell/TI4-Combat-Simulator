package Factions;

import Units.Unit;
import Units.UnitNames;

public class Mahact extends Faction {
    private Unit flagship;

    public Mahact(){
        super();
        //flagship
        flagship = new Unit.Builder(UnitNames.FLAGSHIP)
                .addSpaceCombatValue(5,2)
                .build();
    }
}