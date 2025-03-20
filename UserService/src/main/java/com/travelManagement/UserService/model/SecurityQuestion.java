package com.travelManagement.UserService.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "security_question")
@RequiredArgsConstructor
@Getter
@Setter
public class SecurityQuestion {
	@Id
	private Long id;
	
	@Column(name = "question", unique = true, nullable = false)
	private String question;
	private String answer;
	
	@Column(name = "rec_start_timestamp", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private LocalDateTime recStartTimeStamp;

	@Column(name = "rec_end_timestamp", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private LocalDateTime recEndTimeStamp;

	@Column(name = "deleted_flag", nullable = false)
	private Boolean deletedFlag;
	
	@ManyToOne
    private User user;
	
}
