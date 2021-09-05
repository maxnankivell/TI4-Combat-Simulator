package Factions;

import Units.Unit;
import Units.UnitName;

public class Naalu extends Faction{

    public Naalu(){
        super();
        //flagship
        flagship = new Unit.Builder(UnitName.FLAGSHIP)
                .addSpaceCombatValue(9,2)
                .build();
        //special units
        fighter.setSpaceCombatValue(8,1);
        fighterUpgrade.setSpaceCombatValue(7,1);
    }
}
