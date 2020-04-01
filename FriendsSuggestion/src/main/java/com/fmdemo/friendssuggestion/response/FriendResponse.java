package com.fmdemo.friendssuggestion.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class FriendResponse {

	@JsonProperty("message")
	private String message;

	@JsonProperty("statusCode")
	private Integer statusCode;

	public FriendResponse(String message, Integer statusCode) {
		super();
		this.message = message;
		this.statusCode = statusCode;
	}
}
