package Factions;

import Units.Unit;
import Units.UnitName;

public class Nekro extends Faction{

    public Nekro(){
        super();
        //flagship
        flagship.setSpaceCombatValue(9, 2);

    }

    public void upgradeFlagship(){
        flagship = new Unit.Builder(UnitName.FLAGSHIP)
                .addSpaceCombatValue(9, 2)
                .build();
    }
}
