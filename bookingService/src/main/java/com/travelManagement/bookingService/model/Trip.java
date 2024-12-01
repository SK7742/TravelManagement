package com.travelManagement.bookingService.model;

import java.time.LocalDate;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "tm_trips")
@AllArgsConstructor
@Getter
@Setter
public class Trip {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long tripId;
	private String tripSourcePlace;
	private String tripDestinationPlace;
	private LocalDate tripDate;
	@OneToMany(fetch = FetchType.LAZY)
	private Set<TripVechical> registeredVechicals;
}
