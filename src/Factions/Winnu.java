package Factions;

public class Winnu extends Faction {

    public Winnu(){
        super();
        //flagship
        //When this unit makes a combat roll, it rolls a number of dice equal to the number of
        // your opponent's non-fighter ships in this system.
        flagship.setSpaceCombatValue(5, 0);

    }
}
