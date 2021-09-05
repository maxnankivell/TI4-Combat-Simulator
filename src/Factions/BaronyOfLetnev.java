package Factions;

import Units.Unit;
import Units.UnitNames;

public class BaronyOfLetnev extends Faction{

    public BaronyOfLetnev(){
        super();
        //flagship
        flagship = new Unit.Builder(UnitNames.FLAGSHIP)
                .addSpaceCombatValue(5,2)
                .addBombardmentValue(5,3)
                .build();
    }
}
