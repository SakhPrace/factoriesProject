package sample.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import net.rgielen.fxweaver.core.FxWeaver;
import net.rgielen.fxweaver.core.FxmlView;
import org.springframework.stereotype.Component;
import sample.JavaFxApplication;


@Component
@FxmlView("transporter.fxml")
public class TransporterController {
    @FXML
    private AnchorPane anchorPane;
    @FXML
    private Button buttonShowOrders;
    @FXML
    private Button buttonShowAcceptedOrders;
    @FXML
    private Button buttonLogOut;
    @FXML
    private ListView listViewOrders;
    @FXML
    private Label labelOrders;

    @FXML
    private void buttonShowAcceptedOrdersOnAction(ActionEvent event) {

    }

    @FXML
    private void buttonShowOrdersOnAction(ActionEvent event) {

    }

    @FXML
    private void buttonLogOutOnAction(ActionEvent event) {
        anchorPane.setDisable(true);
        Stage stageThis = (Stage) buttonLogOut.getScene().getWindow();;
        FxWeaver fxWeaver = JavaFxApplication.getFxWeaver();
        Parent root = fxWeaver.loadView(LoginController.class);
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setTitle("Login");
        stage.setScene(scene);
        stage.show();
        stageThis.close();
    }

}
