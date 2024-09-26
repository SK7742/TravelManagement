package com.travelManagement.notificationService.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.travelManagement.notificationService.model.OTPInfo;


public interface OTPRepository extends JpaRepository<OTPInfo, Integer> {

}
