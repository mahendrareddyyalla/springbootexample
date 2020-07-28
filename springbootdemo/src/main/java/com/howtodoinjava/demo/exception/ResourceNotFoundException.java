package com.howtodoinjava.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String resourceName;

    public ResourceNotFoundException( String resourceName) {
        super(resourceName);
        this.resourceName = resourceName;
        
    }

    public String getResourceName() {
        return resourceName;
    }

}