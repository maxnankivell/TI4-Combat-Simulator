package Factions;

import Units.Unit;
import Units.UnitNames;

public class Winnu extends Faction {

    public Winnu(){
        super();
        //flagship
        //When this unit makes a combat roll, it rolls a number of dice equal to the number of
        // your opponent's non-fighter ships in this system.
        flagship = new Unit.Builder(UnitNames.FLAGSHIP)
                .addSpaceCombatValue(7,0)
                .build();
    }
}
