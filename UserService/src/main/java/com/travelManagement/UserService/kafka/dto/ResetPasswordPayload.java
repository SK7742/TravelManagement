package com.travelManagement.UserService.kafka.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@NoArgsConstructor
@ToString
public class ResetPasswordPayload implements Serializable{
	private String emailId;
	private String linkGenerationTime;
	private String linkExpirationTime;
	private String username;
	private String resetLink;
	private String otpType;
}
