package com.example.employee_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.employee_service.entity.DepartmentDto;
import com.example.employee_service.entity.Employee;
import com.example.employee_service.entity.EmployeeDepartmentRequest;
import com.example.employee_service.entity.EmployeeDeptResponse;
import com.example.employee_service.entity.ResponseStructure;
import com.example.employee_service.exception.DataNotFoundException;
import com.example.employee_service.service.IEmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	
	@Autowired
	private IEmployeeService iEmployeeService;
	
	@Autowired
	private DepartmentClient departmentClient;
	
	@GetMapping("/Hi/Yuxi")
	String ding_Yu_Xi() 
	{
		return "Ding Yu Xi, hiiii, shi wanhi";
	}
	
	@PostMapping("/saveEmp")
	ResponseEntity<String> saveEmployee(@RequestBody EmployeeDepartmentRequest employee)
	{
		return iEmployeeService.saveEmployee(employee);
	}
	
	@GetMapping("/fetchEmp/{employeeId}")
	ResponseEntity<EmployeeDeptResponse> findEmployee(@PathVariable("employeeId") Integer employeeId) throws DataNotFoundException
	{
		return iEmployeeService.findEmployee(employeeId);
	}
	
	ResponseEntity<ResponseStructure<Employee>> updateEmployee(@RequestBody Employee employee, @PathVariable Integer employeeId) throws DataNotFoundException
	{
		return iEmployeeService.updateEmployee(employee, employeeId);
	}
}
