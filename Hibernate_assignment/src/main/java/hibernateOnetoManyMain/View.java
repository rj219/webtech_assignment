package hibernateOnetoManyMain;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import hibernateOnetoManyModel.Category;
import hibernateOnetoManyModel.Product;

public class View {
		
		public static void main(String[] args) {
			
			SessionFactory sf = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Category.class).addAnnotatedClass(Product.class).buildSessionFactory();
			
			Session s = sf.openSession();
			
			Transaction tx = null;
			
			tx = s.beginTransaction();
			
			List<Category> c = s.createQuery("from Category").list();
			
			
			
			for(Category cat : c)
			{
				System.out.println(cat.getId()+" "+cat.getName());
				List<Product> p = cat.getProduct();
				for(Product pro : p)
				{
					System.out.println(pro.getId()+" "+pro.getName());
				}
			}
			
		}
}
