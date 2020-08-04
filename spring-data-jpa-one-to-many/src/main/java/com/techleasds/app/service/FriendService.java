package com.techleasds.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.techleasds.app.model.Friend;
import com.techleasds.app.model.UserDTO;
import com.techleasds.app.repository.FriendRepository;
import com.techleasds.app.repository.UserDTORepository;

@Service
public class FriendService {
	@Autowired
	private UserDTORepository userDTORepository;

	@Autowired
	private FriendRepository friendRepository;
	
	public Friend saveUser( Friend friend, Integer userId) {
		Optional<UserDTO> findById = userDTORepository.findById(userId);
		if(findById.isPresent()) {
			UserDTO userDTO = findById.get();
			friend.setUser(userDTO);
		}
		Friend saved = friendRepository.save(friend);
		return saved;
	}
	
	public List<Friend> findAllFriends() {
		List<Friend> findAll = friendRepository.findAll();
		return findAll;
		
	}
	
	public Friend findFriendById(Integer id) {
		Optional<Friend> findById = friendRepository.findById(id);
		return findById.isPresent()==true?findById.get():new Friend();
	}
	public String  deleteUserById(@PathVariable("id") Integer id) {
		
		if(friendRepository.findById(id).isPresent()) {
			friendRepository.deleteById(id);
			return "Deleted";
		}
		return "Not deleted";
	}

	
}
