package com.example.employee_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.employee_service.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	
}
