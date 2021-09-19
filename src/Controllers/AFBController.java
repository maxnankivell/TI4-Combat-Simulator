package Controllers;

import Factions.FactionEnum;
import GUI.OptionData;
import Player.*;
import Units.UnitName;

public class AFBController extends Controller{

    public AFBController(){
        super();
    }

    /**
     * method to run through the AFB process
     */
    @Override
    public void startProcess() {
        preRollChecks(attacker);
        preRollChecks(defender);

        Roller attackerRoller = new Roller(attacker, CombatType.AFB);
        attackerRoller.mainProcess();
        Roller defenderRoller = new Roller(defender, CombatType.AFB);
        defenderRoller.mainProcess();

        postRollChecks(attacker, defender);
        postRollChecks(defender, attacker);
    }

    /**
     * Method to run through all pre-combat modifiers
     */
    public void preRollChecks(Player currentPlayer){

        checkForStrikeWingAmbush(currentPlayer);
        checkForArgentFlightCommander(currentPlayer);
    }

    /**
     * Method to run through all post-combat modifiers
     */
    private void postRollChecks(Player currentPlayer, Player otherPlayer) {

        checkForRaidFormation(currentPlayer, otherPlayer);
    }

    private void checkForStrikeWingAmbush(Player currentPlayer) {
        if (currentPlayer.getOptionData().get(OptionData.STRIKEWINGAMBUSH))
            currentPlayer.addOneDiceToBestUnit(CombatType.AFB);
    }

    private void checkForArgentFlightCommander(Player currentPlayer) {
        if (currentPlayer.getOptionData().get(OptionData.ARGENTFLIGHTCOMMANDER))
            currentPlayer.addOneDiceToBestUnit(CombatType.AFB);
    }

    private void checkForRaidFormation(Player currentPlayer, Player otherPlayer) {
        if(currentPlayer.getFactionEnum() == FactionEnum.ARGENTFLIGHT) {
            if(currentPlayer.getNumHits() > (otherPlayer.getUnitList().numberOfType(UnitName.FIGHTER))) {
                currentPlayer.addNumSustainDamageHits((currentPlayer.getNumHits() - (otherPlayer.getUnitList().numberOfType(UnitName.FIGHTER))));
            }
        }
    }
}
