package com.bridgelabz.eps;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication @Slf4j
public class SpringEmployeePayrollServiceApplication {

	public static void main(String[] args) {
		
		ApplicationContext applicationContext= SpringApplication.run(SpringEmployeePayrollServiceApplication.class, args);
		System.out.println("hello from employee payroll");
		System.out.println("environment is ->"+applicationContext.getEnvironment());
		log.info("environment is ->"+applicationContext.getEnvironment());
		log.info("payroll user ->{}",System.getenv("empPayroll"));

	}

}
