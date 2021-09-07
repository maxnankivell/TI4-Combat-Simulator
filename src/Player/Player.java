package Player;

import Controllers.CombatType;
import Factions.*;
import GUIData.AttackerOptions;
import GUIData.DefenderOptions;
import GUIData.FactionEnum;
import Units.Unit;
import Units.UnitList;
import Units.UnitName;

import java.util.ArrayList;

public class Player {

    private UnitList unitList;
    private Faction faction;
    private PlayerRole role;
    private int numHits;
    private int numInfantryHits;
    private int numSustainDamageHits;
    private int numNonFighterHits;

    public Player(PlayerRole role) {
        this.role = role;
        populateFaction();
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
    }

    /**
     * populates a the faction field with the
     * user inputted faction
     */
    private void populateFaction(){
        FactionEnum inputFaction;
        if(role == PlayerRole.ATTACKER){
            inputFaction = AttackerOptions.getAttackerFactionCB();
        }else {
            inputFaction = DefenderOptions.getDefenderFactionCB();
        }

        faction = switch (inputFaction) {
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

    /**
     * populates unit arraylist with units
     * number of units got from options
     * units have factions specific values
     * @return UnitList with units
     */
    public UnitList populateUnitList() {
        UnitList units = new UnitList();
        int numFlagships, numWarsuns, numDreadnoughts, numCarriers, numCrusiers, numDestroyers, numFighters, numMechs, numInfantry, numPDSs;
        boolean isFlagshipUpgraded, isDreadnoughtUpgraded, isCarrierUpgraded, isCruiserUpgraded, isDestroyerUpgraded, isFighterUpgraded, isInfantryUpgraded, isPdsUpgraded;

        if(role == PlayerRole.ATTACKER){
            numFlagships = AttackerOptions.getAttackerFlagshipCB();
            numWarsuns = AttackerOptions.getAttackerWarSunCB();
            numDreadnoughts = AttackerOptions.getAttackerDreadnoughtCB();
            numCarriers = AttackerOptions.getAttackerCarrierCB();
            numCrusiers = AttackerOptions.getAttackerCruiserCB();
            numDestroyers = AttackerOptions.getAttackerDestroyerCB();
            numFighters = AttackerOptions.getAttackerFighterCB();
            numMechs = AttackerOptions.getAttackerMechCB();
            numInfantry = AttackerOptions.getAttackerInfantryCB();
            numPDSs = AttackerOptions.getAttackerPdsCB();
            isFlagshipUpgraded = AttackerOptions.isAttackerFlagshipCheckBox();
            isDreadnoughtUpgraded = AttackerOptions.isAttackerDreadnoughtCheckBox();
            isCarrierUpgraded = AttackerOptions.isAttackerCarrierCheckBox();
            isCruiserUpgraded = AttackerOptions.isAttackerCruiserCheckBox();
            isDestroyerUpgraded = AttackerOptions.isAttackerDestroyerCheckBox();
            isFighterUpgraded = AttackerOptions.isAttackerFighterCheckBox();
            isInfantryUpgraded = AttackerOptions.isAttackerInfantryCheckBox();
            isPdsUpgraded = AttackerOptions.isAttackerPdsCheckBox();
        }else {
            numFlagships = DefenderOptions.getDefenderFlagshipCB();
            numWarsuns = DefenderOptions.getDefenderWarSunCB();
            numDreadnoughts = DefenderOptions.getDefenderDreadnoughtCB();
            numCarriers = DefenderOptions.getDefenderCarrierCB();
            numCrusiers = DefenderOptions.getDefenderCruiserCB();
            numDestroyers = DefenderOptions.getDefenderDestroyerCB();
            numFighters = DefenderOptions.getDefenderFighterCB();
            numMechs = DefenderOptions.getDefenderMechCB();
            numInfantry = DefenderOptions.getDefenderInfantryCB();
            numPDSs = DefenderOptions.getDefenderPdsCB();
            isFlagshipUpgraded = DefenderOptions.isDefenderFlagshipCheckBox();
            isDreadnoughtUpgraded = DefenderOptions.isDefenderDreadnoughtCheckBox();
            isCarrierUpgraded = DefenderOptions.isDefenderCarrierCheckBox();
            isCruiserUpgraded = DefenderOptions.isDefenderCruiserCheckBox();
            isDestroyerUpgraded = DefenderOptions.isDefenderDestroyerCheckBox();
            isFighterUpgraded = DefenderOptions.isDefenderFighterCheckBox();
            isInfantryUpgraded = DefenderOptions.isDefenderInfantryCheckBox();
            isPdsUpgraded = DefenderOptions.isDefenderPdsCheckBox();
        }

        //flagship
        if (isFlagshipUpgraded && faction instanceof Nomad) {
            for (int i = 0; i < numFlagships; i++) {
                units.add(new Unit(faction.getFlagshipUpgrade()));
            }
        } else {
            for (int i = 0; i < numFlagships; i++) {
                units.add(new Unit(faction.getFlagship()));
            }
        }

        //warsuns
        for (int i = 0; i < numWarsuns; i++) {
            units.add(new Unit(faction.getWarsun()));
        }

        //dreadnought
        if (isDreadnoughtUpgraded) {
            for (int i = 0; i < numDreadnoughts; i++) {
                units.add(new Unit(faction.getDreadnoughtUpgrade()));
            }
        } else {
            for (int i = 0; i < numDreadnoughts; i++) {
                units.add(new Unit(faction.getDreadnought()));
            }
        }

        //carrier
        if (isCarrierUpgraded) {
            for (int i = 0; i < numCarriers; i++) {
                units.add(new Unit(faction.getCarrierUpgrade()));
            }
        } else {
            for (int i = 0; i < numCarriers; i++) {
                units.add(new Unit(faction.getCarrier()));
            }
        }

        //crusier
        if (isCruiserUpgraded) {
            for (int i = 0; i < numCrusiers; i++) {
                units.add(new Unit(faction.getCruiserUpgrade()));
            }
        } else {
            for (int i = 0; i < numCrusiers; i++) {
                units.add(new Unit(faction.getCruiser()));
            }
        }

        //destroyer
        if (isDestroyerUpgraded) {
            for (int i = 0; i < numDestroyers; i++) {
                units.add(new Unit(faction.getDestroyerUpgrade()));
            }
        } else {
            for (int i = 0; i < numDestroyers; i++) {
                units.add(new Unit(faction.getDestroyer()));
            }
        }

        //fighter
        if (isFighterUpgraded) {
            for (int i = 0; i < numFighters; i++) {
                units.add(new Unit(faction.getFighterUpgrade()));
            }
        } else {
            for (int i = 0; i < numFighters; i++) {
                units.add(new Unit(faction.getFighter()));
            }
        }

        //mech
        for (int i = 0; i < numMechs; i++) {
            units.add(new Unit(faction.getMech()));
        }

        //infantry
        if (isInfantryUpgraded) {
            for (int i = 0; i < numInfantry; i++) {
                units.add(new Unit(faction.getInfantryUpgrade()));
            }
        } else {
            for (int i = 0; i < numInfantry; i++) {
                units.add(new Unit(faction.getInfantry()));
            }
        }

        //pds
        if (isPdsUpgraded) {
            for (int i = 0; i < numPDSs; i++) {
                units.add(new Unit(faction.getPdsUpgrade()));
            }
        } else {
            for (int i = 0; i < numPDSs; i++) {
                units.add(new Unit(faction.getPds()));
            }
        }

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
            if (unit.getName()==UnitName.PDS || unit.getName()==UnitName.PDSUPGRADE){
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
     * @param unitNameUpgraded name of upgraded unit
     */
    public void addDiceToSpecificUnitType(CombatType combatType, UnitName unitName, UnitName unitNameUpgraded){
        switch (combatType){
            case AFB:
                for (Unit unit: unitList.getUnitArrayList()){
                    if((unit.getName() == unitName || unit.getName() == unitNameUpgraded) && unit.getNumDiceRollsAFB()!=0){
                        unit.setNumDiceRollsAFB(unit.getNumDiceRollsAFB()+1);
                    }
                }
                break;
            case BOMBARDMENT:
                for (Unit unit: unitList.getUnitArrayList()){
                    if((unit.getName() == unitName || unit.getName() == unitNameUpgraded) && unit.getNumDiceRollsBombardment()!=0){
                        unit.setNumDiceRollsBombardment(unit.getNumDiceRollsBombardment()+1);
                    }
                }
                break;
            case SPACECANNON:
                for (Unit unit: unitList.getUnitArrayList()){
                    if((unit.getName() == unitName || unit.getName() == unitNameUpgraded) && unit.getNumDiceRollsSpaceCannon()!=0){
                        unit.setNumDiceRollsSpaceCannon(unit.getNumDiceRollsSpaceCannon()+1);
                    }
                }
                break;
            case SPACECOMBAT:
                for (Unit unit: unitList.getUnitArrayList()){
                    if((unit.getName() == unitName || unit.getName() == unitNameUpgraded) && unit.getNumDiceRollsSpaceCombat()!=0){
                        unit.setNumDiceRollsSpaceCombat(unit.getNumDiceRollsSpaceCombat()+1);
                    }
                }
                break;
            case GROUNDCOMBAT:
                for (Unit unit: unitList.getUnitArrayList()){
                    if((unit.getName() == unitName || unit.getName() == unitNameUpgraded) && unit.getNumDiceRollsGroundCombat()!=0){
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
     * @param unitNameUpgraded name of upgraded unit
     */
    public void changeHitValueOfAllUnitsOfSpecificType(CombatType combatType, int addAmount, UnitName unitName, UnitName unitNameUpgraded){
        switch (combatType){
            case AFB:
                for (Unit unit: unitList.getUnitArrayList()){
                    if((unit.getName() == unitName || unit.getName() == unitNameUpgraded) && unit.getHitValueAFB()!=0){
                        unit.setHitValueAFB(unit.getHitValueAFB()+addAmount);
                    }
                }
                break;
            case BOMBARDMENT:
                for (Unit unit: unitList.getUnitArrayList()){
                    if((unit.getName() == unitName || unit.getName() == unitNameUpgraded) && unit.getHitValueBombardment()!=0){
                        unit.setHitValueBombardment(unit.getHitValueBombardment()+addAmount);
                    }
                }
                break;
            case SPACECANNON:
                for (Unit unit: unitList.getUnitArrayList()){
                    if((unit.getName() == unitName || unit.getName() == unitNameUpgraded) && unit.getHitValueSpaceCannon()!=0){
                        unit.setHitValueSpaceCannon(unit.getHitValueSpaceCannon()+addAmount);
                    }
                }
                break;
            case SPACECOMBAT:
                for (Unit unit: unitList.getUnitArrayList()){
                    if((unit.getName() == unitName || unit.getName() == unitNameUpgraded) && unit.getHitValueSpaceCombat()!=0){
                        unit.setHitValueSpaceCombat(unit.getHitValueSpaceCombat()+addAmount);
                    }
                }
                break;
            case GROUNDCOMBAT:
                for (Unit unit: unitList.getUnitArrayList()){
                    if((unit.getName() == unitName || unit.getName() == unitNameUpgraded) && unit.getHitValueGroundCombat()!=0){
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
