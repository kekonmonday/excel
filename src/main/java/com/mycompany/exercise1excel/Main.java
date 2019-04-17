package com.mycompany.exercise1excel;

import java.util.Arrays;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String... args) {
        launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent parent = null;
        parent = FXMLLoader.load(Main.class.getResource("/fxml/main.fxml"));
        primaryStage.setScene(new Scene(parent));
        primaryStage.show();
    }

}
