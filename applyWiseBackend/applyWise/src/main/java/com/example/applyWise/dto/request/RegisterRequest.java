package com.example.applyWise.dto.request;

import com.example.applyWise.entity.Role;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;


public class RegisterRequest {
	@NotBlank
	private String name ;
	
	@Email
	private String email ;
	
	@Size(min=4)
	private String password ;
	
	@NotNull
	private Role role ;
	
	public RegisterRequest() {
		// TODO Auto-generated constructor stub
	}
	
	

	public RegisterRequest(@NotBlank String name, @Email String email, @Size(min = 4) String password,
			@NotNull Role role) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.role = role;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
	
	
}
