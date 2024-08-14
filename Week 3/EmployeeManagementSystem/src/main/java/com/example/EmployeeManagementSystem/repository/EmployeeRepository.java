package com.example.EmployeeManagementSystem.repository;
// Exercises: 3, 5, 8

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.EmployeeManagementSystem.entity.Employee;
import com.example.EmployeeManagementSystem.projection.EmployeeProjection;

import java.util.List;

// Previous code
/*
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
*/

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    // Custom Query Method (Exercise 5)
    List<Employee> findByDepartmentName(String departmentName);
    
    // Projection Example (Exercise 8)
    @Query("SELECT e.name as name, e.email as email, d.name as departmentName FROM Employee e JOIN e.department d")
    List<EmployeeProjection> findEmployeeSummary();
}
