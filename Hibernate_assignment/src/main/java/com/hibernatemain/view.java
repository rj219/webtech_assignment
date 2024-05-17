package com.hibernatemain;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.hibernatemodel.Address;
import com.hibernatemodel.Student;

public class view {
	
	public static void main(String[] args) {
		
		
		SessionFactory sf = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).addAnnotatedClass(Address.class).buildSessionFactory();
		
		Session s = sf.openSession();
		
		Transaction tx = null;
		
		tx = s.beginTransaction();
		
		List<Student> list = s.createQuery("from Student").list();
		
		for(Student student : list)
		{
			System.out.println(student.getId()+" "+student.getName());
			Address address = student.getAddress();
			System.out.println(address.getId()+" "+address.getAddress()+" "+address.getCity()+" "+address.getState()+" "+address.getStreet()+" "+address.getZipcode());
		}
		
	}
	
	

}
