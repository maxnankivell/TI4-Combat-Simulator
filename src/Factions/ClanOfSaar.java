package Factions;

import Units.Unit;
import Units.UnitNames;

public class ClanOfSaar extends Faction{
    private Unit flagship;

    public ClanOfSaar(){
        super();
        //flagship
        flagship = new Unit.Builder(UnitNames.FLAGSHIP)
                .addSpaceCombatValue(5,2)
                .addAFBValue(6,4)
                .build();
    }

}
