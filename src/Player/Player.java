package Player;

import Controllers.CombatType;
import Factions.*;
import GUI.Main;
import GUI.OptionData;
import GUI.UnitCountData;
import GUI.UpgradeData;
import Factions.FactionEnum;
import Units.Unit;
import Units.UnitList;
import Units.UnitName;

import java.util.ArrayList;
import java.util.EnumMap;

public class Player {

    private UnitList unitList;
    private Faction faction;
    private PlayerRole role;
    private int numHits;
    private int numInfantryHits;
    private int numSustainDamageHits;
    private int numNonFighterHits;
    private FactionEnum factionEnum;
    private EnumMap<UpgradeData, Boolean> upgradeData;
    private EnumMap<OptionData, Boolean> optionData;
    private EnumMap<UnitCountData, Integer> unitCountData;

    //Main constructor
    public Player(PlayerRole role) {
        this.role = role;

        populateDataFields();
        populateFaction();
        upgradeUnits();
        unitList = populateUnitList();
    }

    //Make a copy
    public Player(Player master) {
        this.unitList = master.getUnitList();
        this.faction = master.getFaction();
        this.role = master.getRole();
        this.numHits = master.getNumHits();
        this.numInfantryHits = master.getNumInfantryHits();
        this.numSustainDamageHits = master.getNumSustainDamageHits();
        this.numNonFighterHits = master.getNumNonFighterHits();
        this.factionEnum = master.getFactionEnum();
        this.upgradeData = master.getUpgradeData();
        this.optionData = master.getOptionData();
        this.unitCountData = master.getUnitCountData();
    }

    private void populateDataFields(){
        switch (role){
            case ATTACKER -> {
                factionEnum = Main.getAttackerFaction();
                upgradeData = Main.getAttackerUpgradeData();
                optionData = Main.getAttackerOptionData();
                unitCountData = Main.getAttackerUnitCountData();
            }
            case DEFENDER -> {
                factionEnum = Main.getDefenderFaction();
                upgradeData = Main.getDefenderUpgradeData();
                optionData = Main.getDefenderOptionData();
                unitCountData = Main.getDefenderUnitCountData();
            }
        }
    }

    /**
     * populates a the faction field with the
     * user inputted faction
     */
    private void populateFaction(){
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

    private void upgradeUnits(){
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

    /**
     * populates unit arraylist with units
     * number of units got from options
     * units have factions specific values
     * @return UnitList with units
     */
    public UnitList populateUnitList() {
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

    /**
     * adds the titans hero unit to the list of units
     */
    public void addUnitTitansHero(){
        unitList.add(new Unit.Builder(UnitName.OTHER)
                .addSpaceCannonValue(5,3)
                .build());
    }

    /**
     * adds the experimental battlestation unit to the list of units
     */
    public void addUnitExperimentalBattlestation(){
        unitList.add(new Unit.Builder(UnitName.OTHER)
                .addSpaceCannonValue(5,3)
                .build());
    }

    /**
     * stops all pds from firing and turns off planetary shield
     */
    public void disablePDS(){
        for (Unit unit: unitList.getUnitArrayList()){
            if (unit.getName()==UnitName.PDS){
                unit.setNumDiceRollsSpaceCannon(0);
                unit.setHitValueSpaceCannon(0);
                unit.setPlanetaryShield(false);
            }
        }
    }

    /**
     * adds a dice to the best possible unit given this stage of combat
     * @param combatType the current stage of combat
     */
    public void addOneDiceToBestUnit(CombatType combatType){
        Unit lowestHitValue = unitList.get(0);
        switch (combatType){
            case AFB:
                for (Unit unit: unitList.getUnitArrayList()){
                    if ((unit.getHitValueAFB()<lowestHitValue.getHitValueAFB() && unit.getHitValueAFB()!=0)
                            || lowestHitValue.getHitValueAFB()==0){
                        lowestHitValue=unit;
                    }
                }
                if (lowestHitValue.getHitValueAFB()!=0) {
                    lowestHitValue.setNumDiceRollsAFB(lowestHitValue.getNumDiceRollsAFB() + 1);
                }
                break;
            case BOMBARDMENT:
                for (Unit unit: unitList.getUnitArrayList()){
                    if ((unit.getHitValueBombardment()<lowestHitValue.getHitValueBombardment() && unit.getHitValueBombardment()!=0)
                            || lowestHitValue.getHitValueBombardment()==0){
                        lowestHitValue=unit;
                    }
                }
                if (lowestHitValue.getHitValueBombardment()!=0) {
                    lowestHitValue.setNumDiceRollsBombardment(lowestHitValue.getNumDiceRollsBombardment() + 1);
                }
                break;
            case SPACECANNON:
                for (Unit unit: unitList.getUnitArrayList()){
                    if ((unit.getHitValueSpaceCannon()<lowestHitValue.getHitValueSpaceCannon() && unit.getHitValueSpaceCannon()!=0)
                            || lowestHitValue.getHitValueSpaceCannon()==0){
                        lowestHitValue=unit;
                    }
                }
                if (lowestHitValue.getHitValueSpaceCannon()!=0) {
                    lowestHitValue.setNumDiceRollsSpaceCannon(lowestHitValue.getNumDiceRollsSpaceCannon() + 1);
                }
                break;
            case SPACECOMBAT:
                for (Unit unit: unitList.getUnitArrayList()){
                    if ((unit.getHitValueSpaceCombat()<lowestHitValue.getHitValueSpaceCombat() && unit.getHitValueSpaceCombat()!=0)
                            || lowestHitValue.getHitValueSpaceCombat()==0){
                        lowestHitValue=unit;
                    }
                }
                if (lowestHitValue.getHitValueSpaceCombat()!=0) {
                    lowestHitValue.setNumDiceRollsSpaceCombat(lowestHitValue.getNumDiceRollsSpaceCombat() + 1);
                }
                break;
            case GROUNDCOMBAT:
                for (Unit unit: unitList.getUnitArrayList()){
                    if ((unit.getHitValueGroundCombat()<lowestHitValue.getHitValueGroundCombat()) && unit.getHitValueGroundCombat()!=0
                            || lowestHitValue.getHitValueGroundCombat()==0){
                        lowestHitValue=unit;
                    }
                }
                if (lowestHitValue.getHitValueGroundCombat()!=0) {
                    lowestHitValue.setNumDiceRollsGroundCombat(lowestHitValue.getNumDiceRollsGroundCombat() + 1);
                }
                break;
        }
    }

    /**
     * adds a dice to all units of a specific type given this stage of combat
     * @param combatType the current stage of combat
     * @param unitName name of unit
     */
    public void addDiceToSpecificUnitType(CombatType combatType, UnitName unitName){
        switch (combatType){
            case AFB:
                for (Unit unit: unitList.getUnitArrayList()){
                    if(unit.getName() == unitName && unit.getNumDiceRollsAFB()!=0){
                        unit.setNumDiceRollsAFB(unit.getNumDiceRollsAFB()+1);
                    }
                }
                break;
            case BOMBARDMENT:
                for (Unit unit: unitList.getUnitArrayList()){
                    if(unit.getName() == unitName && unit.getNumDiceRollsBombardment()!=0){
                        unit.setNumDiceRollsBombardment(unit.getNumDiceRollsBombardment()+1);
                    }
                }
                break;
            case SPACECANNON:
                for (Unit unit: unitList.getUnitArrayList()){
                    if(unit.getName() == unitName && unit.getNumDiceRollsSpaceCannon()!=0){
                        unit.setNumDiceRollsSpaceCannon(unit.getNumDiceRollsSpaceCannon()+1);
                    }
                }
                break;
            case SPACECOMBAT:
                for (Unit unit: unitList.getUnitArrayList()){
                    if(unit.getName() == unitName && unit.getNumDiceRollsSpaceCombat()!=0){
                        unit.setNumDiceRollsSpaceCombat(unit.getNumDiceRollsSpaceCombat()+1);
                    }
                }
                break;
            case GROUNDCOMBAT:
                for (Unit unit: unitList.getUnitArrayList()){
                    if(unit.getName() == unitName && unit.getNumDiceRollsGroundCombat()!=0){
                        unit.setNumDiceRollsGroundCombat(unit.getNumDiceRollsGroundCombat()+1);
                    }
                }
                break;
        }
    }

    /**
     * adds to all units in this stage of combat
     * @param combatType the current stage of combat
     * @param addAmount amount added to the units hit values
     */
    public void changeHitValueOfAllUnits(CombatType combatType, int addAmount){
        switch (combatType){
            case AFB:
                for (Unit unit: unitList.getUnitArrayList()){
                    if (unit.getHitValueAFB()!=0) {
                        unit.setHitValueAFB(unit.getHitValueAFB() + addAmount);
                    }
                }
                break;
            case BOMBARDMENT:
                for (Unit unit: unitList.getUnitArrayList()){
                    if (unit.getHitValueBombardment()!=0) {
                        if (unit.getHitValueBombardment()!=0) {
                            unit.setHitValueBombardment(unit.getHitValueBombardment() + addAmount);
                        }
                    }
                }
                break;
            case SPACECANNON:
                for (Unit unit: unitList.getUnitArrayList()){
                    if (unit.getHitValueSpaceCannon()!=0) {
                        unit.setHitValueSpaceCannon(unit.getHitValueSpaceCannon() + addAmount);
                    }
                }
                break;
            case SPACECOMBAT:
                for (Unit unit: unitList.getUnitArrayList()){
                    if (unit.getHitValueSpaceCombat()!=0) {
                        unit.setHitValueSpaceCombat(unit.getHitValueSpaceCombat() + addAmount);
                    }
                }
                break;
            case GROUNDCOMBAT:
                for (Unit unit: unitList.getUnitArrayList()){
                    if (unit.getHitValueGroundCombat()!=0) {
                        unit.setHitValueGroundCombat(unit.getHitValueGroundCombat() + addAmount);
                    }
                }
                break;
        }
    }

    /**
     * Modifies hit value of all units of a specific type in this stage of combat
     * @param combatType the current stage of combat
     * @param addAmount amount added to the units hit values
     * @param unitName name of unit
     */
    public void changeHitValueOfAllUnitsOfSpecificType(CombatType combatType, int addAmount, UnitName unitName){
        switch (combatType){
            case AFB:
                for (Unit unit: unitList.getUnitArrayList()){
                    if(unit.getName() == unitName && unit.getHitValueAFB()!=0){
                        unit.setHitValueAFB(unit.getHitValueAFB()+addAmount);
                    }
                }
                break;
            case BOMBARDMENT:
                for (Unit unit: unitList.getUnitArrayList()){
                    if(unit.getName() == unitName && unit.getHitValueBombardment()!=0){
                        unit.setHitValueBombardment(unit.getHitValueBombardment()+addAmount);
                    }
                }
                break;
            case SPACECANNON:
                for (Unit unit: unitList.getUnitArrayList()){
                    if(unit.getName() == unitName && unit.getHitValueSpaceCannon()!=0){
                        unit.setHitValueSpaceCannon(unit.getHitValueSpaceCannon()+addAmount);
                    }
                }
                break;
            case SPACECOMBAT:
                for (Unit unit: unitList.getUnitArrayList()){
                    if(unit.getName() == unitName && unit.getHitValueSpaceCombat()!=0){
                        unit.setHitValueSpaceCombat(unit.getHitValueSpaceCombat()+addAmount);
                    }
                }
                break;
            case GROUNDCOMBAT:
                for (Unit unit: unitList.getUnitArrayList()){
                    if(unit.getName() == unitName && unit.getHitValueGroundCombat()!=0){
                        unit.setHitValueGroundCombat(unit.getHitValueGroundCombat()+addAmount);
                    }
                }
                break;
        }
    }

    public Faction getFaction() {
        return faction;
    }

    public PlayerRole getRole() {
        return role;
    }

    public int getNumHits() {
        return numHits;
    }

    public int getNumInfantryHits() {
        return numInfantryHits;
    }

    public int getNumSustainDamageHits() {
        return numSustainDamageHits;
    }

    public int getNumNonFighterHits() {
        return numNonFighterHits;
    }

    public FactionEnum getFactionEnum() {
        return factionEnum;
    }

    public EnumMap<UpgradeData, Boolean> getUpgradeData() {
        return upgradeData;
    }

    public EnumMap<OptionData, Boolean> getOptionData() {
        return optionData;
    }

    public EnumMap<UnitCountData, Integer> getUnitCountData() {
        return unitCountData;
    }

    public UnitList getUnitList(){
        return unitList;
    }

    public ArrayList<Unit> getUnitArrayList(){
        return unitList.getUnitArrayList();
    }

    public void addNumHits(int numHits){
        this.numHits+=numHits;
    }

    public void addNumInfantryHits(int numInfantryHits){
        this.numInfantryHits+=numInfantryHits;
    }

    public void addNumSustainDamageHits(int numSustainDamageHits){
        this.numSustainDamageHits+=numSustainDamageHits;
    }

    public void addNumNonFighterHits(int numNonFighterHits){
        this.numNonFighterHits+=numNonFighterHits;
    }

}
