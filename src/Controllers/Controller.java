package Controllers;

import GUI.GUIData;
import Player.*;

public abstract class Controller {
    protected Player attacker;
    protected Player defender;

    public Controller(){
        attacker = new Player(PlayerRole.ATTACKER,
                GUIData.getInstance().getAttackerFaction(),
                GUIData.getInstance().getAttackerUpgradeData(),
                GUIData.getInstance().getAttackerOptionData(),
                GUIData.getInstance().getAttackerUnitCountData());
        defender = new Player(PlayerRole.DEFENDER,
                GUIData.getInstance().getDefenderFaction(),
                GUIData.getInstance().getDefenderUpgradeData(),
                GUIData.getInstance().getDefenderOptionData(),
                GUIData.getInstance().getDefenderUnitCountData());

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
