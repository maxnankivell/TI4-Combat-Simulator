package sample;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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
        attackerFlagshipCB.getItems().add(1);
        defenderFlagshipCB.getItems().add(1);
        attackerWarSunCB.getItems().addAll(1, 2);
        defenderWarSunCB.getItems().addAll(1, 2);
        attackerDreadnoughtCB.getItems().addAll(1, 2, 3, 4, 5);
        defenderDreadnoughtCB.getItems().addAll(1, 2, 3, 4, 5);
        attackerCarrierCB.getItems().addAll(1, 2, 3, 4);
        defenderCarrierCB.getItems().addAll(1, 2, 3, 4);
        attackerCruiserCB.getItems().addAll(1, 2, 3, 4, 5, 6, 7, 8);
        defenderCruiserCB.getItems().addAll(1, 2, 3, 4, 5, 6, 7, 8);
        attackerDestroyerCB.getItems().addAll(1, 2, 3, 4, 5, 6, 7, 8);
        defenderDestroyerCB.getItems().addAll(1, 2, 3, 4, 5, 6, 7, 8);
        attackerFighterCB.getItems().addAll(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12);
        defenderFighterCB.getItems().addAll(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12);
        attackerMechCB.getItems().addAll(1, 2, 3, 4);
        defenderMechCB.getItems().addAll(1, 2, 3, 4);
        attackerInfantryCB.getItems().addAll(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12);
        defenderInfantryCB.getItems().addAll(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12);

        //Set ComboBox Prompts
        attackerFactionCB.setPromptText("Select Faction");
        defenderFactionCB.setPromptText("Select Faction");
        attackerFlagshipCB.setPromptText("0");
        defenderFlagshipCB.setPromptText("0");
        attackerWarSunCB.setPromptText("0");
        defenderWarSunCB.setPromptText("0");
        attackerDreadnoughtCB.setPromptText("0");
        defenderDreadnoughtCB.setPromptText("0");
        attackerCarrierCB.setPromptText("0");
        defenderCarrierCB.setPromptText("0");
        attackerCruiserCB.setPromptText("0");
        defenderCruiserCB.setPromptText("0");
        attackerDestroyerCB.setPromptText("0");
        defenderDestroyerCB.setPromptText("0");
        attackerFighterCB.setPromptText("0");
        defenderFighterCB.setPromptText("0");
        attackerMechCB.setPromptText("0");
        defenderMechCB.setPromptText("0");
        attackerInfantryCB.setPromptText("0");
        defenderInfantryCB.setPromptText("0");

        //Set Infantry and fighter box's to be editable
        attackerFighterCB.setEditable(true);
        defenderFighterCB.setEditable(true);
        attackerInfantryCB.setEditable(true);
        defenderInfantryCB.setEditable(true);

        //Style ComboBox's
        attackerFlagshipCB.setPrefWidth(60);
        defenderFlagshipCB.setPrefWidth(60);
        attackerWarSunCB.setPrefWidth(60);
        defenderWarSunCB.setPrefWidth(60);
        attackerDreadnoughtCB.setPrefWidth(60);
        defenderDreadnoughtCB.setPrefWidth(60);
        attackerCarrierCB.setPrefWidth(60);
        defenderCarrierCB.setPrefWidth(60);
        attackerCruiserCB.setPrefWidth(60);
        defenderCruiserCB.setPrefWidth(60);
        attackerDestroyerCB.setPrefWidth(60);
        defenderDestroyerCB.setPrefWidth(60);
        attackerFighterCB.setPrefWidth(60);
        defenderFighterCB.setPrefWidth(60);
        attackerMechCB.setPrefWidth(60);
        defenderMechCB.setPrefWidth(60);
        attackerInfantryCB.setPrefWidth(60);
        defenderInfantryCB.setPrefWidth(60);

        //Style Button's
        spaceCannonOffenseBtn.setPrefWidth(150);
        spaceCombatBtn.setPrefWidth(150);
        bombardmentBtn.setPrefWidth(150);
        spaceCannonDefenseBtn.setPrefWidth(150);
        invasionCombatBtn.setPrefWidth(150);

        clearAttackerBtn.setPrefWidth(60);
        clearDefenderBtn.setPrefWidth(60);

        //Style Label's

        //Populate and style topBar
        topBar.getChildren().addAll(optionsBtn, helpBtn);
        topBar.setSpacing(2);

        //Populate and style bottomBar
        bottomBar.getChildren().addAll(
                spaceCannonOffenseBtn,
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

        GridPane.setConstraints(attackerLabel, 0, 0);
        GridPane.setConstraints(unitsLabel, 1, 0);
        GridPane.setConstraints(defenderLabel, 2, 0);
        GridPane.setConstraints(attackerFactionCB, 0, 1);
        GridPane.setConstraints(defenderFactionCB, 2, 1);
        GridPane.setConstraints(attackerFlagshipCB, 0, 2);
        GridPane.setConstraints(flagshipLabel, 1, 2);
        GridPane.setConstraints(defenderFlagshipCB, 2, 2);
        GridPane.setConstraints(attackerWarSunCB, 0, 3);
        GridPane.setConstraints(warSunLabel, 1, 3);
        GridPane.setConstraints(defenderWarSunCB, 2, 3);
        GridPane.setConstraints(attackerDreadnoughtCB, 0, 4);
        GridPane.setConstraints(dreadnoughtLabel, 1, 4);
        GridPane.setConstraints(defenderDreadnoughtCB, 2, 4);
        GridPane.setConstraints(attackerCarrierCB, 0, 5);
        GridPane.setConstraints(carrierLabel, 1, 5);
        GridPane.setConstraints(defenderCarrierCB, 2, 5);
        GridPane.setConstraints(attackerCruiserCB, 0, 6);
        GridPane.setConstraints(cruiserLabel, 1, 6);
        GridPane.setConstraints(defenderCruiserCB, 2, 6);
        GridPane.setConstraints(attackerDestroyerCB, 0, 7);
        GridPane.setConstraints(destroyerLabel, 1, 7);
        GridPane.setConstraints(defenderDestroyerCB, 2, 7);
        GridPane.setConstraints(attackerFighterCB, 0, 8);
        GridPane.setConstraints(fighterLabel, 1, 8);
        GridPane.setConstraints(defenderFighterCB, 2, 8);
        GridPane.setConstraints(attackerMechCB, 0, 9);
        GridPane.setConstraints(mechLabel, 1, 9);
        GridPane.setConstraints(defenderMechCB, 2, 9);
        GridPane.setConstraints(attackerInfantryCB, 0, 10);
        GridPane.setConstraints(infantryLabel, 1, 10);
        GridPane.setConstraints(defenderInfantryCB, 2, 10);
        GridPane.setConstraints(clearAttackerBtn, 0, 11);
        GridPane.setConstraints(clearDefenderBtn, 2, 11);

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
                clearAttackerBtn,
                clearDefenderBtn
        );

        //Populate and style Borderpane
        borderPane.setTop(topBar);
        borderPane.setCenter(gridPane);
        borderPane.setBottom(bottomBar);

        //Add the borderPane to a scene and show it
        Scene mainScene = new Scene(borderPane, 1024, 576);
        window.setScene(mainScene);
        window.setMaximized(true);
        window.show();
    }

}
