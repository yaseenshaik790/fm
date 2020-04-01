package com.fmdemo.friendssuggestion.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class UserResponse {
	
	@JsonProperty("message")
	private String message;
	
	@JsonProperty("statusCode")
	private Integer statusCode;

	public UserResponse(String message, Integer statusCode) {
		super();
		this.message = message;
		this.statusCode = statusCode;
	}

}
