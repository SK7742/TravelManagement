package com.travelManagement.UserService.service.impl;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import com.travelManagement.UserService.exception.UserAlreadyExistException;
import com.travelManagement.UserService.model.User;
import com.travelManagement.UserService.repository.UserRepository;
import com.travelManagement.UserService.service.UserRegistrationService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserRegistrationServiceImpl implements UserRegistrationService{

	private final UserRepository userRepository;
	
	@Override
	public User registerUser(User user) throws UserAlreadyExistException {
		if(!checkAndValidateUserExistance(user)) {
			log.info("Saving {} to database.", user.getUsername());
			populateDefaultValueForNewUser(user);
			return userRepository.save(user);
		}
		log.error("{} is already exists", user.getUsername());
		throw new UserAlreadyExistException();
		
		
	}

	private void populateDefaultValueForNewUser(User user) {
		user.setDeletedFlag(false);
		user.setIsActive(true);
		user.setIsVerified(false);
		user.setRecStartTimeStamp(LocalDateTime.now());
		user.setRecEndTimeStamp(LocalDateTime.of(9999, 12, 31, 12, 0));
		user.setRegisteredOn(LocalDateTime.now());
	}

	private boolean checkAndValidateUserExistance(User user) {
		return userRepository.existsByUsername(user.getUsername());
	}

}
