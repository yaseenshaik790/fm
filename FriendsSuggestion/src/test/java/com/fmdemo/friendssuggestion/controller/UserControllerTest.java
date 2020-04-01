package com.fmdemo.friendssuggestion.controller;

import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.fmdemo.friendssuggestion.entity.Friend;
import com.fmdemo.friendssuggestion.entity.User;
import com.fmdemo.friendssuggestion.service.api.UserService;

@SpringBootTest
public class UserControllerTest {

	@Autowired
	private UserController userController;

	@MockBean
	private UserService userService;

	User user;
	Friend friend;

	@BeforeEach
	public void setUp() {
		user = new User();

	}

}
