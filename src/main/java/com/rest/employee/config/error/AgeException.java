package com.rest.employee.config.error;

public class AgeException extends RuntimeException {
	
	
	 public AgeException(String age) {
	        super("This age is not validated : " + age);
	    }

}