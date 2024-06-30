module main.midpracticecart {
    requires javafx.controls;
    requires javafx.fxml;


    opens main.midpracticecart to javafx.fxml;
    exports main.midpracticecart;
}