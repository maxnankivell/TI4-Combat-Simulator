package Controllers;

import Factions.JolNar;
import Factions.NaazRokha;
import Factions.SardakkNorr;
import GUIData.AttackerOptions;
import GUIData.DefenderOptions;
import Player.Player;
import Units.Unit;
import Units.UnitName;

import java.util.ArrayList;

public class GroundCombatController extends Controller{

    public GroundCombatController(){
        super();
    }

    @Override
    public void startProcess() {
        attackPreProcess();
        defenderPreProcess();

        attackerMainProcess();
        defenderMainProcess();
    }

    /**
     * Method to run through all pre-combat modifiers for the attacker
     */
    public void attackPreProcess(){
        //Tekklar legion
        if (AttackerOptions.isTekklarLegionAttackerCheckbox()){
            tekklarLegion(attacker, defender);
        }

        //Sol agent
        if (AttackerOptions.isSolAgentAttackerCheckbox()){
            attacker.addOneDiceToBestUnit(CombatType.GROUNDCOMBAT);
        }

        //Morale boost
        if (AttackerOptions.isMoraleBoostAttackerCheckbox()){
            attacker.changeHitValueOfAllUnits(CombatType.GROUNDCOMBAT, -1);
        }

        //Winnu commander
        if (AttackerOptions.isWinnuCommanderAttackerCheckbox()){
            attacker.changeHitValueOfAllUnits(CombatType.GROUNDCOMBAT, -2);
        }

        //Jol Nar mech
        if (attacker.getFaction() instanceof JolNar && attacker.getUnitList().containsName(UnitName.MECH)){
            attacker.changeHitValueOfAllUnitsOfSpecificType(CombatType.GROUNDCOMBAT, -1, UnitName.INFANTRY, UnitName.INFANTRYUPGRADE);
        }

        //Naaz Rokha flagship
        if (attacker.getFaction() instanceof NaazRokha && attacker.getUnitList().containsName(UnitName.FLAGSHIP)){
            attacker.addDiceToSpecificUnitType(CombatType.GROUNDCOMBAT, UnitName.MECH, UnitName.MECH);
        }
    }

    /**
     * Method to run through all pre-combat modifiers for the defender
     */
    public void defenderPreProcess(){
        //Magen defense grid
        if (DefenderOptions.isMagenDefenseGridDefenderCheckbox()){
            defender.addNumHits(1);
        }

        //Tekklar legion
        if (DefenderOptions.isTekklarLegionDefenderCheckbox()){
            tekklarLegion(defender, attacker);
        }

        //Sol agent
        if (DefenderOptions.isSolAgentDefenderCheckbox()){
            defender.addOneDiceToBestUnit(CombatType.GROUNDCOMBAT);
        }

        //Morale boost
        if (DefenderOptions.isMoraleBoostDefenderCheckbox()){
            defender.changeHitValueOfAllUnits(CombatType.GROUNDCOMBAT, -1);
        }

        //Winnu commander
        if (DefenderOptions.isWinnuCommanderDefenderCheckbox()){
            defender.changeHitValueOfAllUnits(CombatType.GROUNDCOMBAT, -2);
        }

        //Defending in nebula
        if (DefenderOptions.isDefendingInNebulaDefenderCheckbox()){
            defender.changeHitValueOfAllUnits(CombatType.GROUNDCOMBAT, -1);
        }

        //Jol Nar mech
        if (defender.getFaction() instanceof JolNar && defender.getUnitList().containsName(UnitName.MECH)){
            defender.changeHitValueOfAllUnitsOfSpecificType(CombatType.GROUNDCOMBAT,-1, UnitName.INFANTRY, UnitName.INFANTRYUPGRADE);
        }

        //Naaz Rokha flagship
        if (defender.getFaction() instanceof NaazRokha && defender.getUnitList().containsName(UnitName.FLAGSHIP)){
            defender.addDiceToSpecificUnitType(CombatType.GROUNDCOMBAT, UnitName.MECH, UnitName.MECH);
        }
    }

    /**
     * Method to run through the main combat process for the attacker
     */
    public void attackerMainProcess(){
        //start rolling
        for (Unit unit : attacker.getUnitArrayList()) {
            ArrayList<Integer> diceRolls = new ArrayList<>();

            //roll amount of dice necessary for one unit
            for (int i = 0; i < unit.getNumDiceRollsGroundCombat(); i++) {
                diceRolls.add(diceRoll());
            }

            //Check re-roll conditions
            //Fire team
            if (AttackerOptions.isFireTeamAttackerCheckbox()) {
                diceRolls = reRollMissedDice(CombatType.GROUNDCOMBAT, diceRolls, unit);
            }

            //Check number of hits from this unit
            for (Integer roll : diceRolls) {
                if (roll >= unit.getHitValueGroundCombat()) {
                    attacker.addNumHits(1);
                }
            }

        }
    }

    /**
     * Method to run through the main combat process for the defender
     */
    public void defenderMainProcess(){
        //start rolling
        for (Unit unit : defender.getUnitArrayList()) {
            ArrayList<Integer> diceRolls = new ArrayList<>();

            //roll amount of dice necessary for one unit
            for (int i = 0; i < unit.getNumDiceRollsGroundCombat(); i++) {
                diceRolls.add(diceRoll());
            }

            //Check re-roll conditions
            //Fire team
            if (DefenderOptions.isFireTeamDefenderCheckbox()) {
                diceRolls = reRollMissedDice(CombatType.GROUNDCOMBAT, diceRolls, unit);
            }

            //Check number of hits from this unit
            for (Integer roll : diceRolls) {
                if (roll >= unit.getHitValueGroundCombat()) {
                    defender.addNumHits(1);
                }
            }

        }
    }

    /**
     * subtracts one from all opposing player ground units hit values
     * if the current player is Sardakk Norr then add one to
     * all current player ground units hit values
     */
    public void tekklarLegion(Player currentPlayer, Player otherPlayer){
        currentPlayer.changeHitValueOfAllUnits(CombatType.GROUNDCOMBAT, -1);
        if (otherPlayer.getFaction() instanceof SardakkNorr){
            otherPlayer.changeHitValueOfAllUnits(CombatType.GROUNDCOMBAT, 1);
        }
    }

}
