package com.travelManagement.bookingService.model;

import java.time.LocalDateTime;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "tm_trip_vechicals")
@AllArgsConstructor
@Getter
@Setter
public class TripVechical {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@OneToOne(fetch = FetchType.LAZY)
	private Vechical vechical;
	private LocalDateTime departureTime;
	private LocalDateTime arrivalTime;
}
