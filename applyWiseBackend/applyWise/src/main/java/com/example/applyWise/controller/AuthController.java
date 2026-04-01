package com.example.applyWise.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.applyWise.dto.request.LoginRequest;
import com.example.applyWise.dto.request.RegisterRequest;
import com.example.applyWise.dto.response.AuthResponse;
import com.example.applyWise.service.AuthService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
@CrossOrigin
public class AuthController {

	private final AuthService authService ;
	
	public AuthController(AuthService authService) {
		super();
		this.authService = authService;
	}

	@PostMapping("/register")
	public AuthResponse register( @Valid @RequestBody RegisterRequest request) {
		return authService.register(request) ;
	}
	
	@PostMapping("/login")
	public AuthResponse login(@RequestBody LoginRequest request) {
		return authService.login(request) ;
	}
	
	
}
