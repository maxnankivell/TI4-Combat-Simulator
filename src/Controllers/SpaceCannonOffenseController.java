package Controllers;

import Units.Unit;

public class SpaceCannonOffenseController extends Controller{

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



}
