package com.onlineVotingSystem.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Election")

public class Election {
	@Id
	//@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer electionId;
	@Column(name = "title")
	private String title;
	@Column(name = "startDate")
	private String startDate;
	@Column(name = "endDtae")
	private String endDtae;
	
	@OneToMany(mappedBy="election")
	private List<Candidate> candidate;
	
	@OneToOne(mappedBy="election")
	private ElectionsResults electionsResults;
}
