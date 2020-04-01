package com.fmdemo.friendssuggestion.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fmdemo.friendssuggestion.entity.Friend;

@Repository
public interface FriendRepository extends JpaRepository<Friend, Long> {

}
