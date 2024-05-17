package hibernatemanytomanymain;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import hibernateManytomanymodel.Reader;
import hibernateManytomanymodel.Subscription;

public class Delete {

	public static void main(String[] args) {
		
		SessionFactory sf = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Reader.class).addAnnotatedClass(Subscription.class).buildSessionFactory();
		
		Session s = sf.openSession();
		
		Transaction tx = null;
		
		tx = s.beginTransaction();
		
		Subscription r = s.load(Subscription.class, 1);
		
		s.delete(r);
		
		tx.commit();
	}
	
}
