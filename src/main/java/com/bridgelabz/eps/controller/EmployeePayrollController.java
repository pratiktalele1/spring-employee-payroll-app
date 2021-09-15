package com.bridgelabz.eps.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

@RestController
@RequestMapping("/service")
public class EmployeePayrollController {

//	asign service
	@Autowired
	private IEmployeePayroll services;
	
//	creating list to store Employee data
	private List<EmployeeData> datas = new ArrayList<EmployeeData>();
	
//	creating atomiclong for id
	private static AtomicLong atomicLong = new AtomicLong();

//	creating method for getting all data
	@GetMapping
	private ResponseEntity<List<EmployeeData>> getAll() {
		return new ResponseEntity<>(services.readAll(), HttpStatus.OK);
	}

//	creating method for creating data
	@PostMapping
	private ResponseEntity<ResponseDTO> create(@RequestBody EmployeePayrollDTO e) {
		return new ResponseEntity<>(services.createEmployee(e), HttpStatus.CREATED);
	}

//	creating method for getting data by id
	@GetMapping("/{id}")
	private ResponseEntity<ResponseDTO> getById(@PathVariable int id) {
		return new ResponseEntity<>(services.getDataById(id), HttpStatus.FOUND);
	}

//	creating method for updating data by id
	@PutMapping("/{id}")
	private ResponseEntity<ResponseDTO> updateById(@PathVariable int id, @RequestBody EmployeePayrollDTO dto) {
		return new ResponseEntity<>(services.updateDataById(id,dto), HttpStatus.FOUND);
	}

//	creating method for deleting data by id
	@DeleteMapping("/{id}")
	private ResponseEntity<ResponseDTO> deleteById(@PathVariable int id) {
		return new ResponseEntity<>(services.deleteDataById(id), HttpStatus.FOUND);
	}
}
