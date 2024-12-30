package com.example.employee_service.service;

import org.springframework.http.ResponseEntity;

import com.example.employee_service.entity.Employee;
import com.example.employee_service.entity.EmployeeDepartmentRequest;
import com.example.employee_service.entity.EmployeeDeptResponse;
import com.example.employee_service.entity.ResponseStructure;
import com.example.employee_service.exception.DataNotFoundException;

public interface IEmployeeService {

	ResponseEntity<String> saveEmployee(EmployeeDepartmentRequest employee);
	ResponseEntity<EmployeeDeptResponse> findEmployee (Integer employeeId) throws DataNotFoundException;
	ResponseEntity<ResponseStructure<Employee>> updateEmployee(Employee employee, Integer employeeId) throws DataNotFoundException;
}
