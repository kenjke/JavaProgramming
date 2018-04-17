package com.epam.aleksandr_generalov.java.lesson7.dao;

import com.epam.aleksandr_generalov.java.lesson7.entities.Employee;

import java.util.List;

public interface EmployeeDao {

    void createPersonTable();

    void insert(Employee person);

    Employee selectById(int id);

    List<Employee> selectAll();

    void delete(int id);

    void update(Employee person, int id);
}