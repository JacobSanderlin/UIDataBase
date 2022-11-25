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

    public static ObservableList<Adopter> searchAdopter(String search, String searchField) throws SQLException, ClassNotFoundException {
        String selectStmt = "SELECT * FROM animalshelter.adopter WHERE " + searchField +"="+search;

        try {
            ResultSet rsEmp = DBUtil.dbExecuteQuery(selectStmt);

            return getAdopterList(rsEmp);
        } catch (SQLException e) {
            System.out.println("While searching, an error occurred: " + e);
            throw e;
        }
    }

    public static void deleteAdopterWithID(String adopterID) throws SQLException, ClassNotFoundException {
        String updateStmt =
                "   DELETE FROM animalshelter.adopter\n" +
                        "         WHERE adopter_ID ="+ adopterID +";\n";

        try {
            DBUtil.dbExecuteUpdate(updateStmt);
        } catch (SQLException e) {
            System.out.println("Error occurred while DELETE Operation: " + e);
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

    public static void insertAdopter(int id, String fName, String lName, String phoneNumber, String approval, String address) throws SQLException, ClassNotFoundException {
        //INSERT INTO `animalshelter`.`employee`
        //(`Role`, `Employee_FName`, `Employee_ID`, `Employee_Sex`, `Employee_SSN`, `Employee_LName`, `Employee_Hours`, `Supervisor_ID`)
        //VALUES ('General\n', 'John', '1234567', 'M', '111223333', 'Smith', '25', '7654321');
        String updateStmt =
                "INSERT INTO animalshelter.adopter\n" +
                        "VALUES (" + id + ", '" + approval + "', '" + fName + "', '" + address + "', '"
                        + lName + "', '" + phoneNumber + "');";
        try {
            DBUtil.dbExecuteUpdate(updateStmt);
        } catch (SQLException e) {
            System.out.print("Error occurred while INSERT Operation: " + e);
            throw e;
        }
    }
}
