package Controllers;

import Factions.ArgentFlight;
import GUI.OptionData;
import Player.*;
import Units.UnitName;

public class SpaceCannonOffenseController extends Controller{

    boolean defenderCancelled = false;
    boolean attackerCancelled = false;

    public SpaceCannonOffenseController(){
        super();
    }

    @Override
    public void startProcess() {
        preRollChecks(attacker, defender);
        preRollChecks(defender, attacker);

        if (!attackerCancelled) {
            Roller attackerRoller = new Roller(attacker, CombatType.SPACECANNON);
            attackerRoller.mainProcess();
        }
        if (!defenderCancelled) {
            Roller defenderRoller = new Roller(defender, CombatType.SPACECANNON);
            defenderRoller.mainProcess();
        }

    }

    /**
     * Method to run through all pre-combat modifiers for the attacker
     */
    public void preRollChecks(Player currentPlayer, Player otherPlayer) {
        
        checkForExperimentalBattlestation(currentPlayer);
        checkForTitansHero(currentPlayer);
        checkForPlasmaScoring(currentPlayer);
        checkForAntimassDeflector(currentPlayer, otherPlayer);
        checkForStrikeWingAmbush(currentPlayer);
        checkForArgentFlightCommander(currentPlayer);
        checkForSolarFlare(currentPlayer);
        checkForArgentFlightFlagship(currentPlayer);

    }

    private void checkForExperimentalBattlestation(Player currentPlayer) {
        if (currentPlayer.getOptionData().get(OptionData.EXPERIMENTALBATTLESTATION) && currentPlayer.getRole() == PlayerRole.DEFENDER)
            currentPlayer.addUnitExperimentalBattlestation();
    }

    private void checkForTitansHero(Player currentPlayer) {
        if (currentPlayer.getOptionData().get(OptionData.TITANSHERO) && currentPlayer.getRole() == PlayerRole.DEFENDER)
            currentPlayer.addUnitTitansHero();
    }

    private void checkForPlasmaScoring(Player currentPlayer) {
        if (currentPlayer.getOptionData().get(OptionData.PLASMASCORING))
            currentPlayer.addOneDiceToBestUnit(CombatType.SPACECANNON);
    }

    private void checkForAntimassDeflector(Player currentPlayer, Player otherPlayer) {
        if (currentPlayer.getOptionData().get(OptionData.ANTIMASSDEFLECTOR))
            otherPlayer.changeHitValueOfAllUnits(CombatType.SPACECANNON, 1);
    }

    private void checkForStrikeWingAmbush(Player currentPlayer) {
        if (currentPlayer.getOptionData().get(OptionData.STRIKEWINGAMBUSH))
            currentPlayer.addOneDiceToBestUnit(CombatType.SPACECANNON);
    }

    private void checkForArgentFlightCommander(Player currentPlayer) {
        if (currentPlayer.getOptionData().get(OptionData.ARGENTFLIGHTCOMMANDER))
            currentPlayer.addOneDiceToBestUnit(CombatType.SPACECANNON);
    }

    private void checkForSolarFlare(Player currentPlayer) {
        if (currentPlayer.getOptionData().get(OptionData.SOLARFLAIR) && currentPlayer.getRole() == PlayerRole.ATTACKER)
            defenderCancelled = true;
    }

    private void checkForArgentFlightFlagship(Player currentPlayer) {
        if (attacker.getFaction() instanceof ArgentFlight && attacker.getUnitList().containsName(UnitName.FLAGSHIP)) {
            if (currentPlayer.getRole() == PlayerRole.ATTACKER) {
                defenderCancelled = true;
            }
            if (currentPlayer.getRole() == PlayerRole.DEFENDER) {
                attackerCancelled = true;
            }
        }
    }

}
