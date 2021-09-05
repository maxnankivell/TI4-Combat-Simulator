package GUIData;

/**
 * Class to store the state of all interactive GUI elements for the defender
 * So that they can be used by other classes in the program
 * The class is all static fields with getter and setter methods
 */
public class DefenderOptions {

    //unit upgrades
    private static boolean defenderFlagshipCheckBox = false;
    private static boolean defenderWarSunCheckBox = false;
    private static boolean defenderDreadnoughtCheckBox = false;
    private static boolean defenderCarrierCheckBox = false;
    private static boolean defenderCruiserCheckBox = false;
    private static boolean defenderDestroyerCheckBox = false;
    private static boolean defenderFighterCheckBox = false;
    private static boolean defenderMechCheckBox = false;
    private static boolean defenderInfantryCheckBox = false;
    private static boolean defenderPdsCheckBox = false;

    //options
    private static boolean plasmaScoringDefenderCheckbox = false;
    private static boolean magenDefenseGridDefenderCheckbox = false;
    private static boolean antimassDeflectorDefenderCheckbox = false;

    private static boolean strikeWingAmbushDefenderCheckbox = false;
    private static boolean warFundingDefenderCheckbox = false;
    private static boolean memoriaOneDefenderCheckbox = false;
    private static boolean memoriaTwoDefenderCheckbox = false;
    private static boolean tekklarLegionDefenderCheckbox = false;

    private static boolean baronyAgentDefenderCheckbox = false;
    private static boolean  solAgentDefenderCheckbox = false;

    private static boolean bunkerLabelDefenderCheckbox = false;
    private static boolean experimentalBattlestationDefenderCheckbox = false;
    private static boolean fighterPrototypeDefenderCheckbox = false;
    private static boolean fireTeamDefenderCheckbox = false;
    private static boolean moraleBoostDefenderCheckbox = false;
    private static boolean solarFlairDefenderCheckbox = false;

    private static boolean argentFlightCommanderDefenderCheckbox = false;
    private static boolean jolNarCommanderDefenderCheckbox = false;
    private static boolean l1Z1XCommanderDefenderCheckbox = false;
    private static boolean winnuCommanderDefenderCheckbox = false;

    private static boolean conventionsOfWarDefenderCheckbox = false;
    private static boolean prophecyOfIxthDefenderCheckbox = false;

    private static boolean defendingInNebulaDefenderCheckbox = false;
    private static boolean titansHeroDefenderCheckbox = false;

    //unit numbers
    private static FactionEnum defenderFactionCB;
    private static int defenderFlagshipCB = 0;
    private static int defenderWarSunCB = 0;
    private static int defenderDreadnoughtCB = 0;
    private static int defenderCarrierCB = 0;
    private static int defenderCruiserCB = 0;
    private static int defenderDestroyerCB = 0;
    private static int defenderFighterCB = 0;
    private static int defenderMechCB = 0;
    private static int defenderInfantryCB = 0;
    private static int defenderPdsCB = 0;

    private DefenderOptions() {
    }

    public static boolean isDefenderFlagshipCheckBox() {
        return defenderFlagshipCheckBox;
    }

    public static void setDefenderFlagshipCheckBox(boolean defenderFlagshipCheckBox) {
        DefenderOptions.defenderFlagshipCheckBox = defenderFlagshipCheckBox;
    }

    public static boolean isDefenderWarSunCheckBox() {
        return defenderWarSunCheckBox;
    }

    public static void setDefenderWarSunCheckBox(boolean defenderWarSunCheckBox) {
        DefenderOptions.defenderWarSunCheckBox = defenderWarSunCheckBox;
    }

    public static boolean isDefenderDreadnoughtCheckBox() {
        return defenderDreadnoughtCheckBox;
    }

    public static void setDefenderDreadnoughtCheckBox(boolean defenderDreadnoughtCheckBox) {
        DefenderOptions.defenderDreadnoughtCheckBox = defenderDreadnoughtCheckBox;
    }

    public static boolean isDefenderCarrierCheckBox() {
        return defenderCarrierCheckBox;
    }

    public static void setDefenderCarrierCheckBox(boolean defenderCarrierCheckBox) {
        DefenderOptions.defenderCarrierCheckBox = defenderCarrierCheckBox;
    }

    public static boolean isDefenderCruiserCheckBox() {
        return defenderCruiserCheckBox;
    }

    public static void setDefenderCruiserCheckBox(boolean defenderCruiserCheckBox) {
        DefenderOptions.defenderCruiserCheckBox = defenderCruiserCheckBox;
    }

    public static boolean isDefenderDestroyerCheckBox() {
        return defenderDestroyerCheckBox;
    }

    public static void setDefenderDestroyerCheckBox(boolean defenderDestroyerCheckBox) {
        DefenderOptions.defenderDestroyerCheckBox = defenderDestroyerCheckBox;
    }

    public static boolean isDefenderFighterCheckBox() {
        return defenderFighterCheckBox;
    }

    public static void setDefenderFighterCheckBox(boolean defenderFighterCheckBox) {
        DefenderOptions.defenderFighterCheckBox = defenderFighterCheckBox;
    }

    public static boolean isDefenderMechCheckBox() {
        return defenderMechCheckBox;
    }

    public static void setDefenderMechCheckBox(boolean defenderMechCheckBox) {
        DefenderOptions.defenderMechCheckBox = defenderMechCheckBox;
    }

    public static boolean isDefenderInfantryCheckBox() {
        return defenderInfantryCheckBox;
    }

    public static void setDefenderInfantryCheckBox(boolean defenderInfantryCheckBox) {
        DefenderOptions.defenderInfantryCheckBox = defenderInfantryCheckBox;
    }

    public static boolean isDefenderPdsCheckBox() {
        return defenderPdsCheckBox;
    }

    public static void setDefenderPdsCheckBox(boolean defenderPdsCheckBox) {
        DefenderOptions.defenderPdsCheckBox = defenderPdsCheckBox;
    }

    public static boolean isPlasmaScoringDefenderCheckbox() {
        return plasmaScoringDefenderCheckbox;
    }

    public static void setPlasmaScoringDefenderCheckbox(boolean plasmaScoringDefenderCheckbox) {
        DefenderOptions.plasmaScoringDefenderCheckbox = plasmaScoringDefenderCheckbox;
    }

    public static boolean isMagenDefenseGridDefenderCheckbox() {
        return magenDefenseGridDefenderCheckbox;
    }

    public static void setMagenDefenseGridDefenderCheckbox(boolean magenDefenseGridDefenderCheckbox) {
        DefenderOptions.magenDefenseGridDefenderCheckbox = magenDefenseGridDefenderCheckbox;
    }

    public static boolean isAntimassDeflectorDefenderCheckbox() {
        return antimassDeflectorDefenderCheckbox;
    }

    public static void setAntimassDeflectorDefenderCheckbox(boolean antimassDeflectorDefenderCheckbox) {
        DefenderOptions.antimassDeflectorDefenderCheckbox = antimassDeflectorDefenderCheckbox;
    }

    public static boolean isStrikeWingAmbushDefenderCheckbox() {
        return strikeWingAmbushDefenderCheckbox;
    }

    public static void setStrikeWingAmbushDefenderCheckbox(boolean strikeWingAmbushDefenderCheckbox) {
        DefenderOptions.strikeWingAmbushDefenderCheckbox = strikeWingAmbushDefenderCheckbox;
    }

    public static boolean isWarFundingDefenderCheckbox() {
        return warFundingDefenderCheckbox;
    }

    public static void setWarFundingDefenderCheckbox(boolean warFundingDefenderCheckbox) {
        DefenderOptions.warFundingDefenderCheckbox = warFundingDefenderCheckbox;
    }

    public static boolean isMemoriaOneDefenderCheckbox() {
        return memoriaOneDefenderCheckbox;
    }

    public static void setMemoriaOneDefenderCheckbox(boolean memoriaOneDefenderCheckbox) {
        DefenderOptions.memoriaOneDefenderCheckbox = memoriaOneDefenderCheckbox;
    }

    public static boolean isMemoriaTwoDefenderCheckbox() {
        return memoriaTwoDefenderCheckbox;
    }

    public static void setMemoriaTwoDefenderCheckbox(boolean memoriaTwoDefenderCheckbox) {
        DefenderOptions.memoriaTwoDefenderCheckbox = memoriaTwoDefenderCheckbox;
    }

    public static boolean isTekklarLegionDefenderCheckbox() {
        return tekklarLegionDefenderCheckbox;
    }

    public static void setTekklarLegionDefenderCheckbox(boolean tekklarLegionDefenderCheckbox) {
        DefenderOptions.tekklarLegionDefenderCheckbox = tekklarLegionDefenderCheckbox;
    }

    public static boolean isBaronyAgentDefenderCheckbox() {
        return baronyAgentDefenderCheckbox;
    }

    public static void setBaronyAgentDefenderCheckbox(boolean baronyAgentDefenderCheckbox) {
        DefenderOptions.baronyAgentDefenderCheckbox = baronyAgentDefenderCheckbox;
    }

    public static boolean isSolAgentDefenderCheckbox() {
        return solAgentDefenderCheckbox;
    }

    public static void setSolAgentDefenderCheckbox(boolean solAgentDefenderCheckbox) {
        DefenderOptions.solAgentDefenderCheckbox = solAgentDefenderCheckbox;
    }

    public static boolean isBunkerLabelDefenderCheckbox() {
        return bunkerLabelDefenderCheckbox;
    }

    public static void setBunkerLabelDefenderCheckbox(boolean bunkerLabelDefenderCheckbox) {
        DefenderOptions.bunkerLabelDefenderCheckbox = bunkerLabelDefenderCheckbox;
    }

    public static boolean isExperimentalBattlestationDefenderCheckbox() {
        return experimentalBattlestationDefenderCheckbox;
    }

    public static void setExperimentalBattlestationDefenderCheckbox(boolean experimentalBattlestationDefenderCheckbox) {
        DefenderOptions.experimentalBattlestationDefenderCheckbox = experimentalBattlestationDefenderCheckbox;
    }

    public static boolean isFighterPrototypeDefenderCheckbox() {
        return fighterPrototypeDefenderCheckbox;
    }

    public static void setFighterPrototypeDefenderCheckbox(boolean fighterPrototypeDefenderCheckbox) {
        DefenderOptions.fighterPrototypeDefenderCheckbox = fighterPrototypeDefenderCheckbox;
    }

    public static boolean isFireTeamDefenderCheckbox() {
        return fireTeamDefenderCheckbox;
    }

    public static void setFireTeamDefenderCheckbox(boolean fireTeamDefenderCheckbox) {
        DefenderOptions.fireTeamDefenderCheckbox = fireTeamDefenderCheckbox;
    }

    public static boolean isMoraleBoostDefenderCheckbox() {
        return moraleBoostDefenderCheckbox;
    }

    public static void setMoraleBoostDefenderCheckbox(boolean moraleBoostDefenderCheckbox) {
        DefenderOptions.moraleBoostDefenderCheckbox = moraleBoostDefenderCheckbox;
    }

    public static boolean isSolarFlairDefenderCheckbox() {
        return solarFlairDefenderCheckbox;
    }

    public static void setSolarFlairDefenderCheckbox(boolean solarFlairDefenderCheckbox) {
        DefenderOptions.solarFlairDefenderCheckbox = solarFlairDefenderCheckbox;
    }

    public static boolean isArgentFlightCommanderDefenderCheckbox() {
        return argentFlightCommanderDefenderCheckbox;
    }

    public static void setArgentFlightCommanderDefenderCheckbox(boolean argentFlightCommanderDefenderCheckbox) {
        DefenderOptions.argentFlightCommanderDefenderCheckbox = argentFlightCommanderDefenderCheckbox;
    }

    public static boolean isJolNarCommanderDefenderCheckbox() {
        return jolNarCommanderDefenderCheckbox;
    }

    public static void setJolNarCommanderDefenderCheckbox(boolean jolNarCommanderDefenderCheckbox) {
        DefenderOptions.jolNarCommanderDefenderCheckbox = jolNarCommanderDefenderCheckbox;
    }

    public static boolean isL1Z1XCommanderDefenderCheckbox() {
        return l1Z1XCommanderDefenderCheckbox;
    }

    public static void setL1Z1XCommanderDefenderCheckbox(boolean l1Z1XCommanderDefenderCheckbox) {
        DefenderOptions.l1Z1XCommanderDefenderCheckbox = l1Z1XCommanderDefenderCheckbox;
    }

    public static boolean isWinnuCommanderDefenderCheckbox() {
        return winnuCommanderDefenderCheckbox;
    }

    public static void setWinnuCommanderDefenderCheckbox(boolean winnuCommanderDefenderCheckbox) {
        DefenderOptions.winnuCommanderDefenderCheckbox = winnuCommanderDefenderCheckbox;
    }

    public static boolean isConventionsOfWarDefenderCheckbox() {
        return conventionsOfWarDefenderCheckbox;
    }

    public static void setConventionsOfWarDefenderCheckbox(boolean conventionsOfWarDefenderCheckbox) {
        DefenderOptions.conventionsOfWarDefenderCheckbox = conventionsOfWarDefenderCheckbox;
    }

    public static boolean isProphecyOfIxthDefenderCheckbox() {
        return prophecyOfIxthDefenderCheckbox;
    }

    public static void setProphecyOfIxthDefenderCheckbox(boolean prophecyOfIxthDefenderCheckbox) {
        DefenderOptions.prophecyOfIxthDefenderCheckbox = prophecyOfIxthDefenderCheckbox;
    }

    public static boolean isDefendingInNebulaDefenderCheckbox() {
        return defendingInNebulaDefenderCheckbox;
    }

    public static void setDefendingInNebulaDefenderCheckbox(boolean defendingInNebulaDefenderCheckbox) {
        DefenderOptions.defendingInNebulaDefenderCheckbox = defendingInNebulaDefenderCheckbox;
    }

    public static boolean isTitansHeroDefenderCheckbox() {
        return titansHeroDefenderCheckbox;
    }

    public static void setTitansHeroDefenderCheckbox(boolean titansHeroDefenderCheckbox) {
        DefenderOptions.titansHeroDefenderCheckbox = titansHeroDefenderCheckbox;
    }

    public static FactionEnum getDefenderFactionCB() {
        return defenderFactionCB;
    }

    public static void setDefenderFactionCB(FactionEnum defenderFactionCB) {
        DefenderOptions.defenderFactionCB = defenderFactionCB;
    }

    public static int getDefenderFlagshipCB() {
        return defenderFlagshipCB;
    }

    public static void setDefenderFlagshipCB(int defenderFlagshipCB) {
        DefenderOptions.defenderFlagshipCB = defenderFlagshipCB;
    }

    public static int getDefenderWarSunCB() {
        return defenderWarSunCB;
    }

    public static void setDefenderWarSunCB(int defenderWarSunCB) {
        DefenderOptions.defenderWarSunCB = defenderWarSunCB;
    }

    public static int getDefenderDreadnoughtCB() {
        return defenderDreadnoughtCB;
    }

    public static void setDefenderDreadnoughtCB(int defenderDreadnoughtCB) {
        DefenderOptions.defenderDreadnoughtCB = defenderDreadnoughtCB;
    }

    public static int getDefenderCarrierCB() {
        return defenderCarrierCB;
    }

    public static void setDefenderCarrierCB(int defenderCarrierCB) {
        DefenderOptions.defenderCarrierCB = defenderCarrierCB;
    }

    public static int getDefenderCruiserCB() {
        return defenderCruiserCB;
    }

    public static void setDefenderCruiserCB(int defenderCruiserCB) {
        DefenderOptions.defenderCruiserCB = defenderCruiserCB;
    }

    public static int getDefenderDestroyerCB() {
        return defenderDestroyerCB;
    }

    public static void setDefenderDestroyerCB(int defenderDestroyerCB) {
        DefenderOptions.defenderDestroyerCB = defenderDestroyerCB;
    }

    public static int getDefenderFighterCB() {
        return defenderFighterCB;
    }

    public static void setDefenderFighterCB(int defenderFighterCB) {
        DefenderOptions.defenderFighterCB = defenderFighterCB;
    }

    public static int getDefenderMechCB() {
        return defenderMechCB;
    }

    public static void setDefenderMechCB(int defenderMechCB) {
        DefenderOptions.defenderMechCB = defenderMechCB;
    }

    public static int getDefenderInfantryCB() {
        return defenderInfantryCB;
    }

    public static void setDefenderInfantryCB(int defenderInfantryCB) {
        DefenderOptions.defenderInfantryCB = defenderInfantryCB;
    }

    public static int getDefenderPdsCB() {
        return defenderPdsCB;
    }

    public static void setDefenderPdsCB(int defenderPdsCB) {
        DefenderOptions.defenderPdsCB = defenderPdsCB;
    }
}
