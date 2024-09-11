package com.travelManagement.UserService.service;

import org.springframework.stereotype.Service;

import com.travelManagement.UserService.model.User;

public interface UserService {
	public User fetchUser(User user);
}
