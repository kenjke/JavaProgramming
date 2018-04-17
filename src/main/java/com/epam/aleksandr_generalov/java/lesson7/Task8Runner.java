package com.epam.aleksandr_generalov.java.lesson7;

import com.epam.aleksandr_generalov.java.lesson7.daoimpl.EmployeeDaoImpl;
import com.epam.aleksandr_generalov.java.lesson7.entities.Employee;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

class Task8Runner {

    public static void main(String args[]) {
        Connection connection = null;
        try {
            connection = ConnectionConfiguration.getConnection();
            if (connection != null) {
                System.out.println("Connection established!" + connection.getMetaData().getURL());
            }
            EmployeeDaoImpl employeeDao = new EmployeeDaoImpl();
            Employee employee = new Employee("Aleksandr", "Generalov");
            employeeDao.insert(employee);
            for (int i = 0; i < 10; i++) {
                List<Employee> employees = employeeDao.selectAll();
                for (int j = 0; j < employees.size(); j++) {
                    employeeDao.insert(employee);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}