package com.techleasds.app.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Friend {

	@Id
	private int friendId;
	private String friendName;
	private String friendMail;
	private double individualAmount;
	private String balanceStatus;
	@JsonIgnoreProperties(value = {"friends"})
	@ManyToOne
	private UserDTO user;

	
}
