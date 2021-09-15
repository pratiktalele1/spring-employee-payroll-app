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

import com.bridgelabz.eps.dto.EmployeePayrollDTO;
import com.bridgelabz.eps.dto.ResponseDTO;
import com.bridgelabz.eps.model.EmployeeData;
import com.bridgelabz.eps.model.EmployeePayroll;

@RestController
@RequestMapping("/service")
public class EmployeePayrollController {

//	creating list to store Employee data
	private List<EmployeeData> datas = new ArrayList<EmployeeData>();
	
//	creating atomiclong for id
	private static AtomicLong atomicLong = new AtomicLong();

//	creating method for getting all data
	@GetMapping
	private ResponseEntity<List<EmployeeData>> getAll() {
		return new ResponseEntity<>(datas, HttpStatus.OK);
	}

//	creating method for creating data
	@PostMapping
	private ResponseEntity<ResponseDTO> create(@RequestBody EmployeePayrollDTO e) {
		EmployeeData employeePayroll = new EmployeeData(atomicLong.incrementAndGet(), e);
		ResponseDTO dto = new ResponseDTO("get call success", employeePayroll);
		datas.add(employeePayroll);
		return new ResponseEntity<>(dto, HttpStatus.CREATED);
	}

//	creating method for getting data by id
	@GetMapping("/{id}")
	private ResponseEntity<ResponseDTO> getById(@PathVariable int id) {
		EmployeeData payroll = datas.stream().filter(e -> e.getEmpId() == id).findFirst().get();
		ResponseDTO dto = new ResponseDTO("get call success", payroll);
		return new ResponseEntity<>(dto, HttpStatus.OK);
	}

//	creating method for updating data by id
	@PutMapping("/{id}")
	private ResponseEntity<ResponseDTO> updateById(@PathVariable int id, @RequestBody EmployeePayrollDTO dto) {
		EmployeeData data = datas.stream().filter(e -> e.getEmpId() == id).findFirst().get();
		data.setName(dto.name);
		data.setSalary(dto.salary);
		ResponseDTO responseDto = new ResponseDTO("put call success", data);
		return new ResponseEntity<>(responseDto, HttpStatus.FOUND);
	}

//	creating method for deleting data by id
	@DeleteMapping("/{id}")
	private ResponseEntity<ResponseDTO> deleteById(@PathVariable int id) {
		EmployeeData data = datas.stream().filter(e -> e.getEmpId() == id).findFirst().get();
		datas.remove(data);
		ResponseDTO dto = new ResponseDTO("delete call success", data);
		return new ResponseEntity<>(dto, HttpStatus.OK);
	}
}
