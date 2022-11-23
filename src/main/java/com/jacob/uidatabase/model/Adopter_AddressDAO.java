package com.jacob.uidatabase.model;

import com.jacob.uidatabase.util.DBUtil;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author : Jacob Sanderlin
 * @mailto : js50598@georgiasouthern.edu
 * @created : 11/21/2022, Monday
 **/
public class Adopter_AddressDAO {

    public static Adopter_Address searchAdopterAddress(String street_Address) throws SQLException, ClassNotFoundException {
        String selectStmt = "SELECT * FROM adopter_address WHERE street_address="+ street_Address;

        try {
            ResultSet rsAdopterAddress = DBUtil.dbExecuteQuery(selectStmt);

            return getAdopterAddressFromResultSet(rsAdopterAddress);
        } catch (SQLException e) {
            System.out.println("While searching an employee with " + street_Address + " id, an error occurred: " + e);
            throw e;
        }
    }

    private static Adopter_Address getAdopterAddressFromResultSet(ResultSet rs) throws SQLException {
        Adopter_Address address = null;
        if (rs.next()) {
            address = new Adopter_Address();
            address.setStreet(rs.getString("Street_Address"));
            address.setCity(rs.getString("City"));
            address.setState(rs.getString("State"));
            address.setZip(rs.getInt("Zip"));
        }
        return address;
    }

    public static ObservableList<Adopter_Address> searchAdopters() throws SQLException, ClassNotFoundException {
        String selectStmt = "SELECT * FROM animalshelter.adopter_address";

        try {
            ResultSet rsAdopters = DBUtil.dbExecuteQuery(selectStmt);

            return getAdopterList(rsAdopters);
        } catch (SQLException e) {
            System.out.println("SQL select operation has been failed: " + e);
            throw e;
        }
    }

    private static ObservableList<Adopter_Address> getAdopterList(ResultSet rs) throws SQLException, ClassNotFoundException {
        ObservableList<Adopter_Address> addresses = FXCollections.observableArrayList();

        while (rs.next()) {
            Adopter_Address address = new Adopter_Address();
            address.setStreet(rs.getString("Street_Address"));
            address.setCity(rs.getString("City"));
            address.setState(rs.getString("State"));
            address.setZip(rs.getInt("Zip"));
            addresses.add(address);
        }

        return addresses;
    }
}
