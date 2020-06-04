package sample.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import net.rgielen.fxweaver.core.FxmlView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import sample.services.FactoryServiceInterface;
import sample.services.OrderingServiceInterface;
import sample.services.ProductServiceInterface;

@Component
@FxmlView("ordering.fxml")
public class Ordering {

    @FXML
    private AnchorPane anchorPane;
    @FXML
    private Label labelMaterial;
    @FXML
    private Label labelCustomer;
    @FXML
    private Label labelTransporter;

    @Autowired
    FactoryServiceInterface factoryService;

    @Autowired
    OrderingServiceInterface orderingService;

    @Autowired
    ProductServiceInterface productService;

    @FXML
    private void initialize() {
        
    }
}
