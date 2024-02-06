package com.example.guessinggame;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;

public class HowToPlayController {
    @FXML
    private Label label;

    @FXML
    protected void howToPlay(){

        label.setText("This is a \"Guessing The Number\" game. The game generates a random number between 1 and 1000, and you are asked to guess that number.\n" +
                "You first enter a number between 1 and 1000 in the text field and click on the \"Guess button.\"\n" +
                "If the guessed number is:\n" +
                "1. > The generated number, the game tells you \"Guess Lower.\"\n" +
                "2. < The generated number, the game tells you \"Guess Higher.\"\n" +
                "3. = The generated number, the game tells you \"You Win!\" and shows you the number of trials that you took to get the number correctly.");
        label.setTextFill(Color.WHITE);
    }
    @FXML
    protected void returnMainMenu(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("guess-view.fxml"));
        Parent root = loader.load();
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
