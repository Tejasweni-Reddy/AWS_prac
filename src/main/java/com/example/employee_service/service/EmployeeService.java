package com.example.employee_service.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.employee_service.controller.DepartmentClient;
import com.example.employee_service.entity.DepartmentDto;
import com.example.employee_service.entity.Employee;
import com.example.employee_service.entity.EmployeeDepartmentRequest;
import com.example.employee_service.entity.EmployeeDeptResponse;
import com.example.employee_service.entity.ResponseStructure;
import com.example.employee_service.exception.DataNotFoundException;
import com.example.employee_service.repository.EmployeeRepository;

@Service
public class EmployeeService implements IEmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private DepartmentClient departmentClient;

	@Override
	public ResponseEntity<String> saveEmployee(EmployeeDepartmentRequest employee) {
//		Employee emp = new Employee();
		DepartmentDto dept= new DepartmentDto();
		Employee employee2 = employeeRepository.save(employee.getEmployee());
		employee2.setEmployeeName(employee2.getEmployeeName());
		employee2.setEmployeeEmail(employee2.getEmployeeEmail());
		dept.setEmployeeId(employee.getEmployee().getEmployeeId());
		dept.setDeptName(employee.getDepartmentDto().getDeptName());
		departmentClient.saveDepartment(dept);
		String str = "Employee data saved";
		
		return new ResponseEntity<String>(str, HttpStatus.CREATED) ;
	}

	@Override
	public ResponseEntity<EmployeeDeptResponse> findEmployee(Integer employeeId) throws DataNotFoundException{
		Optional<Employee> optionalEmployee = employeeRepository.findById(employeeId);
		Employee employee = optionalEmployee.get();
		EmployeeDeptResponse ed = new EmployeeDeptResponse();
		DepartmentDto departmentDto = departmentClient.getDepartmentDetails(employeeId);
		
		if(optionalEmployee==null)
		{
			throw new DataNotFoundException("Employee data not found...");
		}
		ed.setEmpId(employeeId);
		ed.setEmpName(employee.getEmployeeName());
		ed.setEmpEmail(employee.getEmployeeEmail());
		ed.setDepartmentId(departmentDto.getDeptId());
		ed.setDepartmentName(departmentDto.getDeptName());
		return new ResponseEntity<EmployeeDeptResponse>(ed, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<ResponseStructure<Employee>> updateEmployee(Employee employee, Integer employeeId) throws DataNotFoundException {
		Optional<Employee> employeeOptional = employeeRepository.findById(employeeId);
		Employee employee2 = new Employee();
		employee2.setEmployeeName(employee.getEmployeeName());
		employee2.setEmployeeEmail(employee.getEmployeeEmail());
		DepartmentDto departmentDto = new DepartmentDto();
		
		if(employeeOptional==null)
		{
			throw new DataNotFoundException("Employee not found...");
		}
//		departmentDto
		return null;
	}
}
