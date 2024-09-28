package com.travelManagement.UserService.kafka;

import java.util.concurrent.Future;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.travelManagement.UserService.kafka.dto.ResetPasswordPayload;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class KafkaProducer {
	private final KafkaTemplate<String, ResetPasswordPayload> ResetPasswordkafkaTemplate;
	private final String resetPasswordProducerTopic = "com.travelManagement.kafka.topic.resetPassword";
	public boolean produceMessageToEmailNotificationTopic(ResetPasswordPayload payload) {
		var response = ResetPasswordkafkaTemplate.send(resetPasswordProducerTopic, payload);
		return false;
	}

}
