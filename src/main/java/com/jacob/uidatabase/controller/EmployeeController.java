package com.jacob.uidatabase.controller;

import com.jacob.uidatabase.MainApp;
import com.jacob.uidatabase.model.*;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.EventObject;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * @author : Jacob Sanderlin
 * @mailto : js50598@georgiasouthern.edu
 * @created : 11/13/2022, Sunday
 **/
public class EmployeeController {

    private SelectionModel<Employee> employeeSelectionModel;
    private SelectionModel<Adopter> adopterSelectionModel;
    private SelectionModel<Animal> animalSelectionModel;
    private SelectionModel<Health_Record> healthRecordSelectionModel;
    private SelectionModel<Adoption_Record> adoptionRecordSelectionModel;

    /**
     *  Employee View Fields
     **/
    @FXML
    private TextField employee_IDText;

    @FXML
    private TextField fNameText;

    @FXML
    private TextField lNameText;

    @FXML
    private TextField SSNText;

    @FXML
    private TextField hoursText;

    @FXML
    private TextField sexText;

    @FXML
    private TextField roleText;

    @FXML
    private TextField supervisor_IDText;

    @FXML
    private TableView<Employee> employeeTable;
    @FXML
    private TableColumn<Employee, Integer> employee_IDColumn;
    @FXML
    private TableColumn<Employee, String> fNameColumn;
    @FXML
    private TableColumn<Employee, String> lNameColumn;
    @FXML
    private TableColumn<Employee, Integer> SSNColumn;
    @FXML
    private TableColumn<Employee, Integer> hoursColumn;
    @FXML
    private TableColumn<Employee, String> sexColumn;
    @FXML
    private TableColumn<Employee, String> roleColumn;
    @FXML
    private TableColumn<Employee, Integer> supervisor_IDColumn;

    /**
     *  Adopter View Fields
     */
    @FXML
    private TextField adopterIDText;
    @FXML
    private TextField fNameAdopterText;
    @FXML
    private TextField lNameAdopterText;
    @FXML
    private TextField phoneNumberText;
    @FXML
    private TextField eligibilityText;
    @FXML
    private TextField streetAddressText;
    @FXML
    private TableView<Adopter> adopterTable;
    @FXML
    private TableColumn<Adopter, Integer> adopter_IDColumn;
    @FXML
    private TableColumn<Adopter, String> adopterFNameColumn;
    @FXML
    private TableColumn<Adopter, String> adopterLNameColumn;
    @FXML
    private TableColumn<Adopter, String> phone_NumberColumn;
    @FXML
    private TableColumn<Adopter, String> eligibilityColumn;
    @FXML
    private TableColumn<Adopter, String> street_AddressColumn;

    /**
     * Animal View Fields
     */
    @FXML
    private TextField animalID;
    @FXML
    private TextField animalName;
    @FXML
    private TextField animalCage;
    @FXML
    private TextField species;
    @FXML
    private TextField adoptionStatus;
    @FXML
    private TextField price;
    @FXML
    private TextField animalAge;
    @FXML
    private TableView<Animal> animalTable;
    @FXML
    private TableColumn<Animal, Integer> animIDColumn;
    @FXML
    private TableColumn<Animal, String> animNameColumn;
    @FXML
    private TableColumn<Animal, Integer> animCageNumberColumn;
    @FXML
    private TableColumn<Animal, String> animSpeciesColumn;
    @FXML
    private TableColumn<Animal, String> animAdoptionStatusColumn;
    @FXML
    private TableColumn<Animal, Double> animPriceColumn;
    @FXML
    private TableColumn<Animal, Integer> animAgeColumn;
    @FXML
    private TableColumn<Animal, String> animNotesColumn;

    /**
     * Health Record Fields
     */
    @FXML
    private TextField animalIDHR;
    @FXML
    private CheckBox castrated;
    @FXML
    private CheckBox rabies;
    @FXML
    private TextField healthRecord;
    @FXML
    private TableView<Health_Record> healthRecordTable;
    @FXML
    private TableColumn<Health_Record, Integer> animalIDColumn;
    @FXML
    private TableColumn<Health_Record, String> castratedColumn;
    @FXML
    private TableColumn<Health_Record, String> rabiesColumn;
    @FXML
    private TableColumn<Health_Record, Integer> recordNumberColumn;
    @FXML
    private TableColumn<Health_Record, String> healthRecordNotesColumn;

    /**
     * Adoption Record Fields
     */
    @FXML
    private TextField adopterID;
    @FXML
    private TextField adopterFName;
    @FXML
    private TextField adopterLName;
    @FXML
    private TextField adopterPhoneNum;
    @FXML
    private TextField caseNumber;
    @FXML
    private TextField animalIDAR;
    @FXML
    private TextField dateAdopted;
    @FXML
    private TextField adopterApprovalRecord;
    @FXML
    private TextField animalNameAR;
    @FXML
    private TableView<Adoption_Record> adoptionRecordTable;
    @FXML
    private TableColumn<Adoption_Record, Integer> adopterRecordIDColumn;
    @FXML
    private TableColumn<Adoption_Record, String> adopterRecordFNameColumn;
    @FXML
    private TableColumn<Adoption_Record, String> adopterRecordLNameColumn;
    @FXML
    private TableColumn<Adoption_Record, String> adopterRecordPhoneNumberColumn;
    @FXML
    private TableColumn<Adoption_Record, Integer> adopterRecordCaseNumberColumn;
    @FXML
    private TableColumn<Adoption_Record, Integer> adopterRecordAnimalIDColumn;
    @FXML
    private TableColumn<Adoption_Record, Date> adopterRecordDateAdoptedColumn;
    @FXML
    private TableColumn<Adoption_Record, String> adopterRecordAdopterApprovalColumn;
    @FXML
    private TableColumn<Adoption_Record, String> adopterRecordAnimalNameColumn;


    public static Employee selectedEmployee;
    public static Adopter selectedAdopter;
    public static Animal selectedAnimal;
    public static Health_Record selectedHealthRecord;
    public static Adoption_Record selectedAdoptionRecord;

    private static Stage addStage;

    public static void closeAddStage() {
        addStage.close();
    }


    /**
     *  Employee View Functions
     */
    @FXML
    private void searchEmployee(ActionEvent event) throws SQLException, ClassNotFoundException {
        try {
            ObservableList<Employee> emp;
            if (!employee_IDText.getText().isEmpty()) {
                emp = EmployeeDAO.searchEmployee(employee_IDText.getText(), "employee_id");
                populateEmployees(emp);
            } else if (!fNameText.getText().isEmpty()) {
                emp = EmployeeDAO.searchEmployee("'" + fNameText.getText() + "'", "fName");
                populateEmployees(emp);
            } else if (!lNameText.getText().isEmpty()) {
                emp = EmployeeDAO.searchEmployee("'" + lNameText.getText() + "'", "lName");
                populateEmployees(emp);
            } else if (!SSNText.getText().isEmpty()) {
                emp = EmployeeDAO.searchEmployee(SSNText.getText(), "SSN");
                populateEmployees(emp);
            } else if (!hoursText.getText().isEmpty()) {
                emp = EmployeeDAO.searchEmployee(hoursText.getText(), "hours");
                populateEmployees(emp);
            } else if (!sexText.getText().isEmpty()) {
                emp = EmployeeDAO.searchEmployee("'" + sexText.getText() + "'", "sex");
                populateEmployees(emp);
            } else if (!roleText.getText().isEmpty()) {
                emp = EmployeeDAO.searchEmployee("'" + roleText.getText() + "'", "role");
                populateEmployees(emp);
            } else if (!supervisor_IDText.getText().isEmpty()) {
                emp = EmployeeDAO.searchEmployee(supervisor_IDText.getText(), "supervisor_id");
                populateEmployees(emp);
            } else {
                populateEmployees(EmployeeDAO.searchEmployees());
            }
        } catch (SQLException e) {
            System.out.println("Error occurred while getting employee information from DB.\n" + e);
            throw e;
        }
    }

    @FXML
    private void searchEmployees(ActionEvent event) throws SQLException, ClassNotFoundException {
        try {
            //Get all Employees information
            ObservableList<Employee> empData = EmployeeDAO.searchEmployees();
            //Populate Employees on TableView
            populateEmployees(empData);
        } catch (SQLException e) {
            System.out.println("Error occurred while getting employees information from DB.\n" + e);

        }
    }

    private void populateInit() throws SQLException, ClassNotFoundException{
        try {
            populateEmployees(EmployeeDAO.searchEmployees());
            populateAdopters(AdopterDAO.searchAdopters());
            populateAnimals(AnimalDAO.searchAnimals());
            populateHealthRecords(Health_RecordDAO.searchHealthRecords());
            populateAdoptionRecords(Adoption_RecordDAO.searchAdoptionRecords());
        } catch (SQLException e) {
            System.out.println("Error in populateInit: " + e);
            throw e;

        }
    }

    @FXML
    private void initialize() throws SQLException, ClassNotFoundException {
        // Multi-threading Executor
        Executor exec = Executors.newCachedThreadPool((runnable) -> {
            Thread t = new Thread(runnable);
            t.setDaemon(true);
            return t;
        });
        employeeSelectionModel = employeeTable.getSelectionModel();
        employeeTable.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);

        adopterSelectionModel = adopterTable.getSelectionModel();
        adopterTable.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);

        animalSelectionModel = animalTable.getSelectionModel();
        animalTable.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);

        healthRecordSelectionModel = healthRecordTable.getSelectionModel();
        healthRecordTable.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);

        adoptionRecordSelectionModel = adoptionRecordTable.getSelectionModel();
        adoptionRecordTable.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);

        // Employee Table Column Initialization
        employee_IDColumn.setCellValueFactory(cellData -> cellData.getValue().employee_idProperty().asObject());
        fNameColumn.setCellValueFactory(cellData -> cellData.getValue().first_nameProperty());
        lNameColumn.setCellValueFactory(cellData -> cellData.getValue().last_nameProperty());
        SSNColumn.setCellValueFactory(cellData -> cellData.getValue().SSNProperty().asObject());
        hoursColumn.setCellValueFactory(cellData -> cellData.getValue().hoursProperty().asObject());
        sexColumn.setCellValueFactory(cellData -> cellData.getValue().sexProperty());
        roleColumn.setCellValueFactory(cellData -> cellData.getValue().roleProperty());
        supervisor_IDColumn.setCellValueFactory(cellData -> cellData.getValue().supervisor_idProperty().asObject());

        // Adopter Table Column Initialization
        adopter_IDColumn.setCellValueFactory(cellData -> cellData.getValue().adopter_idProperty().asObject());
        adopterFNameColumn.setCellValueFactory(cellData -> cellData.getValue().first_nameProperty());
        adopterLNameColumn.setCellValueFactory(cellData -> cellData.getValue().last_nameProperty());
        phone_NumberColumn.setCellValueFactory(cellData -> cellData.getValue().phone_numberProperty());
        eligibilityColumn.setCellValueFactory(cellData -> cellData.getValue().eligibilityProperty());
        street_AddressColumn.setCellValueFactory(cellData -> cellData.getValue().street_AddressProperty());

        // Animal Table Column Initialization
        animIDColumn.setCellValueFactory(cellData -> cellData.getValue().animalIDProperty().asObject());
        animAgeColumn.setCellValueFactory(cellData -> cellData.getValue().ageProperty().asObject());
        animNameColumn.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
        animCageNumberColumn.setCellValueFactory(cellData -> cellData.getValue().cageNumberProperty().asObject());
        animSpeciesColumn.setCellValueFactory(cellData -> cellData.getValue().speciesProperty());
        animAdoptionStatusColumn.setCellValueFactory(cellData -> cellData.getValue().adoptionStatusProperty());
        animPriceColumn.setCellValueFactory(cellData -> cellData.getValue().priceProperty().asObject());

        // Health Record Table Column Initialization
        animalIDColumn.setCellValueFactory(cellData -> cellData.getValue().animalIDProperty().asObject());
        castratedColumn.setCellValueFactory(cellData -> cellData.getValue().castratedProperty().asString());
        rabiesColumn.setCellValueFactory(cellData -> cellData.getValue().vaccinatedProperty().asString());
        recordNumberColumn.setCellValueFactory(cellData -> cellData.getValue().recordNumberProperty().asObject());

        // Adoption Record Table Column Initialization
        adopterRecordIDColumn.setCellValueFactory(cellData -> cellData.getValue().adopterIDProperty().asObject());
        adopterRecordFNameColumn.setCellValueFactory(cellData -> cellData.getValue().firstNameProperty());
        adopterRecordLNameColumn.setCellValueFactory(cellData -> cellData.getValue().lastNameProperty());
        adopterRecordPhoneNumberColumn.setCellValueFactory(cellData -> cellData.getValue().phoneNumberProperty());
        adopterRecordCaseNumberColumn.setCellValueFactory(cellData -> cellData.getValue().caseNumberProperty().asObject());
        adopterRecordAnimalIDColumn.setCellValueFactory(cellData -> cellData.getValue().animalIDProperty().asObject());
        adopterRecordDateAdoptedColumn.setCellValueFactory(cellData -> cellData.getValue().dateAdoptedProperty());
        adopterRecordAdopterApprovalColumn.setCellValueFactory(cellData -> cellData.getValue().adopterApprovalProperty());
        adopterRecordAnimalNameColumn.setCellValueFactory(cellData -> cellData.getValue().animalNameProperty());

        employeeTable.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                if (mouseEvent.isPrimaryButtonDown() && mouseEvent.getClickCount() == 2) {
                    addStage = new Stage();
                    try {
                        TitledPane addView = FXMLLoader.load(MainApp.class.getResource("/view/EditEmployeeView.fxml"));
                        Scene scene = new Scene(addView);
                        selectedEmployee =  employeeSelectionModel.getSelectedItem();
                        addStage.setOnShown((event) -> {
                            try {
                                EditEmployeeController.show();
                            } catch (SQLException e) {
                                throw new RuntimeException(e);
                            } catch (ClassNotFoundException e) {
                                throw new RuntimeException(e);
                            }
                        });

                        addStage.setScene(scene);
                        addStage.show();



                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }

                }
            }
        });

        adopterTable.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                if (mouseEvent.isPrimaryButtonDown() && mouseEvent.getClickCount() == 2) {
                    addStage = new Stage();
                    try {
                        TitledPane addView = FXMLLoader.load(MainApp.class.getResource("/view/EditAdopterView.fxml"));
                        Scene scene = new Scene(addView);
                        selectedAdopter =  adopterSelectionModel.getSelectedItem();
                        addStage.setOnShown((event) -> {
                            try {
                                EditAdopterController.show();
                            } catch (SQLException e) {
                                throw new RuntimeException(e);
                            } catch (ClassNotFoundException e) {
                                throw new RuntimeException(e);
                            }
                        });

                        addStage.setScene(scene);
                        addStage.show();



                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }

                }
            }
        });
        animalTable.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                if (mouseEvent.isPrimaryButtonDown() && mouseEvent.getClickCount() == 2) {
                    addStage = new Stage();
                    try {
                        TitledPane addView = FXMLLoader.load(MainApp.class.getResource("/view/EditAnimalView.fxml"));
                        Scene scene = new Scene(addView);
                        selectedAnimal =  animalSelectionModel.getSelectedItem();
                        addStage.setOnShown((event) -> {
                            try {
                                EditAnimalController.show();
                            } catch (SQLException e) {
                                throw new RuntimeException(e);
                            } catch (ClassNotFoundException e) {
                                throw new RuntimeException(e);
                            }
                        });

                        addStage.setScene(scene);
                        addStage.show();



                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }

                }
            }
        });

        healthRecordTable.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                if (mouseEvent.isPrimaryButtonDown() && mouseEvent.getClickCount() == 2) {
                    addStage = new Stage();
                    try {
                        TitledPane addView = FXMLLoader.load(MainApp.class.getResource("/view/EditHealthRecordView.fxml"));
                        Scene scene = new Scene(addView);
                        selectedHealthRecord =  healthRecordSelectionModel.getSelectedItem();
                        addStage.setOnShown((event) -> {
                            try {
                                EditHealthRecordController.show();
                            } catch (SQLException e) {
                                throw new RuntimeException(e);
                            } catch (ClassNotFoundException e) {
                                throw new RuntimeException(e);
                            }
                        });

                        addStage.setScene(scene);
                        addStage.show();



                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }

                }
            }
        });

        adoptionRecordTable.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                if (mouseEvent.isPrimaryButtonDown() && mouseEvent.getClickCount() == 2) {
                    addStage = new Stage();
                    try {
                        TitledPane addView = FXMLLoader.load(MainApp.class.getResource("/view/EditAdoptionRecordView.fxml"));
                        Scene scene = new Scene(addView);
                        selectedAdoptionRecord =  adoptionRecordSelectionModel.getSelectedItem();
                        addStage.setOnShown((event) -> {
                            try {
                                EditAdoptionRecordController.show();
                            } catch (SQLException e) {
                                throw new RuntimeException(e);
                            } catch (ClassNotFoundException e) {
                                throw new RuntimeException(e);
                            }
                        });

                        addStage.setScene(scene);
                        addStage.show();



                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }

                }
            }
        });


        populateInit();
    }

    @FXML
    private void refresh(MouseEvent event) throws SQLException, ClassNotFoundException {
        populateInit();
    }

    //Populate Employee
    @FXML
    private void populateEmployee (Employee emp) throws ClassNotFoundException {
        //Declare and ObservableList for table view
        ObservableList<Employee> empData = FXCollections.observableArrayList();
        //Add employee to the ObservableList
        empData.add(emp);
        //Set items to the employeeTable
        employeeTable.setItems(empData);
    }
    //Populate Employee for TableView and Display Employee on TextArea
    @FXML
    private void populateAndShowEmployee(Employee emp) throws ClassNotFoundException {
        if (emp != null) {
            populateEmployee(emp);
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Employee DNE");
            alert.setHeaderText("This employee is not in the database!");
            alert.show();
        }
    }



    @FXML
    private void populateAddresses (ObservableList<Adopter_Address> addressData) {
        //Set items to the employeeTable

    }
    //Populate Employees for TableView
    @FXML
    private void populateEmployees (ObservableList<Employee> empData) {
        //Set items to the employeeTable
        employeeTable.setItems(empData);
    }
    @FXML
    private void insertEmployee (ActionEvent actionEvent) throws SQLException, ClassNotFoundException {

        try {
            addStage = new Stage();
            TitledPane addView = FXMLLoader.load(MainApp.class.getResource("/view/AddEmployeeView.fxml"));
            Scene scene = new Scene(addView);
            addStage.setScene(scene);
            addStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

//        try {
//            EmployeeDAO.insertEmp(roleText.getText(), fNameText.getText(),
//                    Integer.parseInt(employee_IDText.getText()),sexText.getText(), Integer.parseInt(SSNText.getText()),
//                    lNameText.getText(), Integer.parseInt(hoursText.getText()), Integer.parseInt(supervisor_IDText.getText()));
//            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
//            alert.setTitle("Employee Added");
//            alert.setHeaderText("Employee was inserted into the database successfully!");
//            alert.show();
//        } catch (SQLException e) {
//            Alert alert = new Alert(Alert.AlertType.ERROR);
//            alert.setTitle("Error!");
//            alert.setHeaderText("An error occurred while trying to insert the employee to the database!");
//            alert.show();
//            throw e;
//        }
    }

    @FXML
    private void clearEntries(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("WARNING: Clear Entries");
        alert.setHeaderText("You are about to clear all entries.");
        alert.showAndWait();
        employee_IDText.clear();
        fNameText.clear();
        lNameText.clear();
        SSNText.clear();
        hoursText.clear();
        sexText.clear();
        roleText.clear();
        supervisor_IDText.clear();
    }
    //Delete an employee with a given employee ID from DB
    @FXML
    private void deleteEmployee (ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        try {
            EmployeeDAO.deleteEmpWithID(String.valueOf(employeeSelectionModel.getSelectedItem().getEmployee_id()));
            populateEmployees(EmployeeDAO.searchEmployees());
        } catch (SQLException e) {
            throw e;
        }
    }

    /**
     *  Adopter View Functions
     */

    @FXML
    private void populateAdopters(ObservableList<Adopter> adopterData) {
        //Set items to the employeeTable
        adopterTable.setItems(adopterData);
    }

    @FXML
    private void deleteAdopter (ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        try {
            AdopterDAO.deleteAdopterWithID(String.valueOf(adopterSelectionModel.getSelectedItem().getAdopter_id()));
            populateEmployees(EmployeeDAO.searchEmployees());
        } catch (SQLException e) {
            throw e;
        }
    }
    @FXML
    private void insertAdopter (ActionEvent actionEvent) throws SQLException, ClassNotFoundException {

        try {
            addStage = new Stage();
            TitledPane addView = FXMLLoader.load(MainApp.class.getResource("/view/AddAdopterView.fxml"));
            Scene scene = new Scene(addView);
            addStage.setScene(scene);
            addStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void clearAdopterEntries(ActionEvent event){
        adopterIDText.clear();
        fNameAdopterText.clear();
        lNameAdopterText.clear();
        phoneNumberText.clear();
        eligibilityText.clear();
        streetAddressText.clear();
    }
    @FXML
    private void clearHealthEntries(ActionEvent event){
        animalIDHR.clear();
        castrated.setSelected(false);
        rabies.setSelected(false);
        healthRecord.clear();
    }
    @FXML
    private void clearAnimalEntries(ActionEvent event){
        animalID.clear();
        animalAge.clear();
        animalName.clear();
        animalCage.clear();
        species.clear();
        adoptionStatus.clear();
        price.clear();
    }

    @FXML
    private void clearAREntries(ActionEvent event){
        adopterID.clear();
        adopterFName.clear();
        adopterLName.clear();
        adopterPhoneNum.clear();
        caseNumber.clear();
        animalIDAR.clear();
        dateAdopted.clear();
        adopterApprovalRecord.clear();
        animalNameAR.clear();
    }
    @FXML
    private void populateAdopter (Adopter adopter) throws ClassNotFoundException {
        //Declare and ObservableList for table view
        ObservableList<Adopter> adopterData = FXCollections.observableArrayList();
        //Add employee to the ObservableList
        adopterData.add(adopter);
        //Set items to the employeeTable
        adopterTable.setItems(adopterData);
    }

    @FXML
    private void searchAdopter(ActionEvent event) throws SQLException, ClassNotFoundException {
        try {
            ObservableList<Adopter> adopter;
            if (!adopterIDText.getText().isEmpty()) {
                adopter = AdopterDAO.searchAdopter(adopterIDText.getText(), "adopter_id");
                populateAdopters(adopter);
            } else if (!fNameAdopterText.getText().isEmpty()) {
                adopter = AdopterDAO.searchAdopter("'" + fNameAdopterText.getText() + "'", "adopter_fName");
                populateAdopters(adopter);
            } else if (!lNameAdopterText.getText().isEmpty()) {
                adopter = AdopterDAO.searchAdopter("'" + lNameAdopterText.getText() + "'", "adopter_lName");
                populateAdopters(adopter);
            } else if (!phoneNumberText.getText().isEmpty()) {
                adopter = AdopterDAO.searchAdopter("'" + phoneNumberText.getText() + "'", "adopter_phonenumber");
                populateAdopters(adopter);
            } else if (!streetAddressText.getText().isEmpty()) {
                adopter = AdopterDAO.searchAdopter("'" + streetAddressText.getText() + "'", "adopter_Address");
                populateAdopters(adopter);
            } else if (!eligibilityText.getText().isEmpty()) {
                adopter = AdopterDAO.searchAdopter("'" + eligibilityText.getText() + "'", "adopter_approval");
                populateAdopters(adopter);
            }  else {
                populateAdopters(AdopterDAO.searchAdopters());
            }
        } catch (SQLException e) {
            System.out.println("Error occurred while getting adopter information from DB.\n" + e);
            throw e;
        }
    }

    @FXML
    private void populateAndShowAdopter(Adopter ado) throws ClassNotFoundException {
        if (ado != null) {
            populateAdopter(ado);
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Adopter DNE");
            alert.setHeaderText("This adopter is not in the database!");
            alert.show();
        }
    }

    @FXML
    private void searchAdopters(ActionEvent event) throws SQLException, ClassNotFoundException {
        try {
            //Get all Employees information
            ObservableList<Adopter> adoData = AdopterDAO.searchAdopters();
            //Populate Employees on TableView
            populateAdopters(adoData);
        } catch (SQLException e) {
            System.out.println("Error occurred while getting employees information from DB.\n" + e);

        }
    }

    /**
     *  Animal View Functions
     */

    @FXML
    private void populateAnimals(ObservableList<Animal> animalData) {
        //Set items to the employeeTable
        animalTable.setItems(animalData);
    }

    @FXML
    private void deleteAnimal (ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        try {
            AnimalDAO.deleteAnimalWithID(String.valueOf(animalSelectionModel.getSelectedItem().getAnimalID()));
            populateEmployees(EmployeeDAO.searchEmployees());
        } catch (SQLException e) {
            throw e;
        }
    }
    @FXML
    private void searchAnimal(ActionEvent event) throws SQLException, ClassNotFoundException {
        try {
            ObservableList<Animal> animals;
            if (!animalID.getText().isEmpty()) {
                animals = AnimalDAO.searchAnimal(animalID.getText(), "animal_id");
                populateAnimals(animals);
            } else if (!animalName.getText().isEmpty()) {
                animals = AnimalDAO.searchAnimal("'" + animalName.getText() + "'", "animal_name");
                populateAnimals(animals);
            } else if (!adoptionStatus.getText().isEmpty()) {
                animals = AnimalDAO.searchAnimal("'" + adoptionStatus.getText() + "'", "adoption_status");
                populateAnimals(animals);
            } else if (!animalCage.getText().isEmpty()) {
                animals = AnimalDAO.searchAnimal(animalCage.getText(), "CageNum");
                populateAnimals(animals);
            } else if (!animalAge.getText().isEmpty()) {
                animals = AnimalDAO.searchAnimal(animalAge.getText(), "age");
                populateAnimals(animals);
            } else if (!species.getText().isEmpty()) {
                animals = AnimalDAO.searchAnimal("'" + species.getText() + "'", "species");
                populateAnimals(animals);
            } else if (!price.getText().isEmpty()) {
                animals = AnimalDAO.searchAnimal(price.getText(), "price");
                populateAnimals(animals);
            } else {
                populateAnimals(AnimalDAO.searchAnimals());
            }
        } catch (SQLException e) {
            System.out.println("Error occurred while getting adopter information from DB.\n" + e);
            throw e;
        }
    }

    @FXML
    private void insertAnimal(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {

        try {
            addStage = new Stage();
            TitledPane addView = FXMLLoader.load(MainApp.class.getResource("/view/AddAnimalView.fxml"));
            Scene scene = new Scene(addView);
            addStage.setScene(scene);
            addStage.show();
            selectedEmployee.getEmployee_id();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Health Record View Functions
     */
    @FXML
    private void populateHealthRecords(ObservableList<Health_Record> healthRecordData) {
        //Set items to the employeeTable
        healthRecordTable.setItems(healthRecordData);
    }

    @FXML
    private void deleteHealthRecord (ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        try {
            Health_RecordDAO.deleteHealthRecordWithID(String.valueOf(healthRecordSelectionModel.getSelectedItem().getRecordNumber()));
            populateEmployees(EmployeeDAO.searchEmployees());
        } catch (SQLException e) {
            throw e;
        }
    }

    @FXML
    private void searchHealthRecord(ActionEvent event) throws SQLException, ClassNotFoundException {
        try {
            ObservableList<Health_Record> records;
            if (!animalIDHR.getText().isEmpty()) {
                records = Health_RecordDAO.searchHealthRecord(animalIDHR.getText(), "animal_id");
                populateHealthRecords(records);
            } else if (castrated.isSelected()) {
                records = Health_RecordDAO.searchHealthRecord(String.valueOf(castrated.isSelected()), "castrated");
                populateHealthRecords(records);
            } else if (rabies.isSelected()) {
                records = Health_RecordDAO.searchHealthRecord(String.valueOf(rabies.isSelected()), "rabies_vaccine");
                populateHealthRecords(records);
            } else if (!healthRecord.getText().isEmpty()) {
                records = Health_RecordDAO.searchHealthRecord(healthRecord.getText(), "record");
                populateHealthRecords(records);
            }
        } catch (SQLException e) {
            System.out.println("Error occurred while getting adopter information from DB.\n" + e);
            throw e;
        }
    }

    @FXML
    private void searchHealthRecords(ActionEvent event) throws SQLException, ClassNotFoundException {
        populateHealthRecords(Health_RecordDAO.searchHealthRecords());
    }
    @FXML
    private void insertHealthRecord(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {

        try {
            addStage = new Stage();
            TitledPane addView = FXMLLoader.load(MainApp.class.getResource("/view/AddHealthRecordView.fxml"));
            Scene scene = new Scene(addView);
            addStage.setScene(scene);
            addStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     *  Adoption Record View Functions
     */

    @FXML
    private void populateAdoptionRecords(ObservableList<Adoption_Record> adoptionRecordData) {
        adoptionRecordTable.setItems(adoptionRecordData);
    }

    @FXML
    private void deleteAdoptionRecord (ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        try {
            Adoption_RecordDAO.deleteAdoptionRecordWithID(String.valueOf(adoptionRecordSelectionModel.getSelectedItem().getCaseNumber()));
            populateEmployees(EmployeeDAO.searchEmployees());
        } catch (SQLException e) {
            throw e;
        }
    }

    @FXML
    private void searchAdoptionRecord(ActionEvent event) throws SQLException, ClassNotFoundException {
        try {
            ObservableList<Adoption_Record> records;
            if (!dateAdopted.getText().isEmpty()) {
                String date = dateAdopted.getText().replaceAll("-", "");
                records = Adoption_RecordDAO.searchAdoptionRecord(date, "date_adopted");
                populateAdoptionRecords(records);
            } else if (!adopterID.getText().isEmpty()) {
                records = Adoption_RecordDAO.searchAdoptionRecord(adopterID.getText(), "adopter_ID");
                populateAdoptionRecords(records);
            } else if (!adopterFName.getText().isEmpty()) {
                records = Adoption_RecordDAO.searchAdoptionRecord("'" + adopterFName.getText() + "'", "Adopter_Name");
                populateAdoptionRecords(records);
            } else if (!animalIDAR.getText().isEmpty()) {
                records = Adoption_RecordDAO.searchAdoptionRecord(animalIDAR.getText(), "animal_id");
                populateAdoptionRecords(records);
            } else if (!caseNumber.getText().isEmpty()) {
                records = Adoption_RecordDAO.searchAdoptionRecord(caseNumber.getText(), "case_ID");
                populateAdoptionRecords(records);
            } else if (!adopterLName.getText().isEmpty()) {
                records = Adoption_RecordDAO.searchAdoptionRecord("'" + adopterLName.getText() + "'", "Adopter_LName");
                populateAdoptionRecords(records);
            } else if (!adopterPhoneNum.getText().isEmpty()) {
                records = Adoption_RecordDAO.searchAdoptionRecord("'" + adopterPhoneNum.getText() + "'", "adopter_Phone");
                populateAdoptionRecords(records);
            } else if (!adopterApprovalRecord.getText().isEmpty()) {
                records = Adoption_RecordDAO.searchAdoptionRecord("'" + adopterApprovalRecord.getText() + "'", "Adopter_approval");
                populateAdoptionRecords(records);
            } else if (!animalNameAR.getText().isEmpty()) {
                records = Adoption_RecordDAO.searchAdoptionRecord("'" + animalNameAR.getText() + "'", "animal_name");
                populateAdoptionRecords(records);
            } else {
                populateAdoptionRecords(Adoption_RecordDAO.searchAdoptionRecords());
            }
        } catch (SQLException e) {
            System.out.println("Error occurred while getting adopter information from DB.\n" + e);
            throw e;
        }
    }
    @FXML
    private void insertAdoptionRecord(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {

        try {
            addStage = new Stage();
            TitledPane addView = FXMLLoader.load(MainApp.class.getResource("/view/AddAdoptionRecordView.fxml"));
            Scene scene = new Scene(addView);
            addStage.setScene(scene);
            addStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
