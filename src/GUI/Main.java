package GUI;

import javafx.application.Application;
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

public class Main extends Application {

    Stage window;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

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
        Button spaceCannonOffenseBtn = new Button("Space Cannon Offense");
        Button antiFighterBarrageBtn = new Button("Anti Fighter Barrage");
        Button spaceCombatBtn = new Button("Space Combat");
        Button bombardmentBtn = new Button("Bombardment");
        Button spaceCannonDefenseBtn = new Button("Space Cannon Defense");
        Button invasionCombatBtn = new Button("Invasion Combat");

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

        CheckBox attackerFlagshipCheckBox = new CheckBox();
        CheckBox defenderFlagshipCheckBox = new CheckBox();
        CheckBox attackerWarSunCheckBox = new CheckBox();
        CheckBox defenderWarSunCheckBox = new CheckBox();
        CheckBox attackerDreadnoughtCheckBox = new CheckBox();
        CheckBox defenderDreadnoughtCheckBox = new CheckBox();
        CheckBox attackerCarrierCheckBox = new CheckBox();
        CheckBox defenderCarrierCheckBox = new CheckBox();
        CheckBox attackerCruiserCheckBox = new CheckBox();
        CheckBox defenderCruiserCheckBox = new CheckBox();
        CheckBox attackerDestroyerCheckBox = new CheckBox();
        CheckBox defenderDestroyerCheckBox = new CheckBox();
        CheckBox attackerFighterCheckBox = new CheckBox();
        CheckBox defenderFighterCheckBox = new CheckBox();
        CheckBox attackerMechCheckBox = new CheckBox();
        CheckBox defenderMechCheckBox = new CheckBox();
        CheckBox attackerInfantryCheckBox = new CheckBox();
        CheckBox defenderInfantryCheckBox = new CheckBox();
        CheckBox attackerPdsCheckBox = new CheckBox();
        CheckBox defenderPdsCheckBox = new CheckBox();

        ComboBox<Object> attackerFactionCB = new ComboBox<>();
        ComboBox<Object> defenderFactionCB = new ComboBox<>();
        ComboBox<Object> attackerFlagshipCB = new ComboBox<>();
        ComboBox<Object> defenderFlagshipCB = new ComboBox<>();
        ComboBox<Object> attackerWarSunCB = new ComboBox<>();
        ComboBox<Object> defenderWarSunCB = new ComboBox<>();
        ComboBox<Object> attackerDreadnoughtCB = new ComboBox<>();
        ComboBox<Object> defenderDreadnoughtCB = new ComboBox<>();
        ComboBox<Object> attackerCarrierCB = new ComboBox<>();
        ComboBox<Object> defenderCarrierCB = new ComboBox<>();
        ComboBox<Object> attackerCruiserCB = new ComboBox<>();
        ComboBox<Object> defenderCruiserCB = new ComboBox<>();
        ComboBox<Object> attackerDestroyerCB = new ComboBox<>();
        ComboBox<Object> defenderDestroyerCB = new ComboBox<>();
        ComboBox<Object> attackerFighterCB = new ComboBox<>();
        ComboBox<Object> defenderFighterCB = new ComboBox<>();
        ComboBox<Object> attackerMechCB = new ComboBox<>();
        ComboBox<Object> defenderMechCB = new ComboBox<>();
        ComboBox<Object> attackerInfantryCB = new ComboBox<>();
        ComboBox<Object> defenderInfantryCB = new ComboBox<>();
        ComboBox<Object> attackerPdsCB = new ComboBox<>();
        ComboBox<Object> defenderPdsCB = new ComboBox<>();

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
                "Titan of Ul",
                "Vuil'Raith"
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
                "Titan of Ul",
                "Vuil'Raith"
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
        invasionCombatBtn.setPrefWidth(150);

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
                invasionCombatBtn
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

        //adding checkboxs
        GridPane.setConstraints(attackerFlagshipCheckBox, 0, 2);
        GridPane.setConstraints(attackerWarSunCheckBox, 0, 3);
        GridPane.setConstraints(attackerDreadnoughtCheckBox, 0, 4);
        GridPane.setConstraints(attackerCarrierCheckBox, 0, 5);
        GridPane.setConstraints(attackerCruiserCheckBox, 0, 6);
        GridPane.setConstraints(attackerDestroyerCheckBox, 0, 7);
        GridPane.setConstraints(attackerFighterCheckBox, 0, 8);
        GridPane.setConstraints(attackerMechCheckBox, 0, 9);
        GridPane.setConstraints(attackerInfantryCheckBox, 0, 10);
        GridPane.setConstraints(attackerPdsCheckBox, 0, 11);
        GridPane.setConstraints(defenderFlagshipCheckBox, 4, 2);
        GridPane.setConstraints(defenderWarSunCheckBox, 4, 3);
        GridPane.setConstraints(defenderDreadnoughtCheckBox, 4, 4);
        GridPane.setConstraints(defenderCarrierCheckBox, 4, 5);
        GridPane.setConstraints(defenderCruiserCheckBox, 4, 6);
        GridPane.setConstraints(defenderDestroyerCheckBox, 4, 7);
        GridPane.setConstraints(defenderFighterCheckBox, 4, 8);
        GridPane.setConstraints(defenderMechCheckBox, 4, 9);
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
                attackerWarSunCheckBox,
                attackerDreadnoughtCheckBox,
                attackerCarrierCheckBox,
                attackerCruiserCheckBox,
                attackerDestroyerCheckBox,
                attackerFighterCheckBox,
                attackerMechCheckBox,
                attackerInfantryCheckBox,
                attackerPdsCheckBox,
                defenderFlagshipCheckBox,
                defenderWarSunCheckBox,
                defenderDreadnoughtCheckBox,
                defenderCarrierCheckBox,
                defenderCruiserCheckBox,
                defenderDestroyerCheckBox,
                defenderFighterCheckBox,
                defenderMechCheckBox,
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

        //Add the borderPane to a scene and show it
        Scene mainScene = new Scene(borderPane, 1024, 576);
        window.setScene(mainScene);
        window.setMaximized(true);
        window.show();
    }
}