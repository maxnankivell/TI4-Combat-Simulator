package Factions;

import Units.Unit;
import Units.UnitNames;

public class Muaat extends Faction{

    public Muaat(){
        super();
        //flagship
        flagship = new Unit.Builder(UnitNames.FLAGSHIP)
                .addSpaceCombatValue(5,2)
                .build();
        //special units
        //Other players' units in this system lose Planetary Shield.
        warsun.setSpaceCombatValue(3,3);
        warsun.setBombardmentValue(3,3);
    }
}
