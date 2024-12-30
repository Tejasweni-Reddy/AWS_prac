package com.example.employee_service.controller;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.employee_service.entity.DepartmentDto;

@FeignClient(name = "department-service")
public interface DepartmentClient {
	
	@GetMapping(value = "/dept/getDept/{deptId}")
	public DepartmentDto getDepartmentDetails(@PathVariable("deptId") Integer deptId);
	
	@PostMapping(value = "/dept/saveDept")
	public DepartmentDto saveDepartment(@RequestBody DepartmentDto departmentDto);
}
