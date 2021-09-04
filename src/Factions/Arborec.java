package Factions;

import Units.Unit;
import Units.UnitNames;

public class Arborec extends Faction{
    private Unit flagship;

    public Arborec(){
        super();
        flagship = new Unit.Builder(UnitNames.FLAGSHIP).addSpaceCombatValue(7,2).build();
    }

}
