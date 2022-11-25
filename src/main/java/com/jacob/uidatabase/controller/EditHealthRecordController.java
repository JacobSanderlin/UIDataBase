package com.jacob.uidatabase.controller;

import com.jacob.uidatabase.model.AnimalDAO;
import com.jacob.uidatabase.model.Health_Record;
import com.jacob.uidatabase.model.Health_RecordDAO;
import com.jacob.uidatabase.util.DBUtil;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.sql.SQLException;

/**
 * @author : Jacob Sanderlin
 * @mailto : js50598@georgiasouthern.edu
 * @created : 11/24/2022, Thursday
 **/
public class EditHealthRecordController {
    @FXML
    private TextField animalID;
    @FXML
    private CheckBox castrated;
    @FXML
    private CheckBox vaccinated;
    @FXML
    private TextField record;

    private static Health_Record health_record;
    @FXML
    private void editHealthRecord() throws SQLException, ClassNotFoundException {
        String updateStmt = "UPDATE animalshelter.health_records " +
                "\nSET Animal_ID = " + animalID.getText() + ", Castrated = " + castrated.isSelected() +
                ", Rabies_Vaccine = " + vaccinated.isSelected() + ", Record = " + record.getText() + "\nWHERE " +
                "(record = '" + health_record.getRecordNumber() + "');";
        try {
            DBUtil.dbExecuteUpdate(updateStmt);
            EmployeeController.closeAddStage();
        } catch (SQLException e) {
            System.out.println("Error during EDIT Operation: " + e);
            throw e;
        }
    }

    public static void show() throws SQLException, ClassNotFoundException {
        health_record = Health_RecordDAO.searchHealthRecord("record",
                String.valueOf(EmployeeController.selectedHealthRecord.getRecordNumber())).get(0);
    }

    @FXML
    private void refresh(MouseEvent event) {
        animalID.setText(String.valueOf(health_record.getAnimalID()));
        castrated.setSelected(health_record.isCastrated());
        record.setText(String.valueOf(health_record.getRecordNumber()));
        vaccinated.setSelected(health_record.isVaccinated());
    }
    @FXML
    private void cancel(ActionEvent event) {
        EmployeeController.closeAddStage();
    }
}
