package com.onlineVotingSystem.serviceImplementation;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.onlineVotingSystem.entity.ElectionsResults;
import com.onlineVotingSystem.entity.Voter;
import com.onlineVotingSystem.service.ElectionsResultsService;

public class ElectionsResultsImplementation implements ElectionsResultsService{
	Session session;
	Scanner scanner;
	@Override
	public void updateElectionsResultsService(Session session) {
			this.session = session;
			Query  createQuery = session.createQuery("from Electionsresults");
			List<ElectionsResultsService> list = createQuery.list();
			for (ElectionsResultsService electionsResultsService: list)
				System.out.println(electionsResultsService);
			this.session.close();
		
	}
	@Override
	public void insertElectionsResultsService(Session session, Scanner scanner) {
		System.out.println("Enter values ofElectionsResults:id ");
		this.scanner = scanner;
		this.session = session;

		ElectionsResults electionsResults = new ElectionsResults();

		electionsResults.setResultId(scanner.nextInt());

		session.saveOrUpdate(electionsResults);
		session.beginTransaction().commit();
		
	}
	@Override
	public void deleteElectionsResultsService(Session session, Scanner scanner) {
		System.out.println("enter values of ElectionsResults: id");
		this.scanner = scanner;
		this.session = session;
		ElectionsResults electionsResults = new ElectionsResults();
		
		electionsResults.setResultId(scanner.nextInt());
		session.delete(electionsResults);
		session.beginTransaction().commit();
		this.session.close();
		
	}
	@Override
	public void getElectionsResultsService(Session session, Scanner scanner) {
		System.out.println("enter value ElectionsResults:Id");
		this.scanner = scanner;
		this.session = session;
		int resultId = scanner.nextInt();
		ElectionsResults electionsResults = session.get(ElectionsResults.class, resultId);
		System.out.println(electionsResults);
		
	}
	
	

}
