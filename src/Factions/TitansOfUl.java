package Factions;

import Units.Unit;
import Units.UnitName;

public class TitansOfUl extends Faction {
    private Unit flagship;

    public TitansOfUl(){
        super();
        //flagship is default

        //special units
        pds.setGroundCombatValue(7,1);
    }

    public void upgradePds(){
        pds = new Unit.Builder(UnitName.PDS)
                .addIsUpgraded()
                .addSpaceCannonValue(5,1)
                .addGroundCombatValue(6, 1)
                .addIsPlanetaryShield()
                .build();
    }
}