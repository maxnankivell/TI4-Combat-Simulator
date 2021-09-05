package Factions;

import Units.Unit;
import Units.UnitName;

public class NaazRokha extends Faction {

    public NaazRokha(){
        super();
        //flagship
        //Your mechs in this system roll 1 additional die during combat.
        flagship = new Unit.Builder(UnitName.FLAGSHIP)
                .addSpaceCombatValue(9,2)
                .build();
        //special units
        mech.setNumDiceRollsGroundCombat(2);
        mech.setSpaceCombatValue(8,2);
    }
}
