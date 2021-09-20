package com.bridgelabz.eps.exceptionhandler;

import java.util.NoSuchElementException;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.bridgelabz.eps.dto.EmployeePayrollDTO;
import com.bridgelabz.eps.dto.ResponseDTO;

@RestControllerAdvice
public class Exception extends RuntimeException {
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseDTO exception() {
		System.out.println("input invalid error");
		return new ResponseDTO("Invalid Input", null);
	}
	
	@ExceptionHandler(NoSuchElementException.class)
	private ResponseDTO idNotPresent() {
		return new ResponseDTO("id is not present", null);

	}
}