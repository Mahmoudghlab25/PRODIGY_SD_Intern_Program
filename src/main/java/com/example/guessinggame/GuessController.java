package com.example.guessinggame;


import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.scene.control.Label;
import javafx.scene.layout.Region;
import javafx.scene.paint.Color;

import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;



public class GuessController {
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private Region content;
    @FXML
    private Label label;

    public void initialize() {

        setBackGround();
        Timeline colorTimeline = new Timeline(
                new KeyFrame(Duration.ZERO, event -> label.setTextFill(Color.RED)),
                new KeyFrame(Duration.millis(500), event -> label.setTextFill(Color.WHITE)),
                new KeyFrame(Duration.millis(1000), event -> label.setTextFill(Color.RED))
        );

        colorTimeline.setCycleCount(Timeline.INDEFINITE);
        colorTimeline.play();
    }

    private void setBackGround() {
        DoubleProperty yPosition = new SimpleDoubleProperty(0);
        yPosition.addListener((observable, oldValue, newValue) -> setBackgroundPositions(content, yPosition.get()));

        Timeline timeline = new Timeline(
                new KeyFrame(Duration.ZERO, new KeyValue(yPosition, 0)),
                new KeyFrame(Duration.seconds(10), new KeyValue(yPosition, -100)) // Adjust the duration as needed
        );
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }


    private void setBackgroundPositions(Region region, double yPosition) {
        double adjustedYPosition = yPosition % 100;
        String style =
                "-fx-background-position: left bottom " + adjustedYPosition + "px; " +
                        "-fx-background-repeat: no-repeat;";
        region.setStyle(style);
    }

    @FXML
    protected void startGame(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("start-game-view.fxml"));
        root = loader.load();
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    protected void howToPlay(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("how-to-play-view.fxml"));
        root = loader.load();
        // Set any shared data or properties in newController if needed
        HowToPlayController howToPlayController = loader.getController();
        howToPlayController.howToPlay();
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
//        setBackGround();
        stage.setScene(scene);

        stage.show();
    }


}