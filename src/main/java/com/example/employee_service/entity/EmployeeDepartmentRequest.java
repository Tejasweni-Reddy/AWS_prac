package com.example.employee_service.entity;

public class EmployeeDepartmentRequest {
	
	private Employee employee;
	private DepartmentDto departmentDto;
	
	public EmployeeDepartmentRequest() {
		// TODO Auto-generated constructor stub
	}
	
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	public DepartmentDto getDepartmentDto() {
		return departmentDto;
	}
	public void setDepartmentDto(DepartmentDto departmentDto) {
		this.departmentDto = departmentDto;
	}
	
	
}
