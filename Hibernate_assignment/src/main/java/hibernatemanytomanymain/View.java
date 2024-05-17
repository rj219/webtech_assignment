package hibernatemanytomanymain;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import hibernateManytomanymodel.Reader;
import hibernateManytomanymodel.Subscription;

public class View {
	
	public static void main(String[] args) {
		
		SessionFactory sf = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Reader.class).addAnnotatedClass(Subscription.class).buildSessionFactory();
		
		Session s = sf.openSession();
		
		Transaction tx = null;
		
		tx = s.beginTransaction();
		
		List<Reader> list = s.createQuery("from Reader").list();
		
		for(Reader reader : list)
		{
			System.out.println(reader.getId()+" "+reader.getFirstname()+" "+reader.getLastname()+" "+reader.getEmail());
			List<Subscription> subscriptions = reader.getSubscriptions();
			for(Subscription sub : subscriptions)
			{
				System.out.println(sub.getId()+" "+sub.getName());
			}
		}
		
	}

}
