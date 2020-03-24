package sample;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.fxml.FXML;
import javafx.event.ActionEvent;


import java.beans.EventHandler;

public class Controller {
    @FXML
    private Stage stageMain;
    @FXML
    private AnchorPane anchorPaneMain;
    @FXML
    private Scene sceneMain;
    @FXML
    private Button buttonClose;

    @FXML
    private void buttonCloseOnAction (ActionEvent event) {
        System.out.println("Close");
        stageMain.close();
    }

    public Controller(){}
}
