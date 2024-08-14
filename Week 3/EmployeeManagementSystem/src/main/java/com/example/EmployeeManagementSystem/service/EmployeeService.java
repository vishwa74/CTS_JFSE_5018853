package com.example.EmployeeManagementSystem.service;
// Exercises: 5

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.EmployeeManagementSystem.entity.Employee;
import com.example.EmployeeManagementSystem.repository.EmployeeRepository;

import java.util.List;

// Previous code
/*
@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;
    
    public List<Employee> findEmployeesByDepartment(String departmentName) {
        return employeeRepository.findByDepartmentName(departmentName);
    }
}
*/

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;
    
    public List<Employee> findEmployeesByDepartment(String departmentName) {
        return employeeRepository.findByDepartmentName(departmentName);
    }
}
