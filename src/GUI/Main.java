package GUI;

import Controllers.*;
import Factions.FactionEnum;
import GUIData.*;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.EnumMap;

/**
 * Main class will be in charge of the GUI for the main window
 */
public class Main extends Application {

    Stage window;

    CheckBox attackerFlagshipCheckBox;
    CheckBox defenderFlagshipCheckBox;
    CheckBox attackerDreadnoughtCheckBox;
    CheckBox defenderDreadnoughtCheckBox;
    CheckBox attackerCarrierCheckBox;
    CheckBox defenderCarrierCheckBox;
    CheckBox attackerCruiserCheckBox;
    CheckBox defenderCruiserCheckBox;
    CheckBox attackerDestroyerCheckBox;
    CheckBox defenderDestroyerCheckBox;
    CheckBox attackerFighterCheckBox;
    CheckBox defenderFighterCheckBox;
    CheckBox attackerInfantryCheckBox;
    CheckBox defenderInfantryCheckBox;
    CheckBox attackerPdsCheckBox;
    CheckBox defenderPdsCheckBox;

    ComboBox<Object> attackerFactionCB;
    ComboBox<Object> defenderFactionCB;
    ComboBox<Object> attackerFlagshipCB;
    ComboBox<Object> defenderFlagshipCB;
    ComboBox<Object> attackerWarSunCB;
    ComboBox<Object> defenderWarSunCB;
    ComboBox<Object> attackerDreadnoughtCB;
    ComboBox<Object> defenderDreadnoughtCB;
    ComboBox<Object> attackerCarrierCB;
    ComboBox<Object> defenderCarrierCB;
    ComboBox<Object> attackerCruiserCB;
    ComboBox<Object> defenderCruiserCB;
    ComboBox<Object> attackerDestroyerCB;
    ComboBox<Object> defenderDestroyerCB;
    ComboBox<Object> attackerFighterCB;
    ComboBox<Object> defenderFighterCB;
    ComboBox<Object> attackerMechCB;
    ComboBox<Object> defenderMechCB;
    ComboBox<Object> attackerInfantryCB;
    ComboBox<Object> defenderInfantryCB;
    ComboBox<Object> attackerPdsCB;
    ComboBox<Object> defenderPdsCB;

    Button spaceCannonOffenseBtn;
    Button antiFighterBarrageBtn;
    Button spaceCombatBtn;
    Button bombardmentBtn;
    Button spaceCannonDefenseBtn;
    Button groundCombatBtn;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        //Initialise GUIData
        GUIData.getInstance();;

        //Set stage to be called window and give title
        window = primaryStage;
        window.setTitle("Twilight Imperium 4 Combat Simulator");

        //Initialise layout elements
        BorderPane borderPane = new BorderPane();
        GridPane gridPane = new GridPane();
        HBox topBar = new HBox();
        VBox bottomBar = new VBox();

        //Initialise other elements
        Button optionsBtn = new Button("Options");
        Button helpBtn = new Button("Help");
        Button clearAttackerBtn = new Button("Clear");
        Button clearDefenderBtn = new Button("Clear");
        spaceCannonOffenseBtn = new Button("Space Cannon Offense");
        antiFighterBarrageBtn = new Button("Anti Fighter Barrage");
        spaceCombatBtn = new Button("Space Combat");
        bombardmentBtn = new Button("Bombardment");
        spaceCannonDefenseBtn = new Button("Space Cannon Defense");
        groundCombatBtn = new Button("Ground Combat");

        Label attackerLabel = new Label("Attacker");
        Label defenderLabel = new Label("Defender");
        Label unitsLabel = new Label("Units");
        Label flagshipLabel = new Label("Flagship");
        Label warSunLabel = new Label("Warsun");
        Label dreadnoughtLabel = new Label("Dreadnought");
        Label carrierLabel = new Label("Carrier");
        Label cruiserLabel = new Label("Cruiser");
        Label destroyerLabel = new Label("Destroyer");
        Label fighterLabel = new Label("Fighter");
        Label mechLabel = new Label("Mech");
        Label infantryLabel = new Label("Infantry");
        Label pdsLabel = new Label("PDS");

        attackerFlagshipCheckBox = new CheckBox();
        defenderFlagshipCheckBox = new CheckBox();
        attackerDreadnoughtCheckBox = new CheckBox();
        defenderDreadnoughtCheckBox = new CheckBox();
        attackerCarrierCheckBox = new CheckBox();
        defenderCarrierCheckBox = new CheckBox();
        attackerCruiserCheckBox = new CheckBox();
        defenderCruiserCheckBox = new CheckBox();
        attackerDestroyerCheckBox = new CheckBox();
        defenderDestroyerCheckBox = new CheckBox();
        attackerFighterCheckBox = new CheckBox();
        defenderFighterCheckBox = new CheckBox();
        attackerInfantryCheckBox = new CheckBox();
        defenderInfantryCheckBox = new CheckBox();
        attackerPdsCheckBox = new CheckBox();
        defenderPdsCheckBox = new CheckBox();

        attackerFactionCB = new ComboBox<>();
        defenderFactionCB = new ComboBox<>();
        attackerFlagshipCB = new ComboBox<>();
        defenderFlagshipCB = new ComboBox<>();
        attackerWarSunCB = new ComboBox<>();
        defenderWarSunCB = new ComboBox<>();
        attackerDreadnoughtCB = new ComboBox<>();
        defenderDreadnoughtCB = new ComboBox<>();
        attackerCarrierCB = new ComboBox<>();
        defenderCarrierCB = new ComboBox<>();
        attackerCruiserCB = new ComboBox<>();
        defenderCruiserCB = new ComboBox<>();
        attackerDestroyerCB = new ComboBox<>();
        defenderDestroyerCB = new ComboBox<>();
        attackerFighterCB = new ComboBox<>();
        defenderFighterCB = new ComboBox<>();
        attackerMechCB = new ComboBox<>();
        defenderMechCB = new ComboBox<>();
        attackerInfantryCB = new ComboBox<>();
        defenderInfantryCB = new ComboBox<>();
        attackerPdsCB = new ComboBox<>();
        defenderPdsCB = new ComboBox<>();

        //Populate Combo Box's
        attackerFactionCB.getItems().addAll(
                "Arborec",
                "Argent Flight",
                "Barony of Letnev",
                "Clan of Saar",
                "Creuss",
                "Empyrean",
                "Hacan",
                "Jol-Nar",
                "L1Z1x",
                "Mahact",
                "Mentak",
                "Muaat",
                "Naaz-Rokha",
                "Naalu",
                "Nekro",
                "Nomad",
                "Sardakk Norr",
                "Sol",
                "Titans of Ul",
                "Vuil'Raith",
                "Winnu",
                "Xxcha",
                "Yin",
                "Yssaril"
        );
        defenderFactionCB.getItems().addAll(
                "Arborec",
                "Argent Flight",
                "Barony of Letnev",
                "Clan of Saar",
                "Creuss",
                "Empyrean",
                "Hacan",
                "Jol-Nar",
                "L1Z1x",
                "Mahact",
                "Mentak",
                "Muaat",
                "Naaz-Rokha",
                "Naalu",
                "Nekro",
                "Nomad",
                "Sardakk Norr",
                "Sol",
                "Titans of Ul",
                "Vuil'Raith",
                "Winnu",
                "Xxcha",
                "Yin",
                "Yssaril"
        );
        attackerFlagshipCB.getItems().addAll(0, 1);
        defenderFlagshipCB.getItems().addAll(0, 1);
        attackerWarSunCB.getItems().addAll(0, 1, 2);
        defenderWarSunCB.getItems().addAll(0, 1, 2);
        attackerDreadnoughtCB.getItems().addAll(0, 1, 2, 3, 4, 5);
        defenderDreadnoughtCB.getItems().addAll(0, 1, 2, 3, 4, 5);
        attackerCarrierCB.getItems().addAll(0, 1, 2, 3, 4);
        defenderCarrierCB.getItems().addAll(0, 1, 2, 3, 4);
        attackerCruiserCB.getItems().addAll(0, 1, 2, 3, 4, 5, 6, 7, 8);
        defenderCruiserCB.getItems().addAll(0, 1, 2, 3, 4, 5, 6, 7, 8);
        attackerDestroyerCB.getItems().addAll(0, 1, 2, 3, 4, 5, 6, 7, 8);
        defenderDestroyerCB.getItems().addAll(0, 1, 2, 3, 4, 5, 6, 7, 8);
        attackerMechCB.getItems().addAll(0, 1, 2, 3, 4);
        defenderMechCB.getItems().addAll(0, 1, 2, 3, 4);
        attackerPdsCB.getItems().addAll(0, 1, 2, 3, 4, 5 ,6);
        defenderPdsCB.getItems().addAll(0, 1, 2, 3, 4, 5, 6);
        for(int i = 0; i < 100; i++) {
            attackerFighterCB.getItems().add(i);
            defenderFighterCB.getItems().add(i);
            attackerInfantryCB.getItems().add(i);
            defenderInfantryCB.getItems().add(i);
        }


        //Set ComboBox Prompts/Defaults
        attackerFactionCB.setPromptText("Select Faction");
        defenderFactionCB.setPromptText("Select Faction");

        attackerFlagshipCB.getSelectionModel().selectFirst();
        defenderFlagshipCB.getSelectionModel().selectFirst();
        attackerWarSunCB.getSelectionModel().selectFirst();
        defenderWarSunCB.getSelectionModel().selectFirst();
        attackerDreadnoughtCB.getSelectionModel().selectFirst();
        defenderDreadnoughtCB.getSelectionModel().selectFirst();
        attackerCarrierCB.getSelectionModel().selectFirst();
        defenderCarrierCB.getSelectionModel().selectFirst();
        attackerCruiserCB.getSelectionModel().selectFirst();
        defenderCruiserCB.getSelectionModel().selectFirst();
        attackerDestroyerCB.getSelectionModel().selectFirst();
        defenderDestroyerCB.getSelectionModel().selectFirst();
        attackerFighterCB.getSelectionModel().selectFirst();
        defenderFighterCB.getSelectionModel().selectFirst();
        attackerMechCB.getSelectionModel().selectFirst();
        defenderMechCB.getSelectionModel().selectFirst();
        attackerInfantryCB.getSelectionModel().selectFirst();
        defenderInfantryCB.getSelectionModel().selectFirst();
        attackerPdsCB.getSelectionModel().selectFirst();
        defenderPdsCB.getSelectionModel().selectFirst();

        //Style ComboBox's
        attackerFactionCB.setPrefWidth(125);
        defenderFactionCB.setPrefWidth(125);
        attackerFlagshipCB.setPrefWidth(125);
        defenderFlagshipCB.setPrefWidth(125);
        attackerWarSunCB.setPrefWidth(125);
        defenderWarSunCB.setPrefWidth(125);
        attackerDreadnoughtCB.setPrefWidth(125);
        defenderDreadnoughtCB.setPrefWidth(125);
        attackerCarrierCB.setPrefWidth(125);
        defenderCarrierCB.setPrefWidth(125);
        attackerCruiserCB.setPrefWidth(125);
        defenderCruiserCB.setPrefWidth(125);
        attackerDestroyerCB.setPrefWidth(125);
        defenderDestroyerCB.setPrefWidth(125);
        attackerFighterCB.setPrefWidth(125);
        defenderFighterCB.setPrefWidth(125);
        attackerMechCB.setPrefWidth(125);
        defenderMechCB.setPrefWidth(125);
        attackerInfantryCB.setPrefWidth(125);
        defenderInfantryCB.setPrefWidth(125);
        attackerPdsCB.setPrefWidth(125);
        defenderPdsCB.setPrefWidth(125);

        //Style Button's
        spaceCannonOffenseBtn.setPrefWidth(150);
        antiFighterBarrageBtn.setPrefWidth(150);
        spaceCombatBtn.setPrefWidth(150);
        bombardmentBtn.setPrefWidth(150);
        spaceCannonDefenseBtn.setPrefWidth(150);
        groundCombatBtn.setPrefWidth(150);

        clearAttackerBtn.setPrefWidth(125);
        clearDefenderBtn.setPrefWidth(125);

        //Style Label's

        //Populate and style topBar
        topBar.getChildren().addAll(optionsBtn, helpBtn);
        topBar.setSpacing(2);

        //Populate and style bottomBar
        bottomBar.getChildren().addAll(
                spaceCannonOffenseBtn,
                antiFighterBarrageBtn,
                spaceCombatBtn,
                bombardmentBtn,
                spaceCannonDefenseBtn,
                groundCombatBtn
        );
        bottomBar.setAlignment(Pos.CENTER);
        bottomBar.setSpacing(12);
        bottomBar.setPadding(new Insets(12, 0, 12, 0));

        //Populate and style gridPane
        gridPane.setVgap(4);
        gridPane.setHgap(20);
        gridPane.setAlignment(Pos.CENTER);

        GridPane.setConstraints(attackerLabel, 1, 0);
        GridPane.setConstraints(unitsLabel, 2, 0);
        GridPane.setConstraints(defenderLabel, 3, 0);
        GridPane.setConstraints(attackerFactionCB, 1, 1);
        GridPane.setConstraints(defenderFactionCB, 3, 1);
        GridPane.setConstraints(attackerFlagshipCB, 1, 2);
        GridPane.setConstraints(flagshipLabel, 2, 2);
        GridPane.setConstraints(defenderFlagshipCB, 3, 2);
        GridPane.setConstraints(attackerWarSunCB, 1, 3);
        GridPane.setConstraints(warSunLabel, 2, 3);
        GridPane.setConstraints(defenderWarSunCB, 3, 3);
        GridPane.setConstraints(attackerDreadnoughtCB, 1, 4);
        GridPane.setConstraints(dreadnoughtLabel, 2, 4);
        GridPane.setConstraints(defenderDreadnoughtCB, 3, 4);
        GridPane.setConstraints(attackerCarrierCB, 1, 5);
        GridPane.setConstraints(carrierLabel, 2, 5);
        GridPane.setConstraints(defenderCarrierCB, 3, 5);
        GridPane.setConstraints(attackerCruiserCB, 1, 6);
        GridPane.setConstraints(cruiserLabel, 2, 6);
        GridPane.setConstraints(defenderCruiserCB, 3, 6);
        GridPane.setConstraints(attackerDestroyerCB, 1, 7);
        GridPane.setConstraints(destroyerLabel, 2, 7);
        GridPane.setConstraints(defenderDestroyerCB, 3, 7);
        GridPane.setConstraints(attackerFighterCB, 1, 8);
        GridPane.setConstraints(fighterLabel, 2, 8);
        GridPane.setConstraints(defenderFighterCB, 3, 8);
        GridPane.setConstraints(attackerMechCB, 1, 9);
        GridPane.setConstraints(mechLabel, 2, 9);
        GridPane.setConstraints(defenderMechCB, 3, 9);
        GridPane.setConstraints(attackerInfantryCB, 1, 10);
        GridPane.setConstraints(infantryLabel, 2, 10);
        GridPane.setConstraints(defenderInfantryCB, 3, 10);
        GridPane.setConstraints(attackerPdsCB, 1, 11);
        GridPane.setConstraints(pdsLabel, 2, 11);
        GridPane.setConstraints(defenderPdsCB, 3, 11);
        GridPane.setConstraints(clearAttackerBtn, 1, 12);
        GridPane.setConstraints(clearDefenderBtn, 3, 12);

        GridPane.setConstraints(attackerFlagshipCheckBox, 0, 2);
        GridPane.setConstraints(attackerDreadnoughtCheckBox, 0, 4);
        GridPane.setConstraints(attackerCarrierCheckBox, 0, 5);
        GridPane.setConstraints(attackerCruiserCheckBox, 0, 6);
        GridPane.setConstraints(attackerDestroyerCheckBox, 0, 7);
        GridPane.setConstraints(attackerFighterCheckBox, 0, 8);
        GridPane.setConstraints(attackerInfantryCheckBox, 0, 10);
        GridPane.setConstraints(attackerPdsCheckBox, 0, 11);
        GridPane.setConstraints(defenderFlagshipCheckBox, 4, 2);
        GridPane.setConstraints(defenderDreadnoughtCheckBox, 4, 4);
        GridPane.setConstraints(defenderCarrierCheckBox, 4, 5);
        GridPane.setConstraints(defenderCruiserCheckBox, 4, 6);
        GridPane.setConstraints(defenderDestroyerCheckBox, 4, 7);
        GridPane.setConstraints(defenderFighterCheckBox, 4, 8);
        GridPane.setConstraints(defenderInfantryCheckBox, 4, 10);
        GridPane.setConstraints(defenderPdsCheckBox, 4, 11);

        gridPane.getChildren().addAll(
                attackerLabel,
                unitsLabel,
                defenderLabel,
                attackerFactionCB,
                defenderFactionCB,
                attackerFlagshipCB,
                flagshipLabel,
                defenderFlagshipCB,
                attackerWarSunCB,
                warSunLabel,
                defenderWarSunCB,
                attackerDreadnoughtCB,
                dreadnoughtLabel,
                defenderDreadnoughtCB,
                attackerCarrierCB,
                carrierLabel,
                defenderCarrierCB,
                attackerCruiserCB,
                cruiserLabel,
                defenderCruiserCB,
                attackerDestroyerCB,
                destroyerLabel,
                defenderDestroyerCB,
                attackerFighterCB,
                fighterLabel,
                defenderFighterCB,
                attackerMechCB,
                mechLabel,
                defenderMechCB,
                attackerInfantryCB,
                infantryLabel,
                defenderInfantryCB,
                attackerPdsCB,
                pdsLabel,
                defenderPdsCB,
                clearAttackerBtn,
                clearDefenderBtn,
                attackerFlagshipCheckBox,
                attackerDreadnoughtCheckBox,
                attackerCarrierCheckBox,
                attackerCruiserCheckBox,
                attackerDestroyerCheckBox,
                attackerFighterCheckBox,
                attackerInfantryCheckBox,
                attackerPdsCheckBox,
                defenderFlagshipCheckBox,
                defenderDreadnoughtCheckBox,
                defenderCarrierCheckBox,
                defenderCruiserCheckBox,
                defenderDestroyerCheckBox,
                defenderFighterCheckBox,
                defenderInfantryCheckBox,
                defenderPdsCheckBox
        );

        GridPane.setHalignment(unitsLabel, HPos.CENTER);
        GridPane.setHalignment(flagshipLabel, HPos.CENTER);
        GridPane.setHalignment(warSunLabel, HPos.CENTER);
        GridPane.setHalignment(dreadnoughtLabel, HPos.CENTER);
        GridPane.setHalignment(carrierLabel, HPos.CENTER);
        GridPane.setHalignment(cruiserLabel, HPos.CENTER);
        GridPane.setHalignment(destroyerLabel, HPos.CENTER);
        GridPane.setHalignment(fighterLabel, HPos.CENTER);
        GridPane.setHalignment(mechLabel, HPos.CENTER);
        GridPane.setHalignment(infantryLabel, HPos.CENTER);
        GridPane.setHalignment(pdsLabel, HPos.CENTER);

        //Populate and style Borderpane
        borderPane.setTop(topBar);
        borderPane.setCenter(gridPane);
        borderPane.setBottom(bottomBar);

        //Button Actions
        helpBtn.setOnAction(e -> new HelpScreenGUI());
        optionsBtn.setOnAction(e -> new OptionsScreenGUI());
        spaceCannonOffenseBtn.setOnAction(this::handleCombat);
        antiFighterBarrageBtn.setOnAction(this::handleCombat);
        spaceCombatBtn.setOnAction(this::handleCombat);
        bombardmentBtn.setOnAction(this::handleCombat);
        spaceCannonDefenseBtn.setOnAction(this::handleCombat);
        groundCombatBtn.setOnAction(this::handleCombat);
        clearAttackerBtn.setOnAction(e -> handleClearAttacker());
        clearDefenderBtn.setOnAction(e -> handleClearDefender());

        //Add the borderPane to a scene and show it
        Scene mainScene = new Scene(borderPane, 1152, 648);
        window.setScene(mainScene);
        window.setMaximized(true);
        window.show();
    }

    /**
     * Method to handle Ground Combat after the button is pressed
     * It will first check to make sure both factions are selected and all GUI values are saved
     * @param e
     */
    private void handleCombat(ActionEvent e) {
        if (attackerFactionCB.getSelectionModel().isEmpty() || defenderFactionCB.getSelectionModel().isEmpty()){
            return;
        }

        GUIData.getInstance().setAttackerFaction(updateAttackerFaction());
        GUIData.getInstance().setDefenderFaction(updateDefenderFaction());

        GUIData.getInstance().setAttackerUpgradeData(updateAttackerUpgrades());
        GUIData.getInstance().setDefenderUpgradeData(updateDefenderUpgrades());

        GUIData.getInstance().setAttackerUnitCountData(updateAttackerUnitCount());
        GUIData.getInstance().setDefenderUnitCountData(updateDefenderUnitCount());

        if (e.getSource() == antiFighterBarrageBtn) {
            AFBController controller = new AFBController();
            new HitScreenGUI(controller.getAttacker(), controller.getDefender());
        }
        if (e.getSource() == bombardmentBtn) {
            BombardmentController controller = new BombardmentController();
            new HitScreenGUI(controller.getAttacker(), controller.getDefender());
        }
        if (e.getSource() == spaceCannonOffenseBtn) {
            SpaceCannonOffenseController controller = new SpaceCannonOffenseController();
            new HitScreenGUI(controller.getAttacker(), controller.getDefender());
        }
        if (e.getSource() == spaceCannonDefenseBtn) {
            SpaceCannonDefenseController controller = new SpaceCannonDefenseController();
            new HitScreenGUI(controller.getAttacker(), controller.getDefender());
        }
        if (e.getSource() == spaceCombatBtn) {
            SpaceCombatController controller = new SpaceCombatController();
            new HitScreenGUI(controller.getAttacker(), controller.getDefender());
        }
        if (e.getSource() == groundCombatBtn) {
            GroundCombatController controller = new GroundCombatController();
            new HitScreenGUI(controller.getAttacker(), controller.getDefender());
        }

    }

    /**
     * Method to clear all unit amounts selected by the attacker after the button is pressed
     */
    private void handleClearAttacker() {

        attackerFlagshipCB.setValue(0);
        attackerWarSunCB.setValue(0);
        attackerDreadnoughtCB.setValue(0);
        attackerCarrierCB.setValue(0);
        attackerCruiserCB.setValue(0);
        attackerDestroyerCB.setValue(0);
        attackerFighterCB.setValue(0);
        attackerMechCB.setValue(0);
        attackerInfantryCB.setValue(0);
        attackerPdsCB.setValue(0);
    }

    /**
     * Method to clear all unit amounts selected by the defender after the button is pressed
     */
    private void handleClearDefender() {

        defenderFlagshipCB.setValue(0);
        defenderWarSunCB.setValue(0);
        defenderDreadnoughtCB.setValue(0);
        defenderCarrierCB.setValue(0);
        defenderCruiserCB.setValue(0);
        defenderDestroyerCB.setValue(0);
        defenderFighterCB.setValue(0);
        defenderMechCB.setValue(0);
        defenderInfantryCB.setValue(0);
        defenderPdsCB.setValue(0);
    }

    private FactionEnum updateAttackerFaction(){
        String attackerFactionName = (String) attackerFactionCB.getValue();
        attackerFactionName = attackerFactionName.replaceAll("[^a-zA-Z0-9]", "");
        attackerFactionName = attackerFactionName.toUpperCase();
        return FactionEnum.valueOf(attackerFactionName);
    }

    private FactionEnum updateDefenderFaction(){
        String defenderFactionName = (String) defenderFactionCB.getValue();
        defenderFactionName = defenderFactionName.replaceAll("[^a-zA-Z0-9]", "");
        defenderFactionName = defenderFactionName.toUpperCase();
        return FactionEnum.valueOf(defenderFactionName);
    }

    /**
     *
     */
    private EnumMap<UpgradeData, Boolean> updateAttackerUpgrades(){

        EnumMap<UpgradeData, Boolean> attackerUpgradeData = new EnumMap<>(UpgradeData.class);

        attackerUpgradeData.put(UpgradeData.ISFLAGSHIPUPGRADED, attackerFlagshipCheckBox.isSelected());
        attackerUpgradeData.put(UpgradeData.ISDREADNOUGHTUPGRADED, attackerDreadnoughtCheckBox.isSelected());
        attackerUpgradeData.put(UpgradeData.ISCARRIERUPGRADED, attackerCarrierCheckBox.isSelected());
        attackerUpgradeData.put(UpgradeData.ISCRUISERUPGRADED, attackerCruiserCheckBox.isSelected());
        attackerUpgradeData.put(UpgradeData.ISDESTROYERUPGRADED, attackerDestroyerCheckBox.isSelected());
        attackerUpgradeData.put(UpgradeData.ISFIGHTERUPGRADED, attackerFighterCheckBox.isSelected());
        attackerUpgradeData.put(UpgradeData.ISINFANTRYUPGRADED, attackerInfantryCheckBox.isSelected());
        attackerUpgradeData.put(UpgradeData.ISPDSUPGRADED, attackerPdsCheckBox.isSelected());

        return attackerUpgradeData;
    }

    /**
     *
     */
    private EnumMap<UpgradeData, Boolean> updateDefenderUpgrades(){

        EnumMap<UpgradeData, Boolean> defenderUpgradeData = new EnumMap<>(UpgradeData.class);

        defenderUpgradeData.put(UpgradeData.ISFLAGSHIPUPGRADED, defenderFlagshipCheckBox.isSelected());
        defenderUpgradeData.put(UpgradeData.ISDREADNOUGHTUPGRADED, defenderDreadnoughtCheckBox.isSelected());
        defenderUpgradeData.put(UpgradeData.ISCARRIERUPGRADED, defenderCarrierCheckBox.isSelected());
        defenderUpgradeData.put(UpgradeData.ISCRUISERUPGRADED, defenderCruiserCheckBox.isSelected());
        defenderUpgradeData.put(UpgradeData.ISDESTROYERUPGRADED, defenderDestroyerCheckBox.isSelected());
        defenderUpgradeData.put(UpgradeData.ISFIGHTERUPGRADED, defenderFighterCheckBox.isSelected());
        defenderUpgradeData.put(UpgradeData.ISINFANTRYUPGRADED, defenderInfantryCheckBox.isSelected());
        defenderUpgradeData.put(UpgradeData.ISPDSUPGRADED, defenderPdsCheckBox.isSelected());

        return defenderUpgradeData;
    }

    /**
     * Method to save the values of all comboboxs in the static options classes
     */
    private EnumMap<UnitCountData, Integer> updateAttackerUnitCount(){

        EnumMap<UnitCountData, Integer> attackerUnitCountData = new EnumMap<>(UnitCountData.class);

        attackerUnitCountData.put(UnitCountData.FLAGSHIPCOUNT, (Integer) attackerFlagshipCB.getValue());
        attackerUnitCountData.put(UnitCountData.WARSUNCOUNT, (Integer) attackerWarSunCB.getValue());
        attackerUnitCountData.put(UnitCountData.DREADNOUGHTCOUNT, (Integer) attackerDreadnoughtCB.getValue());
        attackerUnitCountData.put(UnitCountData.CARRIERCOUNT, (Integer) attackerCarrierCB.getValue());
        attackerUnitCountData.put(UnitCountData.CRUISERCOUNT, (Integer) attackerCruiserCB.getValue());
        attackerUnitCountData.put(UnitCountData.DESTROYERCOUNT, (Integer) attackerDestroyerCB.getValue());
        attackerUnitCountData.put(UnitCountData.FIGHTERCOUNT, (Integer) attackerFighterCB.getValue());
        attackerUnitCountData.put(UnitCountData.MECHCOUNT, (Integer) attackerMechCB.getValue());
        attackerUnitCountData.put(UnitCountData.INFANTRYCOUNT, (Integer) attackerInfantryCB.getValue());
        attackerUnitCountData.put(UnitCountData.PDSCOUNT, (Integer) attackerPdsCB.getValue());

        return attackerUnitCountData;
    }

    private EnumMap<UnitCountData, Integer> updateDefenderUnitCount(){

        EnumMap<UnitCountData, Integer> defenderUnitCountData = new EnumMap<>(UnitCountData.class);

        defenderUnitCountData.put(UnitCountData.FLAGSHIPCOUNT, (Integer) defenderFlagshipCB.getValue());
        defenderUnitCountData.put(UnitCountData.WARSUNCOUNT, (Integer) defenderWarSunCB.getValue());
        defenderUnitCountData.put(UnitCountData.DREADNOUGHTCOUNT, (Integer) defenderDreadnoughtCB.getValue());
        defenderUnitCountData.put(UnitCountData.CARRIERCOUNT, (Integer) defenderCarrierCB.getValue());
        defenderUnitCountData.put(UnitCountData.CRUISERCOUNT, (Integer) defenderCruiserCB.getValue());
        defenderUnitCountData.put(UnitCountData.DESTROYERCOUNT, (Integer) defenderDestroyerCB.getValue());
        defenderUnitCountData.put(UnitCountData.FIGHTERCOUNT, (Integer) defenderFighterCB.getValue());
        defenderUnitCountData.put(UnitCountData.MECHCOUNT, (Integer) defenderMechCB.getValue());
        defenderUnitCountData.put(UnitCountData.INFANTRYCOUNT, (Integer) defenderInfantryCB.getValue());
        defenderUnitCountData.put(UnitCountData.PDSCOUNT, (Integer) defenderPdsCB.getValue());

        return defenderUnitCountData;
    }

}
