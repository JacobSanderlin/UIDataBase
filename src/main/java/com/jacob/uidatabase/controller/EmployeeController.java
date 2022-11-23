package com.jacob.uidatabase.controller;

import com.jacob.uidatabase.MainApp;
import com.jacob.uidatabase.model.*;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * @author : Jacob Sanderlin
 * @mailto : js50598@georgiasouthern.edu
 * @created : 11/13/2022, Sunday
 **/
public class EmployeeController {

    /**
     *  Employee View Fields
     **/
    @FXML
    private TextField employee_IDText;

    @FXML
    private TextField fNameText;

    @FXML
    private TextField lNameText;

    @FXML
    private TextField SSNText;

    @FXML
    private TextField hoursText;

    @FXML
    private TextField sexText;

    @FXML
    private TextField roleText;

    @FXML
    private TextField supervisor_IDText;

    @FXML
    private TableView<Employee> employeeTable;
    @FXML
    private TableColumn<Employee, Integer> employee_IDColumn;
    @FXML
    private TableColumn<Employee, String> fNameColumn;
    @FXML
    private TableColumn<Employee, String> lNameColumn;
    @FXML
    private TableColumn<Employee, Integer> SSNColumn;
    @FXML
    private TableColumn<Employee, Integer> hoursColumn;
    @FXML
    private TableColumn<Employee, String> sexColumn;
    @FXML
    private TableColumn<Employee, String> roleColumn;
    @FXML
    private TableColumn<Employee, Integer> supervisor_IDColumn;

    /**
     *  Adopter View Fields
     */
    @FXML
    private TextField adopterIDText;
    @FXML
    private TextField fNameAdopterText;
    @FXML
    private TextField lNameAdopterText;
    @FXML
    private TextField phoneNumberText;
    @FXML
    private TextField eligibilityText;
    @FXML
    private TextField streetAddressText;
    @FXML
    private TextField cityText;
    @FXML
    private TextField stateText;
    @FXML
    private TextField zipCodeText;
    @FXML
    private TableView<Adopter> adopterTable;
    @FXML
    private TableColumn<Adopter, Integer> adopter_IDColumn;
    @FXML
    private TableColumn<Adopter, String> adopterFNameColumn;
    @FXML
    private TableColumn<Adopter, String> adopterLNameColumn;
    @FXML
    private TableColumn<Adopter, String> phone_NumberColumn;
    @FXML
    private TableColumn<Adopter, String> eligibilityColumn;
    @FXML
    private TableColumn<Adopter, String> street_AddressColumn;

    private static Stage addStage;

    public static void closeAddStage() {
        addStage.close();
    }


    /**
     *  Employee View Functions
     */
    @FXML
    private void searchEmployee(ActionEvent event) throws SQLException, ClassNotFoundException {
        try {
            if (employee_IDText.getText().isEmpty())
                populateEmployees(EmployeeDAO.searchEmployees());
            else {
                Employee emp = EmployeeDAO.searchEmployee(employee_IDText.getText());
                populateAndShowEmployee(emp);
            }
        } catch (SQLException e) {
            System.out.println("Error occurred while getting employee information from DB.\n" + e);
            throw e;
        }
    }

    @FXML
    private void searchEmployees(ActionEvent event) throws SQLException, ClassNotFoundException {
        try {
            //Get all Employees information
            ObservableList<Employee> empData = EmployeeDAO.searchEmployees();
            //Populate Employees on TableView
            populateEmployees(empData);
        } catch (SQLException e) {
            System.out.println("Error occurred while getting employees information from DB.\n" + e);

        }
    }

    private void populateInit() throws SQLException, ClassNotFoundException{
        try {
            populateEmployees(EmployeeDAO.searchEmployees());
            populateAdopters(AdopterDAO.searchAdopters());
        } catch (SQLException e) {
            System.out.println("Error in populateInit: " + e);
            throw e;

        }
    }

    @FXML
    private void initialize() throws SQLException, ClassNotFoundException {
        // Multi-threading Executor
        Executor exec = Executors.newCachedThreadPool((runnable) -> {
            Thread t = new Thread(runnable);
            t.setDaemon(true);
            return t;
        });
        Adopter_Address address = new Adopter_Address();

        // Employee Table Column Initialization
        employee_IDColumn.setCellValueFactory(cellData -> cellData.getValue().employee_idProperty().asObject());
        fNameColumn.setCellValueFactory(cellData -> cellData.getValue().first_nameProperty());
        lNameColumn.setCellValueFactory(cellData -> cellData.getValue().last_nameProperty());
        SSNColumn.setCellValueFactory(cellData -> cellData.getValue().SSNProperty().asObject());
        hoursColumn.setCellValueFactory(cellData -> cellData.getValue().hoursProperty().asObject());
        sexColumn.setCellValueFactory(cellData -> cellData.getValue().sexProperty());
        roleColumn.setCellValueFactory(cellData -> cellData.getValue().roleProperty());
        supervisor_IDColumn.setCellValueFactory(cellData -> cellData.getValue().supervisor_idProperty().asObject());

        // Adopter Table Column Initialization
        adopter_IDColumn.setCellValueFactory(cellData -> cellData.getValue().adopter_idProperty().asObject());
        adopterFNameColumn.setCellValueFactory(cellData -> cellData.getValue().first_nameProperty());
        adopterLNameColumn.setCellValueFactory(cellData -> cellData.getValue().last_nameProperty());
        phone_NumberColumn.setCellValueFactory(cellData -> cellData.getValue().phone_numberProperty());
        eligibilityColumn.setCellValueFactory(cellData -> cellData.getValue().eligibilityProperty());
        street_AddressColumn.setCellValueFactory(cellData -> cellData.getValue().street_AddressProperty());


        populateInit();
    }

    //Populate Employee
    @FXML
    private void populateEmployee (Employee emp) throws ClassNotFoundException {
        //Declare and ObservableList for table view
        ObservableList<Employee> empData = FXCollections.observableArrayList();
        //Add employee to the ObservableList
        empData.add(emp);
        //Set items to the employeeTable
        employeeTable.setItems(empData);
    }
    //Populate Employee for TableView and Display Employee on TextArea
    @FXML
    private void populateAndShowEmployee(Employee emp) throws ClassNotFoundException {
        if (emp != null) {
            populateEmployee(emp);
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Employee DNE");
            alert.setHeaderText("This employee is not in the database!");
            alert.show();
        }
    }

    @FXML
    private void populateAddresses (ObservableList<Adopter_Address> addressData) {
        //Set items to the employeeTable

    }
    //Populate Employees for TableView
    @FXML
    private void populateEmployees (ObservableList<Employee> empData) {
        //Set items to the employeeTable
        employeeTable.setItems(empData);
    }
    @FXML
    private void insertEmployee (ActionEvent actionEvent) throws SQLException, ClassNotFoundException {

        try {
            addStage = new Stage();
            TitledPane addView = FXMLLoader.load(MainApp.class.getResource("/view/AddEmployeeView.fxml"));
            Scene scene = new Scene(addView);
            addStage.setScene(scene);
            addStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

//        try {
//            EmployeeDAO.insertEmp(roleText.getText(), fNameText.getText(),
//                    Integer.parseInt(employee_IDText.getText()),sexText.getText(), Integer.parseInt(SSNText.getText()),
//                    lNameText.getText(), Integer.parseInt(hoursText.getText()), Integer.parseInt(supervisor_IDText.getText()));
//            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
//            alert.setTitle("Employee Added");
//            alert.setHeaderText("Employee was inserted into the database successfully!");
//            alert.show();
//        } catch (SQLException e) {
//            Alert alert = new Alert(Alert.AlertType.ERROR);
//            alert.setTitle("Error!");
//            alert.setHeaderText("An error occurred while trying to insert the employee to the database!");
//            alert.show();
//            throw e;
//        }
    }

    @FXML
    private void clearEntries(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("WARNING: Clear Entries");
        alert.setHeaderText("You are about to clear all entries.");
        alert.showAndWait();
        employee_IDText.clear();
        fNameText.clear();
        lNameText.clear();
        SSNText.clear();
        hoursText.clear();
        sexText.clear();
        roleText.clear();
        supervisor_IDText.clear();
    }
    //Delete an employee with a given employee ID from DB
    @FXML
    private void deleteEmployee (ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        try {
            EmployeeDAO.deleteEmpWithID(employee_IDText.getText());

        } catch (SQLException e) {
            throw e;
        }
    }

    /**
     *  Adopter View Functions
     */

    @FXML
    private void populateAdopters(ObservableList<Adopter> adopterData) {
        //Set items to the employeeTable
        adopterTable.setItems(adopterData);
    }

    @FXML
    private void clearAdopterEntries(ActionEvent event){
        adopterIDText.clear();
        fNameAdopterText.clear();
        lNameAdopterText.clear();
        phoneNumberText.clear();
        eligibilityText.clear();
        streetAddressText.clear();
        stateText.clear();
        cityText.clear();
        zipCodeText.clear();
    }

    @FXML
    private void populateAdopter (Adopter adopter) throws ClassNotFoundException {
        //Declare and ObservableList for table view
        ObservableList<Adopter> adopterData = FXCollections.observableArrayList();
        //Add employee to the ObservableList
        adopterData.add(adopter);
        //Set items to the employeeTable
        adopterTable.setItems(adopterData);
    }

    @FXML
    private void searchAdopter(ActionEvent event) throws SQLException, ClassNotFoundException {
        try {
            Adopter ado = AdopterDAO.searchAdopter(adopterIDText.getText());
            populateAndShowAdopter(ado);
        } catch (SQLException e) {
            System.out.println("Error occurred while getting employee information from DB.\n" + e);
            throw e;
        }
    }

    @FXML
    private void populateAndShowAdopter(Adopter ado) throws ClassNotFoundException {
        if (ado != null) {
            populateAdopter(ado);
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Adopter DNE");
            alert.setHeaderText("This adopter is not in the database!");
            alert.show();
        }
    }

    @FXML
    private void searchAdopters(ActionEvent event) throws SQLException, ClassNotFoundException {
        try {
            //Get all Employees information
            ObservableList<Adopter> adoData = AdopterDAO.searchAdopters();
            //Populate Employees on TableView
            populateAdopters(adoData);
        } catch (SQLException e) {
            System.out.println("Error occurred while getting employees information from DB.\n" + e);

        }
    }
}
