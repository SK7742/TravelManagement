package com.travelManagement.UserService.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.travelManagement.UserService.model.SecurityQuestion;

public interface SecurityQuestionRepository extends JpaRepository<SecurityQuestion, Long>{

}
