package Controllers;

import Units.Unit;

public class SpaceCombatController extends Controller{

    public SpaceCombatController(){
        super();
    }

    @Override
    public void startProcess() {
        //War funding

        //Barony agent

        //Fighter prototype

        //Morale boost

        //Winnu commander

        //Prophecy of ixth

        //Defending in a nebula


        //Jol Nar flagship

        //Naaz Rokha flagship

        //Sardakk Norr flagship

        //Winnu flagship

        //L1Z1X flagship

        numHitsAttacker = hitCalculator(true);
        numHitsDefender = hitCalculator(false);
    }

    public int hitCalculator(boolean isAttacker){
        int numHits = 0;

        if(isAttacker) {
            for (Unit unit : attacker){
                for (int i=0; i<unit.getNumDiceRollsSpaceCombat(); i++){
                    if (diceRoll() >= unit.getHitValueSpaceCombat()){
                        numHits++;
                    }
                }
            }
        } else {
            for (Unit unit : defender){
                for (int i=0; i<unit.getNumDiceRollsSpaceCombat(); i++){
                    if (diceRoll() >= unit.getHitValueSpaceCombat()){
                        numHits++;
                    }
                }
            }
        }

        return numHits;
    }

}
