package com.example.applyWise.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "jobs")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Job {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id ;
	
	private String title ;
	
	@Column( columnDefinition = "TEXT" )
	private String description ;
	
	private String location ;
	
	private Double salaryMin ;
	
	private Double salaryMax ;
	
	private String jobType ;
	private int experienceRequired ;
	
	@ManyToOne
	@JoinColumn( name = "recruiter_id" )
	private Users recruiter ;
	
	private boolean isActive = true ;
}
