package com.ninos.model;

import java.util.Map;

public class PersonResponse {
	private Map<Long, Person> persons;

	public PersonResponse() {
		// default ctor
	}

	public PersonResponse(Map<Long, Person> persons) {
		this.persons = persons;
	}

	public Map<Long, Person> getPersons() {
		return persons;
	}

	public void setPersons(Map<Long, Person> persons) {
		this.persons = persons;
	}
}
