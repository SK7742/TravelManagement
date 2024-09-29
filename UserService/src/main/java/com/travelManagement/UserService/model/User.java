package com.travelManagement.UserService.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
	@JsonIgnore
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

    @JsonIgnore
    @Column(name = "registered_on", nullable = false, updatable = false)
    private LocalDateTime registeredOn;

    @JsonIgnore
    @Column(name = "is_active", nullable = false)
    private Boolean isActive;

    @JsonIgnore
    @Column(name = "is_verified", nullable = false)
    private Boolean isVerified;

    @JsonIgnore //TODO: Need to remove further
    @Column(name = "profile_picture")
    private byte[] profilePicture;

    @JsonIgnore
    @Column(name = "rec_start_timestamp")
    private LocalDateTime recStartTimeStamp;

    @JsonIgnore
    @Column(name = "rec_end_timestamp")
    private LocalDateTime recEndTimeStamp;

    @JsonIgnore
    @Column(name = "deleted_flag", nullable = false)
    private Boolean deletedFlag;
    
    @JsonIgnore
    @OneToMany
    private Set<Role> roles;
    
    @JsonIgnore
    @OneToMany(mappedBy = "user")
    private Set<SessionActivity> sessions;
    
    @JsonIgnore
    @OneToMany(mappedBy = "user")
    private Set<VerificationOtp> verificationUrls;
}
