package com.travelManagement.notificationService.service;

import com.travelManagement.notificationService.model.User;
import com.travelManagement.notificationService.model.UserServiceResponse;

public interface RegistrationService {

	public UserServiceResponse submitRegistrationForm(User user);

	public UserServiceResponse validateUser(User user);

	public User fetchUserByPhoneNumber(String phoneNumber);

}
