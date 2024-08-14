package com.example.EmployeeManagementSystem.repository;
// Exercise: 3

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.EmployeeManagementSystem.entity.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
}
