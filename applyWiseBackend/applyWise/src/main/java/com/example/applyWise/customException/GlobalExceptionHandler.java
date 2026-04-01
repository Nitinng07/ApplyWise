package com.example.applyWise.customException;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<String> handleNotFound(
			ResourceNotFoundException ex){
		return ResponseEntity
				.status(HttpStatus.NOT_FOUND)
				.body(ex.getMessage()) ;
	}
	
	@ExceptionHandler(exception = ProfileCompletionException.class)
	public ResponseEntity<String> handleProfileCompletion( ProfileCompletionException p ){
		return new ResponseEntity<String>("PROFILE_INCOMPLETE" , HttpStatusCode.valueOf(403) ) ;
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> handleGeneral(
			Exception ex){
		return ResponseEntity
				.status(HttpStatus.BAD_REQUEST)
				.body(ex.getMessage()) ;
	}
	
	public ResponseEntity<String> handleJobExists( JobExistsException e ){
		return new ResponseEntity<String>(e.getMessage() , HttpStatusCode.valueOf(500)) ;
	}
	
	
}
