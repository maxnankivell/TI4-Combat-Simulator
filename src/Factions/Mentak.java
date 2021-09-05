package Factions;

import Units.Unit;
import Units.UnitName;

public class Mentak extends Faction{

    public Mentak(){
        super();
        //flagship
        flagship = new Unit.Builder(UnitName.FLAGSHIP)
                .addSpaceCombatValue(7,2)
                .build();
    }
}
