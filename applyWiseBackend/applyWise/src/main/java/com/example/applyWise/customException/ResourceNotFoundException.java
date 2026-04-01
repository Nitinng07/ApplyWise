package com.example.applyWise.customException;

public class ResourceNotFoundException extends RuntimeException{

	public ResourceNotFoundException(String message) {
		super(message) ;
	}
}
