package sample.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;
import net.rgielen.fxweaver.core.FxmlView;
import org.springframework.stereotype.Component;

@Component
@FxmlView("factory.fxml")
public class FactoryController {
    @FXML
    private AnchorPane anchorPane;
    @FXML
    private Button buttonShowEmployees;
    @FXML
    private Button buttonShowOrders;
    @FXML
    private Button buttonCreateOrder;
    @FXML
    private Label labelListView;
    @FXML
    private ListView listView;


    @FXML
    private void buttonShowEmployeesOnAction(ActionEvent event) {

    }

    @FXML
    private void buttonShowOrdersOnAction(ActionEvent event) {

    }

    @FXML
    private void buttonCreateOrderOnAction(ActionEvent event) {

    }

    @FXML
    private void listViewOnMouseClicked(ActionEvent event) {
        listView.getSelectionModel();
        System.out.println("Koko");
    }
}
