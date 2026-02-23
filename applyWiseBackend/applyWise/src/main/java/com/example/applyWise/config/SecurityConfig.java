package com.example.applyWise.config;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Service;

import com.example.applyWise.entity.Users;
import com.example.applyWise.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class SecurityConfig {

    private final JwtAuthenticationFilter jwtFilter;

    @Bean
    public SecurityFilterChain securityFilterChain(
            HttpSecurity http) throws Exception {

        http
            .csrf(csrf -> csrf.disable())
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/api/auth/**")
                .permitAll()
                .requestMatchers("/api/admin/**")
                .hasRole("ADMIN")
                .requestMatchers("/api/recruiter/**")
                .hasRole("RECRUITER")
                .requestMatchers("/api/jobseeker/**")
                .hasRole("JOB_SEEKER")
                .anyRequest()
                .authenticated()
            )
            .sessionManagement(sess ->
                sess.sessionCreationPolicy(
                    SessionCreationPolicy.STATELESS))
            .addFilterBefore(jwtFilter,
                UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    
    @Bean
    public AuthenticationManager authenticationManager(
    		AuthenticationConfiguration config ) throws Exception{
    		return config.getAuthenticationManager() ;
    }
}

/*
	Login → Generate JWT
	Frontend stores token
	Frontend sends token in header:
	Authorization: Bearer eyJhbGciOiJIUzI1Ni...
	
	Filter extracts token
	Validates
	Loads user
	Sets SecurityContext
	Controller executes
*/