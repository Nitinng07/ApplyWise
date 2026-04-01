package com.example.applyWise.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.applyWise.entity.Application;
import com.example.applyWise.entity.Job;
import com.example.applyWise.entity.JobSeekerProfile;
import com.example.applyWise.repository.JobRepo;
import com.example.applyWise.service.ApplicationService;
import com.example.applyWise.service.JobService;
import com.example.applyWise.service.ProfileService;

@RestController
@RequestMapping("/api/jobseeker")
@CrossOrigin
public class JobSeekerController {

	private JobService jobServ;
	private ApplicationService applServ;
	private ProfileService jobSeekerProfServ ;


	public JobSeekerController(JobService jobServ , ApplicationService applServ , @Qualifier(value ="JobSeekerProfileService" ) ProfileService profileService) {
		this.jobServ = jobServ;
		this.applServ = applServ ;
		this.jobSeekerProfServ = profileService ;
	}


	@GetMapping("/jobs")
	public ResponseEntity<List<Job>> getAllJobs(){
		return new ResponseEntity<List<Job>>(jobServ.getAllJobs() , HttpStatusCode.valueOf(200) ) ;
	}
	
	@PostMapping("/apply/{id}")
	public ResponseEntity<String> applyJob( @PathVariable Long id){
		applServ.applyJob(id) ;
		return new ResponseEntity<String>("APPLIED_JOB" , HttpStatusCode.valueOf(200)) ;
	}
	
	@GetMapping("/applied")
	public ResponseEntity<List<Application>> getAppliedJobs(){
		return new ResponseEntity<List<Application>>( applServ.getAllAppliedJobs() , HttpStatusCode.valueOf(200)  ) ;
	}
	
	@GetMapping("/profile")
	public ResponseEntity<JobSeekerProfile> getProfile(){
		return new ResponseEntity<JobSeekerProfile>( jobSeekerProfServ.getProfile() , HttpStatusCode.valueOf(200) ) ; 
	}
	
	@PutMapping("/profile")
	public ResponseEntity<JobSeekerProfile> completeProfile(@RequestBody JobSeekerProfile profile){
		return new ResponseEntity<JobSeekerProfile>( jobSeekerProfServ.completeProfile(profile) , HttpStatusCode.valueOf(200) ) ;
	}
}
