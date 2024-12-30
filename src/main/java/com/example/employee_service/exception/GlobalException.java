package com.example.employee_service.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.employee_service.entity.Employee;
import com.example.employee_service.entity.ResponseStructure;

@ControllerAdvice
public class GlobalException {
	
	@ExceptionHandler(DataNotFoundException.class)
	public ResponseEntity<ResponseStructure<Object>> DataNotFoundException (DataNotFoundException e)
	{
		ResponseStructure<Object> rs = new ResponseStructure<>();
		rs.setStatus(HttpStatus.NOT_FOUND.value());
		rs.setMessage("data not found...");
		rs.setData(rs);
		return new ResponseEntity<ResponseStructure<Object>> (rs, HttpStatus.NOT_FOUND);
	}
}
