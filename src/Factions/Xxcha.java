package Factions;

import Units.Unit;
import Units.UnitNames;

public class Xxcha extends Faction {

    public Xxcha(){
        super();
        //flagship
        flagship = new Unit.Builder(UnitNames.FLAGSHIP)
                .addSpaceCombatValue(7,2)
                .addSpaceCannonValue(5,3)
                .build();
        //special units
        mech.setSpaceCannonValue(8,1);
    }
}
