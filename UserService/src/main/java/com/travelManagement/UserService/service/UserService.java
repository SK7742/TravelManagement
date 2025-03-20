package com.travelManagement.UserService.service;

import java.util.List;

import com.travelManagement.UserService.constant.LoginQueryParam;
import com.travelManagement.UserService.exception.UserNotFoundException;
import com.travelManagement.UserService.model.SecurityQuestion;
import com.travelManagement.UserService.model.User;

public interface UserService {
	public User fetchUser(User user);

	public User fetchUser(String queryVal, String password, LoginQueryParam queryType) throws UserNotFoundException;

	public boolean addSecurityQuestionsForUser(List<SecurityQuestion> questions);
}
