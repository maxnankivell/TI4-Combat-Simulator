package GUI;

import Factions.FactionEnum;

import java.util.EnumMap;

/**
 * Singleton
 */
public class GUIData {

    // Static variable reference of single_instance
    private static GUIData single_instance = null;

    private FactionEnum attackerFaction;
    private EnumMap<UpgradeData, Boolean> attackerUpgradeData;
    private EnumMap<OptionData, Boolean> attackerOptionData;
    private EnumMap<UnitCountData, Integer> attackerUnitCountData;

    private FactionEnum defenderFaction;
    private EnumMap<UpgradeData, Boolean> defenderUpgradeData;
    private EnumMap<OptionData, Boolean> defenderOptionData;
    private EnumMap<UnitCountData, Integer> defenderUnitCountData;

    //Constructor restricted to this class itself
    private GUIData() {
        initialiseEnumMaps();
    }

    // Static method to create/get instance of Singleton class
    public static GUIData getInstance() {
        if (single_instance == null) single_instance = new GUIData();

        return single_instance;
    }

    private void initialiseEnumMaps() {
        attackerUpgradeData = new EnumMap<>(UpgradeData.class);
        attackerOptionData = new EnumMap<>(OptionData.class);
        attackerUnitCountData = new EnumMap<>(UnitCountData.class);

        defenderUpgradeData = new EnumMap<>(UpgradeData.class);
        defenderOptionData = new EnumMap<>(OptionData.class);
        defenderUnitCountData = new EnumMap<>(UnitCountData.class);

        for (UpgradeData upgradeData : UpgradeData.values()) {
            attackerUpgradeData.put(upgradeData, false);
            defenderUpgradeData.put(upgradeData, false);
        }

        for (OptionData optionData : OptionData.values()) {
            attackerOptionData.put(optionData, false);
            defenderOptionData.put(optionData, false);
        }

        for (UnitCountData unitCountData : UnitCountData.values()) {
            attackerUnitCountData.put(unitCountData, 0);
            defenderUnitCountData.put(unitCountData, 0);
        }
    }



    //Getters
    public FactionEnum getAttackerFaction() {
        return attackerFaction;
    }

    public EnumMap<UpgradeData, Boolean> getAttackerUpgradeData() {
        return attackerUpgradeData;
    }

    public EnumMap<OptionData, Boolean> getAttackerOptionData() {
        return attackerOptionData;
    }

    public EnumMap<UnitCountData, Integer> getAttackerUnitCountData() {
        return attackerUnitCountData;
    }

    public FactionEnum getDefenderFaction() {
        return defenderFaction;
    }

    public EnumMap<UpgradeData, Boolean> getDefenderUpgradeData() {
        return defenderUpgradeData;
    }

    public EnumMap<OptionData, Boolean> getDefenderOptionData() {
        return defenderOptionData;
    }

    public EnumMap<UnitCountData, Integer> getDefenderUnitCountData() {
        return defenderUnitCountData;
    }

    //setters
    public void setAttackerFaction(FactionEnum attackerFaction) {
        this.attackerFaction = attackerFaction;
    }

    public void setAttackerUpgradeData(EnumMap<UpgradeData, Boolean> attackerUpgradeData) {
        this.attackerUpgradeData = attackerUpgradeData;
    }

    public void setAttackerOptionData(EnumMap<OptionData, Boolean> attackerOptionData) {
        this.attackerOptionData = attackerOptionData;
    }

    public void setAttackerUnitCountData(EnumMap<UnitCountData, Integer> attackerUnitCountData) {
        this.attackerUnitCountData = attackerUnitCountData;
    }

    public void setDefenderFaction(FactionEnum defenderFaction) {
        this.defenderFaction = defenderFaction;
    }

    public void setDefenderUpgradeData(EnumMap<UpgradeData, Boolean> defenderUpgradeData) {
        this.defenderUpgradeData = defenderUpgradeData;
    }

    public void setDefenderOptionData(EnumMap<OptionData, Boolean> defenderOptionData) {
        this.defenderOptionData = defenderOptionData;
    }

    public void setDefenderUnitCountData(EnumMap<UnitCountData, Integer> defenderUnitCountData) {
        this.defenderUnitCountData = defenderUnitCountData;
    }
}
