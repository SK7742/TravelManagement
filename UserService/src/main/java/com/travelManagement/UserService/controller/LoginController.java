package com.travelManagement.UserService.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.travelManagement.UserService.http.model.AuthResponse;
import com.travelManagement.UserService.http.model.ErrorResponse;
import com.travelManagement.UserService.model.User;
import com.travelManagement.UserService.service.TokenService;
import com.travelManagement.UserService.service.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/login-controller")
@RequiredArgsConstructor
public class LoginController {
	
	private final TokenService tokenService;
	private final UserService userService;
	
	
	@PostMapping("/login")
	public ResponseEntity<?> validateLogin(@RequestBody User userloginCred) {
		User user = userService.fetchUser(userloginCred);
		if (user == null) {
            // User not found, return a ResponseEntity with a 404 status
            ErrorResponse errorResponse = new ErrorResponse("User not found");
            return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
        }
		String token = tokenService.generateToken(user);

        // Create response with token and user details
        AuthResponse authResponse = new AuthResponse(token, user);

        return new ResponseEntity<>(authResponse, HttpStatus.OK);
	}		
}
