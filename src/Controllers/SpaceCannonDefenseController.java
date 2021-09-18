package Controllers;

import GUI.OptionData;
import Player.*;

public class SpaceCannonDefenseController extends Controller{
    private Player defenderNonShips;

    public SpaceCannonDefenseController(){
        super();
    }

    /**
     * method to run through the space cannon defense process
     */
    @Override
    public void startProcess() {
        defenderNonShips = new Player(defender);
        defenderNonShips.getUnitList().removeShips();

        preProcess(defender, attacker);
        preProcess(attacker, defender);

        Roller defenderRoller = new Roller(defender, CombatType.SPACECANNON);
        defenderRoller.mainProcess();
    }

    /**
     * Method to run through all pre-combat modifiers
     */
    public void preProcess(Player currentPlayer, Player otherPlayer){

        if (currentPlayer.getRole() == PlayerRole.DEFENDER) {
            //Titans hero
            if (currentPlayer.getOptionData().get(OptionData.TITANSHERO)) {
                defenderNonShips.addUnitTitansHero();
            }

            //Check for pre-combat modifiers
            //Plasma scoring
            if (currentPlayer.getOptionData().get(OptionData.PLASMASCORING)) {
                defenderNonShips.addOneDiceToBestUnit(CombatType.SPACECANNON);
            }

            //Argent flight commander
            if (currentPlayer.getOptionData().get(OptionData.ARGENTFLIGHTCOMMANDER)) {
                defenderNonShips.addOneDiceToBestUnit(CombatType.SPACECANNON);
            }
        }

        if (currentPlayer.getRole() == PlayerRole.ATTACKER) {
            //Check for pre-combat modifiers
            //Antimass deflector
            if (currentPlayer.getOptionData().get(OptionData.ANTIMASSDEFLECTOR)) {
                defenderNonShips.changeHitValueOfAllUnits(CombatType.SPACECANNON, 1);
            }

            //Disable
            if (currentPlayer.getOptionData().get(OptionData.DISABLE)) {
                defenderNonShips.disablePDS();
            }
        }
    }

}
