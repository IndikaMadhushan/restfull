package com.in28minutes.rest.webservices.restfull_web_services.user;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserResource {

	private UserDaoService service;

	//GET all users
	public UserResource(UserDaoService service) {
		this.service = service;
	}

	@GetMapping(path="/users")
	public List<User> retrieveUsers() {
		return service.findAll();
	}
}
