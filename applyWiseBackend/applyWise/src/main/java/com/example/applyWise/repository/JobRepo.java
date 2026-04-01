package com.example.applyWise.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.applyWise.entity.Job;
import com.example.applyWise.entity.User;

public interface JobRepo extends JpaRepository<Job, Long>{

	Optional<Job> findByTitleAndRecruiter(String title , User recruiter);
	
	List<Job> findByRecruiter(User recruiter) ;
	
}
