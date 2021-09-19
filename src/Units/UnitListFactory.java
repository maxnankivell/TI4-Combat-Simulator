package Units;

import Factions.*;
import GUIData.UnitCountData;
import GUIData.UpgradeData;

import java.util.EnumMap;

public class UnitListFactory {

    private Faction faction;

    public UnitList makeUnitList(FactionEnum factionEnum, EnumMap<UpgradeData, Boolean> upgradeData, EnumMap<UnitCountData, Integer> unitCountData) {

        populateFaction(factionEnum);
        upgradeUnits(upgradeData);

        return populateUnitList(unitCountData);
    }

    /**
     * Populates a the faction field with the faction Enum passed in
     */
    private void populateFaction(FactionEnum factionEnum){
        faction = switch (factionEnum) {
            case ARBOREC -> new Arborec();
            case ARGENTFLIGHT -> new ArgentFlight();
            case BARONYOFLETNEV -> new BaronyOfLetnev();
            case CLANOFSAAR -> new ClanOfSaar();
            case CREUSS -> new Creuss();
            case EMPYREAN -> new Empyrean();
            case HACAN -> new Hacan();
            case JOLNAR -> new JolNar();
            case L1Z1X -> new L1Z1X();
            case MAHACT -> new Mahact();
            case MUAAT -> new Muaat();
            case MENTAK -> new Mentak();
            case NAALU -> new Naalu();
            case NAAZROKHA -> new NaazRokha();
            case NEKRO -> new Nekro();
            case NOMAD -> new Nomad();
            case SARDAKKNORR -> new SardakkNorr();
            case SOL -> new Sol();
            case TITANSOFUL -> new TitansOfUl();
            case VUILRAITH -> new VuilRaith();
            case WINNU -> new Winnu();
            case XXCHA -> new Xxcha();
            case YIN -> new Yin();
            case YSSARIL -> new Yssaril();
        };
    }

    private void upgradeUnits(EnumMap<UpgradeData, Boolean> upgradeData){
        boolean isFlagshipUpgraded, isDreadnoughtUpgraded, isCarrierUpgraded, isCruiserUpgraded, isDestroyerUpgraded, isFighterUpgraded, isInfantryUpgraded, isPdsUpgraded;

        isFlagshipUpgraded = upgradeData.get(UpgradeData.ISFLAGSHIPUPGRADED);
        isDreadnoughtUpgraded = upgradeData.get(UpgradeData.ISDREADNOUGHTUPGRADED);
        isCarrierUpgraded = upgradeData.get(UpgradeData.ISCARRIERUPGRADED);
        isCruiserUpgraded = upgradeData.get(UpgradeData.ISCRUISERUPGRADED);
        isDestroyerUpgraded = upgradeData.get(UpgradeData.ISDESTROYERUPGRADED);
        isFighterUpgraded = upgradeData.get(UpgradeData.ISFIGHTERUPGRADED);
        isInfantryUpgraded = upgradeData.get(UpgradeData.ISINFANTRYUPGRADED);
        isPdsUpgraded = upgradeData.get(UpgradeData.ISPDSUPGRADED);

        if (isFlagshipUpgraded && faction instanceof Nomad) faction.upgradeFlagship(); //Only Nomad can upgrade
        if (isDreadnoughtUpgraded) faction.upgradeDreadnought();
        if (isCarrierUpgraded) faction.upgradeCarrier();
        if (isCruiserUpgraded) faction.upgradeCruiser();
        if (isDestroyerUpgraded) faction.upgradeDestroyer();
        if (isFighterUpgraded) faction.upgradeFighter();
        if (isInfantryUpgraded) faction.upgradeInfantry();
        if (isPdsUpgraded) faction.upgradePds();

    }

    public UnitList populateUnitList(EnumMap<UnitCountData, Integer> unitCountData) {
        UnitList units = new UnitList();

        int numFlagships, numWarsuns, numDreadnoughts, numCarriers, numCrusiers, numDestroyers, numFighters, numMechs, numInfantry, numPDSs;

        numFlagships = unitCountData.get(UnitCountData.FLAGSHIPCOUNT);
        numWarsuns = unitCountData.get(UnitCountData.WARSUNCOUNT);
        numDreadnoughts = unitCountData.get(UnitCountData.DREADNOUGHTCOUNT);
        numCarriers = unitCountData.get(UnitCountData.CARRIERCOUNT);
        numCrusiers = unitCountData.get(UnitCountData.CRUISERCOUNT);
        numDestroyers = unitCountData.get(UnitCountData.DESTROYERCOUNT);
        numFighters = unitCountData.get(UnitCountData.FIGHTERCOUNT);
        numMechs = unitCountData.get(UnitCountData.MECHCOUNT);
        numInfantry = unitCountData.get(UnitCountData.INFANTRYCOUNT);
        numPDSs = unitCountData.get(UnitCountData.PDSCOUNT);

        for (int i = 0; i < numFlagships; i++) units.add(new Unit(faction.getFlagship()));
        for (int i = 0; i < numWarsuns; i++) units.add(new Unit(faction.getWarsun()));
        for (int i = 0; i < numDreadnoughts; i++) units.add(new Unit(faction.getDreadnought()));
        for (int i = 0; i < numCarriers; i++) units.add(new Unit(faction.getCarrier()));
        for (int i = 0; i < numCrusiers; i++) units.add(new Unit(faction.getCruiser()));
        for (int i = 0; i < numDestroyers; i++) units.add(new Unit(faction.getDestroyer()));
        for (int i = 0; i < numFighters; i++) units.add(new Unit(faction.getFighter()));
        for (int i = 0; i < numMechs; i++) units.add(new Unit(faction.getMech()));
        for (int i = 0; i < numInfantry; i++) units.add(new Unit(faction.getInfantry()));
        for (int i = 0; i < numPDSs; i++) units.add(new Unit(faction.getPds()));

        return units;
    }
}
