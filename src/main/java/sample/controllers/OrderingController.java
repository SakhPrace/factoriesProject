package sample.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import net.rgielen.fxweaver.core.FxmlView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import sample.entities.AuctionEntity;
import sample.entities.FactoryEntity;
import sample.entities.OrderingEntity;
import sample.services.*;

import java.util.List;

@Component
@FxmlView("ordering.fxml")
public class OrderingController {
    @FXML
    private AnchorPane anchorPane;
    @FXML
    private Label labelMaterial;
    @FXML
    private Label labelCustomer;
    @FXML
    private Label labelTransporter;
    @FXML
    private Label labelPriceName;
    @FXML
    private Label labelPriceValue;
    @FXML
    private Button buttonAcceptOrder;
    @FXML
    private Button buttonDeleteOrder;

    @Autowired
    FactoryServiceInterface factoryService;

    @Autowired
    OrderingServiceInterface orderingService;

    @Autowired
    ProductServiceInterface productService;

    @Autowired
    TransportOperatorServiceInterface transportOperatorService;

    @Autowired
    AuctionServiceInterface auctionService;

    private Stage stageThis;

    private OrderingEntity orderingEntityThis;

    private AuctionEntity auctionEntityThis;

    private List<OrderingEntity> orderingEntities;

    private Boolean acceptedOrder;

    @FXML
    public void buttonAcceptOrderOnAction(ActionEvent event) {
        orderingEntityThis.setTransportOperatorByIdTransport(transportOperatorService.findEntityById(auctionEntityThis.getIdTransporter()));
        orderingEntityThis.setPrice(auctionEntityThis.getOfferedPrice());
        orderingService.save(orderingEntityThis);
        auctionService.deleteById(auctionEntityThis.getId());
        stageThis.close();
    }

    @FXML
    public void buttonDeleteOrderOnAction(ActionEvent event) {
        orderingService.deleteById(orderingEntityThis.getId());
        stageThis.close();
    }


    @FXML
    private void initialize() {
        anchorPane.sceneProperty().addListener((observableScene, oldScene, newScene) -> {
            if (oldScene == null && newScene != null) {
                // scene is set for the first time. Now its the time to listen stage changes.
                newScene.windowProperty().addListener((observableWindow, oldWindow, newWindow) -> {
                    if (oldWindow == null && newWindow != null) {
                        stageThis = (Stage) this.anchorPane.getScene().getWindow();
                        orderingEntityThis = orderingService.findEntityById(Integer.valueOf(stageThis.getTitle()));
                        stageThis.setTitle(orderingEntityThis.getProductByIdProduct().getName());
                        labelMaterial.setText(stageThis.getTitle());
                        labelCustomer.setText(orderingEntityThis.getFactoryByIdFactory().getName());
                        if (orderingEntityThis.getTransportOperatorByIdTransport() != null) {
                            acceptedOrder = true;
                            labelTransporter.setText(transportOperatorService.findEntityById(orderingEntityThis.getTransportOperatorByIdTransport().getId()).getName());
                            labelPriceName.setText("Price");
                            labelPriceValue.setText(String.valueOf(orderingEntityThis.getPrice()));
                            buttonAcceptOrder.setVisible(false);
                        } else {
                            acceptedOrder = false;
                            labelTransporter.setText("UNACCEPTED ORDER");
                            labelPriceName.setText("Bid Price");
                            auctionEntityThis = auctionService.findEntityByOrderId(orderingEntityThis.getId());
                            labelPriceValue.setText(String.valueOf(auctionEntityThis.getOfferedPrice()));
                        }
                        ((Stage) newWindow).maximizedProperty().addListener((a, b, c) -> {
                            if (c) {
                                System.out.println("I am maximized!");
                            }
                        });
                    }
                });
            }
        });
    }
}
