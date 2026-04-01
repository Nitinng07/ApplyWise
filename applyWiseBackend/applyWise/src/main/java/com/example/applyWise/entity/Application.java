package com.example.applyWise.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="applications")
public class Application {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id ;
	
	private ApplicationStatus applStatus = ApplicationStatus.APPLIED ;
	
	@ManyToOne
	@JoinColumn(name="job_id")
	private Job job ;
	
	@ManyToOne
	@JoinColumn(name="job_seeker_id")
	private User jobSeekers ;
	
	@ManyToOne
	@JoinColumn(name="job_seeker_profile")
	private JobSeekerProfile jobSeekerProfile ;
	
	public Application() {
		// TODO Auto-generated constructor stub
	}

	public Application(ApplicationStatus applStatus, Job job, User jobSeekers, JobSeekerProfile jobSeekerProfile) {
		super();
		this.applStatus = applStatus;
		this.job = job;
		this.jobSeekers = jobSeekers;
		this.jobSeekerProfile = jobSeekerProfile;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public ApplicationStatus getApplStatus() {
		return applStatus;
	}

	public void setApplStatus(ApplicationStatus applStatus) {
		this.applStatus = applStatus;
	}

	public Job getJob() {
		return job;
	}

	public void setJob(Job job) {
		this.job = job;
	}

	public User getJobSeekers() {
		return jobSeekers;
	}

	public void setJobSeekers(User jobSeekers) {
		this.jobSeekers = jobSeekers;
	}

	public JobSeekerProfile getJobSeekerProfile() {
		return jobSeekerProfile;
	}

	public void setJobSeekerProfile(JobSeekerProfile jobSeekerProfile) {
		this.jobSeekerProfile = jobSeekerProfile;
	}

	

	
	
	
}
