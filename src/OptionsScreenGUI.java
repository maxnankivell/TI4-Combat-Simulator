import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class OptionsScreenGUI {

    public OptionsScreenGUI(){

        //Initialise window
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Options");

        //Initialise layout
        GridPane gridPane = new GridPane();
        BorderPane borderPane = new BorderPane();

        //Initialise other elements
        Label optionsLabel = new Label("Options");

        Label techLabel = new Label("Tech");
        Label plasmaScoringLabel = new Label("Plasma Scoring");
        Label magenDefenseGridLabel = new Label("Magen Defense Grid");
        Label duraniumArmourLabel = new Label("Duranium Armour");
        Label assaultCannonLabel = new Label("Assault Cannon");
        Label x89BacterialWeaponLabel = new Label("X-89 Bacterial Weapon");
        Label antimassDeflectorLabel = new Label("Antimass Deflector");
        Label gravitonLaserSystemLabel = new Label("Graviton Laser System");
        Label factionSpecificLabel = new Label("Faction Specific");
        Label promissoryNoteLabel = new Label("Promissory Note");
        Label strikeWingAmbuscadeLabel = new Label("Strike Wing Ambuscade");



        CheckBox plasmaScoringAttackerCheckbox = new CheckBox();
        CheckBox plasmaScoringDefenderCheckbox = new CheckBox();
        CheckBox magenDefenseGridDefenderCheckbox = new CheckBox();
        CheckBox duraniumArmourAttackerCheckbox = new CheckBox();
        CheckBox duraniumArmourDefenderCheckbox = new CheckBox();
        CheckBox assaultCannonAttackerCheckbox = new CheckBox();
        CheckBox assaultCannonDefenderCheckbox = new CheckBox();
        CheckBox x89BacterialWeaponAttackerCheckbox = new CheckBox();
        CheckBox antimassDeflectorAttackerCheckbox = new CheckBox();
        CheckBox antimassDeflectorDefenderCheckbox = new CheckBox();
        CheckBox gravitonLaserSystemAttackerCheckbox = new CheckBox();
        CheckBox gravitonLaserSystemDefenderCheckbox = new CheckBox();


        Button closeButton = new Button("Close");

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
        GridPane.setConstraints(duraniumArmourAttackerCheckbox, 0, 3);
        GridPane.setConstraints(duraniumArmourLabel, 1, 3);
        GridPane.setConstraints(duraniumArmourDefenderCheckbox, 2, 3);
        GridPane.setConstraints(assaultCannonAttackerCheckbox, 0, 4);
        GridPane.setConstraints(assaultCannonLabel, 1, 4);
        GridPane.setConstraints(assaultCannonDefenderCheckbox, 2, 4);
        GridPane.setConstraints(x89BacterialWeaponAttackerCheckbox, 0, 5);
        GridPane.setConstraints(x89BacterialWeaponLabel, 1, 5);
        GridPane.setConstraints(antimassDeflectorAttackerCheckbox, 0, 6);
        GridPane.setConstraints(antimassDeflectorLabel, 1, 6);
        GridPane.setConstraints(antimassDeflectorDefenderCheckbox, 2, 6);
        GridPane.setConstraints(gravitonLaserSystemAttackerCheckbox, 0, 7);
        GridPane.setConstraints(gravitonLaserSystemLabel, 1, 7);
        GridPane.setConstraints(gravitonLaserSystemDefenderCheckbox, 2, 7);
        GridPane.setConstraints(factionSpecificLabel, 1, 8);
        GridPane.setConstraints(promissoryNoteLabel, 1, 9);

        gridPane.getChildren().addAll(
                techLabel,
                plasmaScoringAttackerCheckbox,
                plasmaScoringLabel,
                plasmaScoringDefenderCheckbox,
                magenDefenseGridLabel,
                magenDefenseGridDefenderCheckbox,
                duraniumArmourAttackerCheckbox,
                duraniumArmourLabel,
                duraniumArmourDefenderCheckbox,
                assaultCannonAttackerCheckbox,
                assaultCannonLabel,
                assaultCannonDefenderCheckbox,
                x89BacterialWeaponLabel,
                x89BacterialWeaponAttackerCheckbox,
                antimassDeflectorAttackerCheckbox,
                antimassDeflectorLabel,
                antimassDeflectorDefenderCheckbox,
                gravitonLaserSystemAttackerCheckbox,
                gravitonLaserSystemLabel,
                gravitonLaserSystemDefenderCheckbox,
                factionSpecificLabel,
                promissoryNoteLabel
        );

        GridPane.setHalignment(techLabel, HPos.CENTER);
        GridPane.setHalignment(plasmaScoringAttackerCheckbox, HPos.CENTER);
        GridPane.setHalignment(plasmaScoringLabel, HPos.CENTER);
        GridPane.setHalignment(plasmaScoringDefenderCheckbox, HPos.CENTER);
        GridPane.setHalignment(magenDefenseGridLabel, HPos.CENTER);
        GridPane.setHalignment(magenDefenseGridDefenderCheckbox, HPos.CENTER);
        GridPane.setHalignment(duraniumArmourAttackerCheckbox, HPos.CENTER);
        GridPane.setHalignment(duraniumArmourLabel, HPos.CENTER);
        GridPane.setHalignment(duraniumArmourDefenderCheckbox, HPos.CENTER);
        GridPane.setHalignment(assaultCannonAttackerCheckbox, HPos.CENTER);
        GridPane.setHalignment(assaultCannonLabel, HPos.CENTER);
        GridPane.setHalignment(assaultCannonDefenderCheckbox, HPos.CENTER);
        GridPane.setHalignment(x89BacterialWeaponLabel, HPos.CENTER);
        GridPane.setHalignment(x89BacterialWeaponAttackerCheckbox, HPos.CENTER);
        GridPane.setHalignment(antimassDeflectorAttackerCheckbox, HPos.CENTER);
        GridPane.setHalignment(antimassDeflectorLabel, HPos.CENTER);
        GridPane.setHalignment(antimassDeflectorDefenderCheckbox, HPos.CENTER);
        GridPane.setHalignment(gravitonLaserSystemAttackerCheckbox, HPos.CENTER);
        GridPane.setHalignment(gravitonLaserSystemLabel, HPos.CENTER);
        GridPane.setHalignment(gravitonLaserSystemDefenderCheckbox, HPos.CENTER);

        //Populate and style Borderpane
        borderPane.setTop(optionsLabel);
        borderPane.setCenter(gridPane);
        borderPane.setBottom(closeButton);

        //Button actions
        closeButton.setOnAction(e -> window.close());

        Scene scene = new Scene(borderPane, 600, 600);
        window.setScene(scene);
        window.showAndWait();
    }
}
