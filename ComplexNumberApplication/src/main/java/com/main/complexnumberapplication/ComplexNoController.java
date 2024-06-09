package com.main.complexnumberapplication;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class ComplexNoController {


    @FXML
    private TextField valueOf2ndImgNo;
    @FXML
    private Label outputLabel;
    @FXML
    private TextField valueOf1stRealNo;
    @FXML
    private TextField valueOf1stImgNo;
    @FXML
    private CheckBox thirdCheckBox;
    @FXML
    private TextField valueOf2ndRealNo;
    @FXML
    private CheckBox secondCheckBox;
    @FXML
    private TextField valueOf3rdRealNo;
    @FXML
    private TextField valueOf3rdImgNo;
    @FXML
    private ComboBox<String> operationComboBox;
    @FXML
    private CheckBox firstCheckBox;

    ComplexNo c1,c2,c3,c4;


    @FXML    void executeOperationButtonOnAction(ActionEvent event) {
        c1 = new ComplexNo(
                Integer.parseInt(valueOf1stRealNo.getText()),
                Integer.parseInt(valueOf1stImgNo.getText())
        );
        //int real = c1.getReal();//c1.real;
        c2 = new ComplexNo(
                Integer.parseInt(valueOf2ndRealNo.getText()),
                Integer.parseInt(valueOf2ndImgNo.getText())
        );

        c3 = new ComplexNo(
                Integer.parseInt(valueOf3rdRealNo.getText()),
                Integer.parseInt(valueOf3rdImgNo.getText())
        );
        Object obj;

        int checkBoxCount=0;
        boolean firstCNisSelected=false, secondCNisSelected=false, thirdCNisSelected=false;
        String selectedOperation = operationComboBox.getValue();

        if(selectedOperation.equals("Add")){
            checkBoxCount=0;
            if(firstCheckBox.isSelected()){
                checkBoxCount++;
                firstCNisSelected=true;
            }
            if(secondCheckBox.isSelected()){
                checkBoxCount++;
                secondCNisSelected=true;
            }
            if(thirdCheckBox.isSelected()){
                checkBoxCount++;
                thirdCNisSelected=true;
            }
            if(checkBoxCount<2){
                outputLabel.setText("Oops! For addition, select at least 2 Complex Nos");
            }
            else{
                if(checkBoxCount==3) {
                    c4 = c1.add(c2).add(c3);
                }
                else if( firstCNisSelected && secondCNisSelected ) c4 = c1.add(c2);
                else if( secondCNisSelected && thirdCNisSelected ) c4 = c2.add(c3);
                else if( firstCNisSelected && thirdCNisSelected ) c4 = c1.add(c3);
            }
        }
        else if (selectedOperation.equals("Subtract")){
            checkBoxCount=0;
            if(firstCheckBox.isSelected()){
                checkBoxCount++;
                firstCNisSelected=true;
            }
            if(secondCheckBox.isSelected()){
                checkBoxCount++;
                secondCNisSelected=true;
            }
            if(thirdCheckBox.isSelected()){
                checkBoxCount++;
                thirdCNisSelected=true;
            }
            if(checkBoxCount<2){
                outputLabel.setText("Oops! For subtractionn, select at least 2 Complex Nos");
            }
            else{
                if(checkBoxCount==3) {
                    c4 = c1.subtract(c2).subtract(c3);
                }
                else if( firstCNisSelected && secondCNisSelected ) c4 = c1.subtract(c2);
                else if( secondCNisSelected && thirdCNisSelected ) c4 = c2.subtract(c3);
                else if( firstCNisSelected && thirdCNisSelected ) c4 = c1.subtract(c3);
            }
        }
        else if (selectedOperation.equals("Show")){
            outputLabel.setText(
                    "First Complex No: " + c1.toString() + "\n"
                            + "Second Complex No: " + c2.toString() + "\n"
                            + "Third Complex No: " + c3.toString() + "\n"
                            + "Resultant Complex No: " + c4.toString() + "\n"
            );

        }


    }

    @FXML
    void initialize() {
        operationComboBox.getItems().add("Add");
        operationComboBox.getItems().addAll("Subtract", "Show");
        c4 = new ComplexNo();
    }
}

/*

 */
