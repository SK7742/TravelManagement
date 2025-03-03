package com.travelManagement.UserService.exception;

public class UserAlreadyExistException extends Exception {
	private static final long serialVersionUID = 1L;
	private String errorCode;

    public UserAlreadyExistException(String message, String errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

    public String getErrorCode() {
        return errorCode;
    }
}
