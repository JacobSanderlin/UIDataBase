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
public class AdopterDAO {

    public static Adopter searchAdopter(String adopterID) throws SQLException, ClassNotFoundException {
        String selectStmt = "SELECT * FROM adopter WHERE adopter_id="+ adopterID;

        try {
            ResultSet rsAdopter = DBUtil.dbExecuteQuery(selectStmt);

            return getAdopterFromResultSet(rsAdopter);
        } catch (SQLException e) {
            System.out.println("While searching an employee with " + adopterID + " id, an error occurred: " + e);
            throw e;
        }
    }

    private static Adopter getAdopterFromResultSet(ResultSet rs) throws SQLException {
        Adopter adopter = null;
        if (rs.next()) {
            adopter = new Adopter();
            adopter.setAdopter_id(rs.getInt("ADOPTER_ID"));
            adopter.setEligibility(rs.getString("ADOPTER_APPROVAL"));
            adopter.setFirst_name(rs.getString("ADOPTER_FNAME"));
            adopter.setLast_name(rs.getString("ADOPTER_LNAME"));
            adopter.setPhone_number(rs.getString("ADOPTER_PHONENUMBER"));
            adopter.setStreet_Address(rs.getString("adopter_Address"));
        }
        return adopter;
    }

    public static ObservableList<Adopter> searchAdopters() throws SQLException, ClassNotFoundException {
        String selectStmt = "SELECT * FROM animalshelter.adopter";

        try {
            ResultSet rsAdopters = DBUtil.dbExecuteQuery(selectStmt);

            return getAdopterList(rsAdopters);
        } catch (SQLException e) {
            System.out.println("SQL select operation has been failed: " + e);
            throw e;
        }
    }

    private static ObservableList<Adopter> getAdopterList(ResultSet rs) throws SQLException, ClassNotFoundException {
        ObservableList<Adopter> adopterList = FXCollections.observableArrayList();

        while (rs.next()) {
            Adopter adopter = new Adopter();
            adopter.setAdopter_id(rs.getInt("adopter_ID"));
            adopter.setFirst_name(rs.getString("adopter_FName"));
            adopter.setLast_name(rs.getString("adopter_LName"));
            adopter.setEligibility(rs.getString("adopter_Approval"));
            adopter.setPhone_number(rs.getString("adopter_PhoneNumber"));
            adopter.setStreet_Address(rs.getString("adopter_Address"));
            adopterList.add(adopter);
        }

        return adopterList;
    }
}
