package Factions;

import Units.Unit;
import Units.UnitNames;

public class Empyrean extends Faction{

    public Empyrean() {
        super();
        //Flagship
        flagship = new Unit.Builder(UnitNames.FLAGSHIP)
                .addSpaceCannonValue(5,2)
                .build();
    }
}
