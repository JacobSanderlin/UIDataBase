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
public class Adoption_RecordDAO {

    public static ObservableList<Adoption_Record> searchAdoptionRecord(String search, String searchField) throws SQLException, ClassNotFoundException {
        String selectStmt = "SELECT * FROM animalshelter.adoption_record WHERE " + searchField +"="+search;

        try {
            ResultSet rsEmp = DBUtil.dbExecuteQuery(selectStmt);

            return getAdoptionRecordList(rsEmp);
        } catch (SQLException e) {
            System.out.println("While searching, an error occurred: " + e);
            throw e;
        }
    }

    private static Adoption_Record getAdoptionRecordFromResultSet(ResultSet rs) throws SQLException {
        Adoption_Record record = null;
        if (rs.next()) {
            record = new Adoption_Record();
            record.setAdopterID(rs.getInt("ADOPTER_ID"));
            record.setPhoneNumber(rs.getString("ADOPTER_Phone"));
            record.setFirstName(rs.getString("ADOPTER_NAME"));
            record.setLastName(rs.getString("ADOPTER_LNAME"));
            record.setAnimalID(rs.getInt("Animal_ID"));
            record.setAdopterApproval(rs.getString("adopter_Approval"));
            record.setCaseNumber(rs.getInt("Case_ID"));
            record.setDateAdopted(rs.getDate("Date_Adopted"));
            record.setAnimalName(rs.getString("animal_name"));
        }
        return record;
    }

    public static ObservableList<Adoption_Record> searchAdoptionRecords() throws SQLException, ClassNotFoundException {
        String selectStmt = "SELECT * FROM animalshelter.adoption_record";

        try {
            ResultSet rsRecords = DBUtil.dbExecuteQuery(selectStmt);

            return getAdoptionRecordList(rsRecords);
        } catch (SQLException e) {
            System.out.println("SQL select operation has been failed: " + e);
            throw e;
        }
    }

    private static ObservableList<Adoption_Record> getAdoptionRecordList(ResultSet rs) throws SQLException, ClassNotFoundException {
        ObservableList<Adoption_Record> recordList = FXCollections.observableArrayList();

        while (rs.next()) {
            Adoption_Record record = new Adoption_Record();
            record.setAdopterID(rs.getInt("ADOPTER_ID"));
            record.setPhoneNumber(rs.getString("ADOPTER_Phone"));
            record.setFirstName(rs.getString("ADOPTER_NAME"));
            record.setLastName(rs.getString("ADOPTER_LNAME"));
            record.setAnimalID(rs.getInt("Animal_ID"));
            record.setAdopterApproval(rs.getString("adopter_Approval"));
            record.setCaseNumber(rs.getInt("Case_ID"));
            record.setDateAdopted(rs.getDate("Date_Adopted"));
            record.setAnimalName(rs.getString("animal_name"));
            recordList.add(record);
        }

        return recordList;
    }
    public static void insertAdoptionRecord(int id, String fname, String lname, String name,
                                            int aid, int caseid, String phone, String approval,
                                            String date) throws SQLException, ClassNotFoundException {
        String updateStmt =
                "INSERT INTO animalshelter.adoption_record\n" +
                        "VALUES (" + id + ", '" + phone + "', '" + fname + "', '" + name + "', "
                        + caseid + ", " + date + ",'" + approval + "', " + aid + ", '" + lname + "');";
        try {
            DBUtil.dbExecuteUpdate(updateStmt);
        } catch (SQLException e) {
            System.out.print("Error occurred while INSERT Operation: " + e);
            throw e;
        }
    }

    public static void deleteAdoptionRecordWithID(String record) throws SQLException, ClassNotFoundException {
        String updateStmt =
                "   DELETE FROM animalshelter.adoption_record\n" +
                        "         WHERE case_ID ="+ record +";\n";

        try {
            DBUtil.dbExecuteUpdate(updateStmt);
        } catch (SQLException e) {
            System.out.println("Error occurred while DELETE Operation: " + e);
            throw e;
        }
    }
}
