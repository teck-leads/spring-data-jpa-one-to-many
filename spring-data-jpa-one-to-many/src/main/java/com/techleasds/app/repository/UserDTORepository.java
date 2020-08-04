package com.techleasds.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.techleasds.app.model.UserDTO;

@Repository
public interface UserDTORepository extends JpaRepository<UserDTO, Integer> {

}
