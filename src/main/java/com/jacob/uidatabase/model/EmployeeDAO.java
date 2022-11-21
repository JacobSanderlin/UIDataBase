package com.jacob.uidatabase.model;

import com.jacob.uidatabase.util.DBUtil;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author : Jacob Sanderlin
 * @mailto : js50598@georgiasouthern.edu
 * @created : 11/13/2022, Sunday
 **/
public class EmployeeDAO {

    public static Employee searchEmployee(String empID) throws SQLException, ClassNotFoundException {
        String selectStmt = "SELECT * FROM employees WHERE employee_id="+empID;

        try {
            ResultSet rsEmp = DBUtil.dbExecuteQuery(selectStmt);

            return getEmployeeFromResultSet(rsEmp);
        } catch (SQLException e) {
            System.out.println("While searching an employee with " + empID + " id, an error occurred: " + e);
            throw e;
        }
    }

    private static Employee getEmployeeFromResultSet(ResultSet rs) throws SQLException {
        Employee emp = null;
        if (rs.next()) {
            emp = new Employee();
            emp.setEmployee_id(rs.getInt("EMPLOYEE_ID"));
            emp.setFirst_name(rs.getString("FIRST_NAME"));
            emp.setLast_name(rs.getString("LAST_NAME"));
            emp.setHours(rs.getInt("HOURS"));
            emp.setSSN(rs.getInt("SSN"));
            emp.setRole(rs.getString("ROLE"));
            emp.setSex(rs.getString("SEX"));
            emp.setSupervisor_id(rs.getInt("SUPERVISOR_ID"));
        }
        return emp;
    }

    public static ObservableList<Employee> searchEmployees() throws SQLException, ClassNotFoundException {
        String selectStmt = "SELECT * FROM animalshelter.employee";

        try {
            ResultSet rsEmps = DBUtil.dbExecuteQuery(selectStmt);

            return getEmployeeList(rsEmps);
        } catch (SQLException e) {
            System.out.println("SQL select operation has been failed: " + e);
            throw e;
        }
    }

    private static ObservableList<Employee> getEmployeeList(ResultSet rs) throws SQLException, ClassNotFoundException {
        ObservableList<Employee> empList = FXCollections.observableArrayList();

        while (rs.next()) {
            Employee emp = new Employee();
            emp.setEmployee_id(rs.getInt("Employee_ID"));
            emp.setFirst_name(rs.getString("fName"));
            emp.setLast_name(rs.getString("lName"));
            emp.setHours(rs.getInt("hours"));
            emp.setSSN(rs.getInt("SSN"));
            emp.setRole(rs.getString("role"));
            emp.setSex(rs.getString("sex"));
            emp.setSupervisor_id(rs.getInt("supervisor_ID"));
            empList.add(emp);
        }

        return empList;
    }

    public static void deleteEmpWithID(String empID) throws SQLException, ClassNotFoundException {
        String updateStmt = "Begin\n" +
                "   DELETE FROM employees\n" +
                "         WHERE employee_id ="+ empID +";\n" +
                "   COMMIT;\n" +
                "END;";

        try {
            DBUtil.dbExecuteUpdate(updateStmt);
        } catch (SQLException e) {
            System.out.println("Error occurred while DELETE Operation: " + e);
            throw e;
        }
    }

    public static void insertEmp (String role, String fName, int id, String sex, int SSN, String lName, int hours, int supervisorID) throws SQLException, ClassNotFoundException {
        //INSERT INTO `animalshelter`.`employee`
        //(`Role`, `Employee_FName`, `Employee_ID`, `Employee_Sex`, `Employee_SSN`, `Employee_LName`, `Employee_Hours`, `Supervisor_ID`)
        //VALUES ('General\n', 'John', '1234567', 'M', '111223333', 'Smith', '25', '7654321');
        String updateStmt =
                        "INSERT INTO animalshelter.employee\n" +
                        "VALUES ('" + role + "', '" + fName + "', " + id + ", " + SSN + ", '"
                        + sex + "', '" + lName + "', " + hours + ", " + supervisorID +");";
        try {
            DBUtil.dbExecuteUpdate(updateStmt);
        } catch (SQLException e) {
            System.out.print("Error occurred while INSERT Operation: " + e);
            throw e;
        }
    }
}
