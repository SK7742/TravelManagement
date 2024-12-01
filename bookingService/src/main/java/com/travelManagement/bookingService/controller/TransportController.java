package com.travelManagement.bookingService.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.travelManagement.bookingService.model.Vechical;
import com.travelManagement.bookingService.service.TransportService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("transport-controller/")
@RequiredArgsConstructor
public class TransportController {
	private final TransportService transportService;
	@PostMapping("transport/")
	public Object addNewBus(@RequestBody Vechical vechical) {
		return transportService.createNewTransport(vechical);
	}
}
