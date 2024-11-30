package com.travelManagement.bookingService.model;

import java.time.LocalDateTime;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "trip_vechical")
@AllArgsConstructor
@Getter
@Setter
public class TripVechical {
	@Id
	private Long id;
	@OneToOne(fetch = FetchType.LAZY)
	private Vechical vechical;
	private LocalDateTime departureTime;
	private LocalDateTime arrivalTime;
}
