package com.onlineVotingSystem.service;

import java.util.Scanner;

import org.hibernate.Session;

public interface CandidateServicelayer {
	void updateCandidate(Session session,Scanner scanner);
	void insertCandidate(Session session, Scanner scanner);
	void deleteCandidate(Session session, Scanner scanner);
	void getAllCandidate(Session session);
	public void getCandidate(Session session, Scanner scanner);

}
