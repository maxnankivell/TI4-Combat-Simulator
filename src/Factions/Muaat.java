package Factions;

import Units.Unit;
import Units.UnitName;

public class Muaat extends Faction{

    public Muaat(){
        super();
        //flagship
        flagship.setSpaceCombatValue(5, 2);

    }

    public void upgradeFlagship(){
        flagship = new Unit.Builder(UnitName.FLAGSHIP)
                .addSpaceCombatValue(5, 2)
                .build();
    }
}
