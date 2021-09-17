package Factions;

import Units.Unit;
import Units.UnitName;

public class Nomad extends Faction {

    public Nomad(){
        super();
        //flagship
        flagship.setAFBValue(8, 3);

        //special units
        //While a mech is in a space area during combat, you may use its SUSTAIN DAMAGE ability to cancel
        //a hit that is produced against your ships in this system.
    }

    public void upgradeFlagship(){
        flagship = new Unit.Builder(UnitName.FLAGSHIP)
                .addSpaceCombatValue(5,2)
                .addAFBValue(5,3)
                .build();
    }
}
