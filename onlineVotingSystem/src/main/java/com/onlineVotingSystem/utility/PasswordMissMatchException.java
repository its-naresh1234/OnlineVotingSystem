package com.onlineVotingSystem.utility;

public class PasswordMissMatchException extends Exception {
	String message;

	public PasswordMissMatchException(String message) {
		super(message);
		this.message = message;
	}
	

}
