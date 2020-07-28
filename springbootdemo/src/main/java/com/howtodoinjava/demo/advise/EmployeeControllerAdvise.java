package com.howtodoinjava.demo.advise;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.howtodoinjava.demo.exception.ResourceNotFoundException;

@ControllerAdvice
public class EmployeeControllerAdvise {
	@ExceptionHandler({ResourceNotFoundException.class})
	 public ResponseEntity<String> workOrderEscalatedAlready(
			 ResourceNotFoundException exception) {

	      /*  // Build the Error Message.
	        Map<String, Object> exceptionInfo = new HashMap<>();
	        exceptionInfo.put("error", "employee id not found");
	      */
	        // Return the Response.
	        return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
	    }
}
