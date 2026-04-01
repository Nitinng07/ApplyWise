package com.example.applyWise.entity;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "job_seeker_profile")
public class JobSeekerProfile {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id ;
	
	private String skills ;
	private Integer experienceYears ;
	private String education ;
	private String resumeUrl ;
	private String location ;
	
	@OneToOne
	@JoinColumn(name="user_id" , nullable=false )
	private User user ;

	public JobSeekerProfile() {
		// TODO Auto-generated constructor stub
	}

	public JobSeekerProfile(String skills, Integer experienceYears, String education, String resumeUrl, String location,
			User user) {
		super();
		this.skills = skills;
		this.experienceYears = experienceYears;
		this.education = education;
		this.resumeUrl = resumeUrl;
		this.location = location;
		this.user = user;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSkills() {
		return skills;
	}

	public void setSkills(String skills) {
		this.skills = skills;
	}

	public Integer getExperienceYears() {
		return experienceYears;
	}

	public void setExperienceYears(Integer experienceYears) {
		this.experienceYears = experienceYears;
	}

	public String getEducation() {
		return education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	public String getResumeUrl() {
		return resumeUrl;
	}

	public void setResumeUrl(String resumeUrl) {
		this.resumeUrl = resumeUrl;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "JobSeekerProfile [id=" + id + ", skills=" + skills + ", experienceYears=" + experienceYears
				+ ", education=" + education + ", resumeUrl=" + resumeUrl + ", location=" + location + ", user=" + user
				+ "]";
	}
	
	
	
	
	
}
