module com.main.complexnumberapplication {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.main.complexnumberapplication to javafx.fxml;
    exports com.main.complexnumberapplication;
}