package com.fmdemo.friendssuggestion.dto;

import java.util.List;

import lombok.Data;

@Data
public class FriendsRequest {

	private String userName;

	private List<FriendDTO> friends;

}
