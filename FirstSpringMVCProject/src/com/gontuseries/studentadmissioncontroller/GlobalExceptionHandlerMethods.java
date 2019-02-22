package com.gontuseries.studentadmissioncontroller;

import java.io.IOException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

//allows us to consolidate our multiple, scattered @ExceptionHandlers from before into a single, global error handling component
@ControllerAdvice
public class GlobalExceptionHandlerMethods {
	
	@ExceptionHandler(value=NullPointerException.class)
	public String handleNullPointerException(Exception e) {
		System.out.println("Null Pointer Exception Occured: "+e);
		
		return "NullPointerException";
	}
	
	@ExceptionHandler(value=IOException.class)
	public String handleIOException(Exception e) {
		System.out.println("IO Exception Occured: "+e);
		
		return "IOException";
	}
	
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(value=Exception.class)
	public String handleException(Exception e) {
		System.out.println("Unknown Exception Occured: "+e);
		
		return "Exception";
	}
	
}
