package Factions;

public class Yin extends Faction{

    public Yin(){
        super();
        //flagship
        //When this ship is destroyed, destroy all ships in this system.
        flagship.setSpaceCombatValue(9, 2);

    }
}
