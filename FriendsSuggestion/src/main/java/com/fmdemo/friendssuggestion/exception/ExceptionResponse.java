package com.fmdemo.friendssuggestion.exception;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class ExceptionResponse {
	@JsonProperty("errorMessage")
	private String errorMessage;
	@JsonProperty("errorCode")
	private Integer errorCode;

	public ExceptionResponse(String errorMessage, Integer errorCode) {
		super();
		this.errorMessage = errorMessage;
		this.errorCode = errorCode;
	}

}
