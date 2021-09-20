package Factions;

import Units.Unit;
import Units.UnitName;

public class Naalu extends Faction{

    public Naalu(){
        super();
        //flagship
        flagship.setSpaceCombatValue(9, 2);

        //special units
        fighter.setSpaceCombatValue(8,1);
    }

    public void upgradeFighter(){
        fighter = new Unit.Builder(UnitName.FIGHTER)
                .addIsUpgraded()
                .addSpaceCombatValue(7,1)
                .build();
    }
}
