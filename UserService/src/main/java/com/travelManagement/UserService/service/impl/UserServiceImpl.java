package com.travelManagement.UserService.service.impl;

import org.springframework.stereotype.Service;

import com.travelManagement.UserService.model.User;
import com.travelManagement.UserService.repository.UserRepository;
import com.travelManagement.UserService.service.UserService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
	
	private final UserRepository userRepository;
	
	public User fetchUser(User user) {
		return userRepository.findByUsernameAndPassword(user.getUsername(), user.getPassword());
	}
}
