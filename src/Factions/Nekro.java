package Factions;

import Units.Unit;
import Units.UnitNames;

public class Nekro extends Faction{
    private Unit flagship;

    public Nekro(){
        super();
        //flagship
        flagship = new Unit.Builder(UnitNames.FLAGSHIP)
                .addSpaceCombatValue(9,2)
                .build();
    }
}