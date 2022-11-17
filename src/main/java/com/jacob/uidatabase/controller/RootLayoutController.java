package com.jacob.uidatabase.controller;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;

/**
 * @author : Jacob Sanderlin
 * @mailto : js50598@georgiasouthern.edu
 * @created : 11/13/2022, Sunday
 **/
public class RootLayoutController {

    public void handleExit(ActionEvent event) {
        System.exit(0);
    }

    public void handleHelp(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Program Information");
        alert.setHeaderText("This is the Database UI application for Team 10");
        alert.setContentText("The database is designed to be used at an animal shelter.");
        alert.show();
    }
}
