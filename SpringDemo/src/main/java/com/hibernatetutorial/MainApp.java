package com.hibernatetutorial;

import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class MainApp {

	public static void main(String[] args) throws SecurityException, RollbackException, HeuristicMixedException,
			HeuristicRollbackException, SystemException {
		System.out.println("This is hibernate tutorial.");

		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("/com/hibernatetutorial/hibernate.cfg.xml").build();
		Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();

		SessionFactory factory = meta.getSessionFactoryBuilder().build();

		//Configuration c=new Configuration("");
		//SessionFactory factory = c.buildSessionFactory();
		
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		

		Employee e1 = new Employee();
		e1.setId(2);
		e1.setFirstName("Admin");
		e1.setLastName("admin");
		session.save(e1);
		t.commit();
		System.out.println("Data saved successfully.");
		factory.close();
		session.close();

	}

}
