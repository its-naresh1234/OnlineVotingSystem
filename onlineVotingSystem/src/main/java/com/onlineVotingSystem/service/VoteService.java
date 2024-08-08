package com.onlineVotingSystem.service;

import java.util.Scanner;

import org.hibernate.Session;

public interface VoteService {
	void getAllVote(Session session);
	void insertVote(Session session, Scanner scanner);
	void deleteVOte(Session session, Scanner scanner);
	public void getVote(Session session, Scanner scanner);

}
