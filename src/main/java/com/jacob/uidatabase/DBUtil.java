package com.jacob.uidatabase;

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

    private static final String connStr = "jdbc:oracle:thin:root/280Batmankitbest123@localhost:3306";
}
