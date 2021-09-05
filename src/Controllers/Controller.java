package Controllers;

import Factions.*;
import GUIData.AttackerOptions;
import GUIData.DefenderOptions;
import Units.Unit;

import java.util.ArrayList;

public abstract class Controller {
    protected ArrayList<Unit> defender;
    protected ArrayList<Unit> attacker;
    protected int numHitsAttacker;
    protected int numHitsDefender;
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

    public ArrayList<Unit> populateAttacker() throws Throwable {
        ArrayList<Unit> units = new ArrayList<Unit>();
        Faction faction;
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

        faction = switch (AttackerOptions.getAttackerFactionCB()) {
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
        if (AttackerOptions.isAttackerFlagshipCheckBox() && faction instanceof Nomad){
            for(int i=0; i<numFlagships; i++){
                units.add(new Unit(faction.getFlagshipUpgrade()));
            }
        } else{
            for(int i=0; i<numFlagships; i++){
                units.add(new Unit(faction.getFlagship()));
            }
        }

        //warsuns
        for(int i=0; i<numWarsuns; i++){
            units.add(new Unit(faction.getWarsun()));
        }

        //dreadnought
        if (AttackerOptions.isAttackerDreadnoughtCheckBox()){
            for(int i=0; i<numDreadnoughts; i++){
                units.add(new Unit(faction.getDreadnoughtUpgrade()));
            }
        } else{
            for(int i=0; i<numDreadnoughts; i++){
                units.add(new Unit(faction.getDreadnought()));
            }
        }

        //carrier
        if (AttackerOptions.isAttackerCarrierCheckBox()){
            for(int i=0; i<numCarriers; i++){
                units.add(new Unit(faction.getCarrierUpgrade()));
            }
        } else{
            for(int i=0; i<numCarriers; i++){
                units.add(new Unit(faction.getCarrier()));
            }
        }

        //crusier
        if (AttackerOptions.isAttackerCruiserCheckBox()){
            for(int i=0; i<numCrusiers; i++){
                units.add(new Unit(faction.getCruiserUpgrade()));
            }
        } else{
            for(int i=0; i<numCrusiers; i++){
                units.add(new Unit(faction.getCruiser()));
            }
        }

        //destroyer
        if (AttackerOptions.isAttackerDestroyerCheckBox()){
            for(int i=0; i<numDestroyers; i++){
                units.add(new Unit(faction.getDestroyerUpgrade()));
            }
        } else{
            for(int i=0; i<numDestroyers; i++){
                units.add(new Unit(faction.getDestroyer()));
            }
        }

        //fighter
        if (AttackerOptions.isAttackerFighterCheckBox()){
            for(int i=0; i<numFighters; i++){
                units.add(new Unit(faction.getFighterUpgrade()));
            }
        } else{
            for(int i=0; i<numFighters; i++){
                units.add(new Unit(faction.getFighter()));
            }
        }

        //mech
        for(int i=0; i<numMechs; i++){
            units.add(new Unit(faction.getMech()));
        }

        //infantry
        if (AttackerOptions.isAttackerInfantryCheckBox()){
            for(int i=0; i<numInfantry; i++){
                units.add(new Unit(faction.getInfantryUpgrade()));
            }
        } else{
            for(int i=0; i<numInfantry; i++){
                units.add(new Unit(faction.getInfantry()));
            }
        }

        //pds
        if (AttackerOptions.isAttackerPdsCheckBox()){
            for(int i=0; i<numPDSs; i++){
                units.add(new Unit(faction.getPdsUpgrade()));
            }
        } else{
            for(int i=0; i<numPDSs; i++){
                units.add(new Unit(faction.getPds()));
            }
        }

        return units;
    }

    public ArrayList<Unit> populateDefender() throws Throwable {
        ArrayList<Unit> units = new ArrayList<Unit>();
        Faction faction;
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

        faction = switch (DefenderOptions.getDefenderFactionCB()) {
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
        if (DefenderOptions.isDefenderFlagshipCheckBox() && faction instanceof Nomad) {
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
        if (DefenderOptions.isDefenderDreadnoughtCheckBox()) {
            for (int i = 0; i < numDreadnoughts; i++) {
                units.add(new Unit(faction.getDreadnoughtUpgrade()));
            }
        } else {
            for (int i = 0; i < numDreadnoughts; i++) {
                units.add(new Unit(faction.getDreadnought()));
            }
        }

        //carrier
        if (DefenderOptions.isDefenderCarrierCheckBox()) {
            for (int i = 0; i < numCarriers; i++) {
                units.add(new Unit(faction.getCarrierUpgrade()));
            }
        } else {
            for (int i = 0; i < numCarriers; i++) {
                units.add(new Unit(faction.getCarrier()));
            }
        }

        //crusier
        if (DefenderOptions.isDefenderCruiserCheckBox()) {
            for (int i = 0; i < numCrusiers; i++) {
                units.add(new Unit(faction.getCruiserUpgrade()));
            }
        } else {
            for (int i = 0; i < numCrusiers; i++) {
                units.add(new Unit(faction.getCruiser()));
            }
        }

        //destroyer
        if (DefenderOptions.isDefenderDestroyerCheckBox()) {
            for (int i = 0; i < numDestroyers; i++) {
                units.add(new Unit(faction.getDestroyerUpgrade()));
            }
        } else {
            for (int i = 0; i < numDestroyers; i++) {
                units.add(new Unit(faction.getDestroyer()));
            }
        }

        //fighter
        if (DefenderOptions.isDefenderFighterCheckBox()) {
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
        if (DefenderOptions.isDefenderInfantryCheckBox()) {
            for (int i = 0; i < numInfantry; i++) {
                units.add(new Unit(faction.getInfantryUpgrade()));
            }
        } else {
            for (int i = 0; i < numInfantry; i++) {
                units.add(new Unit(faction.getInfantry()));
            }
        }

        //pds
        if (DefenderOptions.isDefenderPdsCheckBox()) {
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

    public int diceRoll(){
        return (int) Math.floor(Math.random()*10)+1;
    }

    public abstract void startProcess();
}
