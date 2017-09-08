package com.ninos;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.ninos.model.JobType;
import com.ninos.model.PersonPatchRequest;

import java.io.IOException;
import java.util.Optional;

public class PersonPatchRequestDeserialiser extends JsonDeserializer<PersonPatchRequest> {

	@Override
	public PersonPatchRequest deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
		PersonPatchRequest personPatchRequest = new PersonPatchRequest();

		JsonNode jsonNode = p.getCodec().readTree(p);

		Optional.ofNullable(jsonNode.get("firstName")).ifPresent(value -> personPatchRequest.setFirstName(value.asText()));
		Optional.ofNullable(jsonNode.get("lastName")).ifPresent(value -> personPatchRequest.setLastName(value.asText()));
		Optional.ofNullable(jsonNode.get("jobType")).ifPresent(value -> {
			JobType jobType;
			switch(value.asText().toLowerCase()) {
				case "unemployed":  jobType = JobType.UNEMPLOYED;
									break;

				case "public_sector_employee":  jobType = JobType.PUBLIC_SECTOR_EMPLOYEE;
												break;

				case "private_sector_employee": jobType = JobType.PRIVATE_SECTOR_EMPLOYEE;
												break;

				case "company_owner":   jobType = JobType.COMPANY_OWNER;
										break;

				default:    jobType = JobType.UNDEFINED;
							break; // just in case someone decides to put another case below the default one (...)
			}
			personPatchRequest.setJobType(jobType);
		});

		return personPatchRequest;
	}
}
