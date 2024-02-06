module com.example.guessinggame {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;

    opens com.example.guessinggame to javafx.fxml;
    exports com.example.guessinggame;
}