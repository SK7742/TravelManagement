package com.travelManagement.UserService.service;

import org.springframework.stereotype.Service;

import com.travelManagement.UserService.exception.UserNotFoundException;
import com.travelManagement.UserService.model.User;

@Service
public interface UserService {
	public User fetchUser(User user);
	public User fetchUserByEmail(String email) throws UserNotFoundException;
}
