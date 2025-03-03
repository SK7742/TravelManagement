package com.travelManagement.UserService.service;

import com.travelManagement.UserService.exception.UserAlreadyExistException;
import com.travelManagement.UserService.model.User;

public interface UserRegistrationService {

	public User registerUser(User user) throws UserAlreadyExistException;

}
