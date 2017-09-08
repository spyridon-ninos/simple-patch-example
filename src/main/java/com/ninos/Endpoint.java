package com.ninos;

import com.ninos.model.Person;
import com.ninos.model.PersonPatchRequest;
import com.ninos.model.PersonResponse;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;

@RestController
@RequestMapping(
		value = "/",
		produces = MediaType.APPLICATION_JSON_UTF8_VALUE
)
public class Endpoint {

	private PersonService personService;

	@Inject
	public Endpoint(
		PersonService personService
	) {
		this.personService = personService;
	}

	@GetMapping
	public PersonResponse getPerson() {
		return new PersonResponse(personService.getPersonMap());
	}

	// if we had a PUT method, we would call the replacePerson method from
	// the personService
	@PatchMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public PersonResponse updatePerson(
		@PathVariable("id") Long id,
		@RequestBody PersonPatchRequest diff
	) {
		personService.updatePerson(id, diff);
		return new PersonResponse(personService.getPersonMap());
	}
}
