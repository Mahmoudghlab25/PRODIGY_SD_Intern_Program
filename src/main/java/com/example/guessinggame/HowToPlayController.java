package com.example.guessinggame;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;

public class HowToPlayController {
    @FXML
    private Label label;
    @FXML
    private AnchorPane anchorPane;
    @FXML
    private VBox centeredVBox;

    @FXML
    protected void initialize() {
        double xOffset = (anchorPane.getWidth() - centeredVBox.getWidth()) / 2;
        double yOffset = (anchorPane.getHeight() - centeredVBox.getHeight()) / 2;
        centeredVBox.setLayoutX(xOffset);
        centeredVBox.setLayoutY(yOffset);
        howToPlay();
    }

    private void howToPlay(){

        label.setText("""
                This is a "Guessing The Number" game. The game generates a random number between 1 and 100, and you are asked to guess that number.
                You first enter a number between 1 and 100 in the text field and click on the "Guess button."
                If the guessed number is:
                1) > The generated number, the game tells you "Guess Lower."
                2) < The generated number, the game tells you "Guess Higher."
                3) = The generated number, the game tells you "You Win!" and shows you the number of trials that you took to get the number correctly.""");
        label.setTextFill(Color.rgb(241,73,73));
    }
    @FXML
    protected void returnMainMenu(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("guess-view.fxml"));
        Parent root = loader.load();
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setX(100);
        stage.setY(100);
        stage.show();
    }
}
