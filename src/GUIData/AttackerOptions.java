package GUIData;

/**
 * Class to store the state of all interactive GUI elements for the attacker
 * So that they can be used by other classes in the program
 * The class is all static fields with getter and setter methods
 */
public class AttackerOptions {

    //upgrades
    private static boolean attackerFlagshipCheckBox = false;
    private static boolean attackerDreadnoughtCheckBox = false;
    private static boolean attackerCarrierCheckBox = false;
    private static boolean attackerCruiserCheckBox = false;
    private static boolean attackerDestroyerCheckBox = false;
    private static boolean attackerFighterCheckBox = false;
    private static boolean attackerInfantryCheckBox = false;
    private static boolean attackerPdsCheckBox = false;

    //options
    private static boolean plasmaScoringAttackerCheckbox = false;
    private static boolean x89BacterialWeaponAttackerCheckbox = false;
    private static boolean antimassDeflectorAttackerCheckbox = false;

    private static boolean strikeWingAmbushAttackerCheckbox = false;
    private static boolean warFundingAttackerCheckbox = false;
    private static boolean memoriaOneAttackerCheckbox = false;
    private static boolean memoriaTwoAttackerCheckbox = false;
    private static boolean tekklarLegionAttackerCheckbox = false;

    private static boolean baronyAgentAttackerCheckbox = false;
    private static boolean solAgentAttackerCheckbox = false;

    private static boolean disableLabelAttackerCheckbox = false;
    private static boolean fighterPrototypeAttackerCheckbox = false;
    private static boolean fireTeamAttackerCheckbox = false;
    private static boolean moraleBoostAttackerCheckbox = false;
    private static boolean blitzAttackerCheckbox = false;
    private static boolean solarFlairAttackerCheckbox = false;
    private static boolean argentFlightCommanderAttackerCheckbox = false;
    private static boolean jolNarCommanderAttackerCheckbox = false;
    private static boolean l1Z1XCommanderAttackerCheckbox = false;
    private static boolean winnuCommanderAttackerCheckbox = false;

    private static boolean prophecyOfIxthAttackerCheckbox = false;

    private static boolean titansHeroAttackerCheckbox = false;

    //unit numbers
    private static FactionEnum attackerFactionCB;
    private static int attackerFlagshipCB = 0;
    private static int attackerWarSunCB = 0;
    private static int attackerDreadnoughtCB = 0;
    private static int attackerCarrierCB = 0;
    private static int attackerCruiserCB = 0;
    private static int attackerDestroyerCB = 0;
    private static int attackerFighterCB = 0;
    private static int attackerMechCB = 0;
    private static int attackerInfantryCB = 0;
    private static int attackerPdsCB = 0;

    private AttackerOptions() {
    }

    public static boolean isAttackerFlagshipCheckBox() {
        return attackerFlagshipCheckBox;
    }

    public static void setAttackerFlagshipCheckBox(boolean attackerFlagshipCheckBox) {
        AttackerOptions.attackerFlagshipCheckBox = attackerFlagshipCheckBox;
    }

    public static boolean isAttackerDreadnoughtCheckBox() {
        return attackerDreadnoughtCheckBox;
    }

    public static void setAttackerDreadnoughtCheckBox(boolean attackerDreadnoughtCheckBox) {
        AttackerOptions.attackerDreadnoughtCheckBox = attackerDreadnoughtCheckBox;
    }

    public static boolean isAttackerCarrierCheckBox() {
        return attackerCarrierCheckBox;
    }

    public static void setAttackerCarrierCheckBox(boolean attackerCarrierCheckBox) {
        AttackerOptions.attackerCarrierCheckBox = attackerCarrierCheckBox;
    }

    public static boolean isAttackerCruiserCheckBox() {
        return attackerCruiserCheckBox;
    }

    public static void setAttackerCruiserCheckBox(boolean attackerCruiserCheckBox) {
        AttackerOptions.attackerCruiserCheckBox = attackerCruiserCheckBox;
    }

    public static boolean isAttackerDestroyerCheckBox() {
        return attackerDestroyerCheckBox;
    }

    public static void setAttackerDestroyerCheckBox(boolean attackerDestroyerCheckBox) {
        AttackerOptions.attackerDestroyerCheckBox = attackerDestroyerCheckBox;
    }

    public static boolean isAttackerFighterCheckBox() {
        return attackerFighterCheckBox;
    }

    public static void setAttackerFighterCheckBox(boolean attackerFighterCheckBox) {
        AttackerOptions.attackerFighterCheckBox = attackerFighterCheckBox;
    }

    public static boolean isAttackerInfantryCheckBox() {
        return attackerInfantryCheckBox;
    }

    public static void setAttackerInfantryCheckBox(boolean attackerInfantryCheckBox) {
        AttackerOptions.attackerInfantryCheckBox = attackerInfantryCheckBox;
    }

    public static boolean isAttackerPdsCheckBox() {
        return attackerPdsCheckBox;
    }

    public static void setAttackerPdsCheckBox(boolean attackerPdsCheckBox) {
        AttackerOptions.attackerPdsCheckBox = attackerPdsCheckBox;
    }

    public static boolean isPlasmaScoringAttackerCheckbox() {
        return plasmaScoringAttackerCheckbox;
    }

    public static void setPlasmaScoringAttackerCheckbox(boolean plasmaScoringAttackerCheckbox) {
        AttackerOptions.plasmaScoringAttackerCheckbox = plasmaScoringAttackerCheckbox;
    }

    public static boolean isX89BacterialWeaponAttackerCheckbox() {
        return x89BacterialWeaponAttackerCheckbox;
    }

    public static void setX89BacterialWeaponAttackerCheckbox(boolean x89BacterialWeaponAttackerCheckbox) {
        AttackerOptions.x89BacterialWeaponAttackerCheckbox = x89BacterialWeaponAttackerCheckbox;
    }

    public static boolean isAntimassDeflectorAttackerCheckbox() {
        return antimassDeflectorAttackerCheckbox;
    }

    public static void setAntimassDeflectorAttackerCheckbox(boolean antimassDeflectorAttackerCheckbox) {
        AttackerOptions.antimassDeflectorAttackerCheckbox = antimassDeflectorAttackerCheckbox;
    }

    public static boolean isStrikeWingAmbushAttackerCheckbox() {
        return strikeWingAmbushAttackerCheckbox;
    }

    public static void setStrikeWingAmbushAttackerCheckbox(boolean strikeWingAmbushAttackerCheckbox) {
        AttackerOptions.strikeWingAmbushAttackerCheckbox = strikeWingAmbushAttackerCheckbox;
    }

    public static boolean isWarFundingAttackerCheckbox() {
        return warFundingAttackerCheckbox;
    }

    public static void setWarFundingAttackerCheckbox(boolean warFundingAttackerCheckbox) {
        AttackerOptions.warFundingAttackerCheckbox = warFundingAttackerCheckbox;
    }

    public static boolean isMemoriaOneAttackerCheckbox() {
        return memoriaOneAttackerCheckbox;
    }

    public static void setMemoriaOneAttackerCheckbox(boolean memoriaOneAttackerCheckbox) {
        AttackerOptions.memoriaOneAttackerCheckbox = memoriaOneAttackerCheckbox;
    }

    public static boolean isMemoriaTwoAttackerCheckbox() {
        return memoriaTwoAttackerCheckbox;
    }

    public static void setMemoriaTwoAttackerCheckbox(boolean memoriaTwoAttackerCheckbox) {
        AttackerOptions.memoriaTwoAttackerCheckbox = memoriaTwoAttackerCheckbox;
    }

    public static boolean isTekklarLegionAttackerCheckbox() {
        return tekklarLegionAttackerCheckbox;
    }

    public static void setTekklarLegionAttackerCheckbox(boolean tekklarLegionAttackerCheckbox) {
        AttackerOptions.tekklarLegionAttackerCheckbox = tekklarLegionAttackerCheckbox;
    }

    public static boolean isBaronyAgentAttackerCheckbox() {
        return baronyAgentAttackerCheckbox;
    }

    public static void setBaronyAgentAttackerCheckbox(boolean baronyAgentAttackerCheckbox) {
        AttackerOptions.baronyAgentAttackerCheckbox = baronyAgentAttackerCheckbox;
    }

    public static boolean isSolAgentAttackerCheckbox() {
        return solAgentAttackerCheckbox;
    }

    public static void setSolAgentAttackerCheckbox(boolean solAgentAttackerCheckbox) {
        AttackerOptions.solAgentAttackerCheckbox = solAgentAttackerCheckbox;
    }

    public static boolean isDisableLabelAttackerCheckbox() {
        return disableLabelAttackerCheckbox;
    }

    public static void setDisableLabelAttackerCheckbox(boolean disableLabelAttackerCheckbox) {
        AttackerOptions.disableLabelAttackerCheckbox = disableLabelAttackerCheckbox;
    }

    public static boolean isFighterPrototypeAttackerCheckbox() {
        return fighterPrototypeAttackerCheckbox;
    }

    public static void setFighterPrototypeAttackerCheckbox(boolean fighterPrototypeAttackerCheckbox) {
        AttackerOptions.fighterPrototypeAttackerCheckbox = fighterPrototypeAttackerCheckbox;
    }

    public static boolean isFireTeamAttackerCheckbox() {
        return fireTeamAttackerCheckbox;
    }

    public static void setFireTeamAttackerCheckbox(boolean fireTeamAttackerCheckbox) {
        AttackerOptions.fireTeamAttackerCheckbox = fireTeamAttackerCheckbox;
    }

    public static boolean isMoraleBoostAttackerCheckbox() {
        return moraleBoostAttackerCheckbox;
    }

    public static void setMoraleBoostAttackerCheckbox(boolean moraleBoostAttackerCheckbox) {
        AttackerOptions.moraleBoostAttackerCheckbox = moraleBoostAttackerCheckbox;
    }

    public static boolean isBlitzAttackerCheckbox() {
        return blitzAttackerCheckbox;
    }

    public static void setBlitzAttackerCheckbox(boolean blitzAttackerCheckbox) {
        AttackerOptions.blitzAttackerCheckbox = blitzAttackerCheckbox;
    }

    public static boolean isSolarFlairAttackerCheckbox() {
        return solarFlairAttackerCheckbox;
    }

    public static void setSolarFlairAttackerCheckbox(boolean solarFlairAttackerCheckbox) {
        AttackerOptions.solarFlairAttackerCheckbox = solarFlairAttackerCheckbox;
    }

    public static boolean isArgentFlightCommanderAttackerCheckbox() {
        return argentFlightCommanderAttackerCheckbox;
    }

    public static void setArgentFlightCommanderAttackerCheckbox(boolean argentFlightCommanderAttackerCheckbox) {
        AttackerOptions.argentFlightCommanderAttackerCheckbox = argentFlightCommanderAttackerCheckbox;
    }

    public static boolean isJolNarCommanderAttackerCheckbox() {
        return jolNarCommanderAttackerCheckbox;
    }

    public static void setJolNarCommanderAttackerCheckbox(boolean jolNarCommanderAttackerCheckbox) {
        AttackerOptions.jolNarCommanderAttackerCheckbox = jolNarCommanderAttackerCheckbox;
    }

    public static boolean isL1Z1XCommanderAttackerCheckbox() {
        return l1Z1XCommanderAttackerCheckbox;
    }

    public static void setL1Z1XCommanderAttackerCheckbox(boolean l1Z1XCommanderAttackerCheckbox) {
        AttackerOptions.l1Z1XCommanderAttackerCheckbox = l1Z1XCommanderAttackerCheckbox;
    }

    public static boolean isWinnuCommanderAttackerCheckbox() {
        return winnuCommanderAttackerCheckbox;
    }

    public static void setWinnuCommanderAttackerCheckbox(boolean winnuCommanderAttackerCheckbox) {
        AttackerOptions.winnuCommanderAttackerCheckbox = winnuCommanderAttackerCheckbox;
    }

    public static boolean isProphecyOfIxthAttackerCheckbox() {
        return prophecyOfIxthAttackerCheckbox;
    }

    public static void setProphecyOfIxthAttackerCheckbox(boolean prophecyOfIxthAttackerCheckbox) {
        AttackerOptions.prophecyOfIxthAttackerCheckbox = prophecyOfIxthAttackerCheckbox;
    }

    public static boolean isTitansHeroAttackerCheckbox() {
        return titansHeroAttackerCheckbox;
    }

    public static void setTitansHeroAttackerCheckbox(boolean titansHeroAttackerCheckbox) {
        AttackerOptions.titansHeroAttackerCheckbox = titansHeroAttackerCheckbox;
    }

    public static FactionEnum getAttackerFactionCB() {
        return attackerFactionCB;
    }

    public static void setAttackerFactionCB(FactionEnum attackerFactionCB) {
        AttackerOptions.attackerFactionCB = attackerFactionCB;
    }

    public static int getAttackerFlagshipCB() {
        return attackerFlagshipCB;
    }

    public static void setAttackerFlagshipCB(int attackerFlagshipCB) {
        AttackerOptions.attackerFlagshipCB = attackerFlagshipCB;
    }

    public static int getAttackerWarSunCB() {
        return attackerWarSunCB;
    }

    public static void setAttackerWarSunCB(int attackerWarSunCB) {
        AttackerOptions.attackerWarSunCB = attackerWarSunCB;
    }

    public static int getAttackerDreadnoughtCB() {
        return attackerDreadnoughtCB;
    }

    public static void setAttackerDreadnoughtCB(int attackerDreadnoughtCB) {
        AttackerOptions.attackerDreadnoughtCB = attackerDreadnoughtCB;
    }

    public static int getAttackerCarrierCB() {
        return attackerCarrierCB;
    }

    public static void setAttackerCarrierCB(int attackerCarrierCB) {
        AttackerOptions.attackerCarrierCB = attackerCarrierCB;
    }

    public static int getAttackerCruiserCB() {
        return attackerCruiserCB;
    }

    public static void setAttackerCruiserCB(int attackerCruiserCB) {
        AttackerOptions.attackerCruiserCB = attackerCruiserCB;
    }

    public static int getAttackerDestroyerCB() {
        return attackerDestroyerCB;
    }

    public static void setAttackerDestroyerCB(int attackerDestroyerCB) {
        AttackerOptions.attackerDestroyerCB = attackerDestroyerCB;
    }

    public static int getAttackerFighterCB() {
        return attackerFighterCB;
    }

    public static void setAttackerFighterCB(int attackerFighterCB) {
        AttackerOptions.attackerFighterCB = attackerFighterCB;
    }

    public static int getAttackerMechCB() {
        return attackerMechCB;
    }

    public static void setAttackerMechCB(int attackerMechCB) {
        AttackerOptions.attackerMechCB = attackerMechCB;
    }

    public static int getAttackerInfantryCB() {
        return attackerInfantryCB;
    }

    public static void setAttackerInfantryCB(int attackerInfantryCB) {
        AttackerOptions.attackerInfantryCB = attackerInfantryCB;
    }

    public static int getAttackerPdsCB() {
        return attackerPdsCB;
    }

    public static void setAttackerPdsCB(int attackerPdsCB) {
        AttackerOptions.attackerPdsCB = attackerPdsCB;
    }
}
