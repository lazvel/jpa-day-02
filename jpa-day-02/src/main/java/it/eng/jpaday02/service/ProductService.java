package it.eng.jpaday02.service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import it.eng.jpaday02.entity.Product;

public class ProductService {
	private EntityManagerFactory emf;
	
	public ProductService(EntityManagerFactory emf) {
		this.emf = emf;
	}
	
	public void saveOrUpdate(Product product) throws Exception {
		EntityManager em = emf.createEntityManager();
		// ako ima id, proizvod mora da postoji u bazi
		if (product.getId() != null)  {
			Product existingProduct = em.find(Product.class, product.getId());
			if (existingProduct == null) throw new Exception("Prosledjen entitet ne postoji u bazi");
		}
		em.getTransaction().begin();
		em.merge(product);
		em.getTransaction().commit();
		
		
		em.close();
	}
}
