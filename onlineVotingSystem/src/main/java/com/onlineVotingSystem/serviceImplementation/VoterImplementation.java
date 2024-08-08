package com.onlineVotingSystem.serviceImplementation;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.mysql.cj.exceptions.PasswordExpiredException;
import com.onlineVotingSystem.entity.Voter;
import com.onlineVotingSystem.service.VoterServicelayer;
import com.onlineVotingSystem.utility.PasswordMissMatchException;

public class VoterImplementation implements VoterServicelayer {
	Session session;
	Scanner scanner;

	@Override
	public void updateVoter(Session session,Scanner scanner) {
		System.out.println("enter value Voter: voterId");
		this.scanner = scanner;
		this.session = session;
		int voterId = scanner.nextInt();
		Voter voter = session.get(Voter.class, voterId);
		System.out.println("update voter userName");
		voter.setUserName(scanner.next());
		System.out.println("update voter password");
		voter.setPassword(scanner.next());
		System.out.println("update voter FullName:");
		voter.setFullName(scanner.next());
		System.out.println("update voter Qualification:");
		voter.setQualification(scanner.next());
		System.out.println("update voter phoneNumber");
		voter.setPhoneNumber(scanner.nextInt());
		System.out.println("update voter email:");
		voter.setEmail(scanner.next());
		System.out.println("update voter Address");
		voter.setAddress(scanner.next());
		
		session.saveOrUpdate(voter);
		session.beginTransaction().commit();

	}

	@Override
	public void insertVoter(Session session, Scanner scanner) {
		System.out
				.println("Enter values of Voter:id,username,password,email,fullname,address,phnNumber,qualification ");
		this.scanner = scanner;
		this.session = session;

		Voter voter = new Voter();
		System.out.println("enter id");
		voter.setVoterId(scanner.nextInt());
		System.out.println("enter name");
		voter.setUserName(scanner.next());
		System.out.println("enter password");
		voter.setPassword(scanner.next());
		System.out.println("enter email");
		voter.setEmail(scanner.next());
		System.out.println("enter full name");
		voter.setFullName(scanner.next());
		System.out.println("enter address");
		voter.setAddress(scanner.next());
		System.out.println("enter phnumber");
		voter.setPhoneNumber(scanner.nextInt());
		System.out.println("enter qualification");
		voter.setQualification(scanner.next());

		session.saveOrUpdate(voter);
		session.beginTransaction().commit();

	}

	@Override
	public void deleteVoter(Session session, Scanner scanner) {
		// TODO Auto-generated method stub

		System.out.println("enter values of Voter: id");
		this.scanner = scanner;
		this.session = session;
		Voter voter = new Voter();

		voter.setVoterId(scanner.nextInt());
		session.delete(voter);
		session.beginTransaction().commit();
		this.session.close();

	}

	@Override
	public void getVoter(Session session, Scanner scanner) throws PasswordMissMatchException{

		System.out.println("enter value Voter: voterId");
		this.scanner = scanner;
		this.session = session;
		int voterId = scanner.nextInt();
		System.out.println("enter password:");
		String password1=scanner.next();
		Voter voter = session.get(Voter.class, voterId);
		if(password1.equals(voter.getPassword())) {
		
			System.out.println("Login is successfull");
		}
		else {
			
			throw new PasswordMissMatchException("password missmatch");
		}System.out.println(voter);

	}

	@Override
	public void getAllVoter(Session session, Scanner scanner) {
		this.session = session;
		Query createQuery = session.createQuery("from Voter");
		List<Voter> list = createQuery.list();
		for (Voter voter : list)
			System.out.println(voter);
		this.session.close();
		
	}

}
