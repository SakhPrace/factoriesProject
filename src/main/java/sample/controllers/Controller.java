package sample.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import net.rgielen.fxweaver.core.FxWeaver;
import net.rgielen.fxweaver.core.FxmlView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import sample.JavaFxApplication;
import sample.entities.FactoryEntity;
import sample.services.FactoryService;
import sample.services.FactoryServiceInterface;


import java.beans.EventHandler;
import java.util.Optional;
@Component
@FxmlView("main.fxml")
public class Controller {

    @FXML
    AnchorPane anchorPane;
    @FXML
    private Button buttonClose;
    @FXML
    private ListView listView;
    @FXML
    private Button buttonFactoryOpenTest;
    @FXML
    private Button buttonTransporterOpenTest;

    @Autowired
    FactoryServiceInterface factoryService;

    @FXML
    private void buttonCloseOnAction(ActionEvent event) {
        System.out.println("Close");
        //stageMain.close();
    }

    @FXML
    private void buttonFactoryOpenTestOnAction(ActionEvent event){
        FxWeaver fxWeaver = JavaFxApplication.getFxWeaver();
        Parent root = fxWeaver.loadView(FactoryController.class);
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        buttonFactoryOpenTest.setDisable(true);
        stage.show();
    }

    @FXML
    private void buttonTransporterOpenTestOnAction(ActionEvent event) {
        FxWeaver fxWeaver = JavaFxApplication.getFxWeaver();
        Parent root = fxWeaver.loadView(TransporterController.class);
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        buttonTransporterOpenTest.setDisable(true);
        stage.show();
    }

    @FXML
    private void initialize() {

/*
        FactoryEntity factoryEntity = new FactoryEntity();
        factoryEntity.setId(0);
        factoryEntity.setName("AAA");
        factoryEntity.setExportid(0);
        factoryService.save(factoryEntity);

 */

        ObservableList<String> langs = FXCollections.observableArrayList();
        FactoryEntity factoryEntity1 = factoryService.findEntityById(Integer.valueOf(0));
        langs.add(factoryEntity1.getName());
        listView.setItems(langs);


    }

    public Controller(){

    }
}
