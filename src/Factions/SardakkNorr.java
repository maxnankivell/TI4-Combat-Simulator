package Factions;

public class SardakkNorr extends Faction{

    public SardakkNorr() {
        //Flagship
        setFlagShipCombatValue(new int[][]{{2, 6},{2, 6}});
        //Special units
        setDreadnoughtBombardmentValue(new int[][]{{2, 4},{2, 4}});
        //Special abilities
        unrelenting();
    }

    private void unrelenting() {
        int[][] flag = getFlagShipCombatValue();
        setFlagShipCombatValue(new int[][]{{flag[0][0], flag[0][1]-1},{flag[1][0], flag[1][1]-1}});

        setWarSunCombatValue(new int[][]{{2, 6},{2, 6}});
        setDreadnoughtCombatValue(new int[][]{{2, 6},{2, 6}});
        setCarrierCombatValue(new int[][]{{2, 6},{2, 6}});
        setCruiserCombatValue(new int[][]{{2, 6},{2, 6}});
        setDestroyerCombatValue(new int[][]{{2, 6},{2, 6}});
        setFighterCombatValue(new int[][]{{2, 6},{2, 6}});
        setInfantryCombatValue(new int[][]{{2, 6},{2, 6}});
        setMechCombatValue(new int[][]{{2, 6},{2, 6}});

    }

}
