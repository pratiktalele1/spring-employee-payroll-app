package com.bridgelabz.eps.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

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

import com.bridgelabz.eps.model.EmployeePayroll;

@RestController
@RequestMapping("/service")
public class EmployeePayrollController {
	
	private List<EmployeePayroll> list=new ArrayList<EmployeePayroll>();
	private static AtomicLong atomicLong=new AtomicLong();
	
//	creating method for getting all data
	@GetMapping
	private ResponseEntity<List<EmployeePayroll>> getAll() {
		return new ResponseEntity<>(list,HttpStatus.OK);
	}
	
//	creating method for creating data
	@PostMapping
	private ResponseEntity<EmployeePayroll> create(@RequestBody EmployeePayroll employeePayroll) {
		employeePayroll.setId(atomicLong.incrementAndGet());
		list.add(employeePayroll);
		return new ResponseEntity<>(employeePayroll,HttpStatus.CREATED);
	}
	
//	creating method for getting data by id
	@GetMapping("/{id}")
	private ResponseEntity<EmployeePayroll> getById(@PathVariable int id){
		EmployeePayroll payroll =list.stream().filter(e->e.getId()==id).findFirst().get();
		return new ResponseEntity<>(payroll,HttpStatus.OK);
	}
	
//	creating method for updating data by id
	@PutMapping("/{id}")
	private ResponseEntity<EmployeePayroll> updateById(@PathVariable int id,@RequestBody EmployeePayroll roll){
		EmployeePayroll payroll=list.stream().filter(e->e.getId()==id).findFirst().get();
		payroll.setFirstName(roll.getFirstName());
		payroll.setLastName(roll.getLastName());
		return new ResponseEntity<>(HttpStatus.FOUND);
	}
	
//	creating method for deleting data by id
	@DeleteMapping("/{id}")
	private ResponseEntity<EmployeePayroll> deleteById(@PathVariable int id) {
		EmployeePayroll payroll=list.stream().filter(e->e.getId()==id).findFirst().get();
		list.remove(payroll);
		return new ResponseEntity<>(payroll,HttpStatus.FOUND);
	}
}
