package Controllers;

import Units.Unit;

public class SpaceCannonDefenseController extends Controller{

    public SpaceCannonDefenseController(){
        super();
    }

    @Override
    public void startProcess() {
        //Plasma scoring

        //Antimass deflector

        //Disable

        //Experimental battlestation

        //Argent flight commander

        //Jol-Nar commander

        //Titans hero

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
