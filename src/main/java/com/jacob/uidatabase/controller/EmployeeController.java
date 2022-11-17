package com.jacob.uidatabase.controller;

import com.jacob.uidatabase.model.Employee;
import com.jacob.uidatabase.model.EmployeeDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.sql.SQLException;

/**
 * @author : Jacob Sanderlin
 * @mailto : js50598@georgiasouthern.edu
 * @created : 11/13/2022, Sunday
 **/
public class EmployeeController {

    @FXML
    private TextField empIDText;

    @FXML
    private TextField firstNameText;

    @FXML
    private TextField lastNameText;

    @FXML
    private TextField SSNText;

    @FXML
    private TextField hoursText;

    @FXML
    private TextField sexText;

    @FXML
    private TextField roleText;

    @FXML
    private TextField supervisorIDText;

    @FXML
    private TableView employeeTable;
    @FXML
    private TableColumn<Employee, Integer> empIDColumn;
    @FXML
    private TableColumn<Employee, String> firstNameColumn;
    @FXML
    private TableColumn<Employee, String> lastNameColumn;
    @FXML
    private TableColumn<Employee, Integer> SSNColumn;
    @FXML
    private TableColumn<Employee, Integer> hoursColumn;
    @FXML
    private TableColumn<Employee, String> sexColumn;
    @FXML
    private TableColumn<Employee, String> roleColumn;
    @FXML
    private TableColumn<Employee, Integer> supervisorIDColumn;

    @FXML
    private void searchEmployee(ActionEvent event) throws SQLException, ClassNotFoundException {
        try {
            Employee emp = EmployeeDAO.searchEmployee(empIDText.getText());
            populateAndShowEmployee(emp);
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

    @FXML
    private void initialize() {
        empIDColumn.setCellValueFactory(cellData -> cellData.getValue().employee_idProperty().asObject());
        firstNameColumn.setCellValueFactory(cellData -> cellData.getValue().first_nameProperty());
        lastNameColumn.setCellValueFactory(cellData -> cellData.getValue().last_nameProperty());
        SSNColumn.setCellValueFactory(cellData -> cellData.getValue().SSNProperty().asObject());
        hoursColumn.setCellValueFactory(cellData -> cellData.getValue().hoursProperty().asObject());
        sexColumn.setCellValueFactory(cellData -> cellData.getValue().sexProperty());
        roleColumn.setCellValueFactory(cellData -> cellData.getValue().roleProperty());
        supervisorIDColumn.setCellValueFactory(cellData -> cellData.getValue().supervisor_idProperty().asObject());
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
    //Populate Employees for TableView
    @FXML
    private void populateEmployees (ObservableList<Employee> empData) throws ClassNotFoundException {
        //Set items to the employeeTable
        employeeTable.setItems(empData);
    }
    @FXML
    private void insertEmployee (ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        try {
            EmployeeDAO.insertEmp(roleText.getText(),firstNameText.getText(),
                    Integer.parseInt(empIDText.getText()),sexText.getText(), Integer.parseInt(SSNText.getText()));
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Employee Added");
            alert.setHeaderText("Employee was inserted into the database successfully!");
            alert.show();
        } catch (SQLException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error!");
            alert.setHeaderText("An error occurred while trying to insert the employee to the database!");
            alert.show();
            throw e;
        }
    }
    //Delete an employee with a given employee Id from DB
    @FXML
    private void deleteEmployee (ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        try {
            EmployeeDAO.deleteEmpWithID(empIDText.getText());
        } catch (SQLException e) {
            throw e;
        }
    }
}
