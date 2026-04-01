package com.example.applyWise.service;

import java.util.List;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.example.applyWise.customException.ProfileCompletionException;
import com.example.applyWise.customException.ResourceNotFoundException;
import com.example.applyWise.entity.Application;
import com.example.applyWise.entity.ApplicationStatus;
import com.example.applyWise.entity.Job;
import com.example.applyWise.entity.JobSeekerProfile;
import com.example.applyWise.entity.User;
import com.example.applyWise.repository.ApplicationRepo;
import com.example.applyWise.repository.JobRepo;
import com.example.applyWise.repository.JobSeekerProfileRepo;
import com.example.applyWise.repository.UserRepository;

@Service
public class ApplicationServiceImpl implements ApplicationService {

	private UserRepository userRepo;
	private ApplicationRepo applRepo;
	private JobRepo jobRepo;
	private JobSeekerProfileRepo jobSeekerProfileRepo ;

	public ApplicationServiceImpl(JobSeekerProfileRepo jobSeekerProfileRepo, ApplicationRepo applRepo, JobRepo jobRepo, UserRepository userRepo) {
		this.applRepo = applRepo;
		this.jobRepo = jobRepo;
		this.userRepo = userRepo;
		this.jobSeekerProfileRepo  = jobSeekerProfileRepo ;
	}

	@Override
	public Application applyJob(Long jobId) {

		String email = SecurityContextHolder.getContext().getAuthentication().getName();

		User user = userRepo.findByEmail(email).orElseThrow(() -> new ResourceNotFoundException("USER_NOT_FOUND"));
		JobSeekerProfile userProfile = jobSeekerProfileRepo.findByUser(user).orElseThrow(() -> new ResourceNotFoundException("PROFILE_NOT_FOUND"));
		
		if(userProfile.getEducation()==null || userProfile.getResumeUrl()==null || userProfile.getLocation()==null || userProfile.getSkills()==null ) {
			throw new ProfileCompletionException("Please complete the profile");
		}
		
		Job job = jobRepo.findById(jobId).orElseThrow(() -> {
			throw new ResourceNotFoundException("JOB_NOT_PRESENT");
		});

		if (applRepo.findByJobAndJobSeekers(job, user).isPresent()) {
			throw new ResourceNotFoundException("ALREADY_APPLIED");
		}

		return applRepo.save(new Application(ApplicationStatus.APPLIED, job, user , userProfile));
	}

	@Override
	public List<Application> getAllAppliedJobs() {
		String email = SecurityContextHolder.getContext().getAuthentication().getName();
		User user = userRepo.findByEmail(email).orElseThrow(() -> new ResourceNotFoundException("USER_NOT_FOUND"));

		return applRepo.findByJobSeekers(user);
	}

	@Override
	public List<Application> getApplicants(Long id) {
		Job job = jobRepo.findById(id).orElseThrow(() -> {
			throw new ResourceNotFoundException("Job not found");
		});

		return applRepo.findByJob(job);
	}

}
