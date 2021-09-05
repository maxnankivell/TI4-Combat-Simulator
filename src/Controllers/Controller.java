package Controllers;

import Factions.*;
import GUIData.AttackerOptions;
import Units.Unit;

import java.util.ArrayList;

public abstract class Controller {
    protected ArrayList<Unit> defender;
    protected ArrayList<Unit> attacker;
    protected int numHitsAttacker;
    protected int numHitsDefender;

    public Controller(){
        this.attacker = populateAttacker();
        this.defender = populateDefender();

        startProcess();
    }

    public ArrayList<Unit> populateAttacker(){
        ArrayList<Unit> units = new ArrayList<Unit>();
        Faction faction;
        int numFlagships = AttackerOptions.getAttackerFlagshipCB();
        int numWarsuns = AttackerOptions.getAttackerWarSunCB();
        int numDreadnought = AttackerOptions.getAttackerDreadnoughtCB();
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
        }



        return null;
    }

    public ArrayList<Unit> populateDefender(){
        ArrayList<Unit> units = new ArrayList<Unit>();




        return null;
    }

    public abstract void startProcess();

    public int hitCalculator(boolean isAttacker){
        int numHits = 0;
        int diceValue;

        //for each ship type
        //for each ship player has of that ship
//        diceValue = rollDice();
//        if(isAttacker) {
//            if (attacker.doesItHit(shipType, diceValue)) {
//                numHits++;
//            }
//        } else {
//            if (attacker.doesItHit(shipType, diceValue)) {
//                numHits++;
//            }
//        }
        return numHits;
    }

    public int rollDice(){return -1;}

    public int getNumHitsAttacker() {
        return numHitsAttacker;
    }

    public int getNumHitsDefender() {
        return numHitsDefender;
    }
}
