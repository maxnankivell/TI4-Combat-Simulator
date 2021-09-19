package Controllers;

import Factions.FactionEnum;
import GUIData.OptionData;
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
        if (currentPlayer.getOptionData().get(OptionData.EXPERIMENTALBATTLESTATION) && currentPlayer instanceof DefendingPlayer)
            currentPlayer.addUnitExperimentalBattlestation();
    }

    private void checkForTitansHero(Player currentPlayer) {
        if (currentPlayer.getOptionData().get(OptionData.TITANSHERO) && currentPlayer instanceof DefendingPlayer)
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
        if (currentPlayer.getOptionData().get(OptionData.SOLARFLAIR) && currentPlayer instanceof AttackingPlayer)
            defenderCancelled = true;
    }

    private void checkForArgentFlightFlagship(Player currentPlayer) {
        if (attacker.getFactionEnum() == FactionEnum.ARGENTFLIGHT && attacker.getUnitList().containsName(UnitName.FLAGSHIP)) {
            if (currentPlayer instanceof AttackingPlayer) {
                defenderCancelled = true;
            }
            if (currentPlayer instanceof DefendingPlayer) {
                attackerCancelled = true;
            }
        }
    }

}
