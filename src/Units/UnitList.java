package Units;

import Controllers.CombatType;

import java.util.ArrayList;

public class UnitList {
    private ArrayList<Unit> unitArrayList;

    public UnitList(){
        unitArrayList = new ArrayList<>();
    }

    public ArrayList<Unit> getUnitArrayList() {
        return unitArrayList;
    }

    public void add(Unit unit){
        unitArrayList.add(unit);
    }

    public Unit get(int index){
        return unitArrayList.get(index);
    }

    public void remove(int index){
        unitArrayList.remove(index);
    }

    public int size(){
        return unitArrayList.size();
    }

    /**
     * checks if any unit has a planetary shield
     * @return if any unit has a planetary shield
     */
    public boolean containsPlanetryShield(){
        for (Unit unit : unitArrayList) {
            if(unit.hasPlanetaryShield()){
                return true;
            }
        }
        return false;
    }

    /**
     * stops all pds from firing and turns off planetary shield
     */
    public void disablePDS(){
        for (Unit unit: unitArrayList){
            if (unit.getName()==UnitName.PDS || unit.getName()==UnitName.PDSUPGRADE){
                unit.setNumDiceRollsSpaceCannon(0);
                unit.setHitValueSpaceCannon(0);
                unit.setPlanetaryShield(false);
            }
        }
    }

    /**
     * Method to check if an arraylist of units contains a unit with a specific name
     * @param name Unit name to search for
     * @return true if unit is found
     */
    public boolean containsName(UnitName name){
        for (Unit unit : unitArrayList) {
            if(unit.getName() == name){
                return true;
            }
        }
        return false;
    }

    /**
     * Method to find the number of units with a given name in an arraylist
     * @param name Unit name to search for
     * @return Number of units found
     */
    public int numberOfType(UnitName name){
        int number = 0;

        for (Unit unit : unitArrayList) {
            if(unit.getName() == name){
                number++;
            }
        }
        return number;
    }

    /**
     * Method to find the number of non fighter ships in an arraylist
     * @return Number of units found
     */
    public int numOfNonFighterShips(){
        int number = 0;

        for (Unit unit : unitArrayList) {
            if(unit.isNonFighterShip()){
                number++;
            }
        }
        return number;
    }


    /**
     * adds a dice to the best possible unit given this stage of combat
     * @param combatType the current stage of combat
     */
    public void addOneDiceToBestUnit(CombatType combatType){
        Unit lowestHitValue = unitArrayList.get(0);
        switch (combatType){
            case AFB:
                for (Unit unit: unitArrayList){
                    if ((unit.getHitValueAFB()<lowestHitValue.getHitValueAFB() && unit.getHitValueAFB()!=0)
                            || lowestHitValue.getHitValueAFB()==0){
                        lowestHitValue=unit;
                    }
                }
                if (lowestHitValue.getHitValueAFB()!=0) {
                    lowestHitValue.setNumDiceRollsAFB(lowestHitValue.getNumDiceRollsAFB() + 1);
                }
                break;
            case BOMBARDMENT:
                for (Unit unit: unitArrayList){
                    if ((unit.getHitValueBombardment()<lowestHitValue.getHitValueBombardment() && unit.getHitValueBombardment()!=0)
                            || lowestHitValue.getHitValueBombardment()==0){
                        lowestHitValue=unit;
                    }
                }
                if (lowestHitValue.getHitValueBombardment()!=0) {
                    lowestHitValue.setNumDiceRollsBombardment(lowestHitValue.getNumDiceRollsBombardment() + 1);
                }
                break;
            case SPACECANNON:
                for (Unit unit: unitArrayList){
                    if ((unit.getHitValueSpaceCannon()<lowestHitValue.getHitValueSpaceCannon() && unit.getHitValueSpaceCannon()!=0)
                            || lowestHitValue.getHitValueSpaceCannon()==0){
                        lowestHitValue=unit;
                    }
                }
                if (lowestHitValue.getHitValueSpaceCannon()!=0) {
                    lowestHitValue.setNumDiceRollsSpaceCannon(lowestHitValue.getNumDiceRollsSpaceCannon() + 1);
                }
                break;
            case SPACECOMBAT:
                for (Unit unit: unitArrayList){
                    if ((unit.getHitValueSpaceCombat()<lowestHitValue.getHitValueSpaceCombat() && unit.getHitValueSpaceCombat()!=0)
                            || lowestHitValue.getHitValueSpaceCombat()==0){
                        lowestHitValue=unit;
                    }
                }
                if (lowestHitValue.getHitValueSpaceCombat()!=0) {
                    lowestHitValue.setNumDiceRollsSpaceCombat(lowestHitValue.getNumDiceRollsSpaceCombat() + 1);
                }
                break;
            case GROUNDCOMBAT:
                for (Unit unit: unitArrayList){
                    if ((unit.getHitValueGroundCombat()<lowestHitValue.getHitValueGroundCombat()) && unit.getHitValueGroundCombat()!=0
                            || lowestHitValue.getHitValueGroundCombat()==0){
                        lowestHitValue=unit;
                    }
                }
                if (lowestHitValue.getHitValueGroundCombat()!=0) {
                    lowestHitValue.setNumDiceRollsGroundCombat(lowestHitValue.getNumDiceRollsGroundCombat() + 1);
                }
                break;
        }
    }

    /**
     * adds a dice to all units of a specific type given this stage of combat
     * @param combatType the current stage of combat
     * @param unitName name of unit
     * @param unitNameUpgraded name of upgraded unit
     */
    public void addDiceToSpecificUnitType(CombatType combatType, UnitName unitName, UnitName unitNameUpgraded){
        switch (combatType){
            case AFB:
                for (Unit unit: unitArrayList){
                    if((unit.getName() == unitName || unit.getName() == unitNameUpgraded) && unit.getNumDiceRollsAFB()!=0){
                        unit.setNumDiceRollsAFB(unit.getNumDiceRollsAFB()+1);
                    }
                }
                break;
            case BOMBARDMENT:
                for (Unit unit: unitArrayList){
                    if((unit.getName() == unitName || unit.getName() == unitNameUpgraded) && unit.getNumDiceRollsBombardment()!=0){
                        unit.setNumDiceRollsBombardment(unit.getNumDiceRollsBombardment()+1);
                    }
                }
                break;
            case SPACECANNON:
                for (Unit unit: unitArrayList){
                    if((unit.getName() == unitName || unit.getName() == unitNameUpgraded) && unit.getNumDiceRollsSpaceCannon()!=0){
                        unit.setNumDiceRollsSpaceCannon(unit.getNumDiceRollsSpaceCannon()+1);
                    }
                }
                break;
            case SPACECOMBAT:
                for (Unit unit: unitArrayList){
                    if((unit.getName() == unitName || unit.getName() == unitNameUpgraded) && unit.getNumDiceRollsSpaceCombat()!=0){
                        unit.setNumDiceRollsSpaceCombat(unit.getNumDiceRollsSpaceCombat()+1);
                    }
                }
                break;
            case GROUNDCOMBAT:
                for (Unit unit: unitArrayList){
                    if((unit.getName() == unitName || unit.getName() == unitNameUpgraded) && unit.getNumDiceRollsGroundCombat()!=0){
                        unit.setNumDiceRollsGroundCombat(unit.getNumDiceRollsGroundCombat()+1);
                    }
                }
                break;
        }
    }

    /**
     * adds to all units in this stage of combat
     * @param combatType the current stage of combat
     * @param addAmount amount added to the units hit values
     */
    public void changeHitValueOfAllUnits(CombatType combatType, int addAmount){
        switch (combatType){
            case AFB:
                for (Unit unit: unitArrayList){
                    if (unit.getHitValueAFB()!=0) {
                        unit.setHitValueAFB(unit.getHitValueAFB() + addAmount);
                    }
                }
                break;
            case BOMBARDMENT:
                for (Unit unit: unitArrayList){
                    if (unit.getHitValueBombardment()!=0) {
                        if (unit.getHitValueBombardment()!=0) {
                            unit.setHitValueBombardment(unit.getHitValueBombardment() + addAmount);
                        }
                    }
                }
                break;
            case SPACECANNON:
                for (Unit unit: unitArrayList){
                    if (unit.getHitValueSpaceCannon()!=0) {
                        unit.setHitValueSpaceCannon(unit.getHitValueSpaceCannon() + addAmount);
                    }
                }
                break;
            case SPACECOMBAT:
                for (Unit unit: unitArrayList){
                    if (unit.getHitValueSpaceCombat()!=0) {
                        unit.setHitValueSpaceCombat(unit.getHitValueSpaceCombat() + addAmount);
                    }
                }
                break;
            case GROUNDCOMBAT:
                for (Unit unit: unitArrayList){
                    if (unit.getHitValueGroundCombat()!=0) {
                        unit.setHitValueGroundCombat(unit.getHitValueGroundCombat() + addAmount);
                    }
                }
                break;
        }
    }

    /**
     * Modifies hit value of all units of a specific type in this stage of combat
     * @param combatType the current stage of combat
     * @param addAmount amount added to the units hit values
     * @param unitName name of unit
     * @param unitNameUpgraded name of upgraded unit
     */
    public void changeHitValueOfAllUnitsOfSpecificType(CombatType combatType, int addAmount, UnitName unitName, UnitName unitNameUpgraded){
        switch (combatType){
            case AFB:
                for (Unit unit: unitArrayList){
                    if((unit.getName() == unitName || unit.getName() == unitNameUpgraded) && unit.getHitValueAFB()!=0){
                        unit.setHitValueAFB(unit.getHitValueAFB()+addAmount);
                    }
                }
                break;
            case BOMBARDMENT:
                for (Unit unit: unitArrayList){
                    if((unit.getName() == unitName || unit.getName() == unitNameUpgraded) && unit.getHitValueBombardment()!=0){
                        unit.setHitValueBombardment(unit.getHitValueBombardment()+addAmount);
                    }
                }
                break;
            case SPACECANNON:
                for (Unit unit: unitArrayList){
                    if((unit.getName() == unitName || unit.getName() == unitNameUpgraded) && unit.getHitValueSpaceCannon()!=0){
                        unit.setHitValueSpaceCannon(unit.getHitValueSpaceCannon()+addAmount);
                    }
                }
                break;
            case SPACECOMBAT:
                for (Unit unit: unitArrayList){
                    if((unit.getName() == unitName || unit.getName() == unitNameUpgraded) && unit.getHitValueSpaceCombat()!=0){
                        unit.setHitValueSpaceCombat(unit.getHitValueSpaceCombat()+addAmount);
                    }
                }
                break;
            case GROUNDCOMBAT:
                for (Unit unit: unitArrayList){
                    if((unit.getName() == unitName || unit.getName() == unitNameUpgraded) && unit.getHitValueGroundCombat()!=0){
                        unit.setHitValueGroundCombat(unit.getHitValueGroundCombat()+addAmount);
                    }
                }
                break;
        }
    }


}
