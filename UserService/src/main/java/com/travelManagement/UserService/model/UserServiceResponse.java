package com.travelManagement.UserService.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserServiceResponse {
	
	private String status;
	private String errorMessage;
//	private List<User> user;
	private String responseMessage;
	
	
}
