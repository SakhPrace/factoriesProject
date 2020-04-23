package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import sample.entities.FactoryEntity;
import sample.entityManegers.FactoryEntityManager;


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
    private ListView listView;

    @FXML
    private void buttonCloseOnAction(ActionEvent event) {
        System.out.println("Close");
        stageMain.close();
    }

    @FXML
    private void initialize() {
        ObservableList<String> langs = FXCollections.observableArrayList();
        FactoryEntity factoryEntity = FactoryEntityManager.loadById(0);
        langs.add(factoryEntity.getName());
        listView.setItems(langs);
    }

    public Controller(){
    }
}
