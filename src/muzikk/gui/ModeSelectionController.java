package muzikk.gui;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import muzikk.MuzikkGlobalInfo;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by filip on 2015-05-07.
 * Controls the ModeSelectionScreen
 */
public class ModeSelectionController implements Initializable {
    private Stage prevStage;
    private FXMLLoader myLoader;
    private Pane myPane;
    @FXML
    private Button singlePlayerButton;
    @FXML
    private Button multiPlayerButton;
    @FXML
    private Button backButton;

    public void setPrevStage(Stage stage){
        this.prevStage = stage;

    }


    @Override
    public void initialize(URL url, ResourceBundle rb){
        singlePlayerButton.setOnAction((event) -> goToSinglePlayer());

        multiPlayerButton.setOnAction((event) -> goToMultiPlayer());

        backButton.setOnAction((event)->backButtonPressed());

    }

    /**
     * Takes the user to the previous scene if the back button is pressed.
     */
    private void backButtonPressed(){
        LoginScreenController c = SceneLoader.loginScreenLoader.getController();
        c.initData();

        MuzikkGlobalInfo.globalStage.setScene(SceneLoader.loginScene);
    }

    /**
     * Takes the user to the singleplayer scene.
     */
    private void goToSinglePlayer(){
        singlePlayerScreenController spC=SceneLoader.spLoader.getController();
        spC.initData();
        spC.resetForms();
        MuzikkGlobalInfo.globalStage.setScene(SceneLoader.spScene);


    }

    /**
     * Takes the user to the multiplayer scene.
     */
    private void goToMultiPlayer(){
        multiPlayerScreenController mpC=SceneLoader.mpLoader.getController();
        mpC.initData();
        mpC.resetForms();
        MuzikkGlobalInfo.globalStage.setScene(SceneLoader.mpScene);
    }


}
