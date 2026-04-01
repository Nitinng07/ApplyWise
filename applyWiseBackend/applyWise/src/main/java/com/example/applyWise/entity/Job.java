package com.example.applyWise.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="jobs")
public class Job {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id ;
	
	private String title ;
	
	@Column(columnDefinition = "TEXT")
	private String description ;
	
	private String location ;
	
	@Column(name="min_sal")
	private Double minSal ;
	
	@Column(name="max_sal")
	private Double maxSal ;

	@Column(name="job_type")
	private String jobType;

	
	private Integer experience ;
	
	@ManyToOne
	@JoinColumn(name="recruiter_id")
	private User recruiter ;

	
	@Column(name="created_at")
	private LocalDateTime createdAt ;
	
	private Boolean is_active = true ;
	
	public Job() {
		// TODO Auto-generated constructor stub
	}

	public Job(Long id, String title, String description, String location, Double minSal, Double maxSal, String jobType,
			Integer experience, User recruiter, LocalDateTime createdAt, Boolean is_active) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.location = location;
		this.minSal = minSal;
		this.maxSal = maxSal;
		this.jobType = jobType;
		this.experience = experience;
		this.recruiter = recruiter;
		this.createdAt = createdAt;
		this.is_active = is_active;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Double getMinSal() {
		return minSal;
	}

	public void setMinSal(Double minSal) {
		this.minSal = minSal;
	}

	public Double getMaxSal() {
		return maxSal;
	}

	public void setMaxSal(Double maxSal) {
		this.maxSal = maxSal;
	}

	public String getJobType() {
		return jobType;
	}

	public void setJobType(String jobType) {
		this.jobType = jobType;
	}

	public Integer getExperience() {
		return experience;
	}

	public void setExperience(Integer experience) {
		this.experience = experience;
	}

	public User getRecruiter() {
		return recruiter;
	}

	public void setRecruiter(User recruiter) {
		this.recruiter = recruiter;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public Boolean isIs_active() {
		return is_active;
	}

	public void setIs_active(Boolean is_active) {
		this.is_active = is_active;
	}

	
	
	
	
}
