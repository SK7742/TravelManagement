package com.travelManagement.UserService.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.travelManagement.UserService.constant.ErrorCodes;
import com.travelManagement.UserService.constant.LoginQueryParam;
import com.travelManagement.UserService.exception.UserNotFoundException;
import com.travelManagement.UserService.model.SecurityQuestion;
import com.travelManagement.UserService.model.User;
import com.travelManagement.UserService.repository.SecurityQuestionRepository;
import com.travelManagement.UserService.repository.UserRepository;
import com.travelManagement.UserService.service.UserService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
	
	private final UserRepository userRepository;
	private final SecurityQuestionRepository securityQuestionRepository;
	
	public User fetchUser(User user) {
		return userRepository.findByUsernameAndPassword(user.getUsername(), user.getPassword());
	}

	@Override
	public User fetchUser(String queryVal, String password, LoginQueryParam queryType) throws UserNotFoundException {
		if(LoginQueryParam.USERNAME.equals(queryType)) {
			if(userRepository.existsByUsername(queryVal)) {
				return userRepository.findByUsernameAndPassword(queryVal, password);
			}
		}else if(LoginQueryParam.EMAIL.equals(queryType)) {
			if(userRepository.existsByEmail(queryVal)) {
				return userRepository.findByEmailAndPassword(queryVal, password);
			}
		}
		throw new UserNotFoundException(ErrorCodes.EM_USER_NOT_FOUND, ErrorCodes.EC_USER_NOT_FOUND);
	}

	@Override
	public boolean addSecurityQuestionsForUser(List<SecurityQuestion> questions) {
//		log.info("Saving Questions for User- {}", questions.get(0).getUser().getUsername());
		securityQuestionRepository.saveAll(questions);
		return true;
	}

}
