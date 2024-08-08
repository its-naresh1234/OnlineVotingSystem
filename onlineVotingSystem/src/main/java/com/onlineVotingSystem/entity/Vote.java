package com.onlineVotingSystem.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Vote")

public class Vote {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
		private Integer votingId;
		
		 @ManyToOne
		 @JoinColumn(name="voterId")
		 private Voter voter;
		 
		 @ManyToOne
		 @JoinColumn(name="candidateId")
		 private Candidate candidate;
		 
		 @ManyToOne
		 @JoinColumn(name="electionId")
		 private Election election;
}
