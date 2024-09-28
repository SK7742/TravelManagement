package com.travelManagement.UserService.controller;

import java.util.HashMap;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.travelManagement.UserService.exception.UserNotFoundException;
import com.travelManagement.UserService.service.ForgetPasswordService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/forget")
@RequiredArgsConstructor
public class ForgetPasswordController {
	private final ForgetPasswordService forgetPasswordService;
	
	@GetMapping("password/{email}")
	public ResponseEntity<?> resetPassword(@PathVariable String email) throws UserNotFoundException{
		boolean emailSent = forgetPasswordService.sendResetTokenToEmail(email);
		return null;
	}
}
