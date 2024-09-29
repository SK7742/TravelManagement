package com.travelManagement.UserService.service.helper;

import java.time.LocalDateTime;
import java.util.HashMap;

import org.springframework.stereotype.Component;

import com.travelManagement.UserService.kafka.KafkaProducer;
import com.travelManagement.UserService.kafka.dto.ResetPasswordPayload;
import com.travelManagement.UserService.model.User;
import com.travelManagement.UserService.model.VerificationOtp;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class KafkaDtoMapper {

	private final KafkaProducer kafkaProducer;

	public boolean mapUserResetTokenAndProduce(User user, HashMap<String, String> resetToken) {
		
		ResetPasswordPayload payload = new ResetPasswordPayload();
		payload.setEmailId(user.getEmail());
		payload.setLinkGenerationTime(resetToken.get("genTs"));
		payload.setLinkExpirationTime(resetToken.get("expTs"));
		payload.setResetLink(resetToken.get("resetLink"));
		payload.setOtpType(resetToken.get("otpType"));
		payload.setUsername(user.getUsername());
		
		return kafkaProducer.produceMessageToEmailNotificationTopic(payload);
	}

}
