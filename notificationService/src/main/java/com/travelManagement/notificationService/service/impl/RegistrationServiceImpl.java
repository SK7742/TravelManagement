package com.travelManagement.notificationService.service.impl;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.travelManagement.notificationService.constant.UserServiceConstant;
import com.travelManagement.notificationService.model.User;
import com.travelManagement.notificationService.model.UserServiceResponse;
import com.travelManagement.notificationService.repository.UserRepository;
import com.travelManagement.notificationService.service.RegistrationService;


@Service
public class RegistrationServiceImpl implements RegistrationService {

	private static final Logger LOGGER = LoggerFactory.getLogger(RegistrationServiceImpl.class);

	@Autowired
	private UserRepository userRepository;

	@Override
	public UserServiceResponse submitRegistrationForm(User user) {
		// TODO Auto-generated method stub

		LOGGER.info("Registarion starts");
		User userResponse = userRepository.save(user);
		String successResponse = userResponse.getId() != null ? UserServiceConstant.REGISTRATION_STATUS_SUCCESS
				: UserServiceConstant.REGISTRATION_STATUS_FAILURE;
		UserServiceResponse userServiceResponse = new UserServiceResponse();
		userServiceResponse.setStatus(successResponse);

		return userServiceResponse;
	}

	@Override
	public UserServiceResponse validateUser(User user) {
		// TODO Auto-generated method stub

		User userResponse = userRepository.findByEmail(user.getEmail());
		UserServiceResponse userServiceResponse = new UserServiceResponse();
		String message = userResponse != null ? "User already exists" : "It's new User";

		userServiceResponse.setStatus(message);
		return userServiceResponse;
	}

	@Override
	public User fetchUserByPhoneNumber(String phoneNumber) {
		// TODO Auto-generated method stub

		Optional<User> user = userRepository.findByPhoneNumber(phoneNumber);
		if (!user.isEmpty()) {
			user.get().getEmail();
		}
		return null;
	}

}

