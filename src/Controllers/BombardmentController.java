package Controllers;

import Units.Unit;

public class BombardmentController extends Controller{

    public BombardmentController(){
        super();
    }

    @Override
    public void startProcess() {
        //Plasma scoring

        //X-89 Bacterial Weapon

        //Strike wing ambush

        //Bunker

        //Disable

        //Blitz

        //Argent flight commander

        //Jol-Nar commander

        //L1Z1X commander

        //Convention of war

        numHitsAttacker = hitCalculator(true);
        numHitsDefender = hitCalculator(false);

    }

    public int hitCalculator(boolean isAttacker){
        int numHits = 0;

        if(isAttacker) {
            for (Unit unit : attacker){
                for (int i=0; i<unit.getNumDiceRollsBombardment(); i++){
                    if (diceRoll() >= unit.getHitValueBombardment()){
                        numHits++;
                    }
                }
            }
        } else {
            for (Unit unit : defender){
                for (int i=0; i<unit.getNumDiceRollsBombardment(); i++){
                    if (diceRoll() >= unit.getHitValueBombardment()){
                        numHits++;
                    }
                }
            }
        }

        return numHits;
    }


}
