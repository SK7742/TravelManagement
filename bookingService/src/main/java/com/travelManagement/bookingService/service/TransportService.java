package com.travelManagement.bookingService.service;

import org.springframework.stereotype.Service;

import com.travelManagement.bookingService.model.Vechical;
import com.travelManagement.bookingService.repository.TransportRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TransportService {
	
	private final TransportRepository transportRepository;

	public Object createNewTransport(Vechical transport) {
			transportRepository.save(transport);
		return null;
	}



}
