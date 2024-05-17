package hibernateOnetoManyMain;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import hibernateOnetoManyModel.Category;
import hibernateOnetoManyModel.Product;

public class Add {
	
	public static void main(String[] args) {
		
		SessionFactory sf = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Product.class).addAnnotatedClass(Category.class).buildSessionFactory();
		Session s = sf.openSession();
		Transaction tx = null;
		tx = s.beginTransaction();
		
		Category cat = new Category();
		cat.setName("Clothes");
		
		//Category c = s.load(Category.class, 1);
		
		Product p1 = new Product();
		p1.setName("Shirt");
		p1.setCategory(cat);
		
		Product p2 = new Product();
		p2.setName("T-Shirt");
		p2.setCategory(cat);
		
		Product p3 = new Product();
		p3.setName("Cap");
		p3.setCategory(cat);
		
		s.save(cat);
		s.save(p1);
		s.save(p2);
		s.save(p3);
		
		tx.commit();
	}

}
