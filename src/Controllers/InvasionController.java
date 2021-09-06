package Controllers;

import Factions.JolNar;
import Factions.NaazRokha;
import Factions.SardakkNorr;
import GUIData.AttackerOptions;
import GUIData.DefenderOptions;
import Units.Unit;
import Units.UnitName;

import java.util.ArrayList;

public class InvasionController extends Controller{

    public InvasionController(){
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
        if (AttackerOptions.isArgentFlightCommanderAttackerCheckbox()){
            tekklarLegionAttacker();
        }

        //Sol agent
        if (AttackerOptions.isSolAgentAttackerCheckbox()){
            addOneDiceToUnit(CombatType.GROUNDCOMBAT, attacker);
        }

        //Morale boost
        if (AttackerOptions.isMoraleBoostAttackerCheckbox()){
            changeHitValueOfAllUnits(CombatType.GROUNDCOMBAT, attacker, -1);
        }

        //Winnu commander
        if (AttackerOptions.isWinnuCommanderAttackerCheckbox()){
            changeHitValueOfAllUnits(CombatType.GROUNDCOMBAT, attacker, -2);
        }

        //Jol Nar mech
        if (attackersFaction instanceof JolNar && containsName(UnitName.MECH, attacker)){
            changeHitValueOfAllUnitsOfSpecificType(CombatType.GROUNDCOMBAT, attacker, -1, UnitName.INFANTRY, UnitName.INFANTRYUPGRADE);
        }

        //Naaz Rokha flagship
        if (attackersFaction instanceof NaazRokha && containsName(UnitName.FLAGSHIP, attacker)){
            addDiceToSpecificUnitType(CombatType.GROUNDCOMBAT, attacker, UnitName.MECH, UnitName.MECH);
        }
    }

    /**
     * Method to run through all pre-combat modifiers for the defender
     */
    public void defenderPreProcess(){
        //Magen defense grid
        if (DefenderOptions.isMagenDefenseGridDefenderCheckbox()){
            numHitsDefender++;
        }

        //Tekklar legion
        if (DefenderOptions.isTekklarLegionDefenderCheckbox()){
            tekklarLegionDefender();
        }

        //Sol agent
        if (DefenderOptions.isSolAgentDefenderCheckbox()){
            addOneDiceToUnit(CombatType.GROUNDCOMBAT, defender);
        }

        //Morale boost
        if (DefenderOptions.isMoraleBoostDefenderCheckbox()){
            changeHitValueOfAllUnits(CombatType.GROUNDCOMBAT, defender, -1);
        }

        //Winnu commander
        if (DefenderOptions.isWinnuCommanderDefenderCheckbox()){
            changeHitValueOfAllUnits(CombatType.GROUNDCOMBAT, defender, -2);
        }

        //Defending in nebula
        if (DefenderOptions.isDefendingInNebulaDefenderCheckbox()){
            changeHitValueOfAllUnits(CombatType.GROUNDCOMBAT, defender, -1);
        }

        //Jol Nar mech
        if (defendersFaction instanceof JolNar && containsName(UnitName.MECH, defender)){
            changeHitValueOfAllUnitsOfSpecificType(CombatType.GROUNDCOMBAT, defender, -1, UnitName.INFANTRY, UnitName.INFANTRYUPGRADE);
        }

        //Naaz Rokha flagship
        if (defendersFaction instanceof NaazRokha && containsName(UnitName.FLAGSHIP, defender)){
            addDiceToSpecificUnitType(CombatType.GROUNDCOMBAT, defender, UnitName.MECH, UnitName.MECH);
        }
    }

    /**
     * Method to run through the main combat process for the attacker
     */
    public void attackerMainProcess(){
        //start rolling
        for (Unit unit : attacker) {
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
                    numHitsAttacker++;
                }
            }

        }
    }

    /**
     * Method to run through the main combat process for the defender
     */
    public void defenderMainProcess(){
        //start rolling
        for (Unit unit : defender) {
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
                    numHitsDefender++;
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
        changeHitValueOfAllUnits(CombatType.GROUNDCOMBAT, attacker, -1);
        if (defendersFaction instanceof SardakkNorr){
            changeHitValueOfAllUnits(CombatType.GROUNDCOMBAT, defender, 1);
        }
    }

    /**
     * subtracts one from all defender ground units hit values
     * if the attacker is Sardakk Norr then add one to
     * all attacker ground units hit values
     */
    public void tekklarLegionDefender(){
        changeHitValueOfAllUnits(CombatType.GROUNDCOMBAT, defender, -1);
        if (attackersFaction instanceof SardakkNorr){
            changeHitValueOfAllUnits(CombatType.GROUNDCOMBAT, attacker, 1);
        }
    }

}
