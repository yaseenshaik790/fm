package com.fmdemo.friendssuggestion.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Table(name = "friends")
@Entity
@Data
public class Friend implements Serializable {
	/**
	* 
	*/
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "friend_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long friendId;

	@Column(name = "user_id")
	private Long userId;

}
