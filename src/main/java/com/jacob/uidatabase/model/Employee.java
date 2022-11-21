package com.jacob.uidatabase.model;

import javafx.beans.property.*;
import javafx.beans.property.SimpleIntegerProperty;

/**
 * @author : Jacob Sanderlin
 * @mailto : js50598@georgiasouthern.edu
 * @created : 11/13/2022, Sunday
 **/
public class Employee {

    private final IntegerProperty employee_id;
    private final StringProperty first_name;
    private final StringProperty last_name;
    private final IntegerProperty hours;
    private final IntegerProperty SSN;
    private final StringProperty sex;
    private final StringProperty role;
    private final IntegerProperty supervisor_id;

    public Employee() {
        this.employee_id = new SimpleIntegerProperty();
        this.first_name = new SimpleStringProperty();
        this.last_name = new SimpleStringProperty();
        this.hours = new SimpleIntegerProperty();
        this.SSN = new SimpleIntegerProperty();
        this.sex = new SimpleStringProperty();
        this.role = new SimpleStringProperty();
        this.supervisor_id = new SimpleIntegerProperty();
    }

    public int getEmployee_id() {
        return employee_id.get();
    }

    public IntegerProperty employee_idProperty() {
        return employee_id;
    }

    public void setEmployee_id(int employee_id) {
        this.employee_id.set(employee_id);
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

    public int getHours() {
        return hours.get();
    }

    public IntegerProperty hoursProperty() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours.set(hours);
    }

    public int getSSN() {
        return SSN.get();
    }

    public IntegerProperty SSNProperty() {
        return SSN;
    }

    public void setSSN(int SSN) {
        this.SSN.set(SSN);
    }

    public String getSex() {
        return sex.get();
    }

    public StringProperty sexProperty() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex.set(sex);
    }

    public String getRole() {
        return role.get();
    }

    public StringProperty roleProperty() {
        return role;
    }

    public void setRole(String role) {
        this.role.set(role);
    }

    public int getSupervisor_id() {
        return supervisor_id.get();
    }

    public IntegerProperty supervisor_idProperty() {
        return supervisor_id;
    }

    public void setSupervisor_id(int supervisor_id) {
        this.supervisor_id.set(supervisor_id);
    }
}
