package com.travelManagement.UserService.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "otp_info")
public class OTPInfo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(unique = true, nullable = false)
	private String otp;

	@Column(name = "phone_number", unique = true, nullable = false)
	private String phoneNumber;

	private String email;

	@Column(name = "rec_start_timestamp")
	private LocalDateTime startTimestamp;

}
