package com.example.applyWise.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="job_seeker_profile")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class JobSeekerProfile {

	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	private Long id ;
	
	private String skills ;
	private int experienceYears ;
	private String education ;
	private String resumeUrl ;
	private String location ;
	
	@OneToOne
	@JoinColumn( name="user_id" , nullable=false )
	private Users user ;
}
