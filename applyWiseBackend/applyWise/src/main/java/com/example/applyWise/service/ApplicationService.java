package com.example.applyWise.service;

import java.util.List;

import com.example.applyWise.entity.Application;
import com.example.applyWise.entity.Job;

public interface ApplicationService {

	Application applyJob(Long jobId) ;
	
	List<Application> getAllAppliedJobs() ;
	
	List<Application> getApplicants(Long id);
	
}
