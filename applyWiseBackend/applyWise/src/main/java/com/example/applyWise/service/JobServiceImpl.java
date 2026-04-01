package com.example.applyWise.service;

import java.util.List;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.example.applyWise.customException.JobExistsException;
import com.example.applyWise.customException.ResourceNotFoundException;
import com.example.applyWise.entity.Job;
import com.example.applyWise.entity.User;
import com.example.applyWise.repository.JobRepo;
import com.example.applyWise.repository.UserRepository;

@Service
public class JobServiceImpl implements JobService {
	private JobRepo repo;
	private UserRepository userRepo;

	public JobServiceImpl(JobRepo repo, UserRepository userRepo) {
		this.repo = repo;
		this.userRepo = userRepo;
	}

	@Override
	public Job addJob(Job job) {

		String email = SecurityContextHolder.getContext().getAuthentication().getName();

		User recr = userRepo.findByEmail(email)
                .orElseThrow(() ->
                        new ResourceNotFoundException("USER_NOT_FOUND"));
		
		if (repo.findByTitleAndRecruiter(job.getTitle(), recr).isPresent()) {
			throw new JobExistsException("JOB_ALREADY_PRESENT");
		}
		job.setRecruiter(recr);
		job.setIs_active(true);

		return repo.save(job);
	}

	@Override
	public List<Job> getAddedJobs() {
		String email = SecurityContextHolder.getContext().getAuthentication().getName();
		User recr = userRepo.findByEmail(email)
                .orElseThrow(() ->
                        new ResourceNotFoundException("USER_NOT_FOUND"));
		
		return repo.findByRecruiter(recr);
	}

	@Override
	public List<Job> getAllJobs() {
		return repo.findAll();
	}

}
