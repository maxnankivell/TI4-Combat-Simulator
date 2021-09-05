package Controllers;

import Units.Unit;

public class InvasionController extends Controller{

    public InvasionController(){
        super();
    }

    @Override
    public void startProcess() {
        //Magen defense grid

        //Tekklar legion

        //Sol agent

        //Fire team

        //Morale boost

        //Winnu commander

        //Defending in nebula

        //Jol Nar mech

        //Naaz Rokha flagship

        numHitsAttacker = hitCalculator(true);
        numHitsDefender = hitCalculator(false);
    }

    public int hitCalculator(boolean isAttacker){
        int numHits = 0;

        if(isAttacker) {
            for (Unit unit : attacker){
                for (int i=0; i<unit.getNumDiceRollsGroundCombat(); i++){
                    if (diceRoll() >= unit.getHitValueGroundCombat()){
                        numHits++;
                    }
                }
            }
        } else {
            for (Unit unit : defender){
                for (int i=0; i<unit.getNumDiceRollsGroundCombat(); i++){
                    if (diceRoll() >= unit.getHitValueGroundCombat()){
                        numHits++;
                    }
                }
            }
        }

        return numHits;
    }

}
