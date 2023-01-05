package com.jacob.uidatabase.controller;

import com.jacob.uidatabase.model.Adoption_Record;
import com.jacob.uidatabase.model.Adoption_RecordDAO;
import com.jacob.uidatabase.model.EmployeeDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

import java.sql.SQLException;
import java.util.regex.Pattern;

/**
 * @author : Jacob Sanderlin
 * @mailto : js50598@georgiasouthern.edu
 * @created : 11/24/2022, Thursday
 **/
public class AddAdoptionRecordController {
    @FXML
    private TextField adopterID;

    @FXML
    private TextField fName;

    @FXML
    private TextField lName;

    @FXML
    private TextField animName;

    @FXML
    private TextField animID;

    @FXML
    private TextField caseID;

    @FXML
    private TextField phone;

    @FXML
    private TextField approval;
    @FXML
    private TextField date;

    @FXML
    private void insertAdoptionRecord(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        try {
            if (!phoneNumberRegex(phone.getText())) {
                Alert error = new Alert(Alert.AlertType.ERROR);
                error.setTitle("Error!");
                error.setHeaderText("Please enter a valid phone number!");
                error.showAndWait();
            } else {
                String dateString = date.getText().replaceAll("-", "");
                Adoption_RecordDAO.insertAdoptionRecord(Integer.parseInt(adopterID.getText()), fName.getText(), lName.getText(),
                        animName.getText(), Integer.parseInt(animID.getText()), Integer.parseInt(caseID.getText()),
                        phone.getText(), approval.getText(), dateString);
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Adoption Record Added");
                alert.setHeaderText("Adoption Record was inserted into the database successfully!");
                alert.showAndWait();
                EmployeeController.closeAddStage();
            }
        } catch (SQLException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error!");
            alert.setHeaderText("An error occurred while trying to insert the adoption record to the database!");
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
    private void cancel(ActionEvent event) {
        EmployeeController.closeAddStage();
    }
}
