package com.fmdemo.friendssuggestion.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fmdemo.friendssuggestion.dto.UserDTO;
import com.fmdemo.friendssuggestion.response.UserResponse;
import com.fmdemo.friendssuggestion.service.api.UserService;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping("")
	public ResponseEntity<UserResponse> addMember(@RequestBody UserDTO userDTO) {

		return new ResponseEntity<>(userService.addMember(userDTO), HttpStatus.OK);

	}

}
