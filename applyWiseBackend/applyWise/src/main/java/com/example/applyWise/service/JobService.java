package com.example.applyWise.service;

import java.util.List;

import com.example.applyWise.entity.Job;

public interface JobService {
	
	Job addJob( Job job) ;
	
	List<Job> getAddedJobs() ;
	
	List<Job> getAllJobs() ;
	 
}
