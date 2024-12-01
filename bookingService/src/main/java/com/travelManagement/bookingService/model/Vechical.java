package com.travelManagement.bookingService.model;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "tm_vechicals")
public class Vechical {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long vechicalId;
	private int vechicalSeatCapacity;
	private Set<String> seatTypes;
	private String vechicalRegNo;
	private String vechicalType;
	private String vechicalMilage;
	private String vechicalAverageSpeed;
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<SeatMap> seatMap;
}
