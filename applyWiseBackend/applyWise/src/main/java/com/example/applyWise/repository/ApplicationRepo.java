package com.example.applyWise.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.applyWise.entity.Application;
import com.example.applyWise.entity.Job;
import com.example.applyWise.entity.User;

public interface ApplicationRepo extends JpaRepository<Application, Long>
{
	
	Optional<Application> findByJobAndJobSeekers(Job job , User user) ;
	
	List<Application> findByJobSeekers(User jobSeekers);
	
	List<Application> findByJob(Job job) ;
	
}
