package com.travelManagement.notificationService.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "session_activity")
public class SessionActivity {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Long id;

    @Column(name = "rec_start_timestamp")
    private LocalDateTime recStartTimeStamp;

    @Column(name = "rec_end_timestamp")
    private LocalDateTime recEndTimeStamp;

    @Column(name = "deleted_flag", nullable = false)
    private Boolean deletedFlag;
    
    @ManyToOne
    private User user;
}

