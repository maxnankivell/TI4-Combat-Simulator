package Units;

import Factions.FactionEnum;
import GUIData.UnitCountData;
import GUIData.UpgradeData;

import java.util.EnumMap;

public class UnitListFactory {

    public UnitList makeUnitList(FactionEnum factionEnum, EnumMap<UpgradeData, Boolean> upgradeData, EnumMap<UnitCountData, Integer> unitCountData) {

        UnitStats unitStats = new UnitStats(factionEnum, upgradeData);

        return populateUnitList(unitCountData, unitStats);
    }

    public UnitList populateUnitList(EnumMap<UnitCountData, Integer> unitCountData, UnitStats unitStats) {
        UnitList units = new UnitList();

        int numFlagships = unitCountData.get(UnitCountData.FLAGSHIPCOUNT);
        int numWarsuns = unitCountData.get(UnitCountData.WARSUNCOUNT);
        int numDreadnoughts = unitCountData.get(UnitCountData.DREADNOUGHTCOUNT);
        int numCarriers = unitCountData.get(UnitCountData.CARRIERCOUNT);
        int numCrusiers = unitCountData.get(UnitCountData.CRUISERCOUNT);
        int numDestroyers = unitCountData.get(UnitCountData.DESTROYERCOUNT);
        int numFighters = unitCountData.get(UnitCountData.FIGHTERCOUNT);
        int numMechs = unitCountData.get(UnitCountData.MECHCOUNT);
        int numInfantry = unitCountData.get(UnitCountData.INFANTRYCOUNT);
        int numPDSs = unitCountData.get(UnitCountData.PDSCOUNT);

        for (int i = 0; i < numFlagships; i++) units.add(new Unit(unitStats.getFlagship()));
        for (int i = 0; i < numWarsuns; i++) units.add(new Unit(unitStats.getWarsun()));
        for (int i = 0; i < numDreadnoughts; i++) units.add(new Unit(unitStats.getDreadnought()));
        for (int i = 0; i < numCarriers; i++) units.add(new Unit(unitStats.getCarrier()));
        for (int i = 0; i < numCrusiers; i++) units.add(new Unit(unitStats.getCruiser()));
        for (int i = 0; i < numDestroyers; i++) units.add(new Unit(unitStats.getDestroyer()));
        for (int i = 0; i < numFighters; i++) units.add(new Unit(unitStats.getFighter()));
        for (int i = 0; i < numMechs; i++) units.add(new Unit(unitStats.getMech()));
        for (int i = 0; i < numInfantry; i++) units.add(new Unit(unitStats.getInfantry()));
        for (int i = 0; i < numPDSs; i++) units.add(new Unit(unitStats.getPds()));

        return units;
    }
}
