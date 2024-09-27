package com.travelManagement.notificationService.service;

import java.util.concurrent.CompletableFuture;

public interface OTPService {

	String genearteOTP(String phoneNumber);

	CompletableFuture<Boolean> sendOTPByEmail(String email, String name, String phoneNumber, String otp);

}
