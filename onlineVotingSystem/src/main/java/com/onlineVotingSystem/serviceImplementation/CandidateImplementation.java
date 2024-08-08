package com.onlineVotingSystem.serviceImplementation;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.onlineVotingSystem.entity.Candidate;
import com.onlineVotingSystem.entity.Election;
import com.onlineVotingSystem.entity.Voter;
import com.onlineVotingSystem.service.CandidateServicelayer;

public class CandidateImplementation implements CandidateServicelayer{
	Session session;
	Scanner scanner;
	@Override
	public void updateCandidate(Session session,Scanner scanner) {
		this.scanner = scanner;
		this.session = session;
		System.out.println("enter value Candidate:candidateId");
		int candidateId = scanner.nextInt();
		Candidate candidate = session.get(Candidate.class, candidateId);
		System.out.println("Upadate candidate name:");
		candidate.setName(scanner.next());
		System.out.println("Upadate candidate age:");
		candidate.setAge(scanner.nextInt());
		System.out.println("Upadate candidate qualification:");
		candidate.setQualification(scanner.next());
		System.out.println("Upadate candidate qualification:");
		candidate.setDivision(scanner.next());
		System.out.println("Upadate candidate password");
		candidate.setPassword(scanner.next());
		
		session.saveOrUpdate(candidate);
		session.beginTransaction().commit();
		
		
	}

	@Override
	public void insertCandidate(Session session, Scanner scanner) {
		System.out.println("Enter values of Candidate:id,name,setPartyAffiliation,age,Qualification,division,electionid ");
		this.scanner = scanner;
		this.session = session;

		Candidate candidate = new Candidate();
         System.out.println("eneter id");
		candidate.setCandidateId(scanner.nextInt());
		  System.out.println("eneter password");
		  candidate.setPassword(scanner.next());
		System.out.println("eneter name");
		candidate.setName(scanner.next());
		System.out.println("eneter party affi");
		candidate.setPartyAffiliation(scanner.next());
		System.out.println("eneter age");
		candidate.setAge(scanner.nextInt());
		System.out.println("eneter qualification");
		candidate.setQualification(scanner.next());
		System.out.println("eneter division");
		candidate.setDivision(scanner.next());
		System.out.println("enter value electionId");
		Election election = session.get(Election.class, scanner.nextInt());
		
        candidate.setElection(election);
        
        election.getCandidate().add(candidate);
		session.saveOrUpdate(candidate);
		session.saveOrUpdate(election);
		session.beginTransaction().commit();
		
	}

	@Override
	public void deleteCandidate(Session session, Scanner scanner) {
		System.out.println("Enter values of Candidate: id");
		this.scanner = scanner;
		this.session = session;
		Candidate candidate = new Candidate();
		
		candidate.setCandidateId(scanner.nextInt());
		session.delete(candidate);
		session.beginTransaction().commit();
		this.session.close();
		
	}

	@Override
	public void getCandidate(Session session, Scanner scanner) {
		System.out.println("enter value Candidate:candidateId");
		this.scanner = scanner;
		this.session = session;
		int candidateId = scanner.nextInt();
		Candidate candidate = session.get(Candidate.class, candidateId);
		System.out.println(candidate);
		
	}

	@Override
	public void getAllCandidate(Session session) {

		this.session = session;
		Query  createQuery = session.createQuery("from Candidate");
		List<Candidate> list = createQuery.list();
		for (Candidate candidate: list)
			System.out.println(candidate);
		this.session.close();
		
	}
	

}
