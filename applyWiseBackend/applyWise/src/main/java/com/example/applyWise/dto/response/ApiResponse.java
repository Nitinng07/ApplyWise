package com.example.applyWise.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ApiResponse {

	private boolean success; 
	private String messge ;
	
	public ApiResponse() {
		// TODO Auto-generated constructor stub
	}
	
	

	public ApiResponse(boolean success, String messge) {
		super();
		this.success = success;
		this.messge = messge;
	}



	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getMessge() {
		return messge;
	}

	public void setMessge(String messge) {
		this.messge = messge;
	}
	
	
}
