package main.midpracticecart;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.ToggleGroup;

import java.net.URL;
import java.util.ResourceBundle;

import static javafx.scene.control.SelectionMode.MULTIPLE;

public class CartViewController implements Initializable {

    @FXML
    private Label unitPriceLabel;
    @FXML
    private TextField totalPayableTextFIeld;
    @FXML
    private TableColumn<Payment, Double> totalAmountTableColumn;
    @FXML
    private Label predefinedVatLabel;
    @FXML
    private TableColumn<Payment, String> productTableColumn;
    @FXML
    private ComboBox<String> selectProductComboBox;
    @FXML
    private RadioButton cashRadioButton;
    @FXML
    private ComboBox<Integer> selectVatToConsiderComboBox;
    @FXML
    private Label paymentStatusLabel;
    @FXML
    private TableColumn<Payment, Double> vatTableColumn;
    @FXML
    private TableView<Payment> cartDetailTableView;
    @FXML
    private TableColumn<Payment, Double> unitPriceTableColumn;
    @FXML
    private TableColumn<Payment, Integer> quantityTableColumn;
    @FXML
    private TableColumn<Payment, Double> vatAmountTableColumn;
    @FXML
    private TextField maximumPerUnitProductCostTextFIeld;
    @FXML
    private RadioButton cardRadioButton;
    @FXML
    private CheckBox usdCheckBox;
    @FXML
    private ComboBox<Integer> selectQuantityComboBox;

    private ObservableList<Payment> oblist;
    @FXML
    private TextArea finalVatAmountTextArea;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
        selectProductComboBox.getItems().addAll("Soap","Milk","Coffee","Tea","Rui Fish","Beef");
        selectQuantityComboBox.getItems().addAll(1,2,3,4,5,6,7,8,9,10);
        selectVatToConsiderComboBox.getItems().addAll(1,2,3,4,5,6,7,8,9,10);

        selectProductComboBox.setValue("Select Product");

        productTableColumn.setCellValueFactory(new PropertyValueFactory<Payment, String>("productName"));
        unitPriceTableColumn.setCellValueFactory(new PropertyValueFactory<Payment, Double>("unitPrice"));
        quantityTableColumn.setCellValueFactory(new PropertyValueFactory<Payment, Integer>("quantity"));
        vatTableColumn.setCellValueFactory(new PropertyValueFactory<Payment, Double>("predefinedVat"));
        vatAmountTableColumn.setCellValueFactory(new PropertyValueFactory<Payment, Double>("vatAmount"));
        totalAmountTableColumn.setCellValueFactory(new PropertyValueFactory<Payment, Double>("totalAmount"));

        cartDetailTableView.setVisible(true);

        cartDetailTableView.getSelectionModel().getSelectionMode();
        cartDetailTableView.setEditable(true);

    }


    @FXML
    public void addProductToCardButtonOnAction(ActionEvent actionEvent) {
        String selectedOption = selectProductComboBox.getValue();
        String sp = "Select Product";
        if(selectedOption.equals(sp)) {
            showAlert("No Product Selected", "Please select a product from the product list!");
        }
        else{

            String productName = selectProductComboBox.getValue();
            Double unitPrice = Double.valueOf(unitPriceLabel.getText());
            Integer quantity = selectQuantityComboBox.getValue();
            Double predefinedVat = Double.valueOf(predefinedVatLabel.getText());
            Double percentage = unitPrice*(predefinedVat/100);
            String s = String.format("%.2f",(selectQuantityComboBox.getValue()*unitPrice)+percentage);
            Double totalAmount = Double.valueOf(s);

            Payment p = new Payment(productName, unitPrice, quantity, predefinedVat, percentage, totalAmount);

            oblist = FXCollections.observableArrayList();
            oblist.add(p);

            cartDetailTableView.getItems().addAll(oblist);

            selectProductComboBox.setValue("Select Product");
            selectQuantityComboBox.setValue(null);
        }
    }



    @FXML
    public void deleteItemButtonOnAction(ActionEvent actionEvent) {
        if(cartDetailTableView.getSelectionModel().getSelectedItems().isEmpty()){
            showAlert("No value selected", "Please select a row for delete!");
        }
        else{
            ObservableList<Payment> selectedRows,addAllProduct ;
            addAllProduct=cartDetailTableView.getItems();
            selectedRows=cartDetailTableView.getSelectionModel().getSelectedItems();

            addAllProduct.removeAll(selectedRows);
        }
    }


    @FXML
    public void selectProductOnAction(ActionEvent actionEvent) {
        switch (selectProductComboBox.getValue()){
            case "Soap":
                unitPriceLabel.setText("50");
                predefinedVatLabel.setText("5");
                break;
            case "Milk":
                unitPriceLabel.setText("80");
                predefinedVatLabel.setText("4.5");
                break;
            case "Coffee":
                unitPriceLabel.setText("500");
                predefinedVatLabel.setText("10");
                break;
            case "Tea":
                unitPriceLabel.setText("250");
                predefinedVatLabel.setText("6.5");
                break;
            case "Rui Fish":
                unitPriceLabel.setText("650");
                predefinedVatLabel.setText("3");
                break;
            case "Beef":
                unitPriceLabel.setText("800");
                predefinedVatLabel.setText("10");
                break;
            default:
                unitPriceLabel.setText("");
                predefinedVatLabel.setText("");
        }
    }

    @FXML
    public void ShowTotalVatButtonOnAction(ActionEvent actionEvent) {
        if (maximumPerUnitProductCostTextFIeld.getText().equals("") && selectVatToConsiderComboBox.getValue()==null){
            showAlert("No Payment or percentage Given ", "Please Give Payment and select vat % from select% combo box.");
        }else
            totalPayableTextFIeld.clear();
        Integer percent = selectVatToConsiderComboBox.getValue();
        Double maximumTkPerUnit= Double.parseDouble(maximumPerUnitProductCostTextFIeld.getText());

        Double totalVat=0.00;
        for (Payment p : oblist){
            if(p.getUnitPrice()>=maximumTkPerUnit){
                totalVat+=p.getVatAmount();
            }
            else totalVat+=0.00;
        }
        // calculate discount functionality

        Double discount = (totalVat*((double)(percent)/100));

        totalPayableTextFIeld.appendText("The Total Vat amount paid for the products meeting search criterion is: "+discount+" Tk");
    }

    @FXML
    public void checkOutButtonOnAction(ActionEvent actionEvent) {
        paymentStatusLabel.setText("");
        totalPayableTextFIeld.clear();

        if (!cashRadioButton.isSelected() && !cardRadioButton.isSelected()){
            showAlert("No Payment method selected",
                    "Please select Payment method from RadioButton.");
        }
        else {
            if (cashRadioButton.isSelected()){
                paymentStatusLabel.setText("Paid by cash");
            }
            else if(cardRadioButton.isSelected()){
                paymentStatusLabel.setText("Paid by card");
            }
        }

        if(!oblist.isEmpty()){
            Double total = 0.00;
            ObservableList<Payment> allRows = cartDetailTableView.getItems();
            for (Payment p : allRows) {
                total += p.getTotalAmount();


            }

            if (usdCheckBox.isSelected()) {
                double d = total/110.39;
                String ds = Double.toString(d).substring(0, Double.toString(d).indexOf('.')+3);

                totalPayableTextFIeld.appendText(ds+ " USD");
            } else {
                totalPayableTextFIeld.appendText(Double.toString(total) + " TK");
            }

        } else {
            if (usdCheckBox.isSelected()) {
                totalPayableTextFIeld.appendText("0.00" + " USD");
                return;
            } else {
                totalPayableTextFIeld.appendText("0.00" + " Tk");
                return;
            }
        }
    }
   private void showAlert(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }



}