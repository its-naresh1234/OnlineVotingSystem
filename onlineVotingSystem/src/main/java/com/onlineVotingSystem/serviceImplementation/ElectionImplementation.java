package com.onlineVotingSystem.serviceImplementation;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.onlineVotingSystem.entity.Election;
import com.onlineVotingSystem.entity.Voter;
import com.onlineVotingSystem.service.ElectionService;

public class ElectionImplementation implements ElectionService {
	Session session;
	Scanner scanner;

	@Override
	public void getAllElection(Session session) {
		this.session = session;
		Query createQuery = session.createQuery("from election");
		List<Election> list = createQuery.list();
		for (Election election : list)
			System.out.println(election);
		this.session.close();

	}

	@Override
	public void insertElection(Session session, Scanner scanner) {
		System.out.println("Enter values of Election:id,startdate,endDate,title");
		this.scanner = scanner;
		this.session = session;

		Election election = new Election();
		System.out.println("enter electionId");
		election.setElectionId(scanner.nextInt());
		System.out.println("enter startdate");
        election.setStartDate(scanner.next());
		System.out.println("enter enddate");
		election.setEndDtae(scanner.next());
		System.out.println("enter title");
		election.setTitle(scanner.next());

		session.saveOrUpdate(election);
		session.beginTransaction().commit();

	}

	@Override
	public void deleteElection(Session session, Scanner scanner) {
		System.out.println("enter values of Voter: id");
		this.scanner = scanner;
		this.session = session;
		Election election = new Election();

		election.setElectionId(scanner.nextInt());
		session.delete(election);
		session.beginTransaction().commit();
		this.session.close();

	}

	@Override
	public void getElection(Session session, Scanner scanner) {
		System.out.println("enter value election: electionId");
		this.scanner = scanner;
		this.session = session;
		int electionId = scanner.nextInt();
		Election election = session.get(Election.class, electionId);
		System.out.println(election);

	}

	@Override
	public void updateElection(Session session, Scanner scanner) {
		System.out.println("enter value election: electionId");

		this.scanner = scanner;
		this.session = session;
		int electionId = scanner.nextInt();
		Election election = session.get(Election.class, electionId);
		System.out.println("for Update enter start and end Dates:");
		election.setStartDate(scanner.next());
		election.setEndDtae(scanner.next());
		session.saveOrUpdate(election);

	}

}
