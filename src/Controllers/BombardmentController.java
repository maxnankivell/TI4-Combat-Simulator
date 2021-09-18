package Controllers;

import Factions.ArgentFlight;
import GUI.OptionData;
import Player.*;
import Units.Unit;
import Units.UnitName;


public class BombardmentController extends Controller{

    boolean planetaryShieldCancelled = false;
    boolean bombardmentCancelled = false;

    public BombardmentController(){
        super();
    }

    @Override
    public void startProcess() {
        preRollChecks(attacker, defender);
        preRollChecks(defender, attacker);

        if ((!defender.getUnitList().containsPlanetaryShield() || planetaryShieldCancelled) && !bombardmentCancelled){
            Roller attackerRoller = new Roller(attacker, CombatType.BOMBARDMENT);
            attackerRoller.mainProcess();
        }
    }

    public void preRollChecks(Player currentPlayer, Player otherPlayer){

        checkForBlitz(currentPlayer);
        checkForPlasmaScoring(currentPlayer);
        checkForStrikeWingAmbush(currentPlayer);
        checkForDisable(currentPlayer);
        checkForArgentFlightCommander(currentPlayer);
        checkForL1Z1XCommander(currentPlayer);
        checkForWarSuns(currentPlayer);
        checkForBunker(currentPlayer, otherPlayer);
        checkForConventionsOfWar(currentPlayer);

    }

    private void checkForBlitz(Player currentPlayer) {
        if (attacker.getOptionData().get(OptionData.BLITZ) && currentPlayer.getRole() == PlayerRole.ATTACKER) {
            for (Unit unit : currentPlayer.getUnitArrayList()){
                if (unit.isNonFighterShip() && unit.getNumDiceRollsBombardment()==0){
                    unit.setBombardmentValue(6,1);
                }
            }
        }
    }

    private void checkForPlasmaScoring(Player currentPlayer) {
        if (attacker.getOptionData().get(OptionData.PLASMASCORING) && currentPlayer.getRole() == PlayerRole.ATTACKER)
            attacker.addOneDiceToBestUnit(CombatType.BOMBARDMENT);
    }

    private void checkForStrikeWingAmbush(Player currentPlayer) {
        if (attacker.getOptionData().get(OptionData.STRIKEWINGAMBUSH) && currentPlayer.getRole() == PlayerRole.ATTACKER)
            attacker.addOneDiceToBestUnit(CombatType.BOMBARDMENT);
    }

    private void checkForDisable(Player currentPlayer) {
        if (attacker.getOptionData().get(OptionData.DISABLE) && currentPlayer.getRole() == PlayerRole.ATTACKER)
            defender.disablePDS();
    }

    private void checkForArgentFlightCommander(Player currentPlayer) {
        if (attacker.getOptionData().get(OptionData.ARGENTFLIGHTCOMMANDER) && currentPlayer.getRole() == PlayerRole.ATTACKER)
            attacker.addOneDiceToBestUnit(CombatType.BOMBARDMENT);
    }

    private void checkForL1Z1XCommander(Player currentPlayer) {
        if (attacker.getOptionData().get(OptionData.L1Z1XCOMMANDER) && currentPlayer.getRole() == PlayerRole.ATTACKER)
            planetaryShieldCancelled = true;
    }

    private void checkForWarSuns(Player currentPlayer) {
        if (attacker.getUnitList().containsName(UnitName.WARSUN) && currentPlayer.getRole() == PlayerRole.ATTACKER)
            planetaryShieldCancelled = true;
    }

    private void checkForBunker(Player currentPlayer, Player otherPlayer) {
        if (currentPlayer.getOptionData().get(OptionData.BUNKER) && currentPlayer.getRole() == PlayerRole.DEFENDER)
            otherPlayer.changeHitValueOfAllUnits(CombatType.BOMBARDMENT, 4);
    }

    private void checkForConventionsOfWar(Player currentPlayer) {
        if (currentPlayer.getOptionData().get(OptionData.CONVENTIONSOFWAR) && currentPlayer.getRole() == PlayerRole.DEFENDER)
            bombardmentCancelled = true;
    }
}
