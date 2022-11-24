package com.jacob.uidatabase.controller;

import com.jacob.uidatabase.model.AnimalDAO;
import com.jacob.uidatabase.model.EmployeeDAO;
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
public class AddAnimalController {
    @FXML
    private TextField animalID;
    @FXML
    private TextField animalName;
    @FXML
    private TextField age;
    @FXML
    private TextField species;
    @FXML
    private TextField cageNumber;
    @FXML
    private TextField adoptionStatus;
    @FXML
    private TextField price;


    @FXML
    private void insertAnimal(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        try {
            AnimalDAO.insertAnimal(Integer.parseInt(animalID.getText()), animalName.getText(),
                    Integer.parseInt(age.getText()),species.getText(), Integer.parseInt(cageNumber.getText()),
                    adoptionStatus.getText(), Double.parseDouble(price.getText()));

            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Animal Added");
            alert.setHeaderText("Animal was inserted into the database successfully!");
            alert.showAndWait();
            EmployeeController.closeAddStage();
        } catch (SQLException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error!");
            alert.setHeaderText("An error occurred while trying to insert the animal to the database!");
            alert.showAndWait();
            throw e;
        }
    }

    @FXML
    private void cancel(ActionEvent event) {
        EmployeeController.closeAddStage();
    }
}
