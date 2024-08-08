package com.onlineVotingSystem.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Voter")

public class Voter {
	@Id
	//@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer voterId;
	@Column(name = "userName")
	private String userName;
	@Column(name = "qualification")
	private String qualification;
	@Column(name = "phoneNumber")
	private Integer phoneNumber;
	@Column(name = "password")
	private String password;
	@Column(name = "email")
	private String email;
	@Column(name = "fullName")
	private String fullName;
	@Column(name = "address")
	private String address;
	
	@OneToMany(mappedBy="voter")
	private List<Vote> vote;
}
