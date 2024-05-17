package hibernateOnetoManyModel;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "HibernateCategory")
public class Category {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	@Column(name = "name")
	private String name;
	
	@OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
	List<Product> product;

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public List<Product> getProduct() {
		return product;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setProduct(List<Product> product) {
		this.product = product;
	}
	
	
}
