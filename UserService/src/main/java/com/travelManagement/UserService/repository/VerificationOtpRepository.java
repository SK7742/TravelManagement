package com.travelManagement.UserService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.travelManagement.UserService.model.VerificationOtp;

@Repository
public interface VerificationOtpRepository extends JpaRepository<VerificationOtp, Long>{

}
