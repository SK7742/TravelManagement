package com.travelManagement.UserService.service;

import com.travelManagement.UserService.exception.UserNotFoundException;

public interface ForgetPasswordService {
	public boolean sendResetTokenToEmail(String email) throws UserNotFoundException;
}
