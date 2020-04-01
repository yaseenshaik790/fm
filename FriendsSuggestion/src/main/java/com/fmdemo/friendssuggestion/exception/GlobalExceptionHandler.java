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

	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<Object> userNotFoundException(UserNotFoundException userNotFoundException) {

		ExceptionResponse exceptionResponse = new ExceptionResponse(userNotFoundException.getMessage(),
				userNotFoundException.getErrorCode());

		return new ResponseEntity<>(exceptionResponse, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(FriendRequestNotFoundException.class)
	public ResponseEntity<Object> friendRequestNotFoundException(
			FriendRequestNotFoundException friendRequestNotFoundException) {

		ExceptionResponse exceptionResponse = new ExceptionResponse(friendRequestNotFoundException.getMessage(),
				friendRequestNotFoundException.getErrorCode());

		return new ResponseEntity<>(exceptionResponse, HttpStatus.NOT_FOUND);
	}

}
