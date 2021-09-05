package Controllers;

import Factions.*;
import GUIData.AttackerOptions;
import GUIData.DefenderOptions;
import Units.Unit;

import java.io.IOError;
import java.io.IOException;
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

        switch (AttackerOptions.getAttackerFactionCB()){
            case ARBOREC:
                faction = new Arborec();
                break;
            case ARGENTFLIGHT:
                faction = new ArgentFlight();
                break;
            case BARONYOFLETNEV:
                faction = new BaronyOfLetnev();
                break;
            case CLANOFSAAR:
                faction = new ClanOfSaar();
                break;
            case CREUSS:
                faction = new Creuss();
                break;
            case EMPYREAN:
                faction = new Empyrean();
                break;
            case HACAN:
                faction = new Hacan();
                break;
            case JOLNAR:
                faction = new JolNar();
                break;
            case L1Z1X:
                faction = new L1Z1X();
                break;
            case MAHACT:
                faction = new Mahact();
                break;
            case MUAAT:
                faction = new Muaat();
                break;
            case MENTAK:
                faction = new Mentak();
                break;
            case NAALU:
                faction = new Naalu();
                break;
            case NAAZROKHA:
                faction = new NaazRokha();
                break;
            case NEKRO:
                faction = new Nekro();
                break;
            case NOMAD:
                faction = new Nomad();
                break;
            case SARDAKKNORR:
                faction = new SardakkNorr();
                break;
            case SOL:
                faction = new Sol();
                break;
            case TITANSOFUL:
                faction = new TitansOfUl();
                break;
            case VUILRAITH:
                faction = new VuilRaith();
                break;
            case WINNU:
                faction = new Winnu();
                break;
            case XXCHA:
                faction = new Xxcha();
                break;
            case YIN:
                faction = new Yin();
                break;
            case YSSARIL:
                faction = new Yssaril();
                break;
            default:
                throw (Throwable) IOException;
        }

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

        switch (DefenderOptions.getDefenderFactionCB()) {
            case ARBOREC:
                faction = new Arborec();
                break;
            case ARGENTFLIGHT:
                faction = new ArgentFlight();
                break;
            case BARONYOFLETNEV:
                faction = new BaronyOfLetnev();
                break;
            case CLANOFSAAR:
                faction = new ClanOfSaar();
                break;
            case CREUSS:
                faction = new Creuss();
                break;
            case EMPYREAN:
                faction = new Empyrean();
                break;
            case HACAN:
                faction = new Hacan();
                break;
            case JOLNAR:
                faction = new JolNar();
                break;
            case L1Z1X:
                faction = new L1Z1X();
                break;
            case MAHACT:
                faction = new Mahact();
                break;
            case MUAAT:
                faction = new Muaat();
                break;
            case MENTAK:
                faction = new Mentak();
                break;
            case NAALU:
                faction = new Naalu();
                break;
            case NAAZROKHA:
                faction = new NaazRokha();
                break;
            case NEKRO:
                faction = new Nekro();
                break;
            case NOMAD:
                faction = new Nomad();
                break;
            case SARDAKKNORR:
                faction = new SardakkNorr();
                break;
            case SOL:
                faction = new Sol();
                break;
            case TITANSOFUL:
                faction = new TitansOfUl();
                break;
            case VUILRAITH:
                faction = new VuilRaith();
                break;
            case WINNU:
                faction = new Winnu();
                break;
            case XXCHA:
                faction = new Xxcha();
                break;
            case YIN:
                faction = new Yin();
                break;
            case YSSARIL:
                faction = new Yssaril();
                break;
            default:
                throw (Throwable) IOException;
        }

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

    public abstract void startProcess();
}
