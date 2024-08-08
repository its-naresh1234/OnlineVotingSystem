package com.onlineVotingSystem.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;



import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Candidate")
public class Candidate {
	@Id
	//@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer candidateId;
	
	@Column(name = "name",nullable=false)
	private String name;
	@Column(name = "password")
	private String password;
	@Column(name = "qualification")
	private String qualification;
	@Column(name = "age",nullable=false)
	private Integer age;
	@Column(name = "division",nullable=false)
	private String division;
	
	
	@Column(name = "partyAffiliation")
	private String partyAffiliation;
	

	
	@ManyToOne
	@JoinColumn(name="electionId")
	private Election election;

}
