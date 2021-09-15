package com.bridgelabz.eps.service;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.bridgelabz.eps.dto.EmployeePayrollDTO;
import com.bridgelabz.eps.dto.ResponseDTO;
import com.bridgelabz.eps.model.EmployeeData;

@Service
public class EmployeePayrollServiceImpl implements IEmployeePayroll {

	private static AtomicLong atomicLong = new AtomicLong();

//	create method
	@Override
	public ResponseDTO createEmployee(EmployeePayrollDTO e) {
		EmployeeData employeePayroll = new EmployeeData(atomicLong.incrementAndGet(), e);
		ResponseDTO dto = new ResponseDTO("get call success", employeePayroll);
		datas.add(employeePayroll);
		return dto;
	}

//	read method
	@Override
	public List<EmployeeData> readAll() {
		return datas;
	}

//	read by id method
	@Override
	public ResponseDTO getDataById(int id) {
		EmployeeData payroll = datas.stream().filter(e -> e.getEmpId() == id).findFirst().get();
		ResponseDTO dto = new ResponseDTO("get call success", payroll);
		return dto;
	}

//	update method
	@Override
	public ResponseDTO updateDataById(int id, EmployeePayrollDTO dto) {
		EmployeeData data = datas.stream().filter(e -> e.getEmpId() == id).findFirst().get();
		data.setName(dto.name);
		data.setSalary(dto.salary);
		ResponseDTO responseDto = new ResponseDTO("put call success", data);
		return responseDto;
	}

//	delete by id method
	@Override
	public ResponseDTO deleteDataById(int id) {
		EmployeeData data = datas.stream().filter(e -> e.getEmpId() == id).findFirst().get();
		datas.remove(data);
		ResponseDTO dto = new ResponseDTO("delete call success", data);
		return dto;
	}

}
