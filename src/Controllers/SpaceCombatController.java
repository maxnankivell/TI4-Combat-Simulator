package Controllers;

import Factions.*;
import GUI.OptionData;
import Player.Player;
import Units.Unit;
import Units.UnitName;

import java.util.ArrayList;

public class SpaceCombatController extends Controller{

    public SpaceCombatController(){
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

        //Populate the number of dice for the winnu flagship
        if(currentPlayer.getFaction() instanceof Winnu && currentPlayer.getUnitList().containsName(UnitName.FLAGSHIP)){
            Winnu.winnuFlagship(currentPlayer, otherPlayer);
        }

        if(currentPlayer.getOptionData().get(OptionData.FIGHTERPROTOTYPE)){
            currentPlayer.changeHitValueOfAllUnitsOfSpecificType(CombatType.SPACECOMBAT,-2, UnitName.FIGHTER);
        }
        if(currentPlayer.getOptionData().get(OptionData.MORALEBOOST)){
            currentPlayer.changeHitValueOfAllUnits(CombatType.SPACECOMBAT, -1);
        }
        if(currentPlayer.getOptionData().get(OptionData.WINNUCOMMANDER)){
            currentPlayer.changeHitValueOfAllUnits(CombatType.SPACECOMBAT, -2);
        }
        if(currentPlayer.getOptionData().get(OptionData.PROPHECYOFIXTH)){
            currentPlayer.changeHitValueOfAllUnitsOfSpecificType(CombatType.SPACECOMBAT,-1, UnitName.FIGHTER);
        }
        if(currentPlayer.getFaction() instanceof SardakkNorr && currentPlayer.getUnitList().containsName(UnitName.FLAGSHIP)){
            SardakkNorr.sardakkNorrFlagship(currentPlayer);
        }

        if(currentPlayer.getFaction() instanceof NaazRokha && currentPlayer.getUnitList().containsName(UnitName.FLAGSHIP)){
            currentPlayer.addDiceToSpecificUnitType(CombatType.SPACECOMBAT,UnitName.MECH);
        }
        if(currentPlayer.getOptionData().get(OptionData.BARONYAGENT)){
            currentPlayer.addOneDiceToBestUnit(CombatType.SPACECOMBAT);
        }
    }

    /**
     * Method to run through the main combat process for the attacker
     */
    public void mainProcess(Player currentPlayer){

        //Start the rolling for each unit
        for (Unit unit : currentPlayer.getUnitArrayList()) {
            ArrayList<Integer> diceRolls = new ArrayList<>();

            //roll amount of dice necessary for one unit
            for (int i=0; i<unit.getNumDiceRollsSpaceCombat(); i++){
                diceRolls.add(Roller.diceRoll());
            }

            //Check re-roll conditions

            //Check number of hits from this unit
            for (Integer roll : diceRolls) {
                if(roll >= unit.getHitValueSpaceCombat()){
                    currentPlayer.addNumHits(1);
                }

                //JolNar Flagship
                if(currentPlayer.getFaction() instanceof JolNar && unit.getName() == UnitName.FLAGSHIP && roll >= 9) {
                    currentPlayer.addNumHits(2);
                }
                //L1Z1X Flagship
                if(currentPlayer.getFaction() instanceof L1Z1X && currentPlayer.getUnitList().containsName(UnitName.FLAGSHIP) && unit.isFlagshipOrDreadnought() && roll >= unit.getHitValueSpaceCombat()) {
                    currentPlayer.addNumHits(-1);
                    currentPlayer.addNumNonFighterHits(1);
                }
            }
        }
    }
}
