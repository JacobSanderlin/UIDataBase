package com.jacob.uidatabase.controller;

import com.jacob.uidatabase.model.AdopterDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
            if (!phoneNumberRegex(phoneNumber.getText())) {
                Alert error = new Alert(Alert.AlertType.ERROR);
                error.setTitle("Error!");
                error.setHeaderText("Please enter a valid phone number!");
                error.showAndWait();
            } else {
                AdopterDAO.insertAdopter(Integer.parseInt(adopterID.getText()), fName.getText(), lName.getText()
                        , phoneNumber.getText(), eligibility.getText(), address.getText());
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Adopter Added");
                alert.setHeaderText("Adopter was inserted into the database successfully!");
                alert.showAndWait();
                EmployeeController.closeAddStage();
            }
        } catch (SQLException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error!");
            alert.setHeaderText("An error occurred while trying to insert the employee to the database!");
            alert.showAndWait();
            throw e;
        }
    }

    private boolean phoneNumberRegex(String phoneNumber) {
        String patterns = "^((\\(\\d{1,3}[ .]?\\))|\\d{1,3})\\d{3}[- .]?\\d{4}$";
        System.out.println(Pattern.compile(patterns).matcher(phoneNumber).find());
        return Pattern.compile(patterns).matcher(phoneNumber).find();
    }

    @FXML
    private void cancel(ActionEvent event) { EmployeeController.closeAddStage(); }
}
