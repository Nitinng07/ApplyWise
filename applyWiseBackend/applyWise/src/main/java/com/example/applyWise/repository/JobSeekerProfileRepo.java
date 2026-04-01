package com.example.applyWise.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.applyWise.entity.JobSeekerProfile;
import com.example.applyWise.entity.User;

public interface JobSeekerProfileRepo extends JpaRepository<JobSeekerProfile, Long>{

	Optional<JobSeekerProfile> findByUser(User user) ;
	
}
