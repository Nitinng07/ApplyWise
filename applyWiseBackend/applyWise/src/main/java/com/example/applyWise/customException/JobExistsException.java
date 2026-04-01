package com.example.applyWise.customException;

public class JobExistsException extends RuntimeException {

	public JobExistsException(String message) {
		super(message) ;
	}
}
