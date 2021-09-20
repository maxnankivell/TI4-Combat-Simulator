package Controllers;

import GUIData.OptionData;
import Player.Player;
import Factions.FactionEnum;
import Units.Unit;
import Units.UnitName;

public class SpaceCombatController extends Controller{

    public SpaceCombatController(){
        super();
    }

    @Override
    public void startProcess() {
        preRollChecks(attacker, defender);
        preRollChecks(defender, attacker);

        Roller attackerRoller = new Roller(attacker, CombatType.SPACECOMBAT);
        attackerRoller.mainProcess();
        Roller defenderRoller = new Roller(defender, CombatType.SPACECOMBAT);
        defenderRoller.mainProcess();
    }

    /**
     * Method to run through all pre-combat modifiers
     */
    public void preRollChecks(Player currentPlayer, Player otherPlayer){

        checkForWinnuFlagship(currentPlayer, otherPlayer);
        checkForFighterPrototype(currentPlayer);
        checkForMoraleBoost(currentPlayer);
        checkForWinnuCommander(currentPlayer);
        checkForProphecyOfIxth(currentPlayer);
        checkForSardakkNorrFlagship(currentPlayer);
        checkForNaazRokhaFlagship(currentPlayer);
        checkForBaronyAgent(currentPlayer);

    }

    private void checkForWinnuFlagship(Player currentPlayer, Player otherPlayer) {
        if(currentPlayer.getFactionEnum() == FactionEnum.WINNU && currentPlayer.getUnitList().containsName(UnitName.FLAGSHIP)) {
            for (Unit unit : currentPlayer.getUnitArrayList()) {
                if(unit.getName() == UnitName.FLAGSHIP){
                    unit.setNumDiceRollsSpaceCombat(otherPlayer.getUnitList().numOfNonFighterShips());
                }
            }
        }
    }

    private void checkForFighterPrototype(Player currentPlayer) {
        if(currentPlayer.getOptionData().get(OptionData.FIGHTERPROTOTYPE))
            currentPlayer.changeHitValueOfAllUnitsOfSpecificType(CombatType.SPACECOMBAT,-2, UnitName.FIGHTER);
    }

    private void checkForMoraleBoost(Player currentPlayer) {
        if(currentPlayer.getOptionData().get(OptionData.MORALEBOOST))
            currentPlayer.changeHitValueOfAllUnits(CombatType.SPACECOMBAT, -1);
    }

    private void checkForWinnuCommander(Player currentPlayer) {
        if(currentPlayer.getOptionData().get(OptionData.WINNUCOMMANDER))
            currentPlayer.changeHitValueOfAllUnits(CombatType.SPACECOMBAT, -2);
    }

    private void checkForProphecyOfIxth(Player currentPlayer) {
        if(currentPlayer.getOptionData().get(OptionData.PROPHECYOFIXTH))
            currentPlayer.changeHitValueOfAllUnitsOfSpecificType(CombatType.SPACECOMBAT,-1, UnitName.FIGHTER);
    }

    private void checkForSardakkNorrFlagship(Player currentPlayer) {
        if(currentPlayer.getFactionEnum() == FactionEnum.SARDAKKNORR && currentPlayer.getUnitList().containsName(UnitName.FLAGSHIP)) {
            currentPlayer.changeHitValueOfAllUnits(CombatType.SPACECOMBAT, -1);
            for (Unit unit : currentPlayer.getUnitArrayList()) {
                if(unit.getName() == UnitName.FLAGSHIP){
                    unit.setHitValueSpaceCombat(unit.getHitValueSpaceCombat()+1);
                }
            }
        }
    }

    private void checkForNaazRokhaFlagship(Player currentPlayer) {
        if(currentPlayer.getFactionEnum() == FactionEnum.NAAZROKHA && currentPlayer.getUnitList().containsName(UnitName.FLAGSHIP))
            currentPlayer.addDiceToSpecificUnitType(CombatType.SPACECOMBAT,UnitName.MECH);
    }

    private void checkForBaronyAgent(Player currentPlayer) {
        if(currentPlayer.getOptionData().get(OptionData.BARONYAGENT))
            currentPlayer.addOneDiceToBestUnit(CombatType.SPACECOMBAT);
    }

}
