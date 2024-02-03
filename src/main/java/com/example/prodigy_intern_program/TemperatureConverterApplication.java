package com.example.prodigy_intern_program;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;


import java.io.IOException;
import java.util.Objects;

public class TemperatureConverterApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(TemperatureConverterApplication.class.getResource("application-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 500, 400);
        scene.getStylesheets().add("Style.css");
        scene.getRoot().getStyleClass().add("root");
        stage.setTitle("Temperature Converter!");

        stage.setScene(scene);
        stage.setResizable(false);


        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}