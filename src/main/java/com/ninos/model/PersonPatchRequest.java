package com.ninos.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.ninos.PersonPatchRequestDeserialiser;

@JsonDeserialize(using = PersonPatchRequestDeserialiser.class)
public class PersonPatchRequest {
	private String firstName;
	private Boolean firstNameUpdated = false;
	private String lastName;
	private Boolean lastNameUpdated = false;
	private JobType jobType;
	private Boolean jobTypeUpdated = false;

	public void setFirstName(String firstName) {
		firstNameUpdated = true;
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		lastNameUpdated = true;
		this.lastName = lastName;
	}

	public void setJobType(JobType jobType) {
		jobTypeUpdated = true;
		this.jobType = jobType;
	}

	public String getFirstName() {
		return firstName;
	}

	public Boolean getFirstNameUpdated() {
		return firstNameUpdated;
	}

	public String getLastName() {
		return lastName;
	}

	public Boolean getLastNameUpdated() {
		return lastNameUpdated;
	}

	public JobType getJobType() {
		return jobType;
	}

	public Boolean getJobTypeUpdated() {
		return jobTypeUpdated;
	}
}
