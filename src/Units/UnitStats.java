package Units;

import Factions.FactionEnum;
import GUIData.UpgradeData;

import java.util.EnumMap;

public class UnitStats {
    private EnumMap<UnitName, Unit> unitStats;

    private FactionEnum factionEnum;
    EnumMap<UpgradeData, Boolean> upgradeData;

    public UnitStats(FactionEnum factionEnum, EnumMap<UpgradeData, Boolean> upgradeData) {
        unitStats = new EnumMap<>(UnitName.class);
        this.factionEnum = factionEnum;
        this.upgradeData = upgradeData;

        initialiseUnits();
        upgradeUnits();
        checkForFactionSpecifics();

    }

    private void initialiseUnits(){
        unitStats.put(UnitName.FLAGSHIP, new Unit.Builder(UnitName.FLAGSHIP)
                .addSpaceCombatValue(7, 2)
                .build());
        unitStats.put(UnitName.WARSUN,new Unit.Builder(UnitName.WARSUN)
                .addSpaceCombatValue(3, 3)
                .addBombardmentValue(3, 3)
                .build());
        unitStats.put(UnitName.DREADNOUGHT,new Unit.Builder(UnitName.DREADNOUGHT)
                .addSpaceCombatValue(5, 1)
                .addBombardmentValue(5, 1)
                .build());
        unitStats.put(UnitName.CARRIER,new Unit.Builder(UnitName.CARRIER)
                .addSpaceCombatValue(9, 1)
                .build());
        unitStats.put(UnitName.CRUISER,new Unit.Builder(UnitName.CRUISER)
                .addSpaceCombatValue(7, 1)
                .build());
        unitStats.put(UnitName.DESTROYER,new Unit.Builder(UnitName.DESTROYER)
                .addSpaceCombatValue(9, 1)
                .addAFBValue(9, 2)
                .build());
        unitStats.put(UnitName.FIGHTER,new Unit.Builder(UnitName.FIGHTER)
                .addSpaceCombatValue(9, 1)
                .build());
        unitStats.put(UnitName.PDS, new Unit.Builder(UnitName.PDS)
                .addSpaceCannonValue(6, 1)
                .addIsPlanetaryShield()
                .build());
        unitStats.put(UnitName.INFANTRY,new Unit.Builder(UnitName.INFANTRY)
                .addGroundCombatValue(8, 1)
                .build());
        unitStats.put(UnitName.MECH, new Unit.Builder(UnitName.MECH)
                .addGroundCombatValue(6, 1)
                .build());
    }

    private void upgradeUnits(){

        boolean isFlagshipUpgraded = upgradeData.get(UpgradeData.ISFLAGSHIPUPGRADED);
        boolean isDreadnoughtUpgraded = upgradeData.get(UpgradeData.ISDREADNOUGHTUPGRADED);
        boolean isCarrierUpgraded = upgradeData.get(UpgradeData.ISCARRIERUPGRADED);
        boolean isCruiserUpgraded = upgradeData.get(UpgradeData.ISCRUISERUPGRADED);
        boolean isDestroyerUpgraded = upgradeData.get(UpgradeData.ISDESTROYERUPGRADED);
        boolean isFighterUpgraded = upgradeData.get(UpgradeData.ISFIGHTERUPGRADED);
        boolean isInfantryUpgraded = upgradeData.get(UpgradeData.ISINFANTRYUPGRADED);
        boolean isPdsUpgraded = upgradeData.get(UpgradeData.ISPDSUPGRADED);

        if (isFlagshipUpgraded && factionEnum == FactionEnum.NOMAD) upgradeFlagship(); //Only Nomad can upgrade
        if (isDreadnoughtUpgraded) upgradeDreadnought();
        if (isCarrierUpgraded) upgradeCarrier();
        if (isCruiserUpgraded) upgradeCruiser();
        if (isDestroyerUpgraded) upgradeDestroyer();
        if (isFighterUpgraded) upgradeFighter();
        if (isInfantryUpgraded) upgradeInfantry();
        if (isPdsUpgraded) upgradePds();

    }

    public void upgradeFlagship(){
        unitStats.get(UnitName.FLAGSHIP).setUpgraded(true);
    }

    public void upgradeDreadnought(){
        unitStats.get(UnitName.DREADNOUGHT).setUpgraded(true);
    }

    public void upgradeCarrier(){
        unitStats.get(UnitName.CARRIER).setUpgraded(true);
    }

    public void upgradeCruiser(){
        unitStats.get(UnitName.CRUISER).setUpgraded(true);
        unitStats.get(UnitName.CRUISER).setSpaceCannonValue(6,1);
    }

    public void upgradeDestroyer(){
        unitStats.get(UnitName.DESTROYER).setUpgraded(true);
        unitStats.get(UnitName.DESTROYER).setSpaceCannonValue(8,1);
        unitStats.get(UnitName.DESTROYER).setAFBValue(6,3);
    }

    public void upgradeFighter(){
        unitStats.get(UnitName.FIGHTER).setUpgraded(true);
        unitStats.get(UnitName.FIGHTER).setSpaceCannonValue(8,1);
    }

    public void upgradePds(){
        unitStats.get(UnitName.PDS).setUpgraded(true);
        unitStats.get(UnitName.PDS).setSpaceCannonValue(5, 1);
    }

    public void upgradeInfantry(){
        unitStats.get(UnitName.INFANTRY).setUpgraded(true);
        unitStats.get(UnitName.INFANTRY).setGroundCombatValue(7, 1);
    }

    private void checkForFactionSpecifics() {
        switch (factionEnum) {
            case ARBOREC -> arborec();
            case ARGENTFLIGHT -> argentFlight();
            case BARONYOFLETNEV -> baronyOfLetnev();
            case CLANOFSAAR -> clanOfSaar();
            case CREUSS -> creuss();
            case EMPYREAN -> empyrean();
            case HACAN -> hacan();
            case JOLNAR -> jolNar();
            case L1Z1X -> l1Z1X();
            case MAHACT -> mahact();
            case MUAAT -> muaat();
            case MENTAK -> mentak();
            case NAALU -> naalu();
            case NAAZROKHA -> naazRokha();
            case NEKRO -> nekro();
            case NOMAD -> nomad();
            case SARDAKKNORR -> sardakkNorr();
            case SOL -> sol();
            case TITANSOFUL -> titansOfUl();
            case VUILRAITH -> vuilRaith();
            case WINNU -> winnu();
            case XXCHA -> xxcha();
            case YIN -> yin();
            case YSSARIL -> yssaril();
        }
    }

    private void arborec() {
        unitStats.get(UnitName.MECH).setPlanetaryShield(true);
    }

    private void argentFlight() {
        Unit destroyer = unitStats.get(UnitName.DESTROYER);
        if (!destroyer.isUpgraded()) {
            destroyer.setSpaceCombatValue(8,1);
            destroyer.setAFBValue(9,2);
        }else {
            destroyer.setSpaceCombatValue(7,1);
            destroyer.setAFBValue(6,3);
        }

    }

    private void baronyOfLetnev() {
        unitStats.get(UnitName.FLAGSHIP).setSpaceCombatValue(5, 2);
        unitStats.get(UnitName.FLAGSHIP).setBombardmentValue(5, 3);
    }

    private void clanOfSaar() {
        unitStats.get(UnitName.FLAGSHIP).setSpaceCombatValue(5, 2);
        unitStats.get(UnitName.FLAGSHIP).setAFBValue(6, 4);
    }

    private void creuss() {
        unitStats.get(UnitName.FLAGSHIP).setSpaceCombatValue(5, 1);
    }

    private void empyrean() {
        unitStats.get(UnitName.FLAGSHIP).setSpaceCombatValue(5, 2);
    }

    private void hacan() {

    }

    private void jolNar() {
        unitStats.get(UnitName.FLAGSHIP).setSpaceCombatValue(6, 2);
        for (Unit unit : unitStats.values()) {
            unit.setHitValueSpaceCombat(unit.getHitValueSpaceCombat()+1);
        }
    }

    private void l1Z1X() {
        unitStats.get(UnitName.FLAGSHIP).setSpaceCombatValue(5, 2);
        unitStats.get(UnitName.MECH).setBombardmentValue(8,1);
        if (unitStats.get(UnitName.DREADNOUGHT).isUpgraded()) {
            unitStats.get(UnitName.DREADNOUGHT).setSpaceCombatValue(4, 1);
            unitStats.get(UnitName.DREADNOUGHT).setSpaceCannonValue(4, 1);
        }
    }

    private void mahact() {
        unitStats.get(UnitName.FLAGSHIP).setSpaceCombatValue(5, 2);
    }

    private void muaat() {
        unitStats.get(UnitName.FLAGSHIP).setSpaceCombatValue(5, 2);
    }

    private void mentak() {

    }

    private void naalu() {
        unitStats.get(UnitName.FLAGSHIP).setSpaceCombatValue(9, 2);
        unitStats.get(UnitName.FIGHTER).setHitValueSpaceCombat(unitStats.get(UnitName.FIGHTER).getHitValueSpaceCombat()-1);
    }

    private void naazRokha() {
        unitStats.get(UnitName.FLAGSHIP).setSpaceCombatValue(9, 2);
        unitStats.get(UnitName.MECH).setNumDiceRollsGroundCombat(2);
        unitStats.get(UnitName.MECH).setSpaceCombatValue(8,2);
    }

    private void nekro() {
        unitStats.get(UnitName.FLAGSHIP).setSpaceCombatValue(9, 2);
    }

    private void nomad() {
        unitStats.get(UnitName.FLAGSHIP).setAFBValue(8, 3);
        if (unitStats.get(UnitName.FLAGSHIP).isUpgraded()) {
            unitStats.get(UnitName.FLAGSHIP).setAFBValue(5, 3);
            unitStats.get(UnitName.FLAGSHIP).setSpaceCombatValue(5, 2);
        }
    }

    private void sardakkNorr() {
        unitStats.get(UnitName.FLAGSHIP).setSpaceCombatValue(6, 2);
        unitStats.get(UnitName.DREADNOUGHT).setBombardmentValue(4,2);
        for (Unit unit : unitStats.values()) {
            unit.setHitValueSpaceCombat(unit.getHitValueSpaceCombat()-1);
        }
    }

    private void sol() {
        unitStats.get(UnitName.FLAGSHIP).setSpaceCombatValue(5, 2);
        unitStats.get(UnitName.INFANTRY).setGroundCombatValue(7,1);
        if (unitStats.get(UnitName.INFANTRY).isUpgraded()) {
            unitStats.get(UnitName.INFANTRY).setGroundCombatValue(6,1);
        }
    }

    private void titansOfUl() {
        unitStats.get(UnitName.PDS).setGroundCombatValue(7,1);
        if (unitStats.get(UnitName.PDS).isUpgraded()){
            unitStats.get(UnitName.PDS).setGroundCombatValue(6,1);
            unitStats.get(UnitName.PDS).setSpaceCannonValue(5,1);
        }
    }

    private void vuilRaith() {
        unitStats.get(UnitName.FLAGSHIP).setSpaceCombatValue(5, 2);
        unitStats.get(UnitName.FLAGSHIP).setBombardmentValue(5, 1);
    }

    private void winnu() {
        unitStats.get(UnitName.FLAGSHIP).setSpaceCombatValue(7, 0);
    }

    private void xxcha() {
        unitStats.get(UnitName.FLAGSHIP).setSpaceCannonValue(5, 3);
        unitStats.get(UnitName.MECH).setSpaceCannonValue(8,1);
    }

    private void yin() {
        unitStats.get(UnitName.FLAGSHIP).setSpaceCombatValue(9, 2);
    }

    private void yssaril() {
        unitStats.get(UnitName.FLAGSHIP).setSpaceCombatValue(5, 2);
    }

    public Unit getFlagship() {
        return unitStats.get(UnitName.FLAGSHIP);
    }

    public Unit getWarsun() {
        return unitStats.get(UnitName.WARSUN);
    }

    public Unit getDreadnought() {
        return unitStats.get(UnitName.DREADNOUGHT);
    }

    public Unit getCarrier() {
        return unitStats.get(UnitName.CARRIER);
    }

    public Unit getCruiser() {
        return unitStats.get(UnitName.CRUISER);
    }

    public Unit getDestroyer() {
        return unitStats.get(UnitName.DESTROYER);
    }

    public Unit getFighter() {
        return unitStats.get(UnitName.FIGHTER);
    }

    public Unit getMech() {
        return unitStats.get(UnitName.MECH);
    }

    public Unit getInfantry() {
        return unitStats.get(UnitName.INFANTRY);
    }

    public Unit getPds() {
        return unitStats.get(UnitName.PDS);
    }

}
