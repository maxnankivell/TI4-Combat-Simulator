package Controllers;

import Units.Unit;

import java.util.ArrayList;

public abstract class Controller {
    protected ArrayList<Unit> defender;
    protected ArrayList<Unit> attacker;
    protected int numHitsAttacker;
    protected int numHitsDefender;

    public Controller(){
        this.attacker = populatePlayer(true);
        this.defender = populatePlayer(false);

        startProcess();
    }

    public ArrayList<Unit> populatePlayer(boolean isAttacker){ return null;}

    public abstract void startProcess();

    public int hitCalculator(boolean isAttacker){
        int numHits = 0;
        int diceValue;

        //for each ship type
        //for each ship player has of that ship
//        diceValue = rollDice();
//        if(isAttacker) {
//            if (attacker.doesItHit(shipType, diceValue)) {
//                numHits++;
//            }
//        } else {
//            if (attacker.doesItHit(shipType, diceValue)) {
//                numHits++;
//            }
//        }
        return numHits;
    }

    public int rollDice(){return -1;}

    public int getNumHitsAttacker() {
        return numHitsAttacker;
    }

    public int getNumHitsDefender() {
        return numHitsDefender;
    }
}
