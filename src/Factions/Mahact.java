package Factions;

import Units.Unit;
import Units.UnitName;

public class Mahact extends Faction {

    public Mahact(){
        super();
        //flagship
        flagship = new Unit.Builder(UnitName.FLAGSHIP)
                .addSpaceCombatValue(5,2)
                .build();
    }
}
