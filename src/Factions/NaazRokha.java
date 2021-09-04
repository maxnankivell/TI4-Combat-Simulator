package Factions;

import Units.Unit;
import Units.UnitNames;

public class NaazRokha extends Faction {
    private Unit flagship;

    public NaazRokha(){
        super();
        //flagship
        //Your mechs in this system roll 1 additional die during combat.
        flagship = new Unit.Builder(UnitNames.FLAGSHIP)
                .addSpaceCombatValue(9,2)
                .build();
        //special units
        mech.setNumDiceRollsGroundCombat(2);
        mech.setSpaceCombatValue(8,2);
    }
}
