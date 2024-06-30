package main.midpractice1;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import javax.print.DocFlavor;
import java.util.ArrayList;

public class MidPractice1Controller {

    @FXML
    private TableColumn<ComplexNo, String> RealNoTableColumn;
    @FXML
    private TextField imgValueTextField;
    @FXML
    private TextField realValueTextField;
    @FXML
    private TableView<ComplexNo> complexNoTableView;
    @FXML
    private TableColumn<ComplexNo,String>  imgNoTableColumn;

    private ObservableList<ComplexNo> cnList;


    @FXML
    public void addDataToArrayListOnButtonAction(ActionEvent actionEvent) {
        if(realValueTextField.getText().isEmpty() || imgValueTextField.getText().isEmpty()){
            showAlert("Value not found","Fill both real and img value boxes for a complex number.");
        }
        else {
            ComplexNo c = new ComplexNo(
                    realValueTextField.getText(),
                    imgValueTextField.getText()
            );
            cnList.add(c);
            imgValueTextField.clear();
            realValueTextField.clear();
        }
    }

    @FXML
    public void DisplayComplexNoButtonOnAction(ActionEvent actionEvent) {
        if(cnList.isEmpty()){
            showAlert("Values not found","Give minimum one complex number as input for displaying in the table.");
        }
        else {
            complexNoTableView.getItems().clear();
            complexNoTableView.getItems().addAll(cnList);
        }
    }

    @FXML
    public void initialize(){
        cnList = FXCollections.observableArrayList();
        RealNoTableColumn.setCellValueFactory(new PropertyValueFactory<ComplexNo,String>("real"));
        imgNoTableColumn.setCellValueFactory(new PropertyValueFactory<ComplexNo,String>("img"));
    }

    private void showAlert(String title, String content){
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }
}