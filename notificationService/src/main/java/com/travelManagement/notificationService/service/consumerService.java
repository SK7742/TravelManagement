package com.travelManagement.notificationService.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class consumerService {
	@KafkaListener(topics = "testTopic", autoStartup = "true", groupId = "testGroup")
	public void subscribe(String message) {
		System.out.println(message);
	}
}
