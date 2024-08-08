package com.onlineVotingSystem.service;

import java.util.Scanner;

import org.hibernate.Session;

import com.onlineVotingSystem.utility.PasswordMissMatchException;

public interface VoterServicelayer {
	void updateVoter(Session session,Scanner scanner);
	void insertVoter(Session session, Scanner scanner);
	void deleteVoter(Session session, Scanner scanner);
	void getAllVoter(Session session, Scanner scanner);
	public void getVoter(Session session, Scanner scanner)throws PasswordMissMatchException;
	
}
