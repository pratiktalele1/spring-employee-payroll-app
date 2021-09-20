package com.bridgelabz.eps.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bridgelabz.eps.dto.EmployeePayrollDTO;
import com.bridgelabz.eps.dto.ResponseDTO;

import com.bridgelabz.eps.model.EmployeeData;
import com.bridgelabz.eps.model.EmployeePayroll;
import com.bridgelabz.eps.service.IEmployeePayroll;

import lombok.extern.slf4j.Slf4j;


@RestController
@RequestMapping("/service")
@Slf4j
public class EmployeePayrollController {

//	IEmployeePayroll is Autowired to call various functions from service layer
	@Autowired
	private IEmployeePayroll services;
	
//	list is created to perform various HTTP CURD operations
	private List<EmployeeData> datas = new ArrayList<EmployeeData>();
	
//	atomiclong created to assign unique id to each payroll data
	private static AtomicLong atomicLong = new AtomicLong();

//	getAll() is created to get all payroll data from service layer using http get method
	@GetMapping
	private ResponseEntity<List<EmployeeData>> getAll() {
		log.info("In the getAll() function to retrive all data");
		return new ResponseEntity<>(services.readAll(), HttpStatus.OK);
	}

//	create() is created to save payroll data to service layer using http post method
	@PostMapping
	private ResponseEntity<ResponseDTO> create(@Valid @RequestBody EmployeePayrollDTO e) {
			log.info("In the create() function to create data");
			return new ResponseEntity<>(services.createEmployee(e), HttpStatus.CREATED);		
	}

//	getById() is created to get payroll data by id from service layer using http get method
	@GetMapping("/{id}")
	private ResponseEntity<ResponseDTO> getById(@PathVariable int id) {
		log.info("In the getById() function to retrive data by using Id");
		return new ResponseEntity<>(services.getDataById(id), HttpStatus.FOUND);
	}

//	updateById() is created to update payroll data by id from service layer using http put method
	@PutMapping("/{id}")
	private ResponseEntity<ResponseDTO> updateById(@PathVariable int id,@Valid @RequestBody EmployeePayrollDTO dto) {
		log.info("In the updateById() function to update data by using Id");
		return new ResponseEntity<>(services.updateDataById(id,dto), HttpStatus.FOUND);
	}

//	deleteById() is created to delete payroll data by id from service layer using http delete method
	@DeleteMapping("/{id}")
	private ResponseEntity<ResponseDTO> deleteById(@PathVariable int id) {
		log.info("In the deleteById() function to delete data by using Id");
		return new ResponseEntity<>(services.deleteDataById(id), HttpStatus.FOUND);
	
	}
	
	
}
