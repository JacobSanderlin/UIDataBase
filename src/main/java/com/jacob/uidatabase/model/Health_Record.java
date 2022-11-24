package com.jacob.uidatabase.model;

import javafx.beans.property.*;

/**
 * @author : Jacob Sanderlin
 * @mailto : js50598@georgiasouthern.edu
 * @created : 11/21/2022, Monday
 **/
public class Health_Record {

    private final IntegerProperty animalID;
    private final BooleanProperty castrated;
    private final BooleanProperty vaccinated;
    private final IntegerProperty recordNumber;

    public Health_Record() {
        this.animalID = new SimpleIntegerProperty();
        this.castrated = new SimpleBooleanProperty();
        this.vaccinated = new SimpleBooleanProperty();
        this.recordNumber = new SimpleIntegerProperty();
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

    public boolean isCastrated() {
        return castrated.get();
    }

    public BooleanProperty castratedProperty() {
        return castrated;
    }

    public void setCastrated(boolean castrated) {
        this.castrated.set(castrated);
    }

    public boolean isVaccinated() {
        return vaccinated.get();
    }

    public BooleanProperty vaccinatedProperty() {
        return vaccinated;
    }

    public void setVaccinated(boolean vaccinated) {
        this.vaccinated.set(vaccinated);
    }

    public int getRecordNumber() {
        return recordNumber.get();
    }

    public IntegerProperty recordNumberProperty() {
        return recordNumber;
    }

    public void setRecordNumber(int recordNumber) {
        this.recordNumber.set(recordNumber);
    }
}
