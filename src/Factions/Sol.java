package Factions;

import Units.Unit;
import Units.UnitName;

public class Sol extends Faction{

    public Sol(){
        super();
        //flagship
        flagship.setSpaceCombatValue(5, 2);

        //special units
        infantry.setGroundCombatValue(7,1);
        //upgraded carriers have sd
    }

    public void upgradeInfantry(){
        infantry = new Unit.Builder(UnitName.INFANTRY)
                .addIsUpgraded()
                .addGroundCombatValue(6,1)
                .build();
    }
}
