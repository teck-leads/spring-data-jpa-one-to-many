package com.techleasds.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techleasds.app.model.UserDTO;
import com.techleasds.app.repository.FriendRepository;
import com.techleasds.app.repository.UserDTORepository;

@Service
public class UserService {
	@Autowired
	private UserDTORepository userDTORepository;
	@Autowired
	private FriendRepository friendRepository;

	public UserDTO saveUser(UserDTO userDTO) {
		UserDTO saved = userDTORepository.save(userDTO);
		return saved;
	}
	
	public UserDTO findUserById( Integer id) {
		Optional<UserDTO> findById = userDTORepository.findById(id);
		return findById.isPresent()==true?findById.get():new UserDTO();
	}
	
	public List<UserDTO> findAllUsers() {
		List<UserDTO> findAll = userDTORepository.findAll();
		return findAll;
		
	}
	
	public void deleteUserById(Integer id) {
		userDTORepository.deleteById(id);
	}
	

}
