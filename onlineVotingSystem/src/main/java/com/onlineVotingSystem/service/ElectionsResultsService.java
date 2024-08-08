package com.onlineVotingSystem.service;

import java.util.Scanner;

import org.hibernate.Session;

public interface ElectionsResultsService {
	void updateElectionsResultsService(Session session);
	void insertElectionsResultsService(Session session, Scanner scanner);
	void deleteElectionsResultsService(Session session, Scanner scanner);
	public void getElectionsResultsService(Session session, Scanner scanner);

}
