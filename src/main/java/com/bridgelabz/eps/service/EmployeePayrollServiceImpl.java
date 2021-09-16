package com.bridgelabz.eps.service;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.bridgelabz.eps.dto.EmployeePayrollDTO;
import com.bridgelabz.eps.dto.ResponseDTO;
import com.bridgelabz.eps.model.EmployeeData;
import com.bridgelabz.eps.repository.IEmployeePayrollRepository;

@Service
public class EmployeePayrollServiceImpl implements IEmployeePayroll {

	private static AtomicLong atomicLong = new AtomicLong();

//	IEmployeePayrollRepository reference is Autowired to save data in repository
	@Autowired
	private IEmployeePayrollRepository employeePayrollRepository;
	
//	createEmployee() function to save payroll data
	@Override
	public ResponseDTO createEmployee(EmployeePayrollDTO e) {
		EmployeeData employeePayroll = new EmployeeData(atomicLong.incrementAndGet(), e);
		ResponseDTO dto = new ResponseDTO("get call success", employeePayroll);
//		datas.add(employeePayroll);
		employeePayrollRepository.save(employeePayroll);
		return dto;
	}

//	readAll() function to get payroll data
	@Override
	public List<EmployeeData> readAll() {
//		return datas;
		return employeePayrollRepository.findAll();
	}

//	getDataById() function to get payroll data by id
	@Override
	public ResponseDTO getDataById(int id) {
		List<EmployeeData> data= employeePayrollRepository.findAll();
		EmployeeData payroll = data.stream().filter(e -> e.getEmpId() == id).findFirst().get();
		ResponseDTO dto = new ResponseDTO("get call success", payroll);
		return dto;
	}

//	updateDataById() function to update payroll data by id
	@Override
	public ResponseDTO updateDataById(int id, EmployeePayrollDTO dto) {
		List<EmployeeData> getAllList= employeePayrollRepository.findAll();
		EmployeeData data = getAllList.stream().filter(e -> e.getEmpId() == id).findFirst().get();
		data.setName(dto.name);
		data.setSalary(dto.salary);
		employeePayrollRepository.save(data);
		ResponseDTO responseDto = new ResponseDTO("put call success", data);
		return responseDto;
	}

//	deleteDataById() function to delete payroll data by id
	@Override
	public ResponseDTO deleteDataById(int id) {
		List<EmployeeData> getAllList= employeePayrollRepository.findAll();
		EmployeeData data = getAllList.stream().filter(e -> e.getEmpId() == id).findFirst().get();
		employeePayrollRepository.delete(data);
		ResponseDTO dto = new ResponseDTO("delete call success", data);
		return dto;
	}

}
