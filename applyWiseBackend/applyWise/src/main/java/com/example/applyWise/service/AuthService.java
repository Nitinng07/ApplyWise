package com.example.applyWise.service;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.applyWise.config.JwtService;
import com.example.applyWise.dto.request.LoginRequest;
import com.example.applyWise.dto.request.RegisterRequest;
import com.example.applyWise.dto.response.AuthResponse;
import com.example.applyWise.entity.Users;
import com.example.applyWise.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthService {

	private final UserRepository userRepo;
	private final PasswordEncoder passEnc;
	private final JwtService jwtService;
	private final AuthenticationManager authMgr;

	public AuthResponse register(RegisterRequest request) {
		if (userRepo.findByEmail(request.getEmail()).isPresent()) {
			throw new RuntimeException("Email already exists");
		}

		Users user = Users.builder().name(request.getName()).email(request.getEmail())
				.password(passEnc.encode(request.getPassword())).role(request.getRole()).build();

		userRepo.save(user);

		String token = jwtService.generateToken(user.getEmail());

		return new AuthResponse(token);
	}
	
	
	public AuthResponse login(LoginRequest request) {
		authMgr.authenticate(
				new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword())) ;
		String token = jwtService.generateToken(request.getEmail()) ;
		
		return new AuthResponse(token) ;
	}
}
