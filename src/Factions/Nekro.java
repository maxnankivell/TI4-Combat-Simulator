package Factions;

import Units.Unit;
import Units.UnitName;

public class Nekro extends Faction{

    public Nekro(){
        super();
        //flagship
        flagship = new Unit.Builder(UnitName.FLAGSHIP)
                .addSpaceCombatValue(9,2)
                .build();
    }
}
