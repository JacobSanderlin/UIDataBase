package com.jacob.uidatabase.model;

import javafx.beans.property.*;

/**
 * @author : Jacob Sanderlin
 * @mailto : js50598@georgiasouthern.edu
 * @created : 11/21/2022, Monday
 **/
public class Animal {

    private final IntegerProperty animalID;
    private final IntegerProperty age;
    private final IntegerProperty cageNumber;
    private final DoubleProperty price;
    private final StringProperty name;
    private final StringProperty adoptionStatus;
    private final StringProperty species;

    public Animal() {
        this.animalID = new SimpleIntegerProperty();
        this.age = new SimpleIntegerProperty();
        this.cageNumber = new SimpleIntegerProperty();
        this.price = new SimpleDoubleProperty();
        this.name = new SimpleStringProperty();
        this.adoptionStatus = new SimpleStringProperty();
        this.species = new SimpleStringProperty();
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

    public int getAge() {
        return age.get();
    }

    public IntegerProperty ageProperty() {
        return age;
    }

    public void setAge(int age) {
        this.age.set(age);
    }

    public int getCageNumber() {
        return cageNumber.get();
    }

    public IntegerProperty cageNumberProperty() {
        return cageNumber;
    }

    public void setCageNumber(int cageNumber) {
        this.cageNumber.set(cageNumber);
    }

    public double getPrice() {
        return price.get();
    }

    public DoubleProperty priceProperty() {
        return price;
    }

    public void setPrice(double price) {
        this.price.set(price);
    }

    public String getName() {
        return name.get();
    }

    public StringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public String getAdoptionStatus() {
        return adoptionStatus.get();
    }

    public StringProperty adoptionStatusProperty() {
        return adoptionStatus;
    }

    public void setAdoptionStatus(String adoptionStatus) {
        this.adoptionStatus.set(adoptionStatus);
    }

    public String getSpecies() {
        return species.get();
    }

    public StringProperty speciesProperty() {
        return species;
    }

    public void setSpecies(String species) {
        this.species.set(species);
    }
}
