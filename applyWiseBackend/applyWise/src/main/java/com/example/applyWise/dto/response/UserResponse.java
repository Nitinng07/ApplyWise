package com.example.applyWise.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;


@AllArgsConstructor
public class UserResponse {

	private Long id ;
	private String name ;
	private String email ;
	private String role ;
	private boolean isActive ;
	
	public UserResponse() {
		// TODO Auto-generated constructor stub
	}
	
	public UserResponse(Long id, String name, String email, String role, boolean isActive) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.role = role;
		this.isActive = isActive;
	}



	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	
	
	
	
}
