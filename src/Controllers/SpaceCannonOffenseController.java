package Controllers;

import Factions.ArgentFlight;
import GUIData.AttackerOptions;
import GUIData.DefenderOptions;
import Units.Unit;
import Units.UnitName;

import java.util.ArrayList;

public class SpaceCannonOffenseController extends Controller{
    private boolean attackerCancelled = false;
    private boolean defenderCancelled = false;

    public SpaceCannonOffenseController(){
        super();
    }

    @Override
    public void startProcess() {
        attackerPreProcess();
        defenderPreProcess();

        if (!attackerCancelled){
            attackerMainProcess();
        }
        if (!defenderCancelled){
            defenderMainProcess();
        }
    }

    /**
     * Method to run through all pre-combat modifiers for the attacker
     */
    public void attackerPreProcess(){
        //Plasma scoring
        if (AttackerOptions.isPlasmaScoringAttackerCheckbox()){
            attacker1.addOneDiceToBestUnit(CombatType.SPACECANNON);
        }

        //Antimass deflector
        if (AttackerOptions.isAntimassDeflectorAttackerCheckbox()){
            defender1.changeHitValueOfAllUnits(CombatType.SPACECANNON, 1);
        }

        //Strike wing ambuscade
        if (AttackerOptions.isStrikeWingAmbushAttackerCheckbox()){
            attacker1.addOneDiceToBestUnit(CombatType.SPACECANNON);
        }

        //Solar flare
        if (AttackerOptions.isSolarFlairAttackerCheckbox()){
            defenderCancelled = true;
        }

        //Argent flight commander
        if (AttackerOptions.isArgentFlightCommanderAttackerCheckbox()){
            attacker1.addOneDiceToBestUnit(CombatType.SPACECANNON);
        }

        //Argent flight flagship
        if (attacker1.getFaction() instanceof ArgentFlight && attacker1.getUnitList().containsName(UnitName.FLAGSHIP)){
            defenderCancelled = true;
        }
    }

    /**
     * Method to run through all pre-combat modifiers for the defender
     */
    public void defenderPreProcess(){
        //Experimental battlestation
        if (DefenderOptions.isExperimentalBattlestationDefenderCheckbox()){
            defender1.addUnitExperimentalBattlestation();
        }

        //Titans Hero
        if (DefenderOptions.isTitansHeroDefenderCheckbox()){
            defender1.addUnitTitansHero();
        }

        //Plasma scoring
        if (DefenderOptions.isPlasmaScoringDefenderCheckbox()){
            defender1.addOneDiceToBestUnit(CombatType.SPACECANNON);
        }

        //Antimass deflector
        if (DefenderOptions.isAntimassDeflectorDefenderCheckbox()){
            attacker1.changeHitValueOfAllUnits(CombatType.SPACECANNON, 1);
        }

        //Strike wing ambuscade
        if (DefenderOptions.isStrikeWingAmbushDefenderCheckbox()){
            defender1.addOneDiceToBestUnit(CombatType.SPACECANNON);
        }

        //Argent flight commander
        if (DefenderOptions.isArgentFlightCommanderDefenderCheckbox()){
            defender1.addOneDiceToBestUnit(CombatType.SPACECANNON);
        }

        //Argent flight flagship
        if (defender1.getFaction() instanceof ArgentFlight && defender1.getUnitList().containsName(UnitName.FLAGSHIP)){
            attackerCancelled = true;
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
            for (int i = 0; i < unit.getNumDiceRollsSpaceCannon(); i++) {
                diceRolls.add(diceRoll());
            }

            //Check re-roll conditions
            //Jol Nar commander
            if (AttackerOptions.isJolNarCommanderAttackerCheckbox()) {
                diceRolls = reRollMissedDice(CombatType.SPACECANNON, diceRolls, unit);
            }

            //Check number of hits from this unit
            for (Integer roll : diceRolls) {
                if (roll >= unit.getHitValueSpaceCannon()) {
                    attacker1.addNumHits(1);
                }
            }
        }
    }

    /**
     * Method to run through the main combat process for the defender
     */
    public void defenderMainProcess() {
        //start rolling
        for (Unit unit : defender1.getUnitArrayList()) {
            ArrayList<Integer> diceRolls = new ArrayList<>();

            //roll amount of dice necessary for one unit
            for (int i = 0; i < unit.getNumDiceRollsSpaceCannon(); i++) {
                diceRolls.add(diceRoll());
            }

            //Check re-roll conditions
            //Jol Nar commander
            if (AttackerOptions.isJolNarCommanderAttackerCheckbox()) {
                diceRolls = reRollMissedDice(CombatType.SPACECANNON, diceRolls, unit);
            }


            //Check number of hits from this unit
            for (Integer roll : diceRolls) {
                if (roll >= unit.getHitValueSpaceCannon()) {
                    defender1.addNumHits(1);
                }
            }
        }
    }

}
