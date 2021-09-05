package Factions;

import Units.Unit;
import Units.UnitName;

public class BaronyOfLetnev extends Faction{

    public BaronyOfLetnev(){
        super();
        //flagship
        flagship = new Unit.Builder(UnitName.FLAGSHIP)
                .addSpaceCombatValue(5,2)
                .addBombardmentValue(5,3)
                .build();
    }
}
