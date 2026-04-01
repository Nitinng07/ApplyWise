package com.example.applyWise.service;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.example.applyWise.customException.ResourceNotFoundException;
import com.example.applyWise.entity.JobSeekerProfile;
import com.example.applyWise.entity.User;
import com.example.applyWise.repository.JobSeekerProfileRepo;
import com.example.applyWise.repository.UserRepository;

@Service("JobSeekerProfileService")
public class JobSeekerProfileServiceImpl implements ProfileService {

	private JobSeekerProfileRepo jobSeekerProfileRepo;
	private UserRepository userRepo ;
	
	public JobSeekerProfileServiceImpl(JobSeekerProfileRepo jobSeekerProfileRepo , UserRepository userRepo) {
		this.jobSeekerProfileRepo = jobSeekerProfileRepo ;
		this.userRepo = userRepo ;
	}

	@Override
	public JobSeekerProfile getProfile() {
		String email = SecurityContextHolder.getContext().getAuthentication().getName();
		User user = userRepo.findByEmail(email).get();
		JobSeekerProfile profile = jobSeekerProfileRepo.findByUser(user).orElseThrow(()-> {throw new ResourceNotFoundException("Profile not found") ;});
		return profile;
	}

	@Override
	public JobSeekerProfile completeProfile(JobSeekerProfile profile) {
		String email = SecurityContextHolder.getContext().getAuthentication().getName();
		JobSeekerProfile dbProfile = getProfile();
		
		User user = dbProfile.getUser();
		user.setName(profile.getUser().getName());
		dbProfile.setUser(user);
		dbProfile.setLocation(profile.getLocation());
		dbProfile.setEducation(profile.getEducation()) ;
		dbProfile.setSkills(profile.getSkills()) ;
		dbProfile.setExperienceYears(profile.getExperienceYears()) ;
		dbProfile.setResumeUrl(profile.getResumeUrl()) ;
		
		jobSeekerProfileRepo.save(dbProfile);
		
		return dbProfile;
	}
	
	
	
}
