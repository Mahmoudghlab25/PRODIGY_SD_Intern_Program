package com.example.guessinggame;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;

import java.util.Random;

public class StartGameController {

    @FXML
    private Label label;

    @FXML
    private TextField textField;
    @FXML
    private Button guessButt;
    private Color color;
    private int number;
    private int steps;

    @FXML
    public void initialize() {
        startNewGame();
    }

    @FXML
    protected void startGame() {
        String guess = textField.getText();
        if (isValid(guess)) {
            steps++;
            int x = Integer.parseInt(guess);
            color = (color == Color.RED) ? Color.BLACK : Color.RED;
            if (x < number) {
                label.setText("Guess Higher!");
                label.setTextFill(color);
            } else if (x > number) {
                label.setText("Guess Lower!");
                label.setTextFill(color);
            } else {
                label.setText("          You Win!\nYou took " + steps + " trials to win.");
                label.setTextFill(Color.LIGHTGREEN);
                guessButt.setDisable(true);
            }
        }
    }

    private boolean isValid(String input) {
        if (textField.getText().isEmpty()) {
            showAlert("Enter a number, please!");
            label.setText("");
            return false;
        }

        if (!input.matches("\\d+")) {
            showAlert("Please, Input a valid integer number between 1 and 1000!");
            label.setText("");
            return false;
        }

        int x = Integer.parseInt(input);
        if (!(x >= 1 && x <= 1000)) {
            showAlert("Please, Input a number between 1 and 1000!");
            label.setText("");
            return false;
        }

        return true;
    }

    @FXML
    protected void handleEnterKey(javafx.scene.input.KeyEvent event) {
        if (event.getCode().getName().equals("Enter")) {
            if (!guessButt.isDisabled()) {
                startGame();
            }
        }
    }

    private void startNewGame() {
        Random random = new Random();
        number = random.nextInt(1, 1000);
        System.out.println(number);
        steps = 0;
        textField.clear();
        label.setText("");
        guessButt.setDisable(false);
    }

    private void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Warning");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
