package Controllers;

import GUI.OptionData;
import Player.*;

public class SpaceCannonDefenseController extends Controller{
    private Player defenderNonShips;

    public SpaceCannonDefenseController(){
        super();
    }

    /**
     * method to run through the space cannon defense process
     */
    @Override
    public void startProcess() {
        defenderNonShips = new Player(defender);
        defenderNonShips.getUnitList().removeShips();

        preRollChecks(defender);
        preRollChecks(attacker);

        Roller defenderRoller = new Roller(defender, CombatType.SPACECANNON);
        defenderRoller.mainProcess();
    }

    /**
     * Method to run through all pre-combat modifiers
     */
    public void preRollChecks(Player currentPlayer){

        checkForTitansHero(currentPlayer);
        checkForPlasmaScoring(currentPlayer);
        checkForArgentFlightCommander(currentPlayer);
        checkForAntimassDeflector(currentPlayer);
        checkForDisable(currentPlayer);

    }

    private void checkForTitansHero(Player currentPlayer) {
        if (currentPlayer.getOptionData().get(OptionData.TITANSHERO) && currentPlayer.getRole() == PlayerRole.DEFENDER)
            defenderNonShips.addUnitTitansHero();
    }

    private void checkForPlasmaScoring(Player currentPlayer) {
        if (currentPlayer.getOptionData().get(OptionData.PLASMASCORING) && currentPlayer.getRole() == PlayerRole.DEFENDER)
            defenderNonShips.addOneDiceToBestUnit(CombatType.SPACECANNON);
    }

    private void checkForArgentFlightCommander(Player currentPlayer) {
        if (currentPlayer.getOptionData().get(OptionData.ARGENTFLIGHTCOMMANDER) && currentPlayer.getRole() == PlayerRole.DEFENDER)
            defenderNonShips.addOneDiceToBestUnit(CombatType.SPACECANNON);
    }

    private void checkForAntimassDeflector(Player currentPlayer) {
        if (currentPlayer.getOptionData().get(OptionData.ANTIMASSDEFLECTOR) && currentPlayer.getRole() == PlayerRole.ATTACKER)
            defenderNonShips.changeHitValueOfAllUnits(CombatType.SPACECANNON, 1);
    }

    private void checkForDisable(Player currentPlayer) {
        if (currentPlayer.getOptionData().get(OptionData.DISABLE) && currentPlayer.getRole() == PlayerRole.ATTACKER)
            defenderNonShips.disablePDS();
    }

}
