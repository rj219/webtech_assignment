package com.hibernatemain;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.hibernatemodel.Address;
import com.hibernatemodel.Student;

public class delete {
	
	public static void main(String[] args) {
		
		SessionFactory sf = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).addAnnotatedClass(Address.class).buildSessionFactory();
		Session s = sf.openSession();
		
		Transaction tx = s.beginTransaction();
		
		Address address = s.load(Address.class, 2);
		//Student student = s.load(Student.class, 1);
		
		s.delete(address);
		
		tx.commit();
		
	}

}
