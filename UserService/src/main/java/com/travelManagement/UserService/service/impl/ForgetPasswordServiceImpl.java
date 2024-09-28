package com.travelManagement.UserService.service.impl;

import java.time.LocalDateTime;
import java.util.HashMap;
import org.springframework.stereotype.Service;

import com.travelManagement.UserService.exception.UserNotFoundException;
import com.travelManagement.UserService.kafka.KafkaProducer;
import com.travelManagement.UserService.kafka.dto.ResetPasswordPayload;
import com.travelManagement.UserService.model.User;
import com.travelManagement.UserService.model.VerificationOtp;
import com.travelManagement.UserService.repository.VerificationOtpRepository;
import com.travelManagement.UserService.service.ForgetPasswordService;
import com.travelManagement.UserService.service.UserService;
import com.travelManagement.UserService.service.helper.KafkaDtoMapper;
import com.travelManagement.UserService.service.helper.TokenGeneratorHelper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ForgetPasswordServiceImpl implements ForgetPasswordService{
	
	private final UserService userService;
	private final TokenGeneratorHelper tokenGeneratorHelper;
	private final KafkaDtoMapper kafkaDtoMapper;
	private final VerificationOtpRepository verificationOtpRepository;

	@Override
	public boolean sendResetTokenToEmail(String email) throws UserNotFoundException {
		User user = userService.fetchUserByEmail(email);
		HashMap<String, String> resetToken = tokenGeneratorHelper.generateResetPasswordLink();
		mapVerificationOtpAndPersistToDb(user, resetToken);
		return kafkaDtoMapper.mapUserResetTokenAndProduce(user, resetToken);
	}

	private void mapVerificationOtpAndPersistToDb(User user, HashMap<String, String> resetToken) {
		
		verificationOtpRepository.save(VerificationOtp.builder()
				.user(user)
				.otp(resetToken.get("resetLink"))
				.otpType("RESET_LINK")
				.recStartTimeStamp(LocalDateTime.parse(resetToken.get("genTs")))
				.recEndTimeStamp(LocalDateTime.parse(resetToken.get("exTs")))
				.deletedFlag(false)
				.build());
	}

}
