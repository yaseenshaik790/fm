package com.fmdemo.friendssuggestion.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.fmdemo.friendssuggestion.dto.FriendDTO;
import com.fmdemo.friendssuggestion.dto.FriendsRequest;
import com.fmdemo.friendssuggestion.dto.UserDTO;
import com.fmdemo.friendssuggestion.entity.Friend;
import com.fmdemo.friendssuggestion.entity.User;
import com.fmdemo.friendssuggestion.exception.FriendRequestNotFoundException;
import com.fmdemo.friendssuggestion.exception.UserAlreadyExcistException;
import com.fmdemo.friendssuggestion.exception.UserNotFoundException;
import com.fmdemo.friendssuggestion.repository.FriendRepository;
import com.fmdemo.friendssuggestion.repository.UserRepository;
import com.fmdemo.friendssuggestion.response.FriendResponse;
import com.fmdemo.friendssuggestion.response.UserResponse;
import com.fmdemo.friendssuggestion.service.api.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private FriendRepository friendRepository;

	private static Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

	public UserResponse addMember(UserDTO userDTO) {
		logger.info("save the member");
		Optional<User> user = userRepository.findByUserName(userDTO.getUserName());

		if (user.isPresent()) {
			logger.warn("user is already exist ");
			throw new UserAlreadyExcistException(userDTO.getUserName());
		}
		User userDetails = new User();
		BeanUtils.copyProperties(userDTO, userDetails);
		userRepository.save(userDetails);
		logger.info("member added successfully");
		return new UserResponse("Member added successfully ", 7676);
	}

	public FriendResponse addFriends(FriendsRequest friendsRequest) {
		Optional<User> user = userRepository.findByUserName(friendsRequest.getUserName());

		if (!user.isPresent()) {
			logger.warn("user doesn't exist ");
			throw new UserNotFoundException(friendsRequest.getUserName());
		}

		List<FriendDTO> friendDTOs = friendsRequest.getFriends();

		if (CollectionUtils.isEmpty(friendDTOs)) {
			throw new FriendRequestNotFoundException();
		}

		List<Friend> friends = friendDTOs.stream().map(friend -> {
			Friend dto = new Friend();
			BeanUtils.copyProperties(friend, dto);
			return dto;
		}).collect(Collectors.toList());

		Friend[] friendDetails = friends.stream().toArray(Friend[]::new);

		for (int index = 0; index < friendDetails.length; index++) {
			Friend friend = friendDetails[index];
			friend.setUserId(user.get().getUserId());
			friendRepository.save(friend);
		}
		user.get().setMutualFriends(friendsRequest.getFriends().size());
		userRepository.save(user.get());
		logger.info("friends added successfully");

		return new FriendResponse("Friends saved Successfully", 6878);
	}

}
