package com.bridgelabz.eps.model;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.bridgelabz.eps.dto.EmployeePayrollDTO;


public class EmployeeData {
	private long empId;
	private String name;
	private double salary;
	
	public EmployeeData(long id,EmployeePayrollDTO dto) {
		this.empId=id;
		this.name=dto.name;
		this.salary=dto.salary;
		
	}
	
	
	public long getEmpId() {
		return empId;
	}
	public void setEmpId(long empId) {
		this.empId = empId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	
}
