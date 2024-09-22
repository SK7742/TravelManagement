package com.travelManagement.UserService.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.travelManagement.UserService.model.OTPInfo;

public interface OTPRepository extends JpaRepository<OTPInfo, Integer> {

}
