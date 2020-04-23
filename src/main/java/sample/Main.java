package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sample.factories.HibernateSessionFactoryUtil;

import java.util.TimeZone;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

        primaryStage  = FXMLLoader.load(getClass().getClassLoader().getResource("sample.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
