package Controllers;

import Factions.*;
import GUI.OptionData;
import Player.Player;
import Units.UnitName;

public class SpaceCombatController extends Controller{

    public SpaceCombatController(){
        super();
    }

    @Override
    public void startProcess() {
        preProcess(attacker, defender);
        preProcess(defender, attacker);

        Roller attackerRoller = new Roller(attacker, CombatType.SPACECOMBAT);
        attackerRoller.mainProcess();
        Roller defenderRoller = new Roller(defender, CombatType.SPACECOMBAT);
        defenderRoller.mainProcess();
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

}
