package Dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import model.Student;

public class Studentdao {

	SessionFactory sf = null;

	public Studentdao() {

		sf = new Configuration().configure("hibernate.cfg.xml").
				addAnnotatedClass(Student.class).
				buildSessionFactory();

	}

	public int addOrupdate(Student std) {
		
		int i = 0;
		
		Transaction tx = null;
		
		Session s = sf.openSession();
		
		tx = s.beginTransaction();
		s.saveOrUpdate(std);
		i = 1;
		tx.commit();
		
		
		return i;
	}

	public List<Student> viewallStudent() {
		
		List<Student> st = new ArrayList();
		
		Transaction tx = null;
		
		Session s = sf.openSession();
		
		tx = s.beginTransaction();
		
		st = s.createQuery("from Student").list();
		tx.commit();
		
		return st;
	}

	public Student loginChk(Student s) {
		
		Session session = sf.openSession();
		Student st=null;
		Transaction tx = null;
		
		try {
			tx = session.beginTransaction();
			st = (Student) session.createQuery("from Student where email="+s.getEmail()+" and pass="+s.getPass()+"");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return st;
	}

	

	

	
	}
	
	


