package com.travelManagement.notificationService.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.travelManagement.notificationService.service.ProducerService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/test")
@RequiredArgsConstructor
public class TestController {
	
	private final ProducerService producerService;
	
	@GetMapping("/produce")
	public void getMessageFromUser(@RequestParam("message") String body) {
		producerService.sendMessageToTopic(body);
	}
}
