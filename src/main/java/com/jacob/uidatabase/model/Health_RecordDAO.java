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
public class Health_RecordDAO {

    public static ObservableList<Health_Record> searchHealthRecord(String search, String searchField) throws SQLException, ClassNotFoundException {
        String selectStmt = "SELECT * FROM animalshelter.health_records WHERE " + searchField +"="+search;

        try {
            ResultSet rsEmp = DBUtil.dbExecuteQuery(selectStmt);

            return getHealthRecordList(rsEmp);
        } catch (SQLException e) {
            System.out.println("While searching, an error occurred: " + e);
            throw e;
        }
    }

    private static Health_Record getHealthRecordFromResultSet(ResultSet rs) throws SQLException {
        Health_Record record = null;
        if (rs.next()) {
            record = new Health_Record();
            record.setRecordNumber(rs.getInt("record"));
            record.setAnimalID(rs.getInt("animal_id"));
            record.setCastrated(rs.getBoolean("castrated"));
            record.setVaccinated(rs.getBoolean("rabies_vaccine"));
        }
        return record;
    }

    public static ObservableList<Health_Record> searchHealthRecords() throws SQLException, ClassNotFoundException {
        String selectStmt = "SELECT * FROM animalshelter.health_records";

        try {
            ResultSet rsRecords = DBUtil.dbExecuteQuery(selectStmt);

            return getHealthRecordList(rsRecords);
        } catch (SQLException e) {
            System.out.println("SQL select operation has been failed: " + e);
            throw e;
        }
    }

    private static ObservableList<Health_Record> getHealthRecordList(ResultSet rs) throws SQLException, ClassNotFoundException {
        ObservableList<Health_Record> recordList = FXCollections.observableArrayList();

        while (rs.next()) {
            Health_Record record = new Health_Record();
            record = new Health_Record();
            record.setRecordNumber(rs.getInt("record"));
            record.setAnimalID(rs.getInt("animal_id"));
            record.setCastrated(rs.getBoolean("castrated"));
            record.setVaccinated(rs.getBoolean("rabies_vaccine"));
            recordList.add(record);
        }

        return recordList;
    }
}
