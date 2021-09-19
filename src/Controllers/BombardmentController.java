package Controllers;

import GUIData.OptionData;
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
        if (attacker.getOptionData().get(OptionData.BLITZ) && currentPlayer instanceof AttackingPlayer) {
            for (Unit unit : currentPlayer.getUnitArrayList()){
                if (unit.isNonFighterShip() && unit.getNumDiceRollsBombardment()==0){
                    unit.setBombardmentValue(6,1);
                }
            }
        }
    }

    private void checkForPlasmaScoring(Player currentPlayer) {
        if (attacker.getOptionData().get(OptionData.PLASMASCORING) && currentPlayer instanceof AttackingPlayer)
            attacker.addOneDiceToBestUnit(CombatType.BOMBARDMENT);
    }

    private void checkForStrikeWingAmbush(Player currentPlayer) {
        if (attacker.getOptionData().get(OptionData.STRIKEWINGAMBUSH) && currentPlayer instanceof AttackingPlayer)
            attacker.addOneDiceToBestUnit(CombatType.BOMBARDMENT);
    }

    private void checkForDisable(Player currentPlayer) {
        if (attacker.getOptionData().get(OptionData.DISABLE) && currentPlayer instanceof AttackingPlayer)
            defender.disablePDS();
    }

    private void checkForArgentFlightCommander(Player currentPlayer) {
        if (attacker.getOptionData().get(OptionData.ARGENTFLIGHTCOMMANDER) && currentPlayer instanceof AttackingPlayer)
            attacker.addOneDiceToBestUnit(CombatType.BOMBARDMENT);
    }

    private void checkForL1Z1XCommander(Player currentPlayer) {
        if (attacker.getOptionData().get(OptionData.L1Z1XCOMMANDER) && currentPlayer instanceof AttackingPlayer)
            planetaryShieldCancelled = true;
    }

    private void checkForWarSuns(Player currentPlayer) {
        if (attacker.getUnitList().containsName(UnitName.WARSUN) && currentPlayer instanceof AttackingPlayer)
            planetaryShieldCancelled = true;
    }

    private void checkForBunker(Player currentPlayer, Player otherPlayer) {
        if (currentPlayer.getOptionData().get(OptionData.BUNKER) && currentPlayer instanceof DefendingPlayer)
            otherPlayer.changeHitValueOfAllUnits(CombatType.BOMBARDMENT, 4);
    }

    private void checkForConventionsOfWar(Player currentPlayer) {
        if (currentPlayer.getOptionData().get(OptionData.CONVENTIONSOFWAR) && currentPlayer instanceof DefendingPlayer)
            bombardmentCancelled = true;
    }
}
