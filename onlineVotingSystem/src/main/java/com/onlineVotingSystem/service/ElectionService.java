package com.onlineVotingSystem.service;

import java.util.Scanner;

import org.hibernate.Session;

public interface ElectionService {
	void getAllElection(Session session);
	void insertElection(Session session, Scanner scanner);
	void deleteElection(Session session, Scanner scanner);
	void updateElection(Session session, Scanner scanner);
	public void getElection(Session session, Scanner scanner);

}
