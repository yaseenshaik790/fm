package com.fmdemo.friendssuggestion.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.fmdemo.friendssuggestion.controller.TestData;
import com.fmdemo.friendssuggestion.dto.FriendDTO;
import com.fmdemo.friendssuggestion.dto.FriendsRequest;
import com.fmdemo.friendssuggestion.dto.UserDTO;
import com.fmdemo.friendssuggestion.entity.Friend;
import com.fmdemo.friendssuggestion.entity.User;
import com.fmdemo.friendssuggestion.repository.FriendRepository;
import com.fmdemo.friendssuggestion.repository.UserRepository;
import com.fmdemo.friendssuggestion.response.UserResponse;
import com.fmdemo.friendssuggestion.service.api.UserService;

@SpringBootTest
public class UserServiceTest {

	@Autowired
	private UserService userService;

	@MockBean
	private UserRepository userRepository;

	@MockBean
	private FriendRepository friendRepository;

	User user;
	Friend friend;
	UserDTO userDto;

	FriendsRequest friendRequest;

	List<FriendDTO> friends;
	FriendDTO friendDto;

	@BeforeEach
	public void setUp() {
		user = new User();
		user.setUserName(TestData.userName);
		user.setFullName(TestData.fullName);

		userDto = new UserDTO();
		userDto.setFullName(TestData.fullName);

		friend = new Friend();
		friend.setUserId(TestData.userId);

		friendDto = new FriendDTO();
		friendDto.setUserName(TestData.userName);

		friends = new ArrayList<>();
		friends.add(friendDto);

		friendRequest = new FriendsRequest();
		friendRequest.setFriends(friends);
		friendRequest.setUserName(TestData.userName);
	}

	@Test
	public void addMemberPositiveTest() {

		when(userRepository.findById(TestData.userId)).thenReturn(Optional.empty());

		UserResponse response = new UserResponse("Member added successfully ", 7676);

		UserResponse userResponse = userService.addMember(userDto);

		assertThat(userResponse.getMessage()).isEqualTo(response.getMessage());
		assertThat(userResponse.getStatusCode()).isEqualTo(response.getStatusCode());

	}

}
