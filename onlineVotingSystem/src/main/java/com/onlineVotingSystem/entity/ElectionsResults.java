package com.onlineVotingSystem.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
@Table(name = "ElectionsResults")
public class ElectionsResults {
	@Id
	//@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer resultId;
	
	@OneToOne
	@JoinColumn(name="electionId")
	private  Election election;
	
}
