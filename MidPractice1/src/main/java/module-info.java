module main.midpractice1 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens main.midpractice1 to javafx.fxml;
    exports main.midpractice1;
}