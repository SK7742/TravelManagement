package com.travelManagement.UserService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.travelManagement.UserService.model.User;
import com.travelManagement.UserService.model.UserServiceResponse;
import com.travelManagement.UserService.service.RegistrationService;

@RestController
@RequestMapping("/registration")
public class RegistrationController {

	@Autowired
	private RegistrationService registrationService;

	@PostMapping("/validate-user")
	public UserServiceResponse validateUser(@RequestBody User user) {
		UserServiceResponse response = registrationService.validateUser(user);
		return response;
	}

	@PostMapping("/user-registration")
	public UserServiceResponse submitRegistrationForm(@RequestBody User user) {
		UserServiceResponse response = registrationService.submitRegistrationForm(user);
		return response;
	}

}
