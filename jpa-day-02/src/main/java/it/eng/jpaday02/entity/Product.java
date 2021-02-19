package it.eng.jpaday02.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Product implements Serializable{
	private static final long serialVersionUID = 19022021120500L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	
	@ManyToOne
	@JoinColumn(name = "manufacturer_id")
	private Manufacturer manufacturer;
	// ukoliko taj proizvod ima listu kategorija, zelim da sacuvam ili apdejtujem sve kategorije kojima pripada taj proizvod
	
	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinTable(name = "product_product_category", 
			joinColumns = @JoinColumn(name = "product_id"),
			inverseJoinColumns = @JoinColumn(name = "category_id")
			)
	private Set<ProductCategory> categories;
	
	public Product() {
		categories = new HashSet<ProductCategory>();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Manufacturer getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(Manufacturer manufacturer) {
		this.manufacturer = manufacturer;
	}

	public Set<ProductCategory> getCategories() {
		return categories;
	}

	public void setCategories(Set<ProductCategory> categories) {
		this.categories = categories;
	}
	
	public void addCategory(ProductCategory productCategory) {
		categories.add(productCategory);
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", manufacturer=" + manufacturer + ", categories=" + categories
				+ "]";
	}

}
