package com.fmdemo.friendssuggestion.exception;

public class UserNotFoundException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private final Integer errorCode = 6777;

	public UserNotFoundException(String userName) {
		super("member not found with user name: " + userName);
	}

	public Integer getErrorCode() {
		return errorCode;
	}
}
