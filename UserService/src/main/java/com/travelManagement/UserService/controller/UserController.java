package com.travelManagement.UserService.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.travelManagement.UserService.constant.LoginQueryParam;
import com.travelManagement.UserService.exception.UserAlreadyExistException;
import com.travelManagement.UserService.exception.UserNotFoundException;
import com.travelManagement.UserService.model.User;
import com.travelManagement.UserService.service.UserRegistrationService;
import com.travelManagement.UserService.service.UserService;

import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("user-controller/")
@RequiredArgsConstructor
@Slf4j
public class UserController {
	private final UserRegistrationService userRegistrationService;
	private final UserService userService;
	
	@PostMapping("/user")
	public User userRegistration(@RequestBody User user) throws UserAlreadyExistException {
		log.info("{} is being register", user.getUsername());
		return userRegistrationService.registerUser(user);
	}
	
	@GetMapping("/userByParam")
	public User fetchUser(@RequestParam LoginQueryParam queryType, String queryVal, String password) throws UserNotFoundException {
		return userService.fetchUser(queryVal, password, queryType);
	}
	
}
