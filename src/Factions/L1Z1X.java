package Factions;

import Units.Unit;
import Units.UnitName;

public class L1Z1X extends Faction{

    public L1Z1X(){
        super();
        //flagship
        //During a space combat, hits produced by this ship and by your dreadnoughts in this system must be assigned to
        // non-fighter ships if able.
        flagship.setSpaceCombatValue(5, 2);

        //special units
        mech.setBombardmentValue(8,1);
    }

    public void upgradeDreadnought(){
        dreadnought = new Unit.Builder(UnitName.DREADNOUGHT)
                .addSpaceCombatValue(4, 1)
                .addBombardmentValue(4, 1)
                .build();
    }
}
