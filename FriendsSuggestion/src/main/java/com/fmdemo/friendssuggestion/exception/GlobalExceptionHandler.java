package com.fmdemo.friendssuggestion.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(UserAlreadyExcistException.class)
	public ResponseEntity<Object> userAlreadyExcistException(UserAlreadyExcistException userAlreadyExcistException) {

		ExceptionResponse exceptionResponse = new ExceptionResponse(userAlreadyExcistException.getMessage(),
				userAlreadyExcistException.getErrorCode());

		return new ResponseEntity<>(exceptionResponse, HttpStatus.NOT_FOUND);

	}
}
