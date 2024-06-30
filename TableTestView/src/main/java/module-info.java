module main.tabletestview {
    requires javafx.controls;
    requires javafx.fxml;


    opens main.tabletestview to javafx.fxml;
    exports main.tabletestview;
}