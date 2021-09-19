package Player;

public class Hits {

    protected int numHits;
    protected int numInfantryHits;
    protected int numSustainDamageHits;
    protected int numNonFighterHits;

    public Hits() {
        this.numHits = 0;
        this.numInfantryHits = 0;
        this.numSustainDamageHits = 0;
        this.numNonFighterHits = 0;
    }

    public void addNumHits(int numHits){
        this.numHits+=numHits;
    }

    public void addNumInfantryHits(int numInfantryHits){
        this.numInfantryHits+=numInfantryHits;
    }

    public void addNumSustainDamageHits(int numSustainDamageHits){
        this.numSustainDamageHits+=numSustainDamageHits;
    }

    public void addNumNonFighterHits(int numNonFighterHits){
        this.numNonFighterHits+=numNonFighterHits;
    }

    public int getNumHits() {
        return numHits;
    }

    public int getNumInfantryHits() {
        return numInfantryHits;
    }

    public int getNumSustainDamageHits() {
        return numSustainDamageHits;
    }

    public int getNumNonFighterHits() {
        return numNonFighterHits;
    }
}
