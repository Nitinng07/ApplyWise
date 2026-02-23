package com.example.applyWise.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Users {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long  id ;
	
	private String name ;
	
	@Column(unique = true , nullable=false)
	private String email ;
	
	private String password ;
	
	@Enumerated(EnumType.STRING)
	private Role role ;
	
	private boolean isActive = true;
	
	private LocalDateTime createdAt = LocalDateTime.now() ;
}
