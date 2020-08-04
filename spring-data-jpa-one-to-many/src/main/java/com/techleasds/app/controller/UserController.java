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

import com.techleasds.app.model.UserDTO;
import com.techleasds.app.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping("/user")
	public ResponseEntity<UserDTO> saveUser(@RequestBody UserDTO userDTO) {
		UserDTO addUser = userService.saveUser(userDTO);
		return new ResponseEntity<>(addUser, HttpStatus.OK);
	}

	@GetMapping("/user/{id}")
	public ResponseEntity<UserDTO> findUserById(@PathVariable("id") Integer id) {
		UserDTO user = userService.findUserById(id);
		return new ResponseEntity<>(user, HttpStatus.OK);
	}
	
	@GetMapping("/user")
	public ResponseEntity<List<UserDTO>> findAllUsers() {
		List<UserDTO> findAllUsers = userService.findAllUsers();
		return new ResponseEntity<>(findAllUsers, HttpStatus.OK);
	}
	
	@DeleteMapping("/user/{id}")
	public ResponseEntity<?> deleteUserById(@PathVariable("id") Integer id) {
		userService.deleteUserById(id);
		return new ResponseEntity<>("deleted", HttpStatus.OK);
	}


}
