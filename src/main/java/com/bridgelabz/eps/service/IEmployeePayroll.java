package com.bridgelabz.eps.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;

import com.bridgelabz.eps.dto.EmployeePayrollDTO;
import com.bridgelabz.eps.dto.ResponseDTO;
import com.bridgelabz.eps.model.EmployeeData;

public interface IEmployeePayroll {
	List<EmployeeData> datas = new ArrayList<EmployeeData>();

	ResponseDTO createEmployee(EmployeePayrollDTO e);

	List<EmployeeData> readAll();

	ResponseDTO getDataById(int id);

	ResponseDTO updateDataById(int id, EmployeePayrollDTO dto);

	ResponseDTO deleteDataById(int id);

}
