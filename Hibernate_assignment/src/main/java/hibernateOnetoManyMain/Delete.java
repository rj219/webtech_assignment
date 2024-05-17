package hibernateOnetoManyMain;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import hibernateOnetoManyModel.Category;
import hibernateOnetoManyModel.Product;

public class Delete {
	
	public static void main(String[] args) {
		
		SessionFactory sf = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Category.class).addAnnotatedClass(Product.class).buildSessionFactory();
		Session s = sf.openSession();
		Transaction tx = null;
		
		tx = s.beginTransaction();
		
		//Product pro = s.load(Product.class, 1);
		Category c = s.load(Category.class, 1);
		s.delete(c);
		
		tx.commit();
	}

}
