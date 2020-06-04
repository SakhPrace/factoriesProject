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
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import net.rgielen.fxweaver.core.FxWeaver;
import net.rgielen.fxweaver.core.FxmlView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.context.ConfigurableApplicationContext;
import sample.JavaFxApplication;
import sample.entities.FactoryEntity;
import sample.entities.OrderingEntity;
import sample.services.FactoryServiceInterface;
import sample.services.OrderingServiceInterface;
import sample.services.ProductServiceInterface;

import java.util.List;

@Component
@FxmlView("factory.fxml")
public class FactoryController {
    @FXML
    private AnchorPane anchorPane;
    @FXML
    private Button buttonCreateOrder;
    @FXML
    private Button buttonLogOut;
    @FXML
    private Button buttonOrdersUpdate;
    @FXML
    private Label labelListView;
    @FXML
    private Label labelFactoryName;
    @FXML
    private ListView listView;

    @Autowired
    FactoryServiceInterface factoryService;

    @Autowired
    OrderingServiceInterface orderingService;

    @Autowired
    ProductServiceInterface productService;

    @FXML
    private void buttonCreateOrderOnAction(ActionEvent event) {

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

    @FXML
    private void buttonOrdersUpdateOnAction(ActionEvent event) {
        updateListView();
        listView.setDisable(false);
    }

    @FXML
    private void listViewOnMouseClicked(MouseEvent mouseEvent) {
        if (mouseEvent.getButton().equals(MouseButton.PRIMARY)) {
            if (mouseEvent.getClickCount() == 2) {

            }
        }

    }

    @FXML
    private void initialize() {

    }

    private void updateListView() {
        ObservableList<String> forListView = FXCollections.observableArrayList();
        Stage stageThis  = (Stage) this.anchorPane.getScene().getWindow();
        FactoryEntity factoryEntityThis = factoryService.findEntityByName(stageThis.getTitle());
        List<OrderingEntity> orderingEntities = orderingService.findEntitiesByFactoryId(factoryEntityThis.getId());
        for (OrderingEntity orderingEntity: orderingEntities) {
            forListView.add(String.valueOf(orderingEntity.getId()) + ". " + productService.findEntityById(orderingEntity.getIdProduct()).getName());
        }
        listView.setItems(forListView);
    }


}
