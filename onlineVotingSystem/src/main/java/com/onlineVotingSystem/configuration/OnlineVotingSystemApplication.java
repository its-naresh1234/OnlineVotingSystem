package com.onlineVotingSystem.configuration;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.internal.build.AllowSysOut;

import com.onlineVotingSystem.entity.Admin;
import com.onlineVotingSystem.entity.Candidate;
import com.onlineVotingSystem.entity.Election;
import com.onlineVotingSystem.entity.ElectionsResults;
import com.onlineVotingSystem.entity.Vote;
import com.onlineVotingSystem.entity.Voter;
import com.onlineVotingSystem.serviceImplementation.AdminImplementation;
import com.onlineVotingSystem.serviceImplementation.CandidateImplementation;
import com.onlineVotingSystem.serviceImplementation.ElectionImplementation;
import com.onlineVotingSystem.serviceImplementation.ElectionsResultsImplementation;
import com.onlineVotingSystem.serviceImplementation.VoteImplementation;
import com.onlineVotingSystem.serviceImplementation.VoterImplementation;
import com.onlineVotingSystem.utility.PasswordMissMatchException;

public class OnlineVotingSystemApplication {
	public static void main(String args[]) {
		SessionFactory sFactory = ConfigurationUtility.getSessionFactory();
		Session session = null;
		AdminImplementation adminImp = new AdminImplementation();
		VoterImplementation voterImp = new VoterImplementation();
		CandidateImplementation candidateImp = new CandidateImplementation();
		ElectionImplementation electionImp = new ElectionImplementation();
		VoteImplementation voteImp = new VoteImplementation();
		ElectionsResultsImplementation electionResultsImp = new ElectionsResultsImplementation();
		Scanner scanner = new Scanner(System.in);
		while (true) {
			System.out.println("----------WELL-COME TO THE ONLINE VOTING APPLICATION--------------");
			System.out.println("1.Register as Voter 2.Login as Voter 3.Login as Admin 4.Login as CAndidate"
					+ " 5.Exist Application");
			System.out.println("Enter your optiion");
			switch (scanner.nextInt()) {
			case 1:
				session = sFactory.openSession();
				voterImp.insertVoter(session, scanner);
				break;
			case 2:
				session = sFactory.openSession();
				try {
					voterImp.getVoter(session, scanner);
				} catch (PasswordMissMatchException e) {
					System.out.println(e);

				}
				System.out.println("1.update voter Details 2.Get Election Details 3.vote");
				switch (scanner.nextInt()) {
				case 1:
					session = sFactory.openSession();
					voterImp.updateVoter(session, scanner);
					break;
				case 2:
					session = sFactory.openSession();
					electionImp.getAllElection(session);
					break;
				case 3:
					session = sFactory.openSession();
					voteImp.insertVote(session, scanner);

				default:
					System.out.println("INVALID OPTION");
				}
				break;

			case 3:
				session = sFactory.openSession();
				try {
					adminImp.getAdmin(session, scanner);
				} catch (PasswordMissMatchException e) {
					System.out.println(e);

				}
				System.out.println("select Optiions for Upadting ");
				System.out.println(
						"1.rigester New Candidate\n 2.Delete candidate\n 3.Update Candidate 4.update election \n 5.Exit from updating");
				switch (scanner.nextInt()) {
				case 1:
					session = sFactory.openSession();
					candidateImp.insertCandidate(session, scanner);
					break;
				case 2:
					session = sFactory.openSession();
					candidateImp.deleteCandidate(session, scanner);
					break;
				case 3:
					session = sFactory.openSession();
					candidateImp.updateCandidate(session, scanner);
					break;

				case 4:
					System.out.println("1.insert data into election 2.update data in election");

					switch (scanner.nextInt()) {
					case 1:
						session = sFactory.openSession();
						electionImp.insertElection(session, scanner);
						break;
					case 2:
						session = sFactory.openSession();
						electionImp.updateElection(session, scanner);
						break;
					default:
						System.out.println("YOU ENTERED INVALID OPTION");
						break;
					}

				case 5:
					System.out.println("Exiting from updating.........");
					System.exit(0);
				}
				break;
			case 4:
				session = sFactory.openSession();
				candidateImp.getCandidate(session, scanner);
				System.out.println("1.Get Election Details");
				switch (scanner.nextInt()) {
				case 1:
					session = sFactory.openSession();
					electionImp.getAllElection(session);
					break;
				}
				break;
			case 5:
				System.out.println("You are Exiting from Application.........");
				System.exit(0);
				break;
			default:
				System.out.println("You are entered INVALID option");
				break;
			}
		}

	}
}
