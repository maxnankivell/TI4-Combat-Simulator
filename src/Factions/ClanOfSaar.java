package Factions;

import Units.Unit;
import Units.UnitName;

public class ClanOfSaar extends Faction{

    public ClanOfSaar(){
        super();
        //flagship
        flagship = new Unit.Builder(UnitName.FLAGSHIP)
                .addSpaceCombatValue(5,2)
                .addAFBValue(6,4)
                .build();
    }

}
