package com.jacob.uidatabase.controller;

import com.jacob.uidatabase.model.Adoption_Record;
import com.jacob.uidatabase.model.Adoption_RecordDAO;
import com.jacob.uidatabase.model.AnimalDAO;
import com.jacob.uidatabase.util.DBUtil;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.sql.SQLException;

/**
 * @author : Jacob Sanderlin
 * @mailto : js50598@georgiasouthern.edu
 * @created : 11/24/2022, Thursday
 **/
public class EditAdoptionRecordController {
    @FXML
    private TextField adopterID;
    @FXML
    private TextField fName;
    @FXML
    private TextField lName;
    @FXML
    private TextField aName;
    @FXML
    private TextField animalID;
    @FXML
    private TextField caseID;
    @FXML
    private TextField phone;
    @FXML
    private TextField approval;
    @FXML
    private TextField date;

    private static Adoption_Record record;
    @FXML
    private void editAdoptionRecord() throws SQLException, ClassNotFoundException {
        String dateString = date.getText().replaceAll("-", "");
        String updateStmt = "UPDATE animalshelter.adoption_record " +
                "\nSET Adopter_ID = " + adopterID.getText() + ", Adopter_Phone = '" + phone.getText() +
                "', Adopter_Name = '" + fName.getText() + "', Animal_Name = '" + aName.getText() +
                "', Case_ID = " + caseID.getText() + ", Date_Adopted = '" + dateString +
                "', Adopter_Approval = '" + approval.getText() + "', Animal_ID = " + animalID.getText() +
                ", Adopter_LName = '" + lName.getText() + "'\nWHERE " +
                "(Case_ID = '" + record.getCaseNumber() + "');";
        try {
            DBUtil.dbExecuteUpdate(updateStmt);
            EmployeeController.closeAddStage();
        } catch (SQLException e) {
            System.out.println("Error during EDIT Operation: " + e);
            throw e;
        }
    }

    public static void show() throws SQLException, ClassNotFoundException {
        record = Adoption_RecordDAO.searchAdoptionRecord("Case_ID",
                String.valueOf(EmployeeController.selectedAdoptionRecord.getCaseNumber())).get(0);
    }

    @FXML
    private void refresh(MouseEvent event) {
        animalID.setText(String.valueOf(record.getAnimalID()));
        fName.setText(record.getFirstName());
        caseID.setText(String.valueOf(record.getCaseNumber()));
        adopterID.setText(String.valueOf(record.getAdopterID()));
        lName.setText(record.getLastName());
        approval.setText(record.getAdopterApproval());
        aName.setText(record.getAnimalName());
        phone.setText(record.getPhoneNumber());
        date.setText(record.getDateAdopted().toString());
    }
    @FXML
    private void cancel(ActionEvent event) {
        EmployeeController.closeAddStage();
    }
}
