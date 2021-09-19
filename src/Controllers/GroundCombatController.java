package Controllers;

import Factions.FactionEnum;
import GUI.OptionData;
import Player.*;
import Units.UnitName;

public class GroundCombatController extends Controller{

    public GroundCombatController(){
        super();
    }

    @Override
    public void startProcess() {
        preRollChecks(attacker, defender);
        preRollChecks(defender, attacker);

        Roller attackerRoller = new Roller(attacker, CombatType.GROUNDCOMBAT);
        attackerRoller.mainProcess();
        Roller defenderRoller = new Roller(defender, CombatType.GROUNDCOMBAT);
        defenderRoller.mainProcess();
    }

    /**
     * Method to run through all pre-combat modifiers
     */
    public void preRollChecks(Player currentPlayer, Player otherPlayer){

        checkForDefendingInNebula(currentPlayer);
        checkForMagenDefenseGrid(currentPlayer);
        checkForTekklarLegion(currentPlayer, otherPlayer);
        checkForMoraleBoost(currentPlayer);
        checkForWinnuCommander(currentPlayer);
        checkForSolAgent(currentPlayer);
        checkForJolNarMech(currentPlayer);
        checkForNaazRokhaFlagship(currentPlayer);

    }

    private void checkForDefendingInNebula(Player currentPlayer) {
        if (currentPlayer.getOptionData().get(OptionData.DEFENDINGINNEBULA) && currentPlayer.getRole() == PlayerRole.DEFENDER)
            currentPlayer.changeHitValueOfAllUnits(CombatType.GROUNDCOMBAT, -1);
    }

    private void checkForMagenDefenseGrid(Player currentPlayer) {
        if (currentPlayer.getOptionData().get(OptionData.MAGENDEFENSEGRID) && currentPlayer.getRole() == PlayerRole.DEFENDER)
            currentPlayer.addNumHits(1);
    }

    private void checkForTekklarLegion(Player currentPlayer, Player otherPlayer) {
        if (currentPlayer.getOptionData().get(OptionData.TEKKLARLEGION)) {
            currentPlayer.changeHitValueOfAllUnits(CombatType.GROUNDCOMBAT, -1);
            if (otherPlayer.getFactionEnum() == FactionEnum.SARDAKKNORR){
                otherPlayer.changeHitValueOfAllUnits(CombatType.GROUNDCOMBAT, 1);
            }
        }
    }

    private void checkForMoraleBoost(Player currentPlayer) {
        if (currentPlayer.getOptionData().get(OptionData.MORALEBOOST))
            currentPlayer.changeHitValueOfAllUnits(CombatType.GROUNDCOMBAT, -1);
    }

    private void checkForWinnuCommander(Player currentPlayer) {
        if (currentPlayer.getOptionData().get(OptionData.WINNUCOMMANDER))
            currentPlayer.changeHitValueOfAllUnits(CombatType.GROUNDCOMBAT, -2);
    }

    private void checkForSolAgent(Player currentPlayer) {
        if (currentPlayer.getOptionData().get(OptionData.SOLAGENT))
            currentPlayer.addOneDiceToBestUnit(CombatType.GROUNDCOMBAT);
    }

    private void checkForJolNarMech(Player currentPlayer) {
        if (currentPlayer.getFactionEnum() == FactionEnum.JOLNAR && currentPlayer.getUnitList().containsName(UnitName.MECH))
            currentPlayer.changeHitValueOfAllUnitsOfSpecificType(CombatType.GROUNDCOMBAT, -1, UnitName.INFANTRY);
    }

    private void checkForNaazRokhaFlagship(Player currentPlayer) {
        if (currentPlayer.getFactionEnum() == FactionEnum.NAAZROKHA && currentPlayer.getUnitList().containsName(UnitName.FLAGSHIP))
            currentPlayer.addDiceToSpecificUnitType(CombatType.GROUNDCOMBAT, UnitName.MECH);
    }

}
