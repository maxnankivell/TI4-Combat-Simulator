package Factions;

import Units.Unit;
import Units.UnitNames;

public class Naalu extends Faction{
    private Unit flagship;

    public Naalu(){
        super();
        //flagship
        flagship = new Unit.Builder(UnitNames.FLAGSHIP)
                .addSpaceCombatValue(9,2)
                .build();
        //special units
        fighter.setSpaceCombatValue(8,1);
        fighterUpgrade.setSpaceCombatValue(7,1);
    }
}
