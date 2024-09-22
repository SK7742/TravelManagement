package com.travelManagement.UserService.service;

import com.travelManagement.UserService.model.User;
import com.travelManagement.UserService.model.UserServiceResponse;

public interface RegistrationService {

	public UserServiceResponse submitRegistrationForm(User user);

	public UserServiceResponse validateUser(User user);

	public User fetchUserByPhoneNumber(String phoneNumber);

}
