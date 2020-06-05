package sample.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import sample.JavaFxApplication;
import sample.entities.FactoryEntity;
import sample.entities.OrderingEntity;
import sample.entities.TransportOperatorEntity;
import sample.services.*;

import java.util.ArrayList;
import java.util.List;


@Component
@FxmlView("transporter.fxml")
public class TransporterController {
    @FXML
    private AnchorPane anchorPane;
    @FXML
    private Button buttonLogOut;
    @FXML
    private ListView listViewAcceptedOrders;
    @FXML
    private ListView listViewUnacceptedOrders;
    @FXML
    private Label labelAcceptedOrders;
    @FXML
    private Label labelUnacceptedOrders;

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

    private ObservableList<String> forListViewAcceptedOrders = FXCollections.observableArrayList();

    private ObservableList<String> forListViewUnacceptedOrders = FXCollections.observableArrayList();

    private List<OrderingEntity> orderingEntitiesAccepted = new ArrayList<>();

    private List<OrderingEntity> orderingEntitiesUnaccepted = new ArrayList<>();

    private Stage stageThis;

    private TransportOperatorEntity transportOperatorEntityThis;

    private List<OrderingEntity> orderingEntities;

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

    private void updateListViewAcceptedOrders() {
        forListViewAcceptedOrders = FXCollections.observableArrayList();
        orderingEntitiesAccepted = new ArrayList<>();
        orderingEntities = orderingService.findEntitiesByFactoryIdWithTransport(transportOperatorEntityThis.getId());
        System.out.println("orderingEnteties count = " + orderingEntities.size());
        for (OrderingEntity orderingEntity : orderingEntities) {
            forListViewAcceptedOrders.add(String.valueOf(orderingEntity.getId()) + ". " + orderingEntity.getProductByIdProduct().getName());
            orderingEntitiesAccepted.add(orderingEntity);
        }
        listViewAcceptedOrders.setItems(forListViewAcceptedOrders);
    }

    private void updateListViewUnacceptedOrders() {
        orderingEntities = orderingService.findEntitiesByFactoryIdWithoutTransport(transportOperatorEntityThis.getId());
        forListViewUnacceptedOrders = FXCollections.observableArrayList();
        orderingEntitiesUnaccepted = new ArrayList<>();
        System.out.println("orderingEnteties count = " + orderingEntities.size());
        for (OrderingEntity orderingEntity : orderingEntities) {
            forListViewUnacceptedOrders.add(String.valueOf(orderingEntity.getId()) + ". " + orderingEntity.getProductByIdProduct().getName());
            orderingEntitiesUnaccepted.add(orderingEntity);
        }
        listViewUnacceptedOrders.setItems(forListViewUnacceptedOrders);
    }

    @FXML
    private void initialize() {
        anchorPane.sceneProperty().addListener((observableScene, oldScene, newScene) -> {
            if (oldScene == null && newScene != null) {
                // scene is set for the first time. Now its the time to listen stage changes.
                newScene.windowProperty().addListener((observableWindow, oldWindow, newWindow) -> {
                    if (oldWindow == null && newWindow != null) {
                        stageThis = (Stage) this.anchorPane.getScene().getWindow();
                        transportOperatorEntityThis = transportOperatorService.findEntityByName(stageThis.getTitle());
                        updateListViewAcceptedOrders();
                        updateListViewUnacceptedOrders();
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
