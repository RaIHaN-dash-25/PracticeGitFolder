package com.main.calculator;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;


public class CalculatorController{

    @FXML
    private TextField SecondValueTextField;
    @FXML
    private TextField FirstValueTextFIeld;
    @FXML
    private TextField DisplayLabel;

    public void initialize() {

    }
    @FXML
    public void DivideButtonOnAction(ActionEvent actionEvent) {
        String num1 = FirstValueTextFIeld.getText();
        String num2 = SecondValueTextField.getText();

        int FirstNum = Integer.parseInt(num1);
        int SecondNum = Integer.parseInt(num2);

        if(SecondNum == 0) {
            DisplayLabel.setText("Cannot be divided by Zero");
        }
        else {
            int resultNum = FirstNum / SecondNum;

            String finalNum = Integer.toString(resultNum);

            DisplayLabel.setText(finalNum);
        }
    }

    @FXML
    public void ClearButtonOnAction(ActionEvent actionEvent) {
        FirstValueTextFIeld.clear();
        SecondValueTextField.clear();
        DisplayLabel.clear();
    }


    @FXML
    public void AddButtonOnAction(ActionEvent actionEvent) {
        String num1 = FirstValueTextFIeld.getText();
        String num2 = SecondValueTextField.getText();

        int FirstNum = Integer.parseInt(num1);
        int SecondNum = Integer.parseInt(num2);

        int resultNum = FirstNum + SecondNum;

        String finalNum = Integer.toString(resultNum);

        DisplayLabel.setText(finalNum);
    }

    @FXML
    public void SubtractButtonOnAction(ActionEvent actionEvent) {
        String num1 = FirstValueTextFIeld.getText();
        String num2 = SecondValueTextField.getText();

        int FirstNum = Integer.parseInt(num1);
        int SecondNum = Integer.parseInt(num2);

        int resultNum = FirstNum - SecondNum;

        String finalNum = Integer.toString(resultNum);

        DisplayLabel.setText(finalNum);
    }


    @FXML
    public void MultiplyButtonOnAction(ActionEvent actionEvent) {
        String num1 = FirstValueTextFIeld.getText();
        String num2 = SecondValueTextField.getText();

        int FirstNum = Integer.parseInt(num1);
        int SecondNum = Integer.parseInt(num2);

        int resultNum = FirstNum * SecondNum;

        String finalNum = Integer.toString(resultNum);

        DisplayLabel.setText(finalNum);
    }
}