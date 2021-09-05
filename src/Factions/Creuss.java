package Factions;

import Units.Unit;
import Units.UnitName;

public class Creuss extends Faction{

    public Creuss(){
        super();
        //flagship
        flagship = new Unit.Builder(UnitName.FLAGSHIP)
                .addSpaceCombatValue(5,1)
                .build();
    }
}
