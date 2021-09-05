package Factions;

import Units.Unit;
import Units.UnitName;

public class Yin extends Faction{

    public Yin(){
        super();
        //flagship
        //When this ship is destroyed, destroy all ships in this system.
        flagship = new Unit.Builder(UnitName.FLAGSHIP)
                .addSpaceCombatValue(9,2)
                .build();
    }
}
