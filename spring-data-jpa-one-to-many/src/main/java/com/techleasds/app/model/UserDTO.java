package com.techleasds.app.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = {"friends"})
public class UserDTO {


	@Id
	private int userId;
	private String userName;
	private String emailId;
	private double totalBalance;
	private String balanceStatus;
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	private List<Friend> friends = new ArrayList<>();;
	
	
}
