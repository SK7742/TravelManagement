package com.travelManagement.UserService.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.travelManagement.UserService.exception.UserAlreadyExistException;
import com.travelManagement.UserService.model.User;
import com.travelManagement.UserService.service.UserRegistrationService;

import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("user-registration/")
@RequiredArgsConstructor
@Slf4j
public class UserRegistrationController {
	private final UserRegistrationService userRegistrationService;
	
	@PostMapping("/user")
	public User userRegistration(User user) throws UserAlreadyExistException {
		log.info("{} is being register", user.getUsername());
		return userRegistrationService.registerUser(user);
	}
	
}
