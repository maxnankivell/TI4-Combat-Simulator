package Units;

import java.util.ArrayList;

public class UnitList {
    private ArrayList<Unit> unitArrayList;

    public UnitList(){
        unitArrayList = new ArrayList<>();
    }

    /**
     * checks if any unit has a planetary shield
     * @return if any unit has a planetary shield
     */
    public boolean containsPlanetaryShield(){
        for (Unit unit : unitArrayList) {
            if(unit.isPlanetaryShield()){
                return true;
            }
        }
        return false;
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

    public void removeShips(){
        unitArrayList.removeIf(Unit::isShip);
    }

    public int size(){
        return unitArrayList.size();
    }

}
