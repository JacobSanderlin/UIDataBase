package com.jacob.uidatabase.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * @author : Jacob Sanderlin
 * @mailto : js50598@georgiasouthern.edu
 * @created : 11/18/2022, Friday
 **/
public class Adopter {

    private final IntegerProperty adopter_id;
    private final StringProperty first_name;
    private final StringProperty last_name;
    private final StringProperty phone_number;
    private final StringProperty eligibility;
    private final StringProperty street_Address;

    public Adopter() {
        this.adopter_id = new SimpleIntegerProperty();
        this.first_name = new SimpleStringProperty();
        this.last_name = new SimpleStringProperty();
        this.phone_number = new SimpleStringProperty();
        this.eligibility = new SimpleStringProperty();
        this.street_Address = new SimpleStringProperty();

    }

    public int getAdopter_id() {
        return adopter_id.get();
    }

    public IntegerProperty adopter_idProperty() {
        return adopter_id;
    }

    public void setAdopter_id(int adopter_id) {
        this.adopter_id.set(adopter_id);
    }

    public String getFirst_name() {
        return first_name.get();
    }

    public StringProperty first_nameProperty() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name.set(first_name);
    }

    public String getLast_name() {
        return last_name.get();
    }

    public StringProperty last_nameProperty() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name.set(last_name);
    }

    public String getPhone_number() {
        return phone_number.get();
    }

    public StringProperty phone_numberProperty() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number.set(phone_number);
    }

    public String getEligibility() {
        return eligibility.get();
    }

    public StringProperty eligibilityProperty() {
        return eligibility;
    }

    public void setEligibility(String eligibility) {
        this.eligibility.set(eligibility);
    }

    public String getStreet_Address() {
        return street_Address.get();
    }

    public StringProperty street_AddressProperty() {
        return street_Address;
    }

    public void setStreet_Address(String street_Address) {
        this.street_Address.set(street_Address);
    }
}
