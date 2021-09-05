package Controllers;

import Factions.ArgentFlight;
import GUIData.AttackerOptions;
import Units.Unit;
import Units.UnitName;

public class SpaceCannonOffenseController extends Controller{
    private boolean attackerCancelled = false;
    private boolean defenderCancelled = false;

    public SpaceCannonOffenseController(){
        super();
    }

    @Override
    public void startProcess() {

        //Plasma scoring

        //Antimass deflector

        //Strike wing ambuscade

        //Experimental battlestation

        //Solar flare

        //Argent flight commander

        //Jol-Nar commander

        //Titans Hero

        //Argent flight flagship

        //Yin flagship

        numHitsAttacker = hitCalculator(true);
        numHitsDefender = hitCalculator(false);
    }

    public int hitCalculator(boolean isAttacker){
        int numHits = 0;

        if(isAttacker) {
            for (Unit unit : attacker){
                for (int i=0; i<unit.getNumDiceRollsSpaceCannon(); i++){
                    if (diceRoll() >= unit.getHitValueSpaceCannon()){
                        numHits++;
                    }
                }
            }
        } else {
            for (Unit unit : defender){
                for (int i=0; i<unit.getNumDiceRollsSpaceCannon(); i++){
                    if (diceRoll() >= unit.getHitValueSpaceCannon()){
                        numHits++;
                    }
                }
            }
        }

        return numHits;
    }


    public void attackerPreProcess(){
        //Plasma scoring
        if (AttackerOptions.isPlasmaScoringAttackerCheckbox()){
            addOneDiceToUnit(CombatType.SPACECANNON, attacker);
        }

        //Antimass deflector
        if (AttackerOptions.isAntimassDeflectorAttackerCheckbox()){
            changeHitValueOfAllUnits(CombatType.SPACECANNON, defender, 1);
        }

        //Strike wing ambuscade
        if (AttackerOptions.isStrikeWingAmbushAttackerCheckbox()){
            addOneDiceToUnit(CombatType.SPACECANNON, attacker);
        }

        //Solar flare
        if (AttackerOptions.isSolarFlairAttackerCheckbox()){
            defenderCancelled = true;
        }

        //Argent flight commander
        if (AttackerOptions.isArgentFlightCommanderAttackerCheckbox()){
            addOneDiceToUnit(CombatType.SPACECANNON, attacker);
        }

        //Argent flight flagship
        if (attackersFaction instanceof ArgentFlight && attacker.contains(new Unit.Builder(UnitName.FLAGSHIP).build())){
            defenderCancelled = true;
        }
    }

    public void defenderPreProcess(){
        //Plasma scoring

        //Antimass deflector

        //Strike wing ambuscade

        //Experimental battlestation

        //Argent flight commander

        //Jol-Nar commander

        //Titans Hero

        //Argent flight flagship

        //Yin flagship
    }

    public void attackerMainProcess(){
        //Jol-Nar commander
    }

    public void defenderMainProcess(){

    }

}
