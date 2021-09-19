package Player;

import GUIData.GUIData;
import Units.UnitListFactory;

public class DefendingPlayer extends Player{

    public DefendingPlayer() {
        super(GUIData.getInstance().getDefenderFaction(), GUIData.getInstance().getDefenderOptionData());

        UnitListFactory unitListFactory = new UnitListFactory();
        unitList = unitListFactory.makeUnitList(factionEnum,  GUIData.getInstance().getDefenderUpgradeData(), GUIData.getInstance().getDefenderUnitCountData());
    }

}
