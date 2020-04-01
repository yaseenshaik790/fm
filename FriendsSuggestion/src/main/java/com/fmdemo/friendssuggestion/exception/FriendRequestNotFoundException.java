package com.fmdemo.friendssuggestion.exception;

public class FriendRequestNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private final Integer errorCode = 6987;

	public FriendRequestNotFoundException() {
		super("Friends request not found exception");
	}

	public Integer getErrorCode() {
		return errorCode;
	}

}
