package Controllers;

import Factions.ArgentFlight;
import GUI.OptionData;
import Player.*;
import Units.Unit;
import Units.UnitName;

import java.util.ArrayList;

public class SpaceCannonOffenseController extends Controller{

    public SpaceCannonOffenseController(){
        super();
    }

    @Override
    public void startProcess() {
        boolean defenderCancelled = preProcess(attacker, defender);
        boolean attackerCancelled = preProcess(defender, attacker);

        if (!attackerCancelled) mainProcess(attacker);
        if (!defenderCancelled) mainProcess(defender);
    }

    /**
     * Method to run through all pre-combat modifiers for the attacker
     */
    public boolean preProcess(Player currentPlayer, Player otherPlayer){

        if (currentPlayer.getRole() == PlayerRole.DEFENDER){
            //Experimental battlestation
            if (currentPlayer.getOptionData().get(OptionData.EXPERIMENTALBATTLESTATION))
                currentPlayer.addUnitExperimentalBattlestation();

            //Titans Hero
            if (currentPlayer.getOptionData().get(OptionData.TITANSHERO))
                currentPlayer.addUnitTitansHero();
        }

        //Plasma scoring
        if (currentPlayer.getOptionData().get(OptionData.PLASMASCORING))
            currentPlayer.addOneDiceToBestUnit(CombatType.SPACECANNON);

        //Antimass deflector
        if (currentPlayer.getOptionData().get(OptionData.ANTIMASSDEFLECTOR))
            otherPlayer.changeHitValueOfAllUnits(CombatType.SPACECANNON, 1);

        //Strike wing ambuscade
        if (currentPlayer.getOptionData().get(OptionData.STRIKEWINGAMBUSH))
            currentPlayer.addOneDiceToBestUnit(CombatType.SPACECANNON);

        //Argent flight commander
        if (currentPlayer.getOptionData().get(OptionData.ARGENTFLIGHTCOMMANDER))
            currentPlayer.addOneDiceToBestUnit(CombatType.SPACECANNON);

        if (currentPlayer.getRole() == PlayerRole.ATTACKER) {
            //Solar flare
            if (currentPlayer.getOptionData().get(OptionData.SOLARFLAIR))
                return true;
        }

        //Argent flight flagship
        if (attacker.getFaction() instanceof ArgentFlight && attacker.getUnitList().containsName(UnitName.FLAGSHIP))
            return true;

        return false;
    }

    /**
     * Method to run through the main combat process
     */
    public void mainProcess(Player currentPlayer){
        //start rolling
        for (Unit unit : currentPlayer.getUnitArrayList()) {
            ArrayList<Integer> diceRolls = new ArrayList<>();

            //roll amount of dice necessary for one unit
            for (int i = 0; i < unit.getNumDiceRollsSpaceCannon(); i++) {
                diceRolls.add(Roller.diceRoll());
            }

            //Check re-roll conditions
            //Jol Nar commander
            if (currentPlayer.getOptionData().get(OptionData.JOLNARCOMMANDER)) {
                Roller.reRollMissedDice(CombatType.SPACECANNON, diceRolls, unit);
            }

            //Check number of hits from this unit
            for (Integer roll : diceRolls) {
                if (roll >= unit.getHitValueSpaceCannon()) {
                    currentPlayer.addNumHits(1);
                }
            }
        }
    }

}
