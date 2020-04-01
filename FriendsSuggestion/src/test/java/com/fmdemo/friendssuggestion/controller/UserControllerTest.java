package com.fmdemo.friendssuggestion.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;

import com.fmdemo.friendssuggestion.dto.UserDTO;
import com.fmdemo.friendssuggestion.entity.Friend;
import com.fmdemo.friendssuggestion.entity.User;
import com.fmdemo.friendssuggestion.response.UserResponse;
import com.fmdemo.friendssuggestion.service.api.UserService;

@SpringBootTest
public class UserControllerTest {

	@Autowired
	private UserController userController;

	@MockBean
	private UserService userService;

	User user;
	Friend friend;
	UserDTO userDto;

	@BeforeEach
	public void setUp() {
		
		user = new User();
		user.setFullName(TestData.fullName);

		userDto = new UserDTO();
		userDto.setFullName(TestData.fullName);

		friend = new Friend();
		friend.setUserId(TestData.userId);

	}

	@Test
	public void addMemberPositiveTest() {

		UserResponse response = new UserResponse("Member added successfully ", 7676);

		when(userService.addMember(userDto)).thenReturn(response);

		ResponseEntity<UserResponse> userResponseEntity = userController.addMember(userDto);

		UserResponse userResponse = userService.addMember(userDto);

		assertThat(userResponse.getMessage()).isEqualTo(userResponseEntity.getBody().getMessage());
		
		assertThat(userResponse.getStatusCode()).isEqualTo(userResponseEntity.getBody().getStatusCode());

	}

	

	
}
