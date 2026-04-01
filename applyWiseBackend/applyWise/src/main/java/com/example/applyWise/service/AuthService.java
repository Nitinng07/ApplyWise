package com.example.applyWise.service;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.applyWise.config.JwtService;
import com.example.applyWise.dto.request.LoginRequest;
import com.example.applyWise.dto.request.RegisterRequest;
import com.example.applyWise.dto.response.AuthResponse;
import com.example.applyWise.entity.JobSeekerProfile;
import com.example.applyWise.entity.RecruiterProfile;
import com.example.applyWise.entity.Role;
import com.example.applyWise.entity.User;
import com.example.applyWise.repository.JobSeekerProfileRepo;
import com.example.applyWise.repository.RecruiterProfileRepo;
import com.example.applyWise.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthService {

	private final UserRepository userRepo;
	private final PasswordEncoder passEnc;
	private final JwtService jwtService;
	private final AuthenticationManager authMgr;
	private final JobSeekerProfileRepo jobSeekerProfileRepo;
	private final RecruiterProfileRepo recruiterProfileRepo;

	public AuthService(UserRepository userRepo, PasswordEncoder passEnc, JwtService jwtService,
			AuthenticationManager authMgr, RecruiterProfileRepo recruiterProfileRepo,
			JobSeekerProfileRepo jobSeekerProfileRepo) {
		super();
		this.userRepo = userRepo;
		this.passEnc = passEnc;
		this.jwtService = jwtService;
		this.authMgr = authMgr;
		this.jobSeekerProfileRepo = jobSeekerProfileRepo;
		this.recruiterProfileRepo = recruiterProfileRepo;
	}

	@Transactional
	public AuthResponse register(RegisterRequest request) {
		if (userRepo.findByEmail(request.getEmail()).isPresent()) {
			throw new RuntimeException("Email already exists");
		}

		User user = new User( request.getName(), request.getEmail(), passEnc.encode(request.getPassword()), request.getRole());
		User savedUser =	userRepo.save(user) ;
		
		if (Role.JOB_SEEKER.equals(savedUser.getRole())) {
	        JobSeekerProfile profile = new JobSeekerProfile();
	        profile.setUser(savedUser);
	        jobSeekerProfileRepo.save(profile);
	    } else {
	        RecruiterProfile profile = new RecruiterProfile();
	        profile.setUser(savedUser);
	        recruiterProfileRepo.save(profile);
	    }

	    String token = jwtService.generateToken(
	        user.getEmail(),
	        user.getRole().name()
	    );

	    return new AuthResponse(token);
	}

	public AuthResponse login(LoginRequest request) {
		authMgr.authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));

		User user = userRepo.findByEmail(request.getEmail()).orElseThrow();

		String token = jwtService.generateToken(user.getEmail(), user.getRole().name());

		return new AuthResponse(token);
	}
}
