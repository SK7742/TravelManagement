package com.travelManagement.bookingService.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class VechicalSeat {
	private int seatNo;
	private String seatType;
	private Double fare;
}
