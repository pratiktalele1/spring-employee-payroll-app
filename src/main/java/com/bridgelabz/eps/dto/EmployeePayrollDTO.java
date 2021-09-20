package com.bridgelabz.eps.dto;

import javax.validation.constraints.Pattern;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

//	DTO class to provide data from UI to Controller
@Getter
@Setter
@AllArgsConstructor
public @Data class EmployeePayrollDTO {
	@Pattern(regexp = "[A-Za-z]+", message = "invalid user name")
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
