package com.fmdemo.friendssuggestion.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.fmdemo.friendssuggestion.repository.FriendRepository;
import com.fmdemo.friendssuggestion.repository.UserRepository;
import com.fmdemo.friendssuggestion.service.api.UserService;

@SpringBootTest
public class UserServiceTest {

	@Autowired
	private UserService userService;

	@MockBean
	private UserRepository userRepository;

	@MockBean
	private FriendRepository friendRepository;
}
