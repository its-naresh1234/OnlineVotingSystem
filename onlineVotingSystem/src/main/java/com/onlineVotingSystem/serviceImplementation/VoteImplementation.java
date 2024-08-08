package com.onlineVotingSystem.serviceImplementation;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.onlineVotingSystem.entity.Candidate;
import com.onlineVotingSystem.entity.Election;
import com.onlineVotingSystem.entity.Vote;
import com.onlineVotingSystem.entity.Voter;
import com.onlineVotingSystem.service.VoteService;

public class VoteImplementation implements VoteService {
	Session session;
	Scanner scanner;
	@Override
	public void getAllVote(Session session) {
		this.session = session;
		Query  createQuery = session.createQuery("from Vote");
		List<Vote> list = createQuery.list();
		for (Vote vote: list)
			System.out.println(vote);
		this.session.close();
		
	}

	@Override
	public void insertVote(Session session, Scanner scanner) {
		
		this.scanner = scanner;
		this.session = session;

		Vote vote = new Vote();
		System.out.println("Enter values of Vote:voterId ");
		Voter voter = session.get(Voter.class, scanner.nextInt());
		vote.setVoter(voter);
		System.out.println("Enter values of Vote:candidateId ");
		Candidate candidate = session.get(Candidate.class, scanner.nextInt());
		vote.setCandidate(candidate);
		System.out.println("Enter values of Vote:ElectionId ");
		Election election = session.get(Election.class, scanner.nextInt());
		vote.setElection(election);
		session.persist(vote);
		session.beginTransaction().commit();
		
	}

	@Override
	public void deleteVOte(Session session, Scanner scanner) {

		System.out.println("enter values of Vote: id");
		this.scanner = scanner;
		this.session = session;
		Vote vote = new Vote();
		
		vote.setVotingId(scanner.nextInt());
		session.delete(vote);
		session.beginTransaction().commit();
		this.session.close();
		
	}

	@Override
	public void getVote(Session session, Scanner scanner) {
		System.out.println("enter value Vote: votingId");
		this.scanner = scanner;
		this.session = session;
		int votingId = scanner.nextInt();
		Vote vote = session.get(Vote.class, votingId);
		System.out.println(vote);
		
	}

}
