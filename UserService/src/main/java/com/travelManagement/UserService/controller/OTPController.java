package com.travelManagement.UserService.controller;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.travelManagement.UserService.model.User;
import com.travelManagement.UserService.service.OTPService;
import com.travelManagement.UserService.service.RegistrationService;

@RestController
public class OTPController {

	@Autowired
	private RegistrationService registrationService;

	@Autowired
	private OTPService otpService;

	public ResponseEntity<?> generateOTP(@RequestBody User user) {
		String phoneNumber = user.getPhoneNumber();

		User userResponse = registrationService.fetchUserByPhoneNumber(phoneNumber);

		if (userResponse == null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("User not found");
		}

		// Generate OTP and save it in Database
		String generatedOtp = otpService.genearteOTP(phoneNumber);

		// Send the OTP to email address
		CompletableFuture<Boolean> emailSendingFuture = otpService.sendOTPByEmail(user.getEmail(), user.getFirstName(),
				user.getPhoneNumber(), generatedOtp);

		boolean otpSent;
		try {
			otpSent = emailSendingFuture.get();
			if (otpSent) {
				return ResponseEntity.ok().body("OTP Sent successfully");
			} else {
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to send OTP");
			}
		} catch (InterruptedException | ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to send OTP");
		}

	}
}
