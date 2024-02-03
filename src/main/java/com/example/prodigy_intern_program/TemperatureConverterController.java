package com.example.prodigy_intern_program;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

public class TemperatureConverterController {


    @FXML
    private Rectangle rect;
    @FXML
    private Circle circle;
    @FXML
    private TextField textField;
    @FXML
    private MenuButton menuButton;
    @FXML
    private Label label1;
    @FXML
    private Label label2;
    @FXML
    private BorderPane borderPane;
    private char character;

    private boolean darkMode = false;

    @FXML
    private void handleToggleClick() {
        toggleMode();
    }



    private void toggleMode() {
        darkMode = !darkMode;

        if (darkMode) {
            // Dark mode
            rect.setFill(Color.LIGHTGREEN);
            circle.setTranslateX(0); // Move the circle to the right
            rect.setStroke(Color.DARKGRAY);
            circle.setFill(Color.WHITE);
            circle.setStroke(Color.DARKGRAY);
            borderPane.getScene().getStylesheets().add("Style.css");
            borderPane.getScene().getRoot().getStyleClass().add("dark-mode");
            label1.getStyleClass().remove("light-mode");
            label1.getStyleClass().add("dark-mode");
            label2.getStyleClass().remove("light-mode");
            label2.getStyleClass().add("dark-mode");
        } else {
            // Light mode
            rect.setFill(Color.WHITE);
            circle.setTranslateX(-25); // Reset the circle's position
            rect.setStroke(Color.LIGHTGRAY);
            circle.setFill(Color.WHITE);
            circle.setStroke(Color.LIGHTGRAY);
            borderPane.getScene().getStylesheets().remove("styles.css");
            borderPane.getScene().getRoot().getStyleClass().remove("dark-mode");
            label1.getStyleClass().remove("dark-mode");
            label1.getStyleClass().add("light-mode");
            label2.getStyleClass().remove("dark-mode");
            label2.getStyleClass().add("light-mode");
        }
    }

    @FXML
    protected boolean isValid(String input) {
        if (input.isEmpty()) {
            showAlert("Cannot process an empty field");
            label1.setText("");
            label2.setText("");
            return false;
        }
        if (!input.matches("\\d*\\.?\\d*")) {
            showAlert("Enter numeric values only");
            label1.setText("");
            label2.setText("");
            return false;
        } else {
            return true;
        }
    }

    @FXML
    protected void onCelsiusItemSelect() {
        character = 'c';
        menuButton.setText("Celsius");
    }

    @FXML
    protected void onKelvinItemSelect() {
        character = 'k';
        menuButton.setText("Kelvin");
    }

    @FXML
    protected void onFahrenheitItemSelect() {
        character = 'f';
        menuButton.setText("Fahrenheit");
    }

    @FXML
    protected void onConvertButtonSelect() {
        if(isValid(textField.getText())){
            switch (character) {
                case 'c': {
                    float celestials = Float.parseFloat(textField.getText());
                    float fahrenheit = celestials * (float) 1.8 + 32;
                    float kelvin = celestials + (float) 273.15;
                    label1.setText("Temperature in fahrenheit: "+fahrenheit);
                    label2.setText("Temperature in kelvin: "+kelvin);
                    break;
                }
                case 'k': {
                    float kelvin = Float.parseFloat(textField.getText());
                    float celsius = kelvin - (float) 273.15;
                    float fahrenheit = celsius * (float) 1.8 + 32;
                    label1.setText("Temperature in celsius: "+celsius);
                    label2.setText("Temperature in fahrenheit: "+fahrenheit);
                    break;
                }
                case 'f': {
                    float fahrenheit = Float.parseFloat(textField.getText());
                    float celsius =  (fahrenheit - 32)/(float) 1.8;
                    float kelvin = celsius + (float) 273.15;
                    label1.setText("Temperature in celsius: "+celsius);
                    label2.setText("Temperature in kelvin: "+kelvin);
                    break;
                }
                default: {
                    //Alert: choose a unit please
                    label1.setText("");
                    label2.setText("");
                    showAlert("Choose a unit, please.");
                }
            }
        }
    }
    private void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Warning");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}