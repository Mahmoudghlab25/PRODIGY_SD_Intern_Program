package com.example.prodigy_intern_program;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

import java.util.Objects;


public class TemperatureConverterController{


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
    @FXML
    private ImageView img;
    @FXML
    private HBox hBox;
    @FXML
    private MenuItem cel;
    private char character;

    private boolean darkMode = false;

    public void toggleMode() {
        darkMode = !darkMode;

        if (darkMode) {
            // Dark mode
            setDarkMode();
        } else {
            // Light mode
            setLightMode();
        }
    }

    private void setLightMode() {
        borderPane.getStylesheets().remove(Objects.requireNonNull(TemperatureConverterController.class.getResource("/com/example/prodigy_intern_program/dark.css")).toExternalForm());
        borderPane.getStylesheets().add(Objects.requireNonNull(TemperatureConverterController.class.getResource("/com/example/prodigy_intern_program/light.css")).toExternalForm());
        hBox.getStylesheets().remove(Objects.requireNonNull(TemperatureConverterController.class.getResource("/com/example/prodigy_intern_program/dark.css")).toExternalForm());
        hBox.getStylesheets().add(Objects.requireNonNull(TemperatureConverterController.class.getResource("/com/example/prodigy_intern_program/light.css")).toExternalForm());
        Image image = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/com/example/prodigy_intern_program/dark.png")));
        img.setImage(image);
    }

    private void setDarkMode() {
        borderPane.getStylesheets().remove(Objects.requireNonNull(TemperatureConverterController.class.getResource("/com/example/prodigy_intern_program/light.css")).toExternalForm());
        borderPane.getStylesheets().add(Objects.requireNonNull(TemperatureConverterController.class.getResource("/com/example/prodigy_intern_program/dark.css")).toExternalForm());
        hBox.getStylesheets().remove(Objects.requireNonNull(TemperatureConverterController.class.getResource("/com/example/prodigy_intern_program/light.css")).toExternalForm());
        hBox.getStylesheets().add(Objects.requireNonNull(TemperatureConverterController.class.getResource("/com/example/prodigy_intern_program/dark.css")).toExternalForm());
        Image image = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/com/example/prodigy_intern_program/light.png")));
        img.setImage(image);
    }

    private boolean isValid(String input) {
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