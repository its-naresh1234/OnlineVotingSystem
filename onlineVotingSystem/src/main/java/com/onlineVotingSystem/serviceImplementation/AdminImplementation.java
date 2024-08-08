package com.onlineVotingSystem.serviceImplementation;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.onlineVotingSystem.entity.Admin;
import com.onlineVotingSystem.entity.Voter;
import com.onlineVotingSystem.service.AdminService;
import com.onlineVotingSystem.utility.PasswordMissMatchException;

public class AdminImplementation implements AdminService{
	Session session;
	Scanner scanner;
	@Override
	public void updateAdmin(Session session) {
		System.out.println("enter value Admin: adminId");
		this.scanner = scanner;
		this.session = session;
		int adminId = scanner.nextInt();
		Admin admin = session.get(Admin.class, adminId);
		System.out.println("update admin userName:");
		admin.setUserName(scanner.next());
		System.out.println("update admin password");
		admin.setPassword(scanner.next());
		System.out.println("update admin email");
		admin.setEmail(scanner.next());
		System.out.println("update admin fullName:");
		admin.setFullName(scanner.next());
		
	}

	@Override
	public void insertAdmin(Session session, Scanner scanner) {
		System.out.println("Enter values of Admin:id ,username,password,email,fullname");
		this.scanner = scanner;
		this.session = session;

		Admin admin = new Admin();
        System.out.println("enter adminId");
		admin.setAdminId(scanner.nextInt());
		 System.out.println("enter userName");
		admin.setUserName(scanner.next());
		 System.out.println("enter apassword");
		admin.setPassword(scanner.next());
		 System.out.println("enter email");
		admin.setEmail(scanner.next());
		 System.out.println("enter fullName");
		admin.setFullName(scanner.next());
		
	
	

		session.saveOrUpdate(admin);
		session.beginTransaction().commit();
		
	}

	@Override
	public void deleteAdmin(Session session, Scanner scanner) {
		System.out.println("enter values of Admin: id");
		this.scanner = scanner;
		this.session = session;
		Admin admin = new Admin();
		
		admin.setAdminId(scanner.nextInt());
		session.delete(admin);
		session.beginTransaction().commit();
		this.session.close();
		
	}

	@Override
	public void getAdmin(Session session, Scanner scanner) throws PasswordMissMatchException{
		System.out.println("enter value Admin: adminId");
		this.scanner = scanner;
		this.session = session;
		int adminId = scanner.nextInt();
		System.out.println("eneter adimn password");
		String  password1=scanner.next();
		Admin admin = session.get(Admin.class, adminId);
		if(password1.equals(admin.getPassword()))
		
			System.out.println("Login is successfull");
		else 
			
			throw new PasswordMissMatchException("password missmatch");
		System.out.println(admin);

		
	}

	
}
