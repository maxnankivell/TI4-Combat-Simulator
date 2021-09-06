package Factions;

import Units.Unit;
import Units.UnitName;

public class Arborec extends Faction{

    public Arborec(){
        super();
        //flagship
        flagship = new Unit.Builder(UnitName.FLAGSHIP)
                .addSpaceCombatValue(7,2)
                .build();
        //special units
        mech.setPlanetaryShield(true);
    }

}
