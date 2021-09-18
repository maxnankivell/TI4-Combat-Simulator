package Controllers;

import Factions.ArgentFlight;
import GUI.OptionData;
import Player.*;

public class AFBController extends Controller{

    public AFBController(){
        super();
    }

    /**
     * method to run through the AFB process
     */
    @Override
    public void startProcess() {
        preProcess(attacker);
        preProcess(defender);

        Roller attackerRoller = new Roller(attacker, CombatType.AFB);
        attackerRoller.mainProcess();
        Roller defenderRoller = new Roller(defender, CombatType.AFB);
        defenderRoller.mainProcess();

        postProcess(attacker, defender);
        postProcess(defender, attacker);
    }

    /**
     * Method to run through all pre-combat modifiers
     */
    public void preProcess(Player currentPlayer){
        //Argent Flight Promissory note
        if (currentPlayer.getOptionData().get(OptionData.STRIKEWINGAMBUSH)) {
            currentPlayer.addOneDiceToBestUnit(CombatType.AFB);
        }
        //Argent Flight commander
        if (currentPlayer.getOptionData().get(OptionData.ARGENTFLIGHTCOMMANDER)) {
            currentPlayer.addOneDiceToBestUnit(CombatType.AFB);
        }
    }

    /**
     * Method to run through all post-combat modifiers
     */
    private void postProcess(Player currentPlayer, Player otherPlayer) {
        //Argent Flight faction ability
        if(currentPlayer.getFaction() instanceof ArgentFlight) {
            ArgentFlight.raidFormation(currentPlayer, otherPlayer);
        }
    }
}
