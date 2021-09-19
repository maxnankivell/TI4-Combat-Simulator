package GUI;

import GUIData.*;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.util.EnumMap;

/**
 * When this class is created it will make a popup GUI with all possible combat abilities
 */
public class OptionsScreenGUI {

    CheckBox plasmaScoringAttackerCheckbox;
    CheckBox plasmaScoringDefenderCheckbox;
    CheckBox magenDefenseGridDefenderCheckbox;
    CheckBox x89BacterialWeaponAttackerCheckbox;
    CheckBox antimassDeflectorAttackerCheckbox;
    CheckBox antimassDeflectorDefenderCheckbox;

    CheckBox strikeWingAmbushAttackerCheckbox;
    CheckBox strikeWingAmbushDefenderCheckbox;
    CheckBox warFundingAttackerCheckbox;
    CheckBox warFundingDefenderCheckbox;
    CheckBox memoriaOneAttackerCheckbox;
    CheckBox memoriaOneDefenderCheckbox;
    CheckBox memoriaTwoAttackerCheckbox;
    CheckBox memoriaTwoDefenderCheckbox;
    CheckBox tekklarLegionAttackerCheckbox;
    CheckBox tekklarLegionDefenderCheckbox;

    CheckBox baronyAgentAttackerCheckbox;
    CheckBox baronyAgentDefenderCheckbox;
    CheckBox solAgentAttackerCheckbox;
    CheckBox solAgentDefenderCheckbox;

    CheckBox bunkerLabelDefenderCheckbox;
    CheckBox disableLabelAttackerCheckbox;
    CheckBox experimentalBattlestationDefenderCheckbox;
    CheckBox fighterPrototypeAttackerCheckbox;
    CheckBox fighterPrototypeDefenderCheckbox;
    CheckBox fireTeamAttackerCheckbox;
    CheckBox fireTeamDefenderCheckbox;
    CheckBox moraleBoostAttackerCheckbox;
    CheckBox moraleBoostDefenderCheckbox;
    CheckBox blitzAttackerCheckbox;
    CheckBox solarFlairAttackerCheckbox;
    CheckBox solarFlairDefenderCheckbox;

    CheckBox argentFlightCommanderAttackerCheckbox;
    CheckBox argentFlightCommanderDefenderCheckbox;
    CheckBox jolNarCommanderAttackerCheckbox ;
    CheckBox jolNarCommanderDefenderCheckbox;
    CheckBox l1Z1XCommanderAttackerCheckbox;
    CheckBox l1Z1XCommanderDefenderCheckbox;
    CheckBox winnuCommanderAttackerCheckbox;
    CheckBox winnuCommanderDefenderCheckbox;

    CheckBox conventionsOfWarDefenderCheckbox;
    CheckBox prophecyOfIxthAttackerCheckbox;
    CheckBox prophecyOfIxthDefenderCheckbox;

    CheckBox defendingInNebulaDefenderCheckbox;
    CheckBox titansHeroAttackerCheckbox;
    CheckBox titansHeroDefenderCheckbox;

    /**
     * Constructor to build the GUI
     */
    public OptionsScreenGUI(){

        //Initialise window
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Options");

        //Initialise layout
        GridPane gridPane = new GridPane();
        BorderPane borderPane = new BorderPane();
        ScrollPane scrollPane = new ScrollPane(gridPane);
        StackPane stackPaneTop = new StackPane();
        StackPane stackPaneBottom = new StackPane();

        //Initialise other elements
        Label optionsLabel = new Label("Options");

        Label techLabel = new Label("Tech");
        Label plasmaScoringLabel = new Label("Plasma Scoring");
        Label magenDefenseGridLabel = new Label("Magen Defense Grid");
        Label x89BacterialWeaponLabel = new Label("X-89 Bacterial Weapon");
        Label antimassDeflectorLabel = new Label("Antimass Deflector");

        Label promissoryNoteLabel = new Label("Promissory Note");
        Label strikeWingAmbushLabel = new Label("Strike Wing Ambush");
        Label warFundingLabel = new Label("War Funding");
        Label memoriaOneLabel = new Label("Memoria 1");
        Label memoriaTwoLabel = new Label("Memoria 2");
        Label tekklarLegionLabel = new Label("Tekklar Legion");

        Label agentLabel = new Label("Agent");
        Label baronyAgentLabel = new Label("Barony Agent");
        Label solAgentLabel = new Label("Sol Agent");

        Label actionCardLabel = new Label("Action Cards");
        Label bunkerLabel = new Label("Bunker");
        Label disableLabel = new Label("Disable");
        Label experimentalBattlestationLabel = new Label("Experimental Battlestation");
        Label fighterPrototypeLabel = new Label("Fighter Prototype");
        Label fireTeamLabel = new Label("Fire Team");
        Label moraleBoostLabel = new Label("Morale Boost");
        Label blitzLabel = new Label("Blitz");
        Label solarFlairLabel = new Label("Solar Flair");

        Label commanderLabel = new Label("Commander");
        Label argentFlightCommanderLabel = new Label("Argent Flight Commander");
        Label jolNarCommanderLabel = new Label("Jol-Nar Commander");
        Label l1Z1XCommanderLabel = new Label("L1Z1X Commander");
        Label winnuCommanderLabel = new Label("Winnu Commander");

        Label agendaLabel = new Label("Agenda");
        Label prophecyOfIxthLabel = new Label("Prophecy Of Ixth");
        Label conventionsOfWarLabel = new Label("Conventions Of War");

        Label otherLabel = new Label("Other");
        Label defendingInNebulaLabel = new Label("Defending In Nebula");
        Label titansHeroLabel = new Label("Titans Hero");

        plasmaScoringAttackerCheckbox = new CheckBox();
        plasmaScoringDefenderCheckbox = new CheckBox();
        magenDefenseGridDefenderCheckbox = new CheckBox();
        x89BacterialWeaponAttackerCheckbox = new CheckBox();
        antimassDeflectorAttackerCheckbox = new CheckBox();
        antimassDeflectorDefenderCheckbox = new CheckBox();

        strikeWingAmbushAttackerCheckbox = new CheckBox();
        strikeWingAmbushDefenderCheckbox = new CheckBox();
        warFundingAttackerCheckbox = new CheckBox();
        warFundingDefenderCheckbox = new CheckBox();
        memoriaOneAttackerCheckbox = new CheckBox();
        memoriaOneDefenderCheckbox = new CheckBox();
        memoriaTwoAttackerCheckbox = new CheckBox();
        memoriaTwoDefenderCheckbox = new CheckBox();
        tekklarLegionAttackerCheckbox = new CheckBox();
        tekklarLegionDefenderCheckbox = new CheckBox();

        baronyAgentAttackerCheckbox = new CheckBox();
        baronyAgentDefenderCheckbox = new CheckBox();
        solAgentAttackerCheckbox = new CheckBox();
        solAgentDefenderCheckbox = new CheckBox();

        bunkerLabelDefenderCheckbox = new CheckBox();
        disableLabelAttackerCheckbox = new CheckBox();
        experimentalBattlestationDefenderCheckbox = new CheckBox();
        fighterPrototypeAttackerCheckbox = new CheckBox();
        fighterPrototypeDefenderCheckbox = new CheckBox();
        fireTeamAttackerCheckbox = new CheckBox();
        fireTeamDefenderCheckbox = new CheckBox();
        moraleBoostAttackerCheckbox = new CheckBox();
        moraleBoostDefenderCheckbox = new CheckBox();
        blitzAttackerCheckbox = new CheckBox();
        solarFlairAttackerCheckbox = new CheckBox();
        solarFlairDefenderCheckbox = new CheckBox();

        argentFlightCommanderAttackerCheckbox = new CheckBox();
        argentFlightCommanderDefenderCheckbox = new CheckBox();
        jolNarCommanderAttackerCheckbox = new CheckBox();
        jolNarCommanderDefenderCheckbox = new CheckBox();
        l1Z1XCommanderAttackerCheckbox = new CheckBox();
        l1Z1XCommanderDefenderCheckbox = new CheckBox();
        winnuCommanderAttackerCheckbox = new CheckBox();
        winnuCommanderDefenderCheckbox = new CheckBox();

        conventionsOfWarDefenderCheckbox = new CheckBox();
        prophecyOfIxthAttackerCheckbox = new CheckBox();
        prophecyOfIxthDefenderCheckbox = new CheckBox();

        defendingInNebulaDefenderCheckbox = new CheckBox();
        titansHeroAttackerCheckbox = new CheckBox();
        titansHeroDefenderCheckbox = new CheckBox();

        //populate checkboxs
        initialiseCheckBoxs();

        Button saveButton = new Button("Save");

        //Populate and style gridPane
        gridPane.setVgap(4);
        gridPane.setHgap(20);
        gridPane.setAlignment(Pos.CENTER);

        GridPane.setConstraints(techLabel, 1, 0);
        GridPane.setConstraints(plasmaScoringAttackerCheckbox, 0, 1);
        GridPane.setConstraints(plasmaScoringLabel, 1, 1);
        GridPane.setConstraints(plasmaScoringDefenderCheckbox, 2, 1);
        GridPane.setConstraints(magenDefenseGridLabel, 1, 2);
        GridPane.setConstraints(magenDefenseGridDefenderCheckbox, 2, 2);
        GridPane.setConstraints(x89BacterialWeaponAttackerCheckbox, 0, 3);
        GridPane.setConstraints(x89BacterialWeaponLabel, 1, 3);
        GridPane.setConstraints(antimassDeflectorAttackerCheckbox, 0, 4);
        GridPane.setConstraints(antimassDeflectorLabel, 1, 4);
        GridPane.setConstraints(antimassDeflectorDefenderCheckbox, 2, 4);

        GridPane.setConstraints(promissoryNoteLabel, 1, 5);
        GridPane.setConstraints(strikeWingAmbushAttackerCheckbox, 0, 6);
        GridPane.setConstraints(strikeWingAmbushLabel, 1, 6);
        GridPane.setConstraints(strikeWingAmbushDefenderCheckbox, 2, 6);
        GridPane.setConstraints(warFundingAttackerCheckbox, 0, 7);
        GridPane.setConstraints(warFundingLabel, 1, 7);
        GridPane.setConstraints(warFundingDefenderCheckbox, 2, 7);
        GridPane.setConstraints(memoriaOneAttackerCheckbox, 0, 8);
        GridPane.setConstraints(memoriaOneLabel, 1, 8);
        GridPane.setConstraints(memoriaOneDefenderCheckbox, 2, 8);
        GridPane.setConstraints(memoriaTwoAttackerCheckbox, 0, 9);
        GridPane.setConstraints(memoriaTwoLabel, 1, 9);
        GridPane.setConstraints(memoriaTwoDefenderCheckbox, 2, 9);
        GridPane.setConstraints(tekklarLegionAttackerCheckbox, 0, 10);
        GridPane.setConstraints(tekklarLegionLabel, 1, 10);
        GridPane.setConstraints(tekklarLegionDefenderCheckbox, 2, 10);

        GridPane.setConstraints(agentLabel, 1, 11);
        GridPane.setConstraints(baronyAgentAttackerCheckbox, 0, 12);
        GridPane.setConstraints(baronyAgentLabel, 1, 12);
        GridPane.setConstraints(baronyAgentDefenderCheckbox, 2, 12);
        GridPane.setConstraints(solAgentAttackerCheckbox, 0, 13);
        GridPane.setConstraints(solAgentLabel, 1, 13);
        GridPane.setConstraints(solAgentDefenderCheckbox, 2, 13);

        GridPane.setConstraints(actionCardLabel, 1, 14);
        GridPane.setConstraints(bunkerLabel, 1, 15);
        GridPane.setConstraints(bunkerLabelDefenderCheckbox, 2, 15);
        GridPane.setConstraints(disableLabelAttackerCheckbox, 0, 16);
        GridPane.setConstraints(disableLabel, 1, 16);
        GridPane.setConstraints(experimentalBattlestationLabel, 1, 17);
        GridPane.setConstraints(experimentalBattlestationDefenderCheckbox, 2, 17);
        GridPane.setConstraints(fighterPrototypeAttackerCheckbox, 0, 18);
        GridPane.setConstraints(fighterPrototypeLabel, 1, 18);
        GridPane.setConstraints(fighterPrototypeDefenderCheckbox, 2, 18);
        GridPane.setConstraints(fireTeamAttackerCheckbox, 0, 19);
        GridPane.setConstraints(fireTeamLabel, 1, 19);
        GridPane.setConstraints(fireTeamDefenderCheckbox, 2, 19);
        GridPane.setConstraints(moraleBoostAttackerCheckbox, 0, 20);
        GridPane.setConstraints(moraleBoostLabel, 1, 20);
        GridPane.setConstraints(moraleBoostDefenderCheckbox, 2, 20);
        GridPane.setConstraints(blitzAttackerCheckbox, 0, 21);
        GridPane.setConstraints(blitzLabel, 1, 21);
        GridPane.setConstraints(solarFlairAttackerCheckbox, 0, 22);
        GridPane.setConstraints(solarFlairLabel, 1, 22);
        GridPane.setConstraints(solarFlairDefenderCheckbox, 2, 22);

        GridPane.setConstraints(commanderLabel, 1, 23);
        GridPane.setConstraints(argentFlightCommanderAttackerCheckbox, 0, 24);
        GridPane.setConstraints(argentFlightCommanderLabel, 1, 24);
        GridPane.setConstraints(argentFlightCommanderDefenderCheckbox, 2, 24);
        GridPane.setConstraints(jolNarCommanderAttackerCheckbox, 0, 25);
        GridPane.setConstraints(jolNarCommanderLabel, 1, 25);
        GridPane.setConstraints(jolNarCommanderDefenderCheckbox, 2, 25);
        GridPane.setConstraints(l1Z1XCommanderAttackerCheckbox, 0, 26);
        GridPane.setConstraints(l1Z1XCommanderLabel, 1, 26);
        GridPane.setConstraints(l1Z1XCommanderDefenderCheckbox, 2, 26);
        GridPane.setConstraints(winnuCommanderAttackerCheckbox, 0, 27);
        GridPane.setConstraints(winnuCommanderLabel, 1, 27);
        GridPane.setConstraints(winnuCommanderDefenderCheckbox, 2, 27);

        GridPane.setConstraints(agendaLabel, 1, 28);
        GridPane.setConstraints(prophecyOfIxthAttackerCheckbox, 0, 29);
        GridPane.setConstraints(prophecyOfIxthLabel, 1, 29);
        GridPane.setConstraints(prophecyOfIxthDefenderCheckbox, 2, 29);
        GridPane.setConstraints(conventionsOfWarLabel, 1, 30);
        GridPane.setConstraints(conventionsOfWarDefenderCheckbox, 2, 30);

        GridPane.setConstraints(otherLabel, 1, 31);
        GridPane.setConstraints(defendingInNebulaLabel, 1, 32);
        GridPane.setConstraints(defendingInNebulaDefenderCheckbox, 2, 32);
        GridPane.setConstraints(titansHeroAttackerCheckbox, 0, 33);
        GridPane.setConstraints(titansHeroLabel, 1, 33);
        GridPane.setConstraints(titansHeroDefenderCheckbox, 2, 33);

        gridPane.getChildren().addAll(
                techLabel,
                plasmaScoringAttackerCheckbox,
                plasmaScoringLabel,
                plasmaScoringDefenderCheckbox,
                magenDefenseGridLabel,
                magenDefenseGridDefenderCheckbox,
                x89BacterialWeaponLabel,
                x89BacterialWeaponAttackerCheckbox,
                antimassDeflectorAttackerCheckbox,
                antimassDeflectorLabel,
                antimassDeflectorDefenderCheckbox,
                promissoryNoteLabel,
                strikeWingAmbushAttackerCheckbox,
                strikeWingAmbushLabel,
                strikeWingAmbushDefenderCheckbox,
                warFundingAttackerCheckbox,
                warFundingLabel,
                warFundingDefenderCheckbox,
                memoriaOneAttackerCheckbox,
                memoriaOneLabel,
                memoriaOneDefenderCheckbox,
                memoriaTwoAttackerCheckbox,
                memoriaTwoLabel,
                memoriaTwoDefenderCheckbox,
                tekklarLegionAttackerCheckbox,
                tekklarLegionLabel,
                tekklarLegionDefenderCheckbox,
                agentLabel,
                baronyAgentAttackerCheckbox,
                baronyAgentLabel,
                baronyAgentDefenderCheckbox,
                solAgentAttackerCheckbox,
                solAgentLabel,
                solAgentDefenderCheckbox,
                actionCardLabel,
                bunkerLabel,
                bunkerLabelDefenderCheckbox,
                disableLabelAttackerCheckbox,
                disableLabel,
                experimentalBattlestationLabel,
                experimentalBattlestationDefenderCheckbox,
                fighterPrototypeAttackerCheckbox,
                fighterPrototypeLabel,
                fighterPrototypeDefenderCheckbox,
                fireTeamAttackerCheckbox,
                fireTeamLabel,
                fireTeamDefenderCheckbox,
                moraleBoostAttackerCheckbox,
                moraleBoostLabel,
                moraleBoostDefenderCheckbox,
                blitzAttackerCheckbox,
                blitzLabel,
                solarFlairAttackerCheckbox,
                solarFlairLabel,
                solarFlairDefenderCheckbox,
                commanderLabel,
                argentFlightCommanderAttackerCheckbox,
                argentFlightCommanderLabel,
                argentFlightCommanderDefenderCheckbox,
                jolNarCommanderAttackerCheckbox,
                jolNarCommanderLabel,
                jolNarCommanderDefenderCheckbox,
                l1Z1XCommanderAttackerCheckbox,
                l1Z1XCommanderLabel,
                l1Z1XCommanderDefenderCheckbox,
                winnuCommanderAttackerCheckbox,
                winnuCommanderLabel,
                winnuCommanderDefenderCheckbox,
                agendaLabel,
                prophecyOfIxthAttackerCheckbox,
                prophecyOfIxthLabel,
                prophecyOfIxthDefenderCheckbox,
                conventionsOfWarLabel,
                conventionsOfWarDefenderCheckbox,
                otherLabel,
                defendingInNebulaLabel,
                defendingInNebulaDefenderCheckbox,
                titansHeroAttackerCheckbox,
                titansHeroLabel,
                titansHeroDefenderCheckbox
        );

        for (Node node:gridPane.getChildren()) {
            GridPane.setHalignment(node, HPos.CENTER);
        }

        //Style ScrollPane
        scrollPane.setFitToWidth(true);

        //Populate and style Borderpane
        stackPaneTop.getChildren().add(optionsLabel);
        stackPaneBottom.getChildren().add(saveButton);
        borderPane.setTop(stackPaneTop);
        borderPane.setCenter(scrollPane);
        borderPane.setBottom(stackPaneBottom);


        //Button actions
        saveButton.setOnAction(e -> {
            GUIData.getInstance().setAttackerOptionData(saveAttackerCheckBoxs());
            GUIData.getInstance().setDefenderOptionData(saveDefenderCheckBoxs());
            window.close();
        });

        //Set the scene and show the window
        Scene scene = new Scene(borderPane, 600, 600);
        window.setScene(scene);
        window.showAndWait();
    }

    /**
     * Method to save the values of all checkboxs in the static options classes
     */
    private EnumMap<OptionData, Boolean> saveAttackerCheckBoxs() {

        EnumMap<OptionData, Boolean> attackerOptionData = new EnumMap<>(OptionData.class);

        attackerOptionData.put(OptionData.PLASMASCORING, plasmaScoringAttackerCheckbox.isSelected());
        attackerOptionData.put(OptionData.X89BACTERIALWEAPON, x89BacterialWeaponAttackerCheckbox.isSelected());
        attackerOptionData.put(OptionData.ANTIMASSDEFLECTOR, antimassDeflectorAttackerCheckbox.isSelected());

        attackerOptionData.put(OptionData.STRIKEWINGAMBUSH, strikeWingAmbushAttackerCheckbox.isSelected());
        attackerOptionData.put(OptionData.WARFUNDING, warFundingAttackerCheckbox.isSelected());
        attackerOptionData.put(OptionData.MEMORIA1, memoriaOneAttackerCheckbox.isSelected());
        attackerOptionData.put(OptionData.MEMORIA2, memoriaTwoAttackerCheckbox.isSelected());
        attackerOptionData.put(OptionData.TEKKLARLEGION, tekklarLegionAttackerCheckbox.isSelected());

        attackerOptionData.put(OptionData.BARONYAGENT, baronyAgentAttackerCheckbox.isSelected());
        attackerOptionData.put(OptionData.SOLAGENT, solAgentAttackerCheckbox.isSelected());

        attackerOptionData.put(OptionData.DISABLE, disableLabelAttackerCheckbox.isSelected());
        attackerOptionData.put(OptionData.FIGHTERPROTOTYPE, fighterPrototypeAttackerCheckbox.isSelected());
        attackerOptionData.put(OptionData.FIRETEAM, fireTeamAttackerCheckbox.isSelected());
        attackerOptionData.put(OptionData.MORALEBOOST, moraleBoostAttackerCheckbox.isSelected());
        attackerOptionData.put(OptionData.BLITZ, blitzAttackerCheckbox.isSelected());
        attackerOptionData.put(OptionData.SOLARFLAIR, solarFlairAttackerCheckbox.isSelected());

        attackerOptionData.put(OptionData.ARGENTFLIGHTCOMMANDER, argentFlightCommanderAttackerCheckbox.isSelected());
        attackerOptionData.put(OptionData.JOLNARCOMMANDER, jolNarCommanderAttackerCheckbox.isSelected());
        attackerOptionData.put(OptionData.L1Z1XCOMMANDER, l1Z1XCommanderAttackerCheckbox.isSelected());
        attackerOptionData.put(OptionData.WINNUCOMMANDER, winnuCommanderAttackerCheckbox.isSelected());

        attackerOptionData.put(OptionData.PROPHECYOFIXTH, prophecyOfIxthAttackerCheckbox.isSelected());

        attackerOptionData.put(OptionData.TITANSHERO, titansHeroAttackerCheckbox.isSelected());

        return attackerOptionData;

    }

    /**
     * Method to save the values of all checkboxs in the static options classes
     */
    private EnumMap<OptionData, Boolean> saveDefenderCheckBoxs() {

        EnumMap<OptionData, Boolean> defenderOptionData = new EnumMap<>(OptionData.class);

        defenderOptionData.put(OptionData.PLASMASCORING,plasmaScoringDefenderCheckbox.isSelected());
        defenderOptionData.put(OptionData.MAGENDEFENSEGRID,magenDefenseGridDefenderCheckbox.isSelected());
        defenderOptionData.put(OptionData.ANTIMASSDEFLECTOR,antimassDeflectorDefenderCheckbox.isSelected());

        defenderOptionData.put(OptionData.STRIKEWINGAMBUSH,strikeWingAmbushDefenderCheckbox.isSelected());
        defenderOptionData.put(OptionData.WARFUNDING,warFundingDefenderCheckbox.isSelected());
        defenderOptionData.put(OptionData.MEMORIA1,memoriaOneDefenderCheckbox.isSelected());
        defenderOptionData.put(OptionData.MEMORIA2,memoriaTwoDefenderCheckbox.isSelected());
        defenderOptionData.put(OptionData.TEKKLARLEGION,tekklarLegionDefenderCheckbox.isSelected());

        defenderOptionData.put(OptionData.BARONYAGENT,baronyAgentDefenderCheckbox.isSelected());
        defenderOptionData.put(OptionData.SOLAGENT,solAgentDefenderCheckbox.isSelected());

        defenderOptionData.put(OptionData.BUNKER,bunkerLabelDefenderCheckbox.isSelected());
        defenderOptionData.put(OptionData.EXPERIMENTALBATTLESTATION,experimentalBattlestationDefenderCheckbox.isSelected());
        defenderOptionData.put(OptionData.FIGHTERPROTOTYPE,fighterPrototypeDefenderCheckbox.isSelected());
        defenderOptionData.put(OptionData.FIRETEAM,fireTeamDefenderCheckbox.isSelected());
        defenderOptionData.put(OptionData.MORALEBOOST,moraleBoostDefenderCheckbox.isSelected());
        defenderOptionData.put(OptionData.SOLARFLAIR,solarFlairDefenderCheckbox.isSelected());

        defenderOptionData.put(OptionData.ARGENTFLIGHTCOMMANDER,argentFlightCommanderDefenderCheckbox.isSelected());
        defenderOptionData.put(OptionData.JOLNARCOMMANDER,jolNarCommanderDefenderCheckbox.isSelected());
        defenderOptionData.put(OptionData.L1Z1XCOMMANDER,l1Z1XCommanderDefenderCheckbox.isSelected());
        defenderOptionData.put(OptionData.WINNUCOMMANDER,winnuCommanderDefenderCheckbox.isSelected());

        defenderOptionData.put(OptionData.CONVENTIONSOFWAR,conventionsOfWarDefenderCheckbox.isSelected());
        defenderOptionData.put(OptionData.PROPHECYOFIXTH,prophecyOfIxthDefenderCheckbox.isSelected());

        defenderOptionData.put(OptionData.DEFENDINGINNEBULA,defendingInNebulaDefenderCheckbox.isSelected());
        defenderOptionData.put(OptionData.TITANSHERO,titansHeroDefenderCheckbox.isSelected());

        return defenderOptionData;
    }

    /**
     * Method to initialise the values of all checkboxs from the information stored in the static options classes
     */
    private void initialiseCheckBoxs(){

        //attacker
        plasmaScoringAttackerCheckbox.setSelected(GUIData.getInstance().getAttackerOptionData().get(OptionData.PLASMASCORING));
        x89BacterialWeaponAttackerCheckbox.setSelected(GUIData.getInstance().getAttackerOptionData().get(OptionData.X89BACTERIALWEAPON));
        antimassDeflectorAttackerCheckbox.setSelected(GUIData.getInstance().getAttackerOptionData().get(OptionData.ANTIMASSDEFLECTOR));

        strikeWingAmbushAttackerCheckbox.setSelected(GUIData.getInstance().getAttackerOptionData().get(OptionData.STRIKEWINGAMBUSH));
        warFundingAttackerCheckbox.setSelected(GUIData.getInstance().getAttackerOptionData().get(OptionData.WARFUNDING));
        memoriaOneAttackerCheckbox.setSelected(GUIData.getInstance().getAttackerOptionData().get(OptionData.MEMORIA1));
        memoriaTwoAttackerCheckbox.setSelected(GUIData.getInstance().getAttackerOptionData().get(OptionData.MEMORIA2));
        tekklarLegionAttackerCheckbox.setSelected(GUIData.getInstance().getAttackerOptionData().get(OptionData.TEKKLARLEGION));

        baronyAgentAttackerCheckbox.setSelected(GUIData.getInstance().getAttackerOptionData().get(OptionData.BARONYAGENT));
        solAgentAttackerCheckbox.setSelected(GUIData.getInstance().getAttackerOptionData().get(OptionData.SOLAGENT));

        disableLabelAttackerCheckbox.setSelected(GUIData.getInstance().getAttackerOptionData().get(OptionData.DISABLE));
        fighterPrototypeAttackerCheckbox.setSelected(GUIData.getInstance().getAttackerOptionData().get(OptionData.FIGHTERPROTOTYPE));
        fireTeamAttackerCheckbox.setSelected(GUIData.getInstance().getAttackerOptionData().get(OptionData.FIRETEAM));
        moraleBoostAttackerCheckbox.setSelected(GUIData.getInstance().getAttackerOptionData().get(OptionData.MORALEBOOST));
        blitzAttackerCheckbox.setSelected(GUIData.getInstance().getAttackerOptionData().get(OptionData.BLITZ));
        solarFlairAttackerCheckbox.setSelected(GUIData.getInstance().getAttackerOptionData().get(OptionData.SOLARFLAIR));

        argentFlightCommanderAttackerCheckbox.setSelected(GUIData.getInstance().getAttackerOptionData().get(OptionData.ARGENTFLIGHTCOMMANDER));
        jolNarCommanderAttackerCheckbox.setSelected(GUIData.getInstance().getAttackerOptionData().get(OptionData.JOLNARCOMMANDER));
        l1Z1XCommanderAttackerCheckbox.setSelected(GUIData.getInstance().getAttackerOptionData().get(OptionData.L1Z1XCOMMANDER));
        winnuCommanderAttackerCheckbox.setSelected(GUIData.getInstance().getAttackerOptionData().get(OptionData.WINNUCOMMANDER));

        prophecyOfIxthAttackerCheckbox.setSelected(GUIData.getInstance().getAttackerOptionData().get(OptionData.PROPHECYOFIXTH));

        titansHeroAttackerCheckbox.setSelected(GUIData.getInstance().getAttackerOptionData().get(OptionData.TITANSHERO));

        //defender
        plasmaScoringDefenderCheckbox.setSelected(GUIData.getInstance().getDefenderOptionData().get(OptionData.PLASMASCORING));
        magenDefenseGridDefenderCheckbox.setSelected(GUIData.getInstance().getDefenderOptionData().get(OptionData.MAGENDEFENSEGRID));
        antimassDeflectorDefenderCheckbox.setSelected(GUIData.getInstance().getDefenderOptionData().get(OptionData.ANTIMASSDEFLECTOR));

        strikeWingAmbushDefenderCheckbox.setSelected(GUIData.getInstance().getDefenderOptionData().get(OptionData.STRIKEWINGAMBUSH));
        warFundingDefenderCheckbox.setSelected(GUIData.getInstance().getDefenderOptionData().get(OptionData.WARFUNDING));
        memoriaOneDefenderCheckbox.setSelected(GUIData.getInstance().getDefenderOptionData().get(OptionData.MEMORIA1));
        memoriaTwoDefenderCheckbox.setSelected(GUIData.getInstance().getDefenderOptionData().get(OptionData.MEMORIA2));
        tekklarLegionDefenderCheckbox.setSelected(GUIData.getInstance().getDefenderOptionData().get(OptionData.TEKKLARLEGION));

        baronyAgentDefenderCheckbox.setSelected(GUIData.getInstance().getDefenderOptionData().get(OptionData.BARONYAGENT));
        solAgentDefenderCheckbox.setSelected(GUIData.getInstance().getDefenderOptionData().get(OptionData.SOLAGENT));

        bunkerLabelDefenderCheckbox.setSelected(GUIData.getInstance().getDefenderOptionData().get(OptionData.BUNKER));
        experimentalBattlestationDefenderCheckbox.setSelected(GUIData.getInstance().getDefenderOptionData().get(OptionData.EXPERIMENTALBATTLESTATION));
        fighterPrototypeDefenderCheckbox.setSelected(GUIData.getInstance().getDefenderOptionData().get(OptionData.FIGHTERPROTOTYPE));
        fireTeamDefenderCheckbox.setSelected(GUIData.getInstance().getDefenderOptionData().get(OptionData.FIRETEAM));
        moraleBoostDefenderCheckbox.setSelected(GUIData.getInstance().getDefenderOptionData().get(OptionData.MORALEBOOST));
        solarFlairDefenderCheckbox.setSelected(GUIData.getInstance().getDefenderOptionData().get(OptionData.SOLARFLAIR));

        argentFlightCommanderDefenderCheckbox.setSelected(GUIData.getInstance().getDefenderOptionData().get(OptionData.ARGENTFLIGHTCOMMANDER));
        jolNarCommanderDefenderCheckbox.setSelected(GUIData.getInstance().getDefenderOptionData().get(OptionData.JOLNARCOMMANDER));
        l1Z1XCommanderDefenderCheckbox.setSelected(GUIData.getInstance().getDefenderOptionData().get(OptionData.L1Z1XCOMMANDER));
        winnuCommanderDefenderCheckbox.setSelected(GUIData.getInstance().getDefenderOptionData().get(OptionData.WINNUCOMMANDER));

        conventionsOfWarDefenderCheckbox.setSelected(GUIData.getInstance().getDefenderOptionData().get(OptionData.CONVENTIONSOFWAR));
        prophecyOfIxthDefenderCheckbox.setSelected(GUIData.getInstance().getDefenderOptionData().get(OptionData.PROPHECYOFIXTH));

        defendingInNebulaDefenderCheckbox.setSelected(GUIData.getInstance().getDefenderOptionData().get(OptionData.DEFENDINGINNEBULA));
        titansHeroDefenderCheckbox.setSelected(GUIData.getInstance().getDefenderOptionData().get(OptionData.TITANSHERO));

    }
}
