package com.techleasds.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.techleasds.app.model.Friend;
import com.techleasds.app.service.FriendService;

@RestController
public class FriendController {
	
	@Autowired
	private FriendService friendService;

	@PostMapping("/friend")
	public ResponseEntity<Friend> saveUser(@RequestBody Friend friend) {
		Friend friendSaved = friendService.saveUser(friend, friend.getFriendId());
		return new ResponseEntity<>(friendSaved, HttpStatus.OK);
	}
	
	@GetMapping("/friend")
	public ResponseEntity<List<Friend>> findAllFriends() {
		List<Friend> findAllFriends = friendService.findAllFriends();
		return new ResponseEntity<>(findAllFriends, HttpStatus.OK);
	}
	


	@GetMapping("/friend/{id}")
	public ResponseEntity<Friend> findFriendById(@PathVariable("id") Integer id) {
		Friend friend = friendService.findFriendById(id);
		return new ResponseEntity<>(friend, HttpStatus.OK);
	}
	
	@DeleteMapping("/friend/{id}")
	public ResponseEntity<?> deleteUserById(@PathVariable("id") Integer id) {
		String status = friendService.deleteUserById(id);
		return new ResponseEntity<>(status, HttpStatus.OK);
	}


	
}
