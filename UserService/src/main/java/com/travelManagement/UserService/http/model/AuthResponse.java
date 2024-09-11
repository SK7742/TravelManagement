package com.travelManagement.UserService.http.model;

import com.travelManagement.UserService.model.User;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class AuthResponse {
	 private String token;
	 private User user;
}
