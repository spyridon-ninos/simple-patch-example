package com.ninos.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Person {
	private String firstName;
	private String lastName;
	private LocalDateTime dob;
	private JobType jobType;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getDob() {
		return dob.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
	}

	public void setDob(String dob) {
		this.dob = LocalDateTime.from(
				DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").parse(dob)
		);
	}

	public JobType getJobType() {
		return jobType;
	}

	public void setJobType(JobType jobType) {
		this.jobType = jobType;
	}

	public Person() {
		// default ctor
	}

	public Person(Person person) {
		this.firstName = person.getFirstName();
		this.lastName = person.getLastName();
		this.jobType = person.getJobType();
		setDob(person.getDob());
	}
}
