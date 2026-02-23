package com.example.applyWise.dto.request;

import com.example.applyWise.entity.Role;

import lombok.Data;

@Data
public class RegisterRequest {

	private String name ;
	private String email ;
	private String password ;
	private Role role ;
}
