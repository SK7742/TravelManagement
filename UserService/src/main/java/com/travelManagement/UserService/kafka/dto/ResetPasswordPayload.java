package com.travelManagement.UserService.kafka.dto;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class ResetPasswordPayload {
	private String emailId;
	private String linkGenerationTime;
	private String linkExpirationTime;
	private String username;
	private String resetLink;
}
