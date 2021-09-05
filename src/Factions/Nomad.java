package Factions;

import Units.Unit;
import Units.UnitName;

public class Nomad extends Faction {

    public Nomad(){
        super();
        //flagship
        flagship = new Unit.Builder(UnitName.FLAGSHIP)
                .addSpaceCombatValue(7,2)
                .addAFBValue(8,3)
                .build();
        //special units
        flagshipUpgrade = new Unit.Builder(UnitName.FLAGSHIPUPGRADE)
                .addSpaceCombatValue(5,2)
                .addAFBValue(5,3)
                .build();
        //While a mech is in a space area during combat, you may use its SUSTAIN DAMAGE ability to cancel
        // a hit that is produced against your ships in this system.
    }
}
