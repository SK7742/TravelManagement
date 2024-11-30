package com.travelManagement.bookingService.model;

import java.util.Set;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
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
@Entity(name = "vechical")
public class Vechical {
	@Id
	private Long vechicalId;
	private String vechicalSeatCapacity;
//	private Set<String> seatTypes;
	private String vechicalRegNo;
	private String vechicalType;
	private String vechicalMilage;
	private String vechicalAverageSpeed;
	@OneToMany(fetch = FetchType.LAZY)
	private Set<SeatMap> seatMap;
}
