package com.jacob.uidatabase.controller;

import com.jacob.uidatabase.model.Adopter;
import com.jacob.uidatabase.model.AdopterDAO;
import com.jacob.uidatabase.util.DBUtil;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.sql.SQLException;
import java.util.regex.Pattern;

/**
 * @author : Jacob Sanderlin
 * @mailto : js50598@georgiasouthern.edu
 * @created : 11/24/2022, Thursday
 **/
public class EditAdopterController {
    @FXML
    private TextField adopterID;
    @FXML
    private TextField fName;
    @FXML
    private TextField lName;
    @FXML
    private TextField phone;
    @FXML
    private TextField eligibility;
    @FXML
    private TextField streetAddress;

    private static Adopter adopter;
    @FXML
    private void editAdopter() throws SQLException, ClassNotFoundException {
        if (!phoneNumberRegex(phone.getText())) {
            Alert error = new Alert(Alert.AlertType.ERROR);
            error.setTitle("Error!");
            error.setHeaderText("Please enter a valid phone number!");
            error.showAndWait();
        } else {
            String updateStmt = "UPDATE animalshelter.adopter " +
                    "\nSET adopter_FName = '" + fName.getText() + "', adopter_LName = '" + lName.getText() +
                    "', adopter_ID = " + adopterID.getText() + ", adopter_PhoneNumber = '" + phone.getText() +
                    "', adopter_Approval = '" + eligibility.getText() + "', adopter_Address = '" + streetAddress.getText() + "' \nWHERE " +
                    "(adopter_ID = '" + adopter.getAdopter_id() + "');";
            try {
                DBUtil.dbExecuteUpdate(updateStmt);
                EmployeeController.closeAddStage();
            } catch (SQLException e) {
                System.out.println("Error during EDIT Operation: " + e);
                throw e;
            }
        }
    }

    private boolean phoneNumberRegex(String phoneNumber) {
        String patterns = "^((\\(\\d{1,3}[ .]?\\))|\\d{1,3})\\d{3}[- .]?\\d{4}$";
        System.out.println(Pattern.compile(patterns).matcher(phoneNumber).find());
        return Pattern.compile(patterns).matcher(phoneNumber).find();
    }

    public static void show() throws SQLException, ClassNotFoundException {
        adopter = AdopterDAO.searchAdopter("adopter_id",
                String.valueOf(EmployeeController.selectedAdopter.getAdopter_id())).get(0);
    }

    @FXML
    private void refresh(MouseEvent event) {
        adopterID.setText(String.valueOf(adopter.getAdopter_id()));
        fName.setText(adopter.getFirst_name());
        lName.setText(adopter.getLast_name());
        phone.setText(adopter.getPhone_number());
        eligibility.setText(adopter.getEligibility());
        streetAddress.setText(adopter.getStreet_Address());
    }
    @FXML
    private void cancel(ActionEvent event) {
        EmployeeController.closeAddStage();
    }
}
