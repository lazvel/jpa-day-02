package it.eng.jpaday022.service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import it.eng.jpaday022.entity.City;


public class CityService {
	private EntityManagerFactory emf;
	
	public CityService(EntityManagerFactory emf) {
		super();
		this.emf = emf;
	}

	public void save(City city) throws Exception {
		EntityManager em = emf.createEntityManager();
		
		try {
			City existingCity = em.find(City.class, city.getNumber());
			if (existingCity == null) throw new Exception("Grad sa tim brojem vec postoji!");
				
			em.getTransaction().begin();
			em.persist(city);
			em.getTransaction().commit();

			System.out.println("Grad je sacuvan");
		} catch (Exception e) {
			em.getTransaction().rollback();
			System.out.println("Error: " + e.getMessage());
			
			// throw e;
			throw new Exception("Grad nije uspesno sacuvan!");
		} finally {
			em.close();
		}
	}
}
