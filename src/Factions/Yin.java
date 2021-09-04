package Factions;

import Units.Unit;
import Units.UnitNames;

public class Yin extends Faction{
    private Unit flagship;

    public Yin(){
        super();
        //flagship
        //When this ship is destroyed, destroy all ships in this system.
        flagship = new Unit.Builder(UnitNames.FLAGSHIP)
                .addSpaceCombatValue(9,2)
                .build();
    }
}
