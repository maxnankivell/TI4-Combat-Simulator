package Controllers;

import Factions.*;
import GUIData.AttackerOptions;
import GUIData.DefenderOptions;
import Units.Unit;
import Units.UnitList;
import Units.UnitName;

import java.util.ArrayList;

public abstract class Controller {
    protected UnitList defender;
    protected UnitList attacker;
    protected Faction attackersFaction;
    protected Faction defendersFaction;
    protected int numHitsAttacker;
    protected int numHitsDefender;
    protected int numInfantryHitsAttacker;
    protected int numInfantryHitsDefender;
    protected int numSustainDamageHitsAttacker;
    protected int numSustainDamageHitsDefender;
    protected int numNonFighterHitsAttacker;
    protected int numNonFighterHitsDefender;
    private Object IOException;

    public Controller(){
        try {
            this.attacker = populateAttacker();
            this.defender = populateDefender();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }

        startProcess();
    }

    public abstract void startProcess();

    /**
     * populates attackers arraylist with units
     * number of units got from attacker options
     * units have factions specific values
     * @return arraylist with attackers units
     */
    public UnitList populateAttacker() {
        UnitList units = new UnitList();
        int numFlagships = AttackerOptions.getAttackerFlagshipCB();
        int numWarsuns = AttackerOptions.getAttackerWarSunCB();
        int numDreadnoughts = AttackerOptions.getAttackerDreadnoughtCB();
        int numCarriers = AttackerOptions.getAttackerCarrierCB();
        int numCrusiers = AttackerOptions.getAttackerCruiserCB();
        int numDestroyers = AttackerOptions.getAttackerDestroyerCB();
        int numFighters = AttackerOptions.getAttackerFighterCB();
        int numMechs = AttackerOptions.getAttackerMechCB();
        int numInfantry = AttackerOptions.getAttackerInfantryCB();
        int numPDSs = AttackerOptions.getAttackerPdsCB();

        attackersFaction = switch (AttackerOptions.getAttackerFactionCB()) {
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

        //flagship
        if (AttackerOptions.isAttackerFlagshipCheckBox() && attackersFaction instanceof Nomad){
            for(int i=0; i<numFlagships; i++){
                units.add(new Unit(attackersFaction.getFlagshipUpgrade()));
            }
        } else{
            for(int i=0; i<numFlagships; i++){
                units.add(new Unit(attackersFaction.getFlagship()));
            }
        }

        //warsuns
        for(int i=0; i<numWarsuns; i++){
            units.add(new Unit(attackersFaction.getWarsun()));
        }

        //dreadnought
        if (AttackerOptions.isAttackerDreadnoughtCheckBox()){
            for(int i=0; i<numDreadnoughts; i++){
                units.add(new Unit(attackersFaction.getDreadnoughtUpgrade()));
            }
        } else{
            for(int i=0; i<numDreadnoughts; i++){
                units.add(new Unit(attackersFaction.getDreadnought()));
            }
        }

        //carrier
        if (AttackerOptions.isAttackerCarrierCheckBox()){
            for(int i=0; i<numCarriers; i++){
                units.add(new Unit(attackersFaction.getCarrierUpgrade()));
            }
        } else{
            for(int i=0; i<numCarriers; i++){
                units.add(new Unit(attackersFaction.getCarrier()));
            }
        }

        //crusier
        if (AttackerOptions.isAttackerCruiserCheckBox()){
            for(int i=0; i<numCrusiers; i++){
                units.add(new Unit(attackersFaction.getCruiserUpgrade()));
            }
        } else{
            for(int i=0; i<numCrusiers; i++){
                units.add(new Unit(attackersFaction.getCruiser()));
            }
        }

        //destroyer
        if (AttackerOptions.isAttackerDestroyerCheckBox()){
            for(int i=0; i<numDestroyers; i++){
                units.add(new Unit(attackersFaction.getDestroyerUpgrade()));
            }
        } else{
            for(int i=0; i<numDestroyers; i++){
                units.add(new Unit(attackersFaction.getDestroyer()));
            }
        }

        //fighter
        if (AttackerOptions.isAttackerFighterCheckBox()){
            for(int i=0; i<numFighters; i++){
                units.add(new Unit(attackersFaction.getFighterUpgrade()));
            }
        } else{
            for(int i=0; i<numFighters; i++){
                units.add(new Unit(attackersFaction.getFighter()));
            }
        }

        //mech
        for(int i=0; i<numMechs; i++){
            units.add(new Unit(attackersFaction.getMech()));
        }

        //infantry
        if (AttackerOptions.isAttackerInfantryCheckBox()){
            for(int i=0; i<numInfantry; i++){
                units.add(new Unit(attackersFaction.getInfantryUpgrade()));
            }
        } else{
            for(int i=0; i<numInfantry; i++){
                units.add(new Unit(attackersFaction.getInfantry()));
            }
        }

        //pds
        if (AttackerOptions.isAttackerPdsCheckBox()){
            for(int i=0; i<numPDSs; i++){
                units.add(new Unit(attackersFaction.getPdsUpgrade()));
            }
        } else{
            for(int i=0; i<numPDSs; i++){
                units.add(new Unit(attackersFaction.getPds()));
            }
        }

        return units;
    }

    /**
     * populates defenders arraylist with units
     * number of units got from defender options
     * units have factions specific values
     * @return arraylist with defenders units
     */
    public UnitList populateDefender() {
        UnitList units = new UnitList();
        int numFlagships = DefenderOptions.getDefenderFlagshipCB();
        int numWarsuns = DefenderOptions.getDefenderWarSunCB();
        int numDreadnoughts = DefenderOptions.getDefenderDreadnoughtCB();
        int numCarriers = DefenderOptions.getDefenderCarrierCB();
        int numCrusiers = DefenderOptions.getDefenderCruiserCB();
        int numDestroyers = DefenderOptions.getDefenderDestroyerCB();
        int numFighters = DefenderOptions.getDefenderFighterCB();
        int numMechs = DefenderOptions.getDefenderMechCB();
        int numInfantry = DefenderOptions.getDefenderInfantryCB();
        int numPDSs = DefenderOptions.getDefenderPdsCB();

        defendersFaction = switch (DefenderOptions.getDefenderFactionCB()) {
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

        //flagship
        if (DefenderOptions.isDefenderFlagshipCheckBox() && defendersFaction instanceof Nomad) {
            for (int i = 0; i < numFlagships; i++) {
                units.add(new Unit(defendersFaction.getFlagshipUpgrade()));
            }
        } else {
            for (int i = 0; i < numFlagships; i++) {
                units.add(new Unit(defendersFaction.getFlagship()));
            }
        }

        //warsuns
        for (int i = 0; i < numWarsuns; i++) {
            units.add(new Unit(defendersFaction.getWarsun()));
        }

        //dreadnought
        if (DefenderOptions.isDefenderDreadnoughtCheckBox()) {
            for (int i = 0; i < numDreadnoughts; i++) {
                units.add(new Unit(defendersFaction.getDreadnoughtUpgrade()));
            }
        } else {
            for (int i = 0; i < numDreadnoughts; i++) {
                units.add(new Unit(defendersFaction.getDreadnought()));
            }
        }

        //carrier
        if (DefenderOptions.isDefenderCarrierCheckBox()) {
            for (int i = 0; i < numCarriers; i++) {
                units.add(new Unit(defendersFaction.getCarrierUpgrade()));
            }
        } else {
            for (int i = 0; i < numCarriers; i++) {
                units.add(new Unit(defendersFaction.getCarrier()));
            }
        }

        //crusier
        if (DefenderOptions.isDefenderCruiserCheckBox()) {
            for (int i = 0; i < numCrusiers; i++) {
                units.add(new Unit(defendersFaction.getCruiserUpgrade()));
            }
        } else {
            for (int i = 0; i < numCrusiers; i++) {
                units.add(new Unit(defendersFaction.getCruiser()));
            }
        }

        //destroyer
        if (DefenderOptions.isDefenderDestroyerCheckBox()) {
            for (int i = 0; i < numDestroyers; i++) {
                units.add(new Unit(defendersFaction.getDestroyerUpgrade()));
            }
        } else {
            for (int i = 0; i < numDestroyers; i++) {
                units.add(new Unit(defendersFaction.getDestroyer()));
            }
        }

        //fighter
        if (DefenderOptions.isDefenderFighterCheckBox()) {
            for (int i = 0; i < numFighters; i++) {
                units.add(new Unit(defendersFaction.getFighterUpgrade()));
            }
        } else {
            for (int i = 0; i < numFighters; i++) {
                units.add(new Unit(defendersFaction.getFighter()));
            }
        }

        //mech
        for (int i = 0; i < numMechs; i++) {
            units.add(new Unit(defendersFaction.getMech()));
        }

        //infantry
        if (DefenderOptions.isDefenderInfantryCheckBox()) {
            for (int i = 0; i < numInfantry; i++) {
                units.add(new Unit(defendersFaction.getInfantryUpgrade()));
            }
        } else {
            for (int i = 0; i < numInfantry; i++) {
                units.add(new Unit(defendersFaction.getInfantry()));
            }
        }

        //pds
        if (DefenderOptions.isDefenderPdsCheckBox()) {
            for (int i = 0; i < numPDSs; i++) {
                units.add(new Unit(defendersFaction.getPdsUpgrade()));
            }
        } else {
            for (int i = 0; i < numPDSs; i++) {
                units.add(new Unit(defendersFaction.getPds()));
            }
        }

        return units;
    }

    /**
     * adds the titans hero unit to the players list of units
     * @param player list of units
     */
    public void addUnitTitansHero(UnitList player){
        player.add(new Unit.Builder(UnitName.OTHER)
                .addSpaceCannonValue(5,3)
                .build());
    }

    /**
     * gets random number from 1 to 10
     * @return random number from 1 to 10
     */
    public int diceRoll(){
        return (int) Math.floor(Math.random()*10)+1;
    }

    /**
     * Rerolls all dice that are currently missing for a unit given this type of combat
     * @param combatType the current type of combat
     * @param diceRolls the list of dice rolls of which the missed dice will be rerolled
     * @param unit the unit whose dice are being rerolled
     */
    public ArrayList<Integer> reRollMissedDice(CombatType combatType, ArrayList<Integer> diceRolls, Unit unit) {
        switch (combatType){
            case AFB:
                for (int i = 0; i < diceRolls.size(); i++) {
                    if(diceRolls.get(i) < unit.getHitValueAFB()){
                        diceRolls.set(i, diceRoll());
                    }
                }
                break;
            case BOMBARDMENT:
                for (int i = 0; i < diceRolls.size(); i++) {
                    if(diceRolls.get(i) < unit.getHitValueBombardment()){
                        diceRolls.set(i, diceRoll());
                    }
                }
                break;
            case SPACECANNON:
                for (int i = 0; i < diceRolls.size(); i++) {
                    if(diceRolls.get(i) < unit.getHitValueSpaceCannon()){
                        diceRolls.set(i, diceRoll());
                    }
                }
                break;
            case SPACECOMBAT:
                for (int i = 0; i < diceRolls.size(); i++) {
                    if(diceRolls.get(i) < unit.getHitValueSpaceCombat()){
                        diceRolls.set(i, diceRoll());
                    }
                }
                break;
            case GROUNDCOMBAT:
                for (int i = 0; i < diceRolls.size(); i++) {
                    if(diceRolls.get(i) < unit.getHitValueGroundCombat()){
                        diceRolls.set(i, diceRoll());
                    }
                }
                break;
        }
        return  diceRolls;
    }

    public int getNumHitsAttacker() {
        return numHitsAttacker;
    }

    public int getNumHitsDefender() {
        return numHitsDefender;
    }

    public int getNumInfantryHitsAttacker() {
        return numInfantryHitsAttacker;
    }

    public int getNumInfantryHitsDefender() {
        return numInfantryHitsDefender;
    }

    public int getNumSustainDamageHitsAttacker() {
        return numSustainDamageHitsAttacker;
    }

    public int getNumSustainDamageHitsDefender() {
        return numSustainDamageHitsDefender;
    }

    public int getNumNonFighterHitsAttacker() {
        return numNonFighterHitsAttacker;
    }

    public int getNumNonFighterHitsDefender() {
        return numNonFighterHitsDefender;
    }
}
