package com.example.applyWise.dto.response;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ApplicantResponse {

	private Long applicationId ;
	private String applicantName ;
	private String applicantEmail ;
	private String status ;
	private LocalDateTime appliedAt ;
	
	public ApplicantResponse() {
		// TODO Auto-generated constructor stub
	}
	
	public ApplicantResponse(Long applicationId, String applicantName, String applicantEmail, String status,
			LocalDateTime appliedAt) {
		super();
		this.applicationId = applicationId;
		this.applicantName = applicantName;
		this.applicantEmail = applicantEmail;
		this.status = status;
		this.appliedAt = appliedAt;
	}

	public Long getApplicationId() {
		return applicationId;
	}

	public void setApplicationId(Long applicationId) {
		this.applicationId = applicationId;
	}

	public String getApplicantName() {
		return applicantName;
	}

	public void setApplicantName(String applicantName) {
		this.applicantName = applicantName;
	}

	public String getApplicantEmail() {
		return applicantEmail;
	}

	public void setApplicantEmail(String applicantEmail) {
		this.applicantEmail = applicantEmail;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public LocalDateTime getAppliedAt() {
		return appliedAt;
	}

	public void setAppliedAt(LocalDateTime appliedAt) {
		this.appliedAt = appliedAt;
	}

	
	
}
