package Controllers;

import Player.*;
import Units.Unit;

import java.util.ArrayList;

public abstract class Controller {
    protected Player attacker;
    protected Player defender;

    public Controller(){
        attacker = new Player(PlayerRole.ATTACKER);
        defender = new Player(PlayerRole.DEFENDER);

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
