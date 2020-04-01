package com.fmdemo.friendssuggestion.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Setter
@Getter
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
