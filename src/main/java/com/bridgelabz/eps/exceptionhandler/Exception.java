package com.bridgelabz.eps.exceptionhandler;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.bridgelabz.eps.dto.EmployeePayrollDTO;
import com.bridgelabz.eps.dto.ResponseDTO;

@RestControllerAdvice
public class Exception extends RuntimeException {
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public void exception() {
		System.out.println("input invalid error");
	}
	

}
