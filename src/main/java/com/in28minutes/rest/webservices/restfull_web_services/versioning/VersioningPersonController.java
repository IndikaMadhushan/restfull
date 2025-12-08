package com.in28minutes.rest.webservices.restfull_web_services.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersioningPersonController {
	@GetMapping("/v1/person")
	public PersonV1 getFirstVersionOfPerson() {
		return new PersonV1("Bob Charlie");
	}

	@GetMapping("/v2/person")
	public PersonV2 getSecondVersionOfPerson() {
		return new PersonV2(new Name("bob", "charlie"));
	}

	@GetMapping(path = "person", params = "version=1")
	public PersonV1 getFirstVersinOfPersonRequestParameter() {
		return new PersonV1("Bob Charlie");
	}
	
	@GetMapping(path = "person", params = "version=2")
	public PersonV2 getSecondVersionOfPersonRequestParameter() {
		return new PersonV2(new Name("bob", "charlie"));
	}
	
	@GetMapping(path = "person/header", headers = "X-API-VERSION=1")
	public PersonV1 getFirstVersinOfPersonRequestHeader() {
		return new PersonV1("Bob Charlie");
	}
	
	@GetMapping(path = "person/header", headers = "X-API-VERSION=2")
	public PersonV2 getSecondVersinOfPersonRequestHeader() {
		return new PersonV2(new Name("bob", "charlie"));
	}
	
	@GetMapping(path = "person/accept", produces = "application/vnd.company.app-v1+json")
	public PersonV1 getFirstVersinOfPersonAcceptHeader() {
		return new PersonV1("Bob Charlie");
	}
	
	@GetMapping(path = "person/accept", produces = "application/vnd.company.app-v2+json")
	public PersonV2 getSecondVersinOfPersonAcceptHeader() {
		return new PersonV2(new Name("bob", "charlie"));
	}
}
