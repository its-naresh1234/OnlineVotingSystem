package com.onlineVotingSystem.configuration;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class ConfigurationUtility {
	static SessionFactory getSessionFactory() {
		StandardServiceRegistry service = new StandardServiceRegistryBuilder().configure("onlineVotingSystem.con.xml")
				.build();

		Metadata meta = new MetadataSources(service).getMetadataBuilder().build();

		SessionFactory sFactory = meta.buildSessionFactory();

		// Session session = sFactory.openSession();
		return sFactory;

	}
}
