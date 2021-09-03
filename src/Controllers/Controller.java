package Controllers;

import Utility.Player;

public abstract class Controller {
    protected Player defender;
    protected Player attacker;
    protected int numHitsAttacker;
    protected int numHitsDefender;

    public Controller(){
        this.attacker = populatePlayer(true);
        this.defender = populatePlayer(false);

        startProcess();
    }

    public Player populatePlayer(boolean isAttacker){ return null;}

    public abstract void startProcess();

    public int hitCalculator(boolean isAttacker){
        int numHits = 0;
        int diceValue;

        //for each ship type
        //for each ship player has of that ship
        diceValue = rollDice();
        //if (Player.doesItHit(shipType, diceValue)) {
        numHits++;
        //}

        return numHits;
    }

    public int rollDice(){return -1;};

    public int getNumHitsAttacker() {
        return numHitsAttacker;
    }

    public int getNumHitsDefender() {
        return numHitsDefender;
    }
}
