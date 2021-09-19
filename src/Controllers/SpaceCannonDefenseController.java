package Controllers;

import GUIData.OptionData;
import Player.*;

public class SpaceCannonDefenseController extends Controller{

    public SpaceCannonDefenseController(){
        super();
    }

    /**
     * method to run through the space cannon defense process
     */
    @Override
    public void startProcess() {

        defender.getUnitList().removeShips();

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
        if (currentPlayer.getOptionData().get(OptionData.TITANSHERO) && currentPlayer instanceof DefendingPlayer)
            defender.addUnitTitansHero();
    }

    private void checkForPlasmaScoring(Player currentPlayer) {
        if (currentPlayer.getOptionData().get(OptionData.PLASMASCORING) && currentPlayer instanceof DefendingPlayer)
            defender.addOneDiceToBestUnit(CombatType.SPACECANNON);
    }

    private void checkForArgentFlightCommander(Player currentPlayer) {
        if (currentPlayer.getOptionData().get(OptionData.ARGENTFLIGHTCOMMANDER) && currentPlayer instanceof DefendingPlayer)
            defender.addOneDiceToBestUnit(CombatType.SPACECANNON);
    }

    private void checkForAntimassDeflector(Player currentPlayer) {
        if (currentPlayer.getOptionData().get(OptionData.ANTIMASSDEFLECTOR) && currentPlayer instanceof AttackingPlayer)
            defender.changeHitValueOfAllUnits(CombatType.SPACECANNON, 1);
    }

    private void checkForDisable(Player currentPlayer) {
        if (currentPlayer.getOptionData().get(OptionData.DISABLE) && currentPlayer instanceof AttackingPlayer)
            defender.disablePDS();
    }

}
