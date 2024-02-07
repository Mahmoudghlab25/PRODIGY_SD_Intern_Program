package com.example.guessinggame;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class GuessApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(GuessApplication.class.getResource("guess-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 500, 400);
        stage.setTitle("Guessing Game!");
        stage.getIcons().add(new Image(GuessApplication.class.getResourceAsStream("dice.png")));
        stage.setScene(scene);
        stage.setResizable(false);
        stage.setX(100);
        stage.setY(100);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}