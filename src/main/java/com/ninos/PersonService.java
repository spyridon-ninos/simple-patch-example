package com.ninos;

import com.ninos.model.JobType;
import com.ninos.model.Person;
import com.ninos.model.PersonPatchRequest;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class PersonService {
	private Map<Long, Person> personMap;

	public PersonService() {
		Person person = new Person();
		person.setFirstName("Spyridon");
		person.setLastName("Ninos");
		person.setJobType(JobType.PRIVATE_SECTOR_EMPLOYEE);
		person.setDob("2000-01-01 00:00:00");

		personMap = new HashMap<>();
		personMap.put(1L, person);
	}

	public Map<Long, Person> getPersonMap() {
		return personMap;
	}

	public void setPersonMap(Map<Long, Person> personMap) {
		this.personMap = personMap;
	}

	public Person getPersonById(Long id) {
		return personMap.get(id);
	}

	/*
	 * OK, normally you wouldn't want to have a dependency from your service layer
	 * in your business layer - as such, you should have something like a PersonDiff
	 * in the place of the PersonPatchRequest, and have the patch request copy
	 * itself to the person diff.
	 *
	 * But since this is supposed to be a simple example, I put the patch request here
	 */
	public Person updatePerson(Long id, PersonPatchRequest diff) {
		Person person = personMap.get(id);

		// I know, I know... I like explicit statements though :)
		if (diff.getFirstNameUpdated() == true) {
			person.setFirstName(diff.getFirstName());
		}

		if (diff.getLastNameUpdated() == true) {
			person.setLastName(diff.getLastName());
		}

		if (diff.getJobTypeUpdated() == true) {
			person.setJobType(diff.getJobType());
		}

		return person;
	}
}
