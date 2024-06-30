package main.tabletestview;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class TableTestViewController {

    @FXML
    private TableColumn<Identity, String> nameTableView;
    @FXML
    private TableColumn<Identity, String> nationalityTableView;
    @FXML
    private TableColumn<Identity, Integer> idTableView;
    @FXML
    private TableView<Identity> tableView;

    @FXML
    private TableColumn<Identity, Integer> ageTableView;
    @FXML
    private TableColumn<Identity, Float> cgpaTableView;
    @FXML
    private TableColumn<Identity,String> universityTableView;



    @FXML
    void addTextToTableButtonOnClicked(Event event) {
        tableView.getItems().addAll(
                new Identity("Raihan", 2220750, 3.46,"IUB" , 23, "Bangladeshi"),
                new Identity("Joy", 2221147, 3.91, "IUB", 23, "Bangladeshi")
        );
    }

    @FXML
    void initialize() {
        nameTableView.setCellValueFactory(new PropertyValueFactory<Identity,String>("name"));
        idTableView.setCellValueFactory(new PropertyValueFactory<Identity,Integer>("id"));
        universityTableView.setCellValueFactory(new PropertyValueFactory<Identity, String>("university"));
        cgpaTableView.setCellValueFactory(new PropertyValueFactory<Identity, Float>("cgpa"));
        ageTableView.setCellValueFactory(new PropertyValueFactory<Identity, Integer>("age"));
        nationalityTableView.setCellValueFactory(new PropertyValueFactory<Identity, String>("nationality"));
    }
}