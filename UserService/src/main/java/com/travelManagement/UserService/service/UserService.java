package com.travelManagement.UserService.service;

import com.travelManagement.UserService.constant.LoginQueryParam;
import com.travelManagement.UserService.exception.UserNotFoundException;
import com.travelManagement.UserService.model.User;

public interface UserService {
	public User fetchUser(User user);

	public User fetchUser(String queryVal, String password, LoginQueryParam queryType) throws UserNotFoundException;
}
