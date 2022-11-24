package com.jacob.uidatabase.controller;

import com.jacob.uidatabase.model.AdopterDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

import java.sql.SQLException;

/**
 * @author : Jacob Sanderlin
 * @mailto : js50598@georgiasouthern.edu
 * @created : 11/24/2022, Thursday
 **/
public class AddAdopterController {

    @FXML
    private TextField adopterID;
    @FXML
    private TextField fName;
    @FXML
    private TextField lName;
    @FXML
    private TextField phoneNumber;
    @FXML
    private TextField eligibility;
    @FXML
    private TextField address;

    @FXML
    private void insertAdopter(ActionEvent event) throws SQLException, ClassNotFoundException {
        try {
            AdopterDAO.insertAdopter(Integer.parseInt(adopterID.getText()), fName.getText(),lName.getText()
                    ,phoneNumber.getText(),eligibility.getText(),address.getText());
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Adopter Added");
            alert.setHeaderText("Adopter was inserted into the database successfully!");
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

    @FXML
    private void cancel(ActionEvent event) { EmployeeController.closeAddStage(); }
}
