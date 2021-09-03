package Factions;

public abstract class Faction {

    //1st row un-upgraded, 2nd row upgraded
    //1st column num dice, 2nd column combat value
    protected int[][] flagShipCombatValue = {   {2, 7},
                                                {2, 7}};
    protected int[][] flagShipAFBValue = {  {0, 0},
                                            {0, 0}};
    protected int[][] flagShipSpaceCannonValue = {  {0, 0},
                                                    {0, 0}};
    protected int[][] flagShipBombardmentValue = {  {0, 0},
                                                    {0, 0}};
    protected int[][] warSunCombatValue = { {0, 0},
                                            {3, 3}};
    protected int[][] warSunBombardmentValue = {{0, 0},
                                                {3, 3}};
    protected int[][] dreadnoughtCombatValue = {{1, 5},
                                                {1, 5}};
    protected int[][] dreadnoughtBombardmentValue = {   {1, 5},
                                                        {1, 5}};
    protected int[][] carrierCombatValue = {{1, 9},
                                            {1, 9}};
    protected int[][] cruiserCombatValue = {{1, 7},
                                            {1, 6}};
    protected int[][] destroyerCombatValue = {  {1, 9},
                                                {1, 8}};
    protected int[][] destroyerAFBValue = { {2, 9},
                                            {3, 6}};
    protected int[][] fighterCombatValue = {{1, 9},
                                            {1, 8}};
    protected int[][] pdsCombatValue = {{0, 0},
                                        {0, 0}};
    protected int[][] pdsSpaceCannonValue = {   {1, 6},
                                                {1, 5}};
    protected int[][] infantryCombatValue = {   {1, 8},
                                                {1, 7}};
    protected int[][] mechCombatValue = {   {1, 6},
                                            {1, 6}};
    protected int[][] mechBombardmentValue = {  {0, 0},
                                                {0, 0}};
    protected int[][] mechSpaceCannonValue = {  {0, 0},
                                                {0, 0}};

    public int[][] getFlagShipCombatValue() {
        return flagShipCombatValue;
    }

    public int[][] getFlagShipAFBValue() {
        return flagShipAFBValue;
    }

    public int[][] getFlagShipSpaceCannonValue() {
        return flagShipSpaceCannonValue;
    }

    public int[][] getFlagShipBombardmentValue() {
        return flagShipBombardmentValue;
    }

    public int[][] getWarSunCombatValue() {
        return warSunCombatValue;
    }

    public int[][] getWarSunBombardmentValue() {
        return warSunBombardmentValue;
    }

    public int[][] getDreadnoughtCombatValue() {
        return dreadnoughtCombatValue;
    }

    public int[][] getDreadnoughtBombardmentValue() {
        return dreadnoughtBombardmentValue;
    }

    public int[][] getCarrierCombatValue() {
        return carrierCombatValue;
    }

    public int[][] getCruiserCombatValue() {
        return cruiserCombatValue;
    }

    public int[][] getDestroyerCombatValue() {
        return destroyerCombatValue;
    }

    public int[][] getDestroyerAFBValue() {
        return destroyerAFBValue;
    }

    public int[][] getFighterCombatValue() {
        return fighterCombatValue;
    }

    public int[][] getPdsCombatValue() {
        return pdsCombatValue;
    }

    public int[][] getPdsSpaceCannonValue() {
        return pdsSpaceCannonValue;
    }

    public int[][] getInfantryCombatValue() {
        return infantryCombatValue;
    }

    public int[][] getMechCombatValue() {
        return mechCombatValue;
    }

    public int[][] getMechBombardmentValue() {
        return mechBombardmentValue;
    }

    public int[][] getMechSpaceCannonValue() {
        return mechSpaceCannonValue;
    }

    public void setFlagShipCombatValue(int[][] flagShipCombatValue) {
        this.flagShipCombatValue = flagShipCombatValue;
    }

    public void setFlagShipAFBValue(int[][] flagShipAFBValue) {
        this.flagShipAFBValue = flagShipAFBValue;
    }

    public void setFlagShipSpaceCannonValue(int[][] flagShipSpaceCannonValue) {
        this.flagShipSpaceCannonValue = flagShipSpaceCannonValue;
    }

    public void setFlagShipBombardmentValue(int[][] flagShipBombardmentValue) {
        this.flagShipBombardmentValue = flagShipBombardmentValue;
    }

    public void setWarSunCombatValue(int[][] warSunCombatValue) {
        this.warSunCombatValue = warSunCombatValue;
    }

    public void setWarSunBombardmentValue(int[][] warSunBombardmentValue) {
        this.warSunBombardmentValue = warSunBombardmentValue;
    }

    public void setDreadnoughtCombatValue(int[][] dreadnoughtCombatValue) {
        this.dreadnoughtCombatValue = dreadnoughtCombatValue;
    }

    public void setDreadnoughtBombardmentValue(int[][] dreadnoughtBombardmentValue) {
        this.dreadnoughtBombardmentValue = dreadnoughtBombardmentValue;
    }

    public void setCarrierCombatValue(int[][] carrierCombatValue) {
        this.carrierCombatValue = carrierCombatValue;
    }

    public void setCruiserCombatValue(int[][] cruiserCombatValue) {
        this.cruiserCombatValue = cruiserCombatValue;
    }

    public void setDestroyerCombatValue(int[][] destroyerCombatValue) {
        this.destroyerCombatValue = destroyerCombatValue;
    }

    public void setDestroyerAFBValue(int[][] destroyerAFBValue) {
        this.destroyerAFBValue = destroyerAFBValue;
    }

    public void setFighterCombatValue(int[][] fighterCombatValue) {
        this.fighterCombatValue = fighterCombatValue;
    }

    public void setPdsCombatValue(int[][] pdsCombatValue) {
        this.pdsCombatValue = pdsCombatValue;
    }

    public void setPdsSpaceCannonValue(int[][] pdsSpaceCannonValue) {
        this.pdsSpaceCannonValue = pdsSpaceCannonValue;
    }

    public void setInfantryCombatValue(int[][] infantryCombatValue) {
        this.infantryCombatValue = infantryCombatValue;
    }

    public void setMechCombatValue(int[][] mechCombatValue) {
        this.mechCombatValue = mechCombatValue;
    }

    public void setMechBombardmentValue(int[][] mechBombardmentValue) {
        this.mechBombardmentValue = mechBombardmentValue;
    }

    public void setMechSpaceCannonValue(int[][] mechSpaceCannonValue) {
        this.mechSpaceCannonValue = mechSpaceCannonValue;
    }
}
