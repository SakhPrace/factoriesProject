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
@FxmlView("transporter.fxml")
public class TransporterController {
    @FXML
    private AnchorPane anchorPane;
    @FXML
    private Button buttonShowOrders;
    @FXML
    private Button buttonShowAcceptedOrders;
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


}
