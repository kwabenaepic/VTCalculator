package com.example.vtcalculator;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class TankCalculator extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(TankCalculator.class.getResource("volumeCalculator.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("VT Volume Calculator");
        stage.setScene(scene);
//        stage.initModality(Modality.APPLICATION_MODAL);
//        stage.initStyle(StageStyle.TRANSPARENT);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}