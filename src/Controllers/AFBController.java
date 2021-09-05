package Controllers;

import Units.Unit;

public class AFBController extends Controller{

    public AFBController(){
        super();
    }

    @Override
    public void startProcess() {
        //Strike wing ambush

        //Argent flight commander

        //Jol-Nar commander

        numHitsAttacker = hitCalculator(true);
        numHitsDefender = hitCalculator(false);
    }

    public int hitCalculator(boolean isAttacker){
        int numHits = 0;

        if(isAttacker) {
            for (Unit unit : attacker){
                for (int i=0; i<unit.getNumDiceRollsAFB(); i++){
                    if (diceRoll() >= unit.getHitValueAFB()){
                        numHits++;
                    }
                }
            }
        } else {
            for (Unit unit : defender){
                for (int i=0; i<unit.getNumDiceRollsAFB(); i++){
                    if (diceRoll() >= unit.getHitValueAFB()){
                        numHits++;
                    }
                }
            }
        }

        return numHits;
    }

}
