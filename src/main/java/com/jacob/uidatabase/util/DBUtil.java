package com.jacob.uidatabase.util;


import com.jacob.uidatabase.controller.LoginViewController;

import javax.sql.RowSet.*;
import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetProvider;

import java.sql.*;


/**
 * @author : Jacob Sanderlin
 * @mailto : js50598@georgiasouthern.edu
 * @created : 11/9/2022, Wednesday
 **/
public class DBUtil {

    // Declare JDBC Driver
    private static final String JDBC_DRIVER = "oracle.jdbc.driver.OracleDriver";

    private static Connection conn = null;

    private static final String connStr = LoginViewController.getConnectionString();

    public static void dbConnect(String connectionString) throws SQLException, ClassNotFoundException {
        try {
            Class.forName(JDBC_DRIVER);
        } catch (ClassNotFoundException e) {
            System.out.println("Where is your Oracle JDBC Driver?");
            e.printStackTrace( );
            throw e;
        }

        System.out.println("Oracle JDBC Driver Registered!");

        try {
            conn = DriverManager.getConnection(connectionString);
        } catch (SQLException e) {
            System.out.println("Connection Failed! Check output console" + e);
            e.printStackTrace();
            throw e;
        }
    }

    public static void dbDisconnect() throws SQLException {
        try {
            if (conn != null && !conn.isClosed()) {
                conn.close();
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public static ResultSet dbExecuteQuery(String queryStmt) throws SQLException, ClassNotFoundException {

        Statement stmt = null;
        ResultSet resultSet = null;
        CachedRowSet crs = null;
        try {
            dbConnect(connStr);
            System.out.println("Select statement: " + queryStmt + "\n");
            stmt = conn.createStatement();

            resultSet = stmt.executeQuery(queryStmt);

            crs = RowSetProvider.newFactory().createCachedRowSet();
            crs.populate(resultSet);
        } catch (SQLException e) {
            System.out.println("Problem occurred at executeQuery operation : " + e);
            throw e;
        } finally {
            if (resultSet != null) {
                resultSet.close();
            }

            if (stmt != null) {
                stmt.close();
            }

            dbDisconnect();
        }

        return crs;
    }

    public static void dbExecuteUpdate(String sqlStmt) throws SQLException, ClassNotFoundException {
        Statement stmt = null;
        try {
            dbConnect(connStr);
            stmt = conn.createStatement();
            stmt.executeUpdate(sqlStmt);
        } catch (SQLException e) {
            System.out.println("Problem occurred at executeUpdate operation : " + e);
            throw e;
        } finally {
            if (stmt != null) {
                stmt.close();
            }
            dbDisconnect();
        }
    }
}
