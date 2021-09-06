package Controllers;

import Factions.ArgentFlight;
import GUIData.AttackerOptions;
import GUIData.DefenderOptions;
import Units.Unit;
import Units.UnitList;
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
            attacker.addOneDiceToBestUnit(CombatType.SPACECANNON);
        }

        //Antimass deflector
        if (AttackerOptions.isAntimassDeflectorAttackerCheckbox()){
            defender.changeHitValueOfAllUnits(CombatType.SPACECANNON, 1);
        }

        //Strike wing ambuscade
        if (AttackerOptions.isStrikeWingAmbushAttackerCheckbox()){
            attacker.addOneDiceToBestUnit(CombatType.SPACECANNON);
        }

        //Solar flare
        if (AttackerOptions.isSolarFlairAttackerCheckbox()){
            defenderCancelled = true;
        }

        //Argent flight commander
        if (AttackerOptions.isArgentFlightCommanderAttackerCheckbox()){
            attacker.addOneDiceToBestUnit(CombatType.SPACECANNON);
        }

        //Argent flight flagship
        if (attackersFaction instanceof ArgentFlight && attacker.containsName(UnitName.FLAGSHIP)){
            defenderCancelled = true;
        }
    }

    /**
     * Method to run through all pre-combat modifiers for the defender
     */
    public void defenderPreProcess(){
        //Plasma scoring
        if (DefenderOptions.isPlasmaScoringDefenderCheckbox()){
            defender.addOneDiceToBestUnit(CombatType.SPACECANNON);
        }

        //Antimass deflector
        if (DefenderOptions.isAntimassDeflectorDefenderCheckbox()){
            attacker.changeHitValueOfAllUnits(CombatType.SPACECANNON, 1);
        }

        //Strike wing ambuscade
        if (DefenderOptions.isStrikeWingAmbushDefenderCheckbox()){
            defender.addOneDiceToBestUnit(CombatType.SPACECANNON);
        }

        //Experimental battlestation
        if (DefenderOptions.isExperimentalBattlestationDefenderCheckbox()){
            addUnitExperimentalBattlestation(defender);
        }

        //Argent flight commander
        if (DefenderOptions.isArgentFlightCommanderDefenderCheckbox()){
            defender.addOneDiceToBestUnit(CombatType.SPACECANNON);
        }

        //Titans Hero
        if (DefenderOptions.isTitansHeroDefenderCheckbox()){
            addUnitTitansHero(defender);
        }

        //Argent flight flagship
        if (defendersFaction instanceof ArgentFlight && defender.containsName(UnitName.FLAGSHIP)){
            attackerCancelled = true;
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
                    numHitsAttacker++;
                }
            }

        }
    }

    /**
     * Method to run through the main combat process for the defender
     */
    public void defenderMainProcess() {
        //start rolling
        for (Unit unit : defender.getUnitArrayList()) {
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
                    numHitsDefender++;
                }
            }

        }
    }

    /**
     * adds the experimental battlestation unit to the players list of units
     * @param player list of units
     */
    public void addUnitExperimentalBattlestation(UnitList player){
        player.add(new Unit.Builder(UnitName.OTHER)
                .addSpaceCannonValue(5,3)
                .build());
    }

}
