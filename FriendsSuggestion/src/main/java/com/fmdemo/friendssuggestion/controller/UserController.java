package com.fmdemo.friendssuggestion.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fmdemo.friendssuggestion.dto.FriendsRequest;
import com.fmdemo.friendssuggestion.dto.UserDTO;
import com.fmdemo.friendssuggestion.response.FriendResponse;
import com.fmdemo.friendssuggestion.response.UserResponse;
import com.fmdemo.friendssuggestion.service.api.UserService;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UserController {

	@Autowired
	private UserService userService;

	private static Logger logger = LoggerFactory.getLogger(UserController.class);

	@PostMapping("")
	public ResponseEntity<UserResponse> addMember(@Valid @RequestBody UserDTO userDTO) {

		logger.info("enters into add member method to save the member");
		return new ResponseEntity<>(userService.addMember(userDTO), HttpStatus.CREATED);

	}

	@PostMapping("/friends")
	public ResponseEntity<FriendResponse> addFriends(@Valid @RequestBody FriendsRequest friendsRequest) {
		logger.info("enters into add friends method to save the friends ");
		return new ResponseEntity<>(userService.addFriends(friendsRequest), HttpStatus.OK);

	}

}
