package com.jacob.uidatabase.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * @author : Jacob Sanderlin
 * @mailto : js50598@georgiasouthern.edu
 * @created : 11/21/2022, Monday
 **/
public class Adopter_Address {

    private final StringProperty street;
    private final StringProperty city;
    private final StringProperty state;
    private final IntegerProperty zip;

    public Adopter_Address() {
        this.street = new SimpleStringProperty();
        this.city = new SimpleStringProperty();
        this.state = new SimpleStringProperty();
        this.zip = new SimpleIntegerProperty();
    }

    public String getStreet() { return street.get();}

    public String getCity() { return city.get(); }

    public String getState() { return state.get(); }

    public int getZip() { return zip.get(); }

    public void setStreet(String street) { this.street.set(street); }

    public void setCity(String city) { this.city.set(city); }

    public void setState(String state) { this.state.set(state); }

    public void setZip(int zip) { this.zip.set(zip); }

    public StringProperty cityProperty() { return city; }

    public StringProperty stateProperty() { return state; }

    public StringProperty streetProperty() { return street; }

    public IntegerProperty zipProperty() { return zip; }
}
