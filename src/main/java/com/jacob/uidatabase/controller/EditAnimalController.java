package com.jacob.uidatabase.controller;

import com.jacob.uidatabase.model.Animal;
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
public class EditAnimalController {
    @FXML
    private TextField animalID;
    @FXML
    private TextField name;
    @FXML
    private TextField age;
    @FXML
    private TextField cage;
    @FXML
    private TextField price;
    @FXML
    private TextField species;
    @FXML
    private TextField status;

    private static Animal animal;
    @FXML
    private void editAnimal() throws SQLException, ClassNotFoundException {
        String updateStmt = "UPDATE animalshelter.animal " +
                "\nSET Animal_Name = '" + name.getText() + "', Adoption_Status = '" + status.getText() +
                "', Animal_ID = " + animalID.getText() + ", CageNum = " + cage.getText() +
                ", Age = " + age.getText() + ", Species = '" + species.getText() +
                "', Price = " + price.getText() + "\nWHERE " +
                "(animal_ID = '" + animal.getAnimalID() + "');";
        try {
            DBUtil.dbExecuteUpdate(updateStmt);
            EmployeeController.closeAddStage();
        } catch (SQLException e) {
            System.out.println("Error during EDIT Operation: " + e);
            throw e;
        }
    }

    public static void show() throws SQLException, ClassNotFoundException {
        animal = AnimalDAO.searchAnimal("animal_ID",
                String.valueOf(EmployeeController.selectedAnimal.getAnimalID())).get(0);
    }

    @FXML
    private void refresh(MouseEvent event) {
        animalID.setText(String.valueOf(animal.getAnimalID()));
        name.setText(animal.getName());
        age.setText(String.valueOf(animal.getAge()));
        cage.setText(String.valueOf(animal.getCageNumber()));
        species.setText(animal.getSpecies());
        price.setText(String.valueOf(animal.getPrice()));
        status.setText(animal.getAdoptionStatus());
    }
    @FXML
    private void cancel(ActionEvent event) {
        EmployeeController.closeAddStage();
    }
}
