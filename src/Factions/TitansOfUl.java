package Factions;

import Units.Unit;
import Units.UnitNames;

public class TitansOfUl extends Faction {
    private Unit flagship;

    public TitansOfUl(){
        super();
        //flagship
        flagship = new Unit.Builder(UnitNames.FLAGSHIP)
                .addSpaceCombatValue(7,2)
                .build();
        //special units
        pds.setGroundCombatValue(6,1);
        pds.setGroundCombatValue(5,1);
    }
}