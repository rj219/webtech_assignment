package hibernatemanytomanymain;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import hibernateManytomanymodel.Reader;
import hibernateManytomanymodel.Subscription;

public class Add {
	
	public static void main(String[] args) {
		
		SessionFactory sf = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Reader.class).addAnnotatedClass(Subscription.class).buildSessionFactory();
		
		Session s = sf.openSession();
		
		Transaction tx = null;
		
		tx = s.beginTransaction();
		
		Reader r = new Reader();
		r.setFirstname("Janak");
		r.setLastname("Rathod");
		r.setEmail("jdrathod@gmail.com");
		
		Reader r1 = new Reader();
		r1.setFirstname("Mannat");
		r1.setLastname("Kareliya");
		r1.setEmail("mannat@gmail.com");
		
		Subscription s1 = new Subscription();
		s1.setName("mayank");
		s1.addReader(r);
		s1.addReader(r1);
		
		s.save(r);
		s.save(r1);
		s.save(s1);
		
		
		tx.commit();
		
		
		
	}
	

}
