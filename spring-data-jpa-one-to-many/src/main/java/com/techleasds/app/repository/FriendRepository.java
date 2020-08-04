package com.techleasds.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.techleasds.app.model.Friend;

@Repository
public interface FriendRepository extends JpaRepository<Friend, Integer>{

	
}
