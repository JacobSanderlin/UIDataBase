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

            Employee employee = getEmployeeFromResultSet(rsEmp);

            return employee;
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
        String selectStmt = "SELECT * FROM employees";

        try {
            ResultSet rsEmps = DBUtil.dbExecuteQuery(selectStmt);

            ObservableList<Employee> empList = getEmployeeList(rsEmps);

            return empList;
        } catch (SQLException e) {
            System.out.println("SQL select operation has been failed: " + e);
            throw e;
        }
    }

    private static ObservableList<Employee> getEmployeeList(ResultSet rs) throws SQLException, ClassNotFoundException {
        ObservableList<Employee> empList = FXCollections.observableArrayList();

        while (rs.next()) {
            Employee emp = new Employee();
            emp.setEmployee_id(rs.getInt("EMPLOYEE_ID"));
            emp.setFirst_name(rs.getString("FIRST_NAME"));
            emp.setLast_name(rs.getString("LAST_NAME"));
            emp.setHours(rs.getInt("HOURS"));
            emp.setSSN(rs.getInt("SSN"));
            emp.setRole(rs.getString("ROLE"));
            emp.setSex(rs.getString("SEX"));
            emp.setSupervisor_id(rs.getInt("SUPERVISOR_ID"));
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

    public static void insertEmp (String role, String name, int id, String sex, int SSN) throws SQLException, ClassNotFoundException {
        //Declare a DELETE statement
        String updateStmt =
                "BEGIN\n" +
                        "INSERT INTO employees\n" +
                        "(ROLE, EMPLOYEE_NAME, EMPLOYEE_ID, SEX, SSN)\n" +
                        "VALUES\n" +
                        "(sequence_employee.nextval, '"+role+"', '"+name+"', '"+id+"','"+sex+"','"+SSN+ ");\n" +
                        "END;";
        //Execute DELETE operation
        try {
            DBUtil.dbExecuteUpdate(updateStmt);
        } catch (SQLException e) {
            System.out.print("Error occurred while DELETE Operation: " + e);
            throw e;
        }
    }
}
