package br.com.dvb.jaxrs.model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Cart {
	
	private Long id;
	private List<Product> products = new ArrayList<>();
	private User user;
	
	public Cart() {
		// TODO Auto-generated constructor stub
	}

	public Cart add(Product product) {
		products.add(product);
		return this;
	}
	
	public Cart to(User user) {
		this.user = user;
		return this;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public void removeProduct(Long productId) {
		for (int i = 0; i < products.size(); i++){
			Product p = products.get(i);
			if (p.getId() == productId) {
				products.remove(i);
			}
		}
	}

}
