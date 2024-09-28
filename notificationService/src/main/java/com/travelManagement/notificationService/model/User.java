package com.travelManagement.notificationService.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "user")
public class User {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Long id;

    @Column(name = "username", unique = true, nullable = false)
    private String username;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "email", unique = true, nullable = false)
    private String email;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "address")
    private String address;

    @Column(name = "registered_on", nullable = false, updatable = false)
    private LocalDateTime registeredOn;

    @Column(name = "is_active", nullable = false)
    private Boolean isActive;

    @Column(name = "is_verified", nullable = false)
    private Boolean isVerified;

    @Column(name = "profile_picture")
    private byte[] profilePicture;

    @Column(name = "rec_start_timestamp")
    private LocalDateTime recStartTimeStamp;

    @Column(name = "rec_end_timestamp")
    private LocalDateTime recEndTimeStamp;

    @Column(name = "deleted_flag", nullable = false)
    private Boolean deletedFlag;
    
    @OneToMany
    private Set<Role> roles;
    
    @OneToMany(mappedBy = "user")
    private Set<SessionActivity> sessions;
    
    @OneToMany(mappedBy = "user")
    private Set<VerificationOtp> verificationUrls;
}
