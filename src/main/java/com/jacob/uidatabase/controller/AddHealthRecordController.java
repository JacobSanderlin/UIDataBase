package com.jacob.uidatabase.controller;

import com.jacob.uidatabase.model.Health_RecordDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;

import java.sql.SQLException;

/**
 * @author : Jacob Sanderlin
 * @mailto : js50598@georgiasouthern.edu
 * @created : 11/24/2022, Thursday
 **/
public class AddHealthRecordController {

    @FXML
    private TextField animalID;

    @FXML
    private TextField record;

    @FXML
    private CheckBox castrated;

    @FXML
    private CheckBox vaccinated;

    @FXML
    private void insertHealthRecord (ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        try {
            Health_RecordDAO.insertHealthRecord(Integer.parseInt(animalID.getText()), Integer.parseInt(record.getText()),
                    castrated.isSelected(), vaccinated.isSelected());
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Record created");
            alert.setHeaderText("Record was created successfully!");
            alert.showAndWait();
            EmployeeController.closeAddStage();
        } catch (SQLException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error!");
            alert.setHeaderText("An error occurred while trying to create the record!");
            alert.showAndWait();
            throw e;
        }
    }

    @FXML
    private void cancel(ActionEvent event) {
        EmployeeController.closeAddStage();
    }
}
