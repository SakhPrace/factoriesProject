package sample.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
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
@FxmlView("login.fxml")
public class LoginController {

    @FXML
    AnchorPane anchorPane;
    @FXML
    private Button buttonClose;
    @FXML
    private Button buttonFactoryOpenTest;
    @FXML
    private Button buttonTransporterOpenTest;
    @FXML
    private Button buttonLogin;
    @FXML
    private TextField textFieldUsername;
    @FXML
    private TextField textFieldPassword;
    @FXML
    private Label labelUsername;
    @FXML
    private Label labelPassword;

    @Autowired
    FactoryServiceInterface factoryService;

    @FXML
    private void buttonCloseOnAction(ActionEvent event) {
        Stage stage = (Stage) buttonClose.getScene().getWindow();
        stage.close();
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
    private void buttonLoginOnAction(ActionEvent event) {
    }

    @FXML
    private void initialize() {

    }

    public LoginController(){

    }
}
