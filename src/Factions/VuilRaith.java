package Factions;

import Units.Unit;
import Units.UnitName;

public class VuilRaith extends Faction {

    public VuilRaith(){
        super();
        //flagship
        flagship = new Unit.Builder(UnitName.FLAGSHIP)
                .addSpaceCombatValue(5,2)
                .addBombardmentValue(5,1)
                .build();
    }
}
