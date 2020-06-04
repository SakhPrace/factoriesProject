package sample.controllers;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import net.rgielen.fxweaver.core.FxWeaver;
import net.rgielen.fxweaver.core.FxmlView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import sample.JavaFxApplication;
import sample.Security;
import sample.services.FactoryServiceInterface;
import sample.services.TransportOperatorServiceInterface;

@Component
@FxmlView("login.fxml")
public class LoginController {

    @FXML
    private AnchorPane anchorPane;
    @FXML
    private Button buttonClose;
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
    @FXML
    private RadioButton radioButtonFactory;
    @FXML
    private RadioButton radioButtonTransporter;

    @Autowired
    FactoryServiceInterface factoryService;

    @Autowired
    TransportOperatorServiceInterface transportOperatorService;

    @FXML
    private void buttonCloseOnAction(ActionEvent event) {
        Stage stage = (Stage) buttonClose.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void buttonLoginOnAction(ActionEvent event) {
        Security security = new Security();
        anchorPane.setDisable(true);
        if (radioButtonFactory.isSelected() && !radioButtonTransporter.isSelected()) {
            try {
                Boolean passwordCheck = security.passwordCheckForFactory(factoryService, textFieldUsername.getText(), textFieldPassword.getText());
                if (passwordCheck) {
                    FxWeaver fxWeaver = JavaFxApplication.getFxWeaver();
                    Parent root = fxWeaver.loadView(FactoryController.class);
                    Scene scene = new Scene(root);
                    Stage stage = new Stage();
                    stage.setScene(scene);
                    stage.setTitle(textFieldUsername.getText());
                    stage.show();
                    buttonCloseOnAction(new ActionEvent());
                } else {showAlertWithoutHeaderText(); }
            } catch (Exception e) {
                showAlertWithoutHeaderText();
                System.out.println(e.fillInStackTrace());
            }
        } else if(!radioButtonFactory.isSelected() && radioButtonTransporter.isSelected()) {
            try {
                Boolean passwordCheck = security.passwordCheckForTransporter(transportOperatorService, textFieldUsername.getText(), textFieldPassword.getText());
                if (passwordCheck) {
                    FxWeaver fxWeaver = JavaFxApplication.getFxWeaver();
                    Parent root = fxWeaver.loadView(TransporterController.class);
                    Scene scene = new Scene(root);
                    Stage stage = new Stage();
                    stage.setScene(scene);
                    stage.setTitle(textFieldUsername.getText());
                    stage.show();
                    buttonCloseOnAction(new ActionEvent());
                } else {showAlertWithoutHeaderText();}
            } catch (Exception e) {
                showAlertWithoutHeaderText();
                System.out.println(e.fillInStackTrace());
            }
        }

    }

    @FXML
    private void radioButtonFactoryOnAction(ActionEvent event) {
        radioButtonFactory.setSelected(true);
        radioButtonTransporter.setSelected(false);
    }

    @FXML
    private void radioButtonTransporterOnAction(ActionEvent event) {
        radioButtonFactory.setSelected(false);
        radioButtonTransporter.setSelected(true);
    }

    @FXML
    private void initialize() {

    }

    public LoginController(){

    }

    private void showAlertWithoutHeaderText() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Login Information");
        alert.setContentText("Incorrect Username or Password!");
        alert.showAndWait();
        anchorPane.setDisable(false);
    }
}