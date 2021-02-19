package it.eng.jpaday02;

import javax.persistence.Persistence;

import it.eng.jpaday02.entity.Manufacturer;
import it.eng.jpaday02.entity.Product;
import it.eng.jpaday02.entity.ProductCategory;
import it.eng.jpaday02.service.ProductService;

public class StartProduct {
	private final ProductService productService;
	
	public StartProduct() {
		productService = new ProductService(Persistence.createEntityManagerFactory("JPADay02"));
	}
	
	public static void main(String[] args) {
		StartProduct startProduct = new StartProduct();
		startProduct.save();
	}

	private void save() {
		Manufacturer manufacturer = new Manufacturer();
		manufacturer.setId(17L);
		
		Product product = new Product();
		product.setId(2L);
		product.setName("proizvod - 2");
		
		product.setManufacturer(manufacturer);
		
		// product.getCategories().clear(); // ocisti celu listu
		
		product.addCategory(new ProductCategory(1L, "kategorija - 1"));
		//product.addCategory(new ProductCategory(4L, "kategorija - 4"));
		//product.addCategory(new ProductCategory(3L, "kategorija - 3"));
		product.addCategory(new ProductCategory(2L, "kategorija - 2"));
		try {
			productService.saveOrUpdate(product);
			System.out.println("Proizvod je uspesno sacuvan");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
