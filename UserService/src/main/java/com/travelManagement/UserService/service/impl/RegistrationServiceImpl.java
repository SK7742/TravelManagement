package com.travelManagement.UserService.service.impl;

import java.time.LocalDateTime;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.travelManagement.UserService.model.User;
import com.travelManagement.UserService.model.UserServiceResponse;
import com.travelManagement.UserService.repository.UserRepository;
import com.travelManagement.UserService.service.RegistrationService;
import com.travelManagemnt.UserService.constant.UserServiceConstant;

@Service
public class RegistrationServiceImpl implements RegistrationService {

	private static final Logger LOGGER = LoggerFactory.getLogger(RegistrationServiceImpl.class);

	@Autowired
	private UserRepository userRepository;

	@Override
	public UserServiceResponse submitRegistrationForm(User user) {
		LOGGER.info("Registarion starts");
		checkAndPopulateDefaultValuesForUserRegistration(user);
		User userResponse = userRepository.save(user);
		String successResponse = userResponse.getId() != null ? UserServiceConstant.REGISTRATION_STATUS_SUCCESS
				: UserServiceConstant.REGISTRATION_STATUS_FAILURE;
		UserServiceResponse userServiceResponse = new UserServiceResponse();
		userServiceResponse.setStatus(successResponse);

		return userServiceResponse;
	}

	private void checkAndPopulateDefaultValuesForUserRegistration(User user) {
		user.setIsActive(true);
		user.setDeletedFlag(false);
		user.setIsVerified(false);
		user.setRecStartTimeStamp(LocalDateTime.now());
		user.setRecEndTimeStamp(LocalDateTime.of(9999, 01, 01, 0, 0));
		user.setRegisteredOn(LocalDateTime.now());
	}

	@Override
	public UserServiceResponse validateUser(User user) {
		User userResponse = userRepository.findByEmail(user.getEmail());
		UserServiceResponse userServiceResponse = new UserServiceResponse();
		String message = userResponse != null ? "User already exists" : "It's new User";

		userServiceResponse.setStatus(message);
		return userServiceResponse;
	}

	@Override
	public User fetchUserByPhoneNumber(String phoneNumber) {

		Optional<User> user = userRepository.findByPhoneNumber(phoneNumber);
		if (!user.isEmpty()) {
			user.get().getEmail();
		}
		return null;
	}

}
