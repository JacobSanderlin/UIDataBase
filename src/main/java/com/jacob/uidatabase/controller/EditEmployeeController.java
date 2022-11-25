package com.jacob.uidatabase.controller;

import com.jacob.uidatabase.model.Employee;
import com.jacob.uidatabase.model.EmployeeDAO;
import com.jacob.uidatabase.util.DBUtil;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.sql.SQLException;

/**
 * @author : Jacob Sanderlin
 * @mailto : js50598@georgiasouthern.edu
 * @created : 11/24/2022, Thursday
 **/
public class EditEmployeeController {

    @FXML
    private TextField employeeID;
    @FXML
    private TextField fName;
    @FXML
    private TextField lName;
    @FXML
    private TextField ssn;
    @FXML
    private TextField hours;
    @FXML
    private TextField sex;
    @FXML
    private TextField role;
    @FXML
    private TextField supervisorID;

    private static Employee employee;
    @FXML
    private void editEmployee() throws SQLException, ClassNotFoundException {
        String updateStmt = "UPDATE animalshelter.employee " +
                "\nSET role = '" + role.getText() + "', fName = '" + fName.getText() +
                "', employee_ID = " + employeeID.getText() + ", SSN = " + ssn.getText() +
                ", sex = '" + sex.getText() + "', lName = '" + lName.getText() + "', hours = " +
                hours.getText() + ", supervisor_ID = " + supervisorID.getText() + " \nWHERE " +
                "(employee_ID = '" + employee.getEmployee_id() + "');";
        try {
            DBUtil.dbExecuteUpdate(updateStmt);
            EmployeeController.closeAddStage();
        } catch (SQLException e) {
            System.out.println("Error during EDIT Operation: " + e);
            throw e;
        }
    }

    public static void show() throws SQLException, ClassNotFoundException {
        employee = EmployeeDAO.searchEmployee("employee_id",
                String.valueOf(EmployeeController.selectedEmployee.getEmployee_id())).get(0);
    }

    @FXML
    private void refresh(MouseEvent event) {
        employeeID.setText(String.valueOf(employee.getEmployee_id()));
        fName.setText(employee.getFirst_name());
        lName.setText(employee.getLast_name());
        ssn.setText(String.valueOf(employee.getSSN()));
        hours.setText(String.valueOf(employee.getHours()));
        sex.setText(employee.getSex());
        role.setText(employee.getRole());
        supervisorID.setText(String.valueOf(employee.getSupervisor_id()));
    }
    @FXML
    private void cancel(ActionEvent event) {
        EmployeeController.closeAddStage();
    }
}
