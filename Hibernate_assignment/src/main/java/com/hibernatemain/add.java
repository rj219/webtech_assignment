package com.hibernatemain;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.hibernatemodel.Address;
import com.hibernatemodel.Student;

public class add {
	
	public static void main(String[] args) {
		
		SessionFactory sf = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).addAnnotatedClass(Address.class).buildSessionFactory();
		
		Session s = sf.openSession();
		
		Transaction tx = null;
		
		tx = s.beginTransaction();
		

		Address address = new Address();
		address.setAddress("Lake-201");
		address.setCity("Surat");
		address.setStreet("Mota-varachha");
		address.setState("Gujrat");
		address.setZipcode("395006");
		
		Student student = new Student();
		student.setName("mayank");
		student.setAddress(address);
		
		s.save(student);
		
		tx.commit();
		
		
	}

}
