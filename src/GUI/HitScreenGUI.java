package GUI;

import Player.Player;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * When this class is created it will make a popup GUI showing the amount of hits produced by a combat
 */
public class HitScreenGUI {

    private final int numHitsAttacker;
    private final int numHitsDefender;
    private final int numInfantryHitsAttacker;
    private final int numInfantryHitsDefender;
    private final int numSustainDamageHitsAttacker;
    private final int numSustainDamageHitsDefender;
    private final int numNonFighterHitsAttacker;
    private final int numNonFighterHitsDefender;

    public HitScreenGUI(Player attacker, Player defender) {
        this.numHitsAttacker = attacker.getNumHits();
        this.numHitsDefender = defender.getNumHits();
        this.numInfantryHitsAttacker = attacker.getNumInfantryHits();
        this.numInfantryHitsDefender = defender.getNumInfantryHits();
        this.numSustainDamageHitsAttacker = attacker.getNumSustainDamageHits();
        this.numSustainDamageHitsDefender = defender.getNumSustainDamageHits();
        this.numNonFighterHitsAttacker = attacker.getNumNonFighterHits();
        this.numNonFighterHitsDefender = defender.getNumNonFighterHits();

        buildGUI();
    }

    private void buildGUI(){
        Stage window = new Stage();

        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Hits");

        //Initialise elements
        Label numHitsAttackerLabel = new Label("Number of hits by the attacker: " + numHitsAttacker);
        Label numInfantryHitsAttackerLabel = new Label("Number of infantry hits by the attacker: " + numInfantryHitsAttacker);
        Label numSustainDamageHitsAttackerLabel = new Label("Number of sustain damage hits by the attacker: " + numSustainDamageHitsAttacker);
        Label numNonFighterHitsAttackerLabel = new Label("Number of non fighter hits by the attacker: " + numNonFighterHitsAttacker);

        Label numHitsDefenderLabel = new Label("Number of hits by the defender: " + numHitsDefender);
        Label numInfantryHitsDefenderLabel = new Label("Number of infantry hits by the defender: " + numInfantryHitsDefender);
        Label numSustainDamageHitsDefenderLabel = new Label("Number of sustain damage hits by the defender: " + numSustainDamageHitsDefender);
        Label numNonFighterHitsDefenderLabel = new Label("Number of non fighter hits by the defender: " + numNonFighterHitsDefender);

        Button closeButton = new Button("Close");

        //Style labels
        numHitsAttackerLabel.setFont(new Font("Arial", 14));
        numHitsAttackerLabel.setWrapText(true);
        numInfantryHitsAttackerLabel.setFont(new Font("Arial", 14));
        numInfantryHitsAttackerLabel.setWrapText(true);
        numSustainDamageHitsAttackerLabel.setFont(new Font("Arial", 14));
        numSustainDamageHitsAttackerLabel.setWrapText(true);
        numNonFighterHitsAttackerLabel.setFont(new Font("Arial", 14));
        numNonFighterHitsAttackerLabel.setWrapText(true);

        numHitsDefenderLabel.setFont(new Font("Arial", 14));
        numHitsDefenderLabel.setWrapText(true);
        numInfantryHitsDefenderLabel.setFont(new Font("Arial", 14));
        numInfantryHitsDefenderLabel.setWrapText(true);
        numSustainDamageHitsDefenderLabel.setFont(new Font("Arial", 14));
        numSustainDamageHitsDefenderLabel.setWrapText(true);
        numNonFighterHitsDefenderLabel.setFont(new Font("Arial", 14));
        numNonFighterHitsDefenderLabel.setWrapText(true);

        //Style buttons
        closeButton.setPrefWidth(80);
        closeButton.setPrefHeight(20);

        //Populate left vbox
        VBox vBoxLeft = new VBox(10);
        vBoxLeft.getChildren().addAll(numHitsAttackerLabel,
                numInfantryHitsAttackerLabel,
                numSustainDamageHitsAttackerLabel,
                numNonFighterHitsAttackerLabel
        );
        vBoxLeft.setAlignment(Pos.CENTER);

        //Populate right vbox
        VBox vBoxRight = new VBox(10);
        vBoxRight.getChildren().addAll(numHitsDefenderLabel,
                numInfantryHitsDefenderLabel,
                numSustainDamageHitsDefenderLabel,
                numNonFighterHitsDefenderLabel
        );
        vBoxRight.setAlignment(Pos.CENTER);

        //Populate sub layout
        HBox hBox = new HBox(40);
        hBox.getChildren().addAll(vBoxLeft, vBoxRight);
        hBox.setAlignment(Pos.CENTER);

        //Setup main layout
        BorderPane mainLayout = new BorderPane();
        mainLayout.setMinWidth(720);
        mainLayout.setMinHeight(240);
        mainLayout.setPadding(new Insets(20, 20, 20, 20));
        StackPane buttonPane = new StackPane(closeButton);
        mainLayout.setCenter(hBox);
        mainLayout.setBottom(buttonPane);

        //Button actions
        closeButton.setOnAction(e -> window.close());

        //Set scene and show window
        Scene scene = new Scene(mainLayout);
        window.setScene(scene);
        window.showAndWait();
    }
}
