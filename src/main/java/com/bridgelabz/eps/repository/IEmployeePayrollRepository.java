package com.bridgelabz.eps.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bridgelabz.eps.model.EmployeeData;


public interface IEmployeePayrollRepository extends JpaRepository<EmployeeData, Integer> {

}
