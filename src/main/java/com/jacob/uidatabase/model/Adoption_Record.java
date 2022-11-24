package com.jacob.uidatabase.model;

import javafx.beans.property.*;

import java.sql.Date;

/**
 * @author : Jacob Sanderlin
 * @mailto : js50598@georgiasouthern.edu
 * @created : 11/21/2022, Monday
 **/
public class Adoption_Record {

    private final IntegerProperty adopterID;
    private final StringProperty firstName;
    private final StringProperty lastName;
    private final StringProperty phoneNumber;
    private final IntegerProperty caseNumber;
    private final IntegerProperty animalID;
    private final ObjectProperty<Date> dateAdopted;
    private final StringProperty adopterApproval;

    public Adoption_Record() {
        this.adopterID = new SimpleIntegerProperty();
        this.firstName = new SimpleStringProperty();
        this.lastName = new SimpleStringProperty();
        this.phoneNumber = new SimpleStringProperty();
        this.caseNumber = new SimpleIntegerProperty();
        this.animalID = new SimpleIntegerProperty();
        this.dateAdopted = new SimpleObjectProperty<>();
        this.adopterApproval = new SimpleStringProperty();
    }

    public int getAdopterID() {
        return adopterID.get();
    }

    public IntegerProperty adopterIDProperty() {
        return adopterID;
    }

    public void setAdopterID(int adopterID) {
        this.adopterID.set(adopterID);
    }

    public String getFirstName() {
        return firstName.get();
    }

    public StringProperty firstNameProperty() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName.set(firstName);
    }

    public String getLastName() {
        return lastName.get();
    }

    public StringProperty lastNameProperty() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName.set(lastName);
    }

    public String getPhoneNumber() {
        return phoneNumber.get();
    }

    public StringProperty phoneNumberProperty() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber.set(phoneNumber);
    }

    public int getCaseNumber() {
        return caseNumber.get();
    }

    public IntegerProperty caseNumberProperty() {
        return caseNumber;
    }

    public void setCaseNumber(int caseNumber) {
        this.caseNumber.set(caseNumber);
    }

    public int getAnimalID() {
        return animalID.get();
    }

    public IntegerProperty animalIDProperty() {
        return animalID;
    }

    public void setAnimalID(int animalID) {
        this.animalID.set(animalID);
    }

    public Date getDateAdopted() {
        return dateAdopted.get();
    }

    public ObjectProperty<Date> dateAdoptedProperty() {
        return dateAdopted;
    }

    public void setDateAdopted(Date dateAdopted) {
        this.dateAdopted.set(dateAdopted);
    }

    public String getAdopterApproval() {
        return adopterApproval.get();
    }

    public StringProperty adopterApprovalProperty() {
        return adopterApproval;
    }

    public void setAdopterApproval(String adopterApproval) {
        this.adopterApproval.set(adopterApproval);
    }
}
