package com.bridgelabz.eps.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

//	DTO class to provide data from UI to Controller
@Getter @Setter @AllArgsConstructor
public @Data class EmployeePayrollDTO {
	public String name;
	public double salary;

	/*
	 * public String getName() { return name; }
	 * 
	 * public void setName(String name) { this.name = name; }
	 * 
	 * public double getSalary() { return salary; }
	 * 
	 * public void setSalary(double salary) { this.salary = salary; }
	 */
}
