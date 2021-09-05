package Factions;

import Units.Unit;
import Units.UnitName;

public class Empyrean extends Faction{

    public Empyrean() {
        super();
        //Flagship
        flagship = new Unit.Builder(UnitName.FLAGSHIP)
                .addSpaceCannonValue(5,2)
                .build();
    }
}
