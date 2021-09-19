package Player;

import GUIData.GUIData;
import Units.UnitListFactory;

public class AttackingPlayer extends Player{

    public AttackingPlayer() {
        super(GUIData.getInstance().getAttackerFaction(), GUIData.getInstance().getAttackerOptionData());

        UnitListFactory unitListFactory = new UnitListFactory();
        unitList = unitListFactory.makeUnitList(factionEnum,  GUIData.getInstance().getAttackerUpgradeData(), GUIData.getInstance().getAttackerUnitCountData());
    }

}
