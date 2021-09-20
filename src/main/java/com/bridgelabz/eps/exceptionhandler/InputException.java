package com.bridgelabz.eps.exceptionhandler;

import org.springframework.stereotype.Component;

@Component
public class InputException extends RuntimeException {
	public InputException() {
		System.out.println("EmptyInput() function");
	}
}
