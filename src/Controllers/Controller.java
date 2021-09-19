package Controllers;

import Player.*;

public abstract class Controller {
    protected Player attacker;
    protected Player defender;

    public Controller(){
        attacker = new AttackingPlayer();
        defender = new DefendingPlayer();

        startProcess();
    }

    public abstract void startProcess();

    public Player getAttacker() {
        return attacker;
    }

    public Player getDefender() {
        return defender;
    }
}
