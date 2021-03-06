package com.rest.employee.config.error;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ErrorHandler extends ResponseEntityExceptionHandler {
	
	
	  @ResponseStatus(
	            value = HttpStatus.NOT_FOUND,
	            reason = "Requested Student Not Found")
	
	 @ExceptionHandler(AgeException.class)
	    public void springHandleNotFound(HttpServletResponse response) throws IOException {
	        response.sendError(HttpStatus.NOT_ACCEPTABLE.value());
	    }


}
