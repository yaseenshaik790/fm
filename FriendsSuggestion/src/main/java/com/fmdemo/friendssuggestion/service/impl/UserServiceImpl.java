package com.fmdemo.friendssuggestion.service.impl;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fmdemo.friendssuggestion.dto.UserDTO;
import com.fmdemo.friendssuggestion.entity.User;
import com.fmdemo.friendssuggestion.exception.UserAlreadyExcistException;
import com.fmdemo.friendssuggestion.repository.UserRepository;
import com.fmdemo.friendssuggestion.response.UserResponse;
import com.fmdemo.friendssuggestion.service.api.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	public UserResponse addMember(UserDTO userDTO) {

		Optional<User> user = userRepository.findByUserName(userDTO.getUserName());

		if (user.isPresent()) {
			throw new UserAlreadyExcistException(userDTO.getUserName());
		}
		User userDetails = new User();
		BeanUtils.copyProperties(userDTO, userDetails);
		userRepository.save(userDetails);

		return new UserResponse("Member added successfully ", 7676);
	}

}
