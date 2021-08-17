import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
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

        //Initialise other elements
        Button closeButton = new Button("Close");



        //Button actions
        closeButton.setOnAction(e -> window.close());

        Scene scene = new Scene(gridPane, 600, 600);
        window.setScene(scene);
        window.showAndWait();
    }
}
