package com.example.applyWise.controller;

import java.util.List;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.applyWise.entity.Application;
import com.example.applyWise.entity.Job;
import com.example.applyWise.service.ApplicationService;
import com.example.applyWise.service.JobService;

@RestController
@RequestMapping("/api/recruiter") 
@CrossOrigin
public class RecruiterController {

	private final JobService jobServ ;
	private final ApplicationService applServ ;

	public RecruiterController(JobService jobServ , ApplicationService applServ) {
		this.jobServ = jobServ;
		this.applServ = applServ;
	}
	
	
	@PostMapping("/jobs")
	public ResponseEntity<String> createJob(@RequestBody Job job){
		jobServ.addJob(job) ;
		return new ResponseEntity<String>("JOB_ADDED" , HttpStatusCode.valueOf(201)) ;
	}
	
	@GetMapping("/getAddedJobs")
	public ResponseEntity<List<Job>> getAddedJobs(){
		return new ResponseEntity<List<Job>>(jobServ.getAddedJobs(),HttpStatusCode.valueOf(200)) ;
	}
	
	@GetMapping("/applications/{jobId}")
	public ResponseEntity<List<Application>> getApplicants(@PathVariable Long jobId){
		return new ResponseEntity<List<Application>>( applServ.getApplicants(jobId) , HttpStatusCode.valueOf(200) ) ;
	}
	
}
