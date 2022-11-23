package com.jacob.uidatabase.controller;

import com.jacob.uidatabase.model.EmployeeDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

import java.sql.SQLException;

/**
 * @author : Jacob Sanderlin
 * @mailto : js50598@georgiasouthern.edu
 * @created : 11/23/2022, Wednesday
 **/
public class AddEmployeeController {
    @FXML
    private TextField addEmpID;

    @FXML
    private TextField addFName;

    @FXML
    private TextField addLName;

    @FXML
    private TextField addSSN;

    @FXML
    private TextField addHours;

    @FXML
    private TextField addSex;

    @FXML
    private TextField addRole;

    @FXML
    private TextField addSupervisor;

    @FXML
    private void insertEmployee (ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        try {
            EmployeeDAO.insertEmp(addRole.getText(), addFName.getText(),
                    Integer.parseInt(addEmpID.getText()),addSex.getText(), Integer.parseInt(addSSN.getText()),
                    addLName.getText(), Integer.parseInt(addHours.getText()), Integer.parseInt(addSupervisor.getText()));
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Employee Added");
            alert.setHeaderText("Employee was inserted into the database successfully!");
            alert.showAndWait();
            EmployeeController.closeAddStage();
        } catch (SQLException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error!");
            alert.setHeaderText("An error occurred while trying to insert the employee to the database!");
            alert.showAndWait();
            throw e;
        }
    }
}
