package com.travelManagement.UserService.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "user_verification_urls")
public class VerificationUrl {
	
	@Id
	private Long id;
	
	@Column(name = "url")
	private String url;
	
    @Column(name = "rec_start_timestamp")
    private LocalDateTime recStartTimeStamp;

    @Column(name = "rec_end_timestamp")
    private LocalDateTime recEndTimeStamp;

    @Column(name = "deleted_flag", nullable = false)
    private Boolean deletedFlag;
    
    @ManyToOne
    private User user;
}
