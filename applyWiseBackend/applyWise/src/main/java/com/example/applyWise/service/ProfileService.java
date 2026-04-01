package com.example.applyWise.service;

import com.example.applyWise.entity.JobSeekerProfile;
import com.example.applyWise.entity.User;

public interface ProfileService {

	JobSeekerProfile getProfile() ;
	
	JobSeekerProfile completeProfile(JobSeekerProfile jobSeekerProfile) ;
	
}
