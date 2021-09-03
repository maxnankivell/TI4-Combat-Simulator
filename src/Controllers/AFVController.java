package Controllers;

public class AFVController extends Controller{

    public AFVController(){
        super();
    }

    @Override
    public void startProcess() {
        //Strike wing ambush

        //Argent flight commander

        //Jol-Nar commander

        numHitsAttacker = hitCalculator(true);
        numHitsDefender = hitCalculator(false);
    }

}
