package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import net.rgielen.fxweaver.core.FxmlView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import sample.entities.FactoryEntity;
import sample.services.FactoryService;
import sample.services.FactoryServiceInterface;


import java.beans.EventHandler;
import java.util.Optional;
@Component
@FxmlView("sample.fxml")
public class Controller {

    @FXML
    private Button buttonClose;
    @FXML
    private ListView listView;

    @Autowired
    FactoryServiceInterface factoryService;

    @FXML
    private void buttonCloseOnAction(ActionEvent event) {
        System.out.println("Close");
        //stageMain.close();
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
