package com.jacob.uidatabase.model;

import com.jacob.uidatabase.util.DBUtil;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author : Jacob Sanderlin
 * @mailto : js50598@georgiasouthern.edu
 * @created : 11/23/2022, Wednesday
 **/
public class AnimalDAO {


    public static ObservableList<Animal> searchAnimal(String search, String searchField) throws SQLException, ClassNotFoundException {
        String selectStmt = "SELECT * FROM animalshelter.animal WHERE " + searchField +"="+search;

        try {
            ResultSet rsEmp = DBUtil.dbExecuteQuery(selectStmt);

            return getAnimalList(rsEmp);
        } catch (SQLException e) {
            System.out.println("While searching, an error occurred: " + e);
            throw e;
        }
    }

    private static Animal getAnimalFromResultSet(ResultSet rs) throws SQLException {
        Animal animal = null;
        if (rs.next()) {
            animal = new Animal();
            animal.setAnimalID(rs.getInt("animal_id"));
            animal.setAge(rs.getInt("age"));
            animal.setName(rs.getString("animal_name"));
            animal.setPrice(rs.getDouble("price"));
            animal.setAdoptionStatus(rs.getString("adoption_status"));
            animal.setCageNumber(rs.getInt("cagenum"));
            animal.setSpecies(rs.getString("species"));
        }
        return animal;
    }

    public static ObservableList<Animal> searchAnimals() throws SQLException, ClassNotFoundException {
        String selectStmt = "SELECT * FROM animalshelter.animal";

        try {
            ResultSet rsAnimals = DBUtil.dbExecuteQuery(selectStmt);

            return getAnimalList(rsAnimals);
        } catch (SQLException e) {
            System.out.println("SQL select operation has been failed: " + e);
            throw e;
        }
    }

    private static ObservableList<Animal> getAnimalList(ResultSet rs) throws SQLException, ClassNotFoundException {
        ObservableList<Animal> animals = FXCollections.observableArrayList();

        while (rs.next()) {
            Animal animal = new Animal();
            animal.setAnimalID(rs.getInt("animal_id"));
            animal.setAge(rs.getInt("age"));
            animal.setName(rs.getString("animal_name"));
            animal.setPrice(rs.getDouble("price"));
            animal.setAdoptionStatus(rs.getString("adoption_status"));
            animal.setCageNumber(rs.getInt("cagenum"));
            animal.setSpecies(rs.getString("species"));
            animals.add(animal);
        }

        return animals;
    }

    public static void insertAnimal(int id, String name, int age, String species, int cage, String status, double price) throws SQLException, ClassNotFoundException {
        String updateStmt =
                "INSERT INTO animalshelter.animal\n" +
                        "VALUES (" + age + ", " + cage + ", " + id + ", " + price + ", '"
                        + name + "', '" + species + "','" + status + ");";
        try {
            DBUtil.dbExecuteUpdate(updateStmt);
        } catch (SQLException e) {
            System.out.print("Error occurred while INSERT Operation: " + e);
            throw e;
        }
    }
}
