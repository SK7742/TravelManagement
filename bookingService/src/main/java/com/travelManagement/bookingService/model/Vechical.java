package com.travelManagement.bookingService.model;

import java.time.LocalDateTime;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Vechical {
	private Long id;
	private String vechicalMode;
	private String vechicalRegNo;
	private String vechicalType;
	private String vechicalMilage;
	private String vechicalAverageSpeed;
	private String vechicalSourcePlace;
	private String vechicalDestinationPlace;
	private LocalDateTime vechicalArrivalTime;
	private String vechicalDepartureTime;
	private String seatCapacity;
	private Set<VechicalSeat> availableSeats;
}
