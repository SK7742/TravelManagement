package com.travelManagement.UserService.service.impl;

import java.time.LocalDateTime;
import java.util.Random;
import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.travelManagement.UserService.model.OTPInfo;
import com.travelManagement.UserService.repository.OTPRepository;
import com.travelManagement.UserService.service.EmailService;
import com.travelManagement.UserService.service.OTPService;

@Service
public class OTPServiceImpl implements OTPService {

	@Autowired
	private OTPRepository otpRepository;
	@Autowired
	private EmailService emailService;

	@Override
	public String genearteOTP(String phoneNumber) {
		// TODO Auto-generated method stub

		Random random = new Random();
		int otpValue = 100 + random.nextInt(900);
		String otp = String.valueOf(otpValue);

		// Save the new OTP details in DB
		OTPInfo otpInfo = new OTPInfo();
		otpInfo.setOtp(otp);
		otpInfo.setPhoneNumber(phoneNumber);
		otpInfo.setStartTimestamp(LocalDateTime.now());
		otpRepository.save(otpInfo);
		return otp;
	}

	@Override
	public CompletableFuture<Boolean> sendOTPByEmail(String email, String name, String phoneNumber, String otp) {
		// TODO Auto-generated method stub

		String subject = "OTP Verification";
		String emailText = emailService.getOtpEmailTemplate(name, phoneNumber, otp);
		CompletableFuture<Void> emailSendingFuture = emailService.sendEmail(otp, subject, emailText);
		return emailSendingFuture.thenApplyAsync(result -> true).exceptionally(ex -> {
			ex.printStackTrace();
			return false;
		});

	}

}
