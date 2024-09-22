package com.travelManagement.UserService.service;

import java.util.concurrent.CompletableFuture;

public interface EmailService {

	public CompletableFuture<Void> sendEmail(String to, String subject, String text);

	public String getOtpEmailTemplate(String name, String phoneNumber, String otp);

}
