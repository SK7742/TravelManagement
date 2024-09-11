package com.travelManagement.UserService.controller;

import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("test-controller")
public class SecureApiTestController {
	@GetMapping("/home")
	public String home(Authentication authentication) {
		String user = authentication != null ? authentication.getName() : "unAuthorized";
		return "Hello " + user;
	}
	
	@GetMapping("/users")
	public List<String> users(){
		return List.of("userOne", "userTwo", "userThree");
	}
}
