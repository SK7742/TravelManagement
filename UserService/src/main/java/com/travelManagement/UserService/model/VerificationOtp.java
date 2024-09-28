package com.travelManagement.UserService.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "user_verification_urls")
public class VerificationOtp {
	
	@Id
	private Long id;
	
	@Column(name = "otp")
	private String otp;
	
	@Column(name = "type")
	private String otpType;
	
    @Column(name = "rec_start_timestamp")
    private LocalDateTime recStartTimeStamp;

    @Column(name = "rec_end_timestamp")
    private LocalDateTime recEndTimeStamp;

    @Column(name = "deleted_flag", nullable = false)
    private Boolean deletedFlag;
    
    @ManyToOne
    private User user;
}
