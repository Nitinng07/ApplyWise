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
@Table(name = "recruiter_profile")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RecruiterProfile {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id ;
	
	private String companyName ;
	private String companyDescription;
	private String website ;
	private String location ;
	
	@OneToOne
	@JoinColumn(name="user_id" , nullable = false)
	private Users user ;
}
