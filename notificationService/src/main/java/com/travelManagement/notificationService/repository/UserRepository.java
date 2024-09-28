package com.travelManagement.notificationService.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.travelManagement.notificationService.model.User;


@Repository
public interface UserRepository extends JpaRepository<User, Long>{

	User findByUsernameAndPassword(String username, String password);
	
	User findByEmail(String email);
	
	Optional<User>  findByPhoneNumber(String phoneNumber);

}