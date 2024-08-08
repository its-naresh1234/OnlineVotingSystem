package com.onlineVotingSystem.service;

import java.util.Scanner;

import org.hibernate.Session;

import com.onlineVotingSystem.utility.PasswordMissMatchException;

public interface AdminService {
	void updateAdmin(Session session);
	void insertAdmin(Session session, Scanner scanner);
	void deleteAdmin(Session session, Scanner scanner);
	public void getAdmin(Session session, Scanner scanner)throws PasswordMissMatchException;
}
