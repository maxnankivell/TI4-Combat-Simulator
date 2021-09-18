package Controllers;

import Factions.ArgentFlight;
import GUI.OptionData;
import Player.*;
import Units.UnitName;

public class SpaceCannonOffenseController extends Controller{

    public SpaceCannonOffenseController(){
        super();
    }

    @Override
    public void startProcess() {
        boolean defenderCancelled = preProcess(attacker, defender);
        boolean attackerCancelled = preProcess(defender, attacker);

        if (!attackerCancelled) {
            Roller attackerRoller = new Roller(attacker, CombatType.SPACECANNON);
            attackerRoller.mainProcess();
        }
        if (!defenderCancelled) {
            Roller defenderRoller = new Roller(defender, CombatType.SPACECANNON);
            defenderRoller.mainProcess();
        }

    }

    /**
     * Method to run through all pre-combat modifiers for the attacker
     */
    public boolean preProcess(Player currentPlayer, Player otherPlayer){

        if (currentPlayer.getRole() == PlayerRole.DEFENDER){
            //Experimental battlestation
            if (currentPlayer.getOptionData().get(OptionData.EXPERIMENTALBATTLESTATION))
                currentPlayer.addUnitExperimentalBattlestation();

            //Titans Hero
            if (currentPlayer.getOptionData().get(OptionData.TITANSHERO))
                currentPlayer.addUnitTitansHero();
        }

        //Plasma scoring
        if (currentPlayer.getOptionData().get(OptionData.PLASMASCORING))
            currentPlayer.addOneDiceToBestUnit(CombatType.SPACECANNON);

        //Antimass deflector
        if (currentPlayer.getOptionData().get(OptionData.ANTIMASSDEFLECTOR))
            otherPlayer.changeHitValueOfAllUnits(CombatType.SPACECANNON, 1);

        //Strike wing ambuscade
        if (currentPlayer.getOptionData().get(OptionData.STRIKEWINGAMBUSH))
            currentPlayer.addOneDiceToBestUnit(CombatType.SPACECANNON);

        //Argent flight commander
        if (currentPlayer.getOptionData().get(OptionData.ARGENTFLIGHTCOMMANDER))
            currentPlayer.addOneDiceToBestUnit(CombatType.SPACECANNON);

        if (currentPlayer.getRole() == PlayerRole.ATTACKER) {
            //Solar flare
            if (currentPlayer.getOptionData().get(OptionData.SOLARFLAIR))
                return true;
        }

        //Argent flight flagship
        if (attacker.getFaction() instanceof ArgentFlight && attacker.getUnitList().containsName(UnitName.FLAGSHIP))
            return true;

        return false;
    }

}
