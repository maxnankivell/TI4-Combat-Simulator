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
            addOneDiceToUnit(CombatType.SPACECANNON, attacker);
        }

        //Antimass deflector
        if (AttackerOptions.isAntimassDeflectorAttackerCheckbox()){
            changeHitValueOfAllUnits(CombatType.SPACECANNON, defender, 1);
        }

        //Strike wing ambuscade
        if (AttackerOptions.isStrikeWingAmbushAttackerCheckbox()){
            addOneDiceToUnit(CombatType.SPACECANNON, attacker);
        }

        //Solar flare
        if (AttackerOptions.isSolarFlairAttackerCheckbox()){
            defenderCancelled = true;
        }

        //Argent flight commander
        if (AttackerOptions.isArgentFlightCommanderAttackerCheckbox()){
            addOneDiceToUnit(CombatType.SPACECANNON, attacker);
        }

        //Argent flight flagship
        if (attackersFaction instanceof ArgentFlight && attacker.contains(new Unit.Builder(UnitName.FLAGSHIP).build())){
            defenderCancelled = true;
        }
    }

    /**
     * Method to run through all pre-combat modifiers for the defender
     */
    public void defenderPreProcess(){
        //Plasma scoring
        if (DefenderOptions.isPlasmaScoringDefenderCheckbox()){
            addOneDiceToUnit(CombatType.SPACECANNON, defender);
        }

        //Antimass deflector
        if (DefenderOptions.isAntimassDeflectorDefenderCheckbox()){
            changeHitValueOfAllUnits(CombatType.SPACECANNON, attacker, 1);
        }

        //Strike wing ambuscade
        if (DefenderOptions.isStrikeWingAmbushDefenderCheckbox()){
            addOneDiceToUnit(CombatType.SPACECANNON, defender);
        }

        //Experimental battlestation
        if (DefenderOptions.isExperimentalBattlestationDefenderCheckbox()){
            addUnitExperimentalBattlestation(defender);
        }

        //Argent flight commander
        if (DefenderOptions.isArgentFlightCommanderDefenderCheckbox()){
            addOneDiceToUnit(CombatType.SPACECANNON, defender);
        }

        //Titans Hero
        if (DefenderOptions.isTitansHeroDefenderCheckbox()){
            addUnitTitansHero(defender);
        }

        //Argent flight flagship
        if (defendersFaction instanceof ArgentFlight && defender.contains(new Unit.Builder(UnitName.FLAGSHIP).build())){
            attackerCancelled = true;
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
        for (Unit unit : defender) {
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
    public void addUnitExperimentalBattlestation(ArrayList<Unit> player){
        player.add(new Unit.Builder(UnitName.OTHER)
                .addSpaceCannonValue(5,3)
                .build());
    }

    /**
     * adds the titans hero unit to the players list of units
     * @param player list of units
     */
    public void addUnitTitansHero(ArrayList<Unit> player){
        player.add(new Unit.Builder(UnitName.OTHER)
                .addSpaceCannonValue(5,3)
                .build());
    }

}
