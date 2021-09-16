package com.bridgelabz.eps.dto;

//	DTO class to provide data from UI to Controller
public class EmployeePayrollDTO {
	public String name;
	public double salary;
	
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
