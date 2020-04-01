package com.fmdemo.friendssuggestion.dto;

import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class UserDTO {

	@NotNull(message = "user name required")
	private String userName;
	
	@NotNull(message = "full name required")
	private String fullName;
	
	@NotNull(message = "gender required")
	private String gender;
}
