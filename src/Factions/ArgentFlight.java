package Factions;

import Units.Unit;
import Units.UnitNames;

public class ArgentFlight extends Faction {

    public ArgentFlight() {
        super();
        //Flagship
        //Other players cannot use space cannon against your ships in this system
        flagship = new Unit.Builder(UnitNames.FLAGSHIP)
                .addSpaceCannonValue(7,2)
                .build();
        //Special units
        destroyer.setSpaceCombatValue(8,1);
        destroyer.setAFBValue(9,2);
        destroyerUpgrade.setSpaceCombatValue(7,1);
        //When this unit uses AFB, each result of 9 or 10 also destroys 1 of your opponent's infantry
        //in the space area of the active system
        destroyerUpgrade.setAFBValue(6,3);
        //When 1 or more of your units uses ANTI-FIGHTER BARRAGE, for each hit produced in excess of your
        //opponent's Fighters, choose 1 of your opponent's ships that has SUSTAIN DAMAGE to become damaged.
    }
}
