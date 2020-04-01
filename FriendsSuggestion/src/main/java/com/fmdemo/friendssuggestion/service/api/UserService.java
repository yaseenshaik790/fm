package com.fmdemo.friendssuggestion.service.api;

import com.fmdemo.friendssuggestion.dto.FriendsRequest;
import com.fmdemo.friendssuggestion.dto.UserDTO;
import com.fmdemo.friendssuggestion.response.FriendResponse;
import com.fmdemo.friendssuggestion.response.UserResponse;

public interface UserService {

	UserResponse addMember(UserDTO userDTO);

	FriendResponse addFriends(FriendsRequest friendsRequest);

}
