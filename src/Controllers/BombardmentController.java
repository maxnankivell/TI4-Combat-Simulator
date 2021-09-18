package Controllers;

import Factions.ArgentFlight;
import GUI.OptionData;
import Player.*;
import Units.UnitName;


public class BombardmentController extends Controller{

    public BombardmentController(){
        super();
    }

    @Override
    public void startProcess() {
        boolean planetaryShieldCancelled = preProcess(attacker, defender);
        boolean bombardmentCancelled = preProcess(defender, attacker);

        if ((!defender.getUnitList().containsPlanetaryShield() || planetaryShieldCancelled) && !bombardmentCancelled){
            Roller attackerRoller = new Roller(attacker, CombatType.BOMBARDMENT);
            attackerRoller.mainProcess();
        }
    }

    public boolean preProcess(Player currentPlayer, Player otherPlayer){

        if (currentPlayer.getRole() == PlayerRole.ATTACKER) {
            //Blitz
            if (attacker.getOptionData().get(OptionData.BLITZ))
                ArgentFlight.blitz(attacker);

            //Plasma scoring
            if (attacker.getOptionData().get(OptionData.PLASMASCORING))
                attacker.addOneDiceToBestUnit(CombatType.BOMBARDMENT);

            //Strike wing ambush
            if (attacker.getOptionData().get(OptionData.STRIKEWINGAMBUSH))
                attacker.addOneDiceToBestUnit(CombatType.BOMBARDMENT);

            //Disable
            if (attacker.getOptionData().get(OptionData.DISABLE))
                defender.disablePDS();

            //Argent flight commander
            if (attacker.getOptionData().get(OptionData.ARGENTFLIGHTCOMMANDER))
                attacker.addOneDiceToBestUnit(CombatType.BOMBARDMENT);

            //L1Z1X commander
            if (attacker.getOptionData().get(OptionData.L1Z1XCOMMANDER))
                return true;

            //warsuns
            if (attacker.getUnitList().containsName(UnitName.WARSUN))
                return true;
        }

        if (currentPlayer.getRole() == PlayerRole.DEFENDER){
            //Bunker
            if (currentPlayer.getOptionData().get(OptionData.BUNKER))
                otherPlayer.changeHitValueOfAllUnits(CombatType.BOMBARDMENT, 4);

            //Convention of war
            //assumes all planets are cultural if checked
            if (currentPlayer.getOptionData().get(OptionData.CONVENTIONSOFWAR))
                return true;
        }

        return false;
    }
}
