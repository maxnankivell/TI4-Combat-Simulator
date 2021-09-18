package Controllers;

import Factions.JolNar;
import Factions.NaazRokha;
import Factions.SardakkNorr;
import GUI.OptionData;
import Player.*;
import Units.Unit;
import Units.UnitName;

import java.util.ArrayList;

public class GroundCombatController extends Controller{

    public GroundCombatController(){
        super();
    }

    @Override
    public void startProcess() {
        preProcess(attacker, defender);
        preProcess(defender, attacker);

        mainProcess(attacker);
        mainProcess(defender);
    }

    /**
     * Method to run through all pre-combat modifiers
     */
    public void preProcess(Player currentPlayer, Player otherPlayer){

        if(currentPlayer.getRole() == PlayerRole.DEFENDER) {
            //Defending in nebula
            if (currentPlayer.getOptionData().get(OptionData.DEFENDINGINNEBULA))
                currentPlayer.changeHitValueOfAllUnits(CombatType.GROUNDCOMBAT, -1);

            //Magen defense grid
            if (currentPlayer.getOptionData().get(OptionData.MAGENDEFENSEGRID))
                currentPlayer.addNumHits(1);
        }

        //Tekklar legion
        if (currentPlayer.getOptionData().get(OptionData.TEKKLARLEGION))
            SardakkNorr.tekklarLegion(currentPlayer, otherPlayer);

        //Morale boost
        if (currentPlayer.getOptionData().get(OptionData.MORALEBOOST))
            currentPlayer.changeHitValueOfAllUnits(CombatType.GROUNDCOMBAT, -1);

        //Winnu commander
        if (currentPlayer.getOptionData().get(OptionData.WINNUCOMMANDER))
            currentPlayer.changeHitValueOfAllUnits(CombatType.GROUNDCOMBAT, -2);

        //Sol agent
        if (currentPlayer.getOptionData().get(OptionData.SOLAGENT))
            currentPlayer.addOneDiceToBestUnit(CombatType.GROUNDCOMBAT);

        //Jol Nar mech
        if (currentPlayer.getFaction() instanceof JolNar && currentPlayer.getUnitList().containsName(UnitName.MECH))
            currentPlayer.changeHitValueOfAllUnitsOfSpecificType(CombatType.GROUNDCOMBAT, -1, UnitName.INFANTRY);

        //Naaz Rokha flagship
        if (currentPlayer.getFaction() instanceof NaazRokha && currentPlayer.getUnitList().containsName(UnitName.FLAGSHIP))
            currentPlayer.addDiceToSpecificUnitType(CombatType.GROUNDCOMBAT, UnitName.MECH);
    }

    /**
     * Method to run through the main combat process
     */
    public void mainProcess(Player currentPlayer){
        //start rolling
        for (Unit unit : currentPlayer.getUnitArrayList()) {
            ArrayList<Integer> diceRolls = new ArrayList<>();

            //roll amount of dice necessary for one unit
            for (int i = 0; i < unit.getNumDiceRollsGroundCombat(); i++) {
                diceRolls.add(Roller.diceRoll());
            }

            //Check re-roll conditions
            //Fire team
            if (currentPlayer.getOptionData().get(OptionData.FIRETEAM)) {
                Roller.reRollMissedDice(CombatType.GROUNDCOMBAT, diceRolls, unit);
            }

            //Check number of hits from this unit
            for (Integer roll : diceRolls) {
                if (roll >= unit.getHitValueGroundCombat()) {
                    currentPlayer.addNumHits(1);
                }
            }

        }
    }
}
