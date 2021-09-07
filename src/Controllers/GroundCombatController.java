package Controllers;

import Factions.JolNar;
import Factions.NaazRokha;
import Factions.SardakkNorr;
import GUIData.AttackerOptions;
import GUIData.DefenderOptions;
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
            tekklarLegionAttacker();
        }

        //Sol agent
        if (AttackerOptions.isSolAgentAttackerCheckbox()){
            attacker1.addOneDiceToBestUnit(CombatType.GROUNDCOMBAT);
        }

        //Morale boost
        if (AttackerOptions.isMoraleBoostAttackerCheckbox()){
            attacker1.changeHitValueOfAllUnits(CombatType.GROUNDCOMBAT, -1);
        }

        //Winnu commander
        if (AttackerOptions.isWinnuCommanderAttackerCheckbox()){
            attacker1.changeHitValueOfAllUnits(CombatType.GROUNDCOMBAT, -2);
        }

        //Jol Nar mech
        if (attacker1.getFaction() instanceof JolNar && attacker1.getUnitList().containsName(UnitName.MECH)){
            attacker1.changeHitValueOfAllUnitsOfSpecificType(CombatType.GROUNDCOMBAT, -1, UnitName.INFANTRY, UnitName.INFANTRYUPGRADE);
        }

        //Naaz Rokha flagship
        if (attacker1.getFaction() instanceof NaazRokha && attacker1.getUnitList().containsName(UnitName.FLAGSHIP)){
            attacker1.addDiceToSpecificUnitType(CombatType.GROUNDCOMBAT, UnitName.MECH, UnitName.MECH);
        }
    }

    /**
     * Method to run through all pre-combat modifiers for the defender
     */
    public void defenderPreProcess(){
        //Magen defense grid
        if (DefenderOptions.isMagenDefenseGridDefenderCheckbox()){
            defender1.addNumHits(1);
        }

        //Tekklar legion
        if (DefenderOptions.isTekklarLegionDefenderCheckbox()){
            tekklarLegionDefender();
        }

        //Sol agent
        if (DefenderOptions.isSolAgentDefenderCheckbox()){
            defender1.addOneDiceToBestUnit(CombatType.GROUNDCOMBAT);
        }

        //Morale boost
        if (DefenderOptions.isMoraleBoostDefenderCheckbox()){
            defender1.changeHitValueOfAllUnits(CombatType.GROUNDCOMBAT, -1);
        }

        //Winnu commander
        if (DefenderOptions.isWinnuCommanderDefenderCheckbox()){
            defender1.changeHitValueOfAllUnits(CombatType.GROUNDCOMBAT, -2);
        }

        //Defending in nebula
        if (DefenderOptions.isDefendingInNebulaDefenderCheckbox()){
            defender1.changeHitValueOfAllUnits(CombatType.GROUNDCOMBAT, -1);
        }

        //Jol Nar mech
        if (defender1.getFaction() instanceof JolNar && defender1.getUnitList().containsName(UnitName.MECH)){
            defender1.changeHitValueOfAllUnitsOfSpecificType(CombatType.GROUNDCOMBAT,-1, UnitName.INFANTRY, UnitName.INFANTRYUPGRADE);
        }

        //Naaz Rokha flagship
        if (defender1.getFaction() instanceof NaazRokha && defender1.getUnitList().containsName(UnitName.FLAGSHIP)){
            defender1.addDiceToSpecificUnitType(CombatType.GROUNDCOMBAT, UnitName.MECH, UnitName.MECH);
        }
    }

    /**
     * Method to run through the main combat process for the attacker
     */
    public void attackerMainProcess(){
        //start rolling
        for (Unit unit : attacker1.getUnitArrayList()) {
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
                    attacker1.addNumHits(1);
                }
            }

        }
    }

    /**
     * Method to run through the main combat process for the defender
     */
    public void defenderMainProcess(){
        //start rolling
        for (Unit unit : defender1.getUnitArrayList()) {
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
                    defender1.addNumHits(1);
                }
            }

        }
    }

    /**
     * subtracts one from all attacker ground units hit values
     * if the defender is Sardakk Norr then add one to
     * all defender ground units hit values
     */
    public void tekklarLegionAttacker(){
        attacker1.changeHitValueOfAllUnits(CombatType.GROUNDCOMBAT, -1);
        if (defender1.getFaction() instanceof SardakkNorr){
            defender1.changeHitValueOfAllUnits(CombatType.GROUNDCOMBAT, 1);
        }
    }

    /**
     * subtracts one from all defender ground units hit values
     * if the attacker is Sardakk Norr then add one to
     * all attacker ground units hit values
     */
    public void tekklarLegionDefender(){
        defender1.changeHitValueOfAllUnits(CombatType.GROUNDCOMBAT, -1);
        if (attacker1.getFaction() instanceof SardakkNorr){
            attacker1.changeHitValueOfAllUnits(CombatType.GROUNDCOMBAT, 1);
        }
    }

}
