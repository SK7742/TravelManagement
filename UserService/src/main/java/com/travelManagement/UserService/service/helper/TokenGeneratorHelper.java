package com.travelManagement.UserService.service.helper;

import java.time.LocalDateTime;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.util.HashMap;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.annotation.ObjectIdGenerators.UUIDGenerator;
@Service
public class TokenGeneratorHelper {

	public HashMap<String, String> generateResetPasswordToken() {
		HashMap<String, String> tokenProperties = new HashMap<String, String>();
		String token = UUID.randomUUID().toString();
		LocalDateTime genTime = LocalDateTime.now();
		LocalDateTime expTime = genTime.plusMinutes(15);
		tokenProperties.put("resetLink", token);
		tokenProperties.put("otpType", "resetEmailLink");
		tokenProperties.put("genTs", genTime.toString());
		tokenProperties.put("expTs", expTime.toString());
		return tokenProperties;
	}

}
