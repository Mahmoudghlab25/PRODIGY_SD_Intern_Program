module com.example.prodigy_intern_program {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;

    opens com.example.prodigy_intern_program to javafx.fxml;
    exports com.example.prodigy_intern_program;
}