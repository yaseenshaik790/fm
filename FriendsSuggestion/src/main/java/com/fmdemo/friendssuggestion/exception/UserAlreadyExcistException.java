package com.fmdemo.friendssuggestion.exception;

public class UserAlreadyExcistException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private final Integer eRROR_CODE = 6767;

	public UserAlreadyExcistException(String userName) {
		super("member is already excist with user name: " + userName);
	}

	public Integer getErrorCode() {
		return eRROR_CODE;
	}

}
