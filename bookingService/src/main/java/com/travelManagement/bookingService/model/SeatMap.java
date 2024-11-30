package com.travelManagement.bookingService.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity(name = "seatMap")
public class SeatMap {
	@Id
	private Long id;
	private int seatNo;
	private String seatType;
	private Double fare;
	private boolean isBooked;
}
