package com.bridgelabz.eps.exceptionhandler;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.MethodArgumentNotValidException;

@Component
public class InputException extends RuntimeException {
	public  InputException() {
		
	}
	
}