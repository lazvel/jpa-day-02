package it.eng.jpaday02.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import it.eng.jpaday02.entity.City;

public class CityService {
	private EntityManagerFactory emf;
	
	public CityService(EntityManagerFactory emf) {
		this.emf = emf;
	}
	
	public void save(City city) throws Exception {
		// TODO VALIDATION
		EntityManager em = emf.createEntityManager();
		
		try {
			City existingCity = em.find(City.class, city.getNumber());
			if (existingCity == null) throw new Exception("Grad sa tim brojem vec postoji!");
				
			em.getTransaction().begin();
			em.persist(city);
			em.getTransaction().commit();

			System.out.println("Grad je sacuvan");
		} catch (Exception e) {
			em.getTransaction().rollback(); // ovde je greska(ceo blok)
			System.out.println("Error: " + e.getMessage());
			
			// throw e;
			throw new Exception("Grad nije uspesno sacuvan!");
		} finally {
			em.close();
		}
	}
	
	public void printAllNativeQuery() {
		EntityManager em = emf.createEntityManager();
		List<Object[]> cities = em.createNativeQuery("SELECT * FROM City").getResultList();
		for (Object[] el : cities) {
			System.out.println(el[0] + "\t" + el[1]);
		}
		
		em.close();
	}
	
	public void printAllNativeQueryMap() {
		EntityManager em = emf.createEntityManager();
		List<City> cities = em.createNativeQuery("SELECT * FROM City", City.class).getResultList();
		for (City city : cities) {
			System.out.println(city);
		}
		
		em.close();
	}
	
	//JPQL
	public void printAll() {
		EntityManager em = emf.createEntityManager(); // JPQL CITY -> CASE SENSITIVE jer ovde radimo sa nazivom klasa
		List<City> cities = em.createQuery("SELECT c FROM City c").getResultList();
		for (City city : cities) {
			System.out.println(city);
		}
		
		em.close();
	}
	
	// u klasi smo definisali named query
	public void printAllNamedQuery() {
		EntityManager em = emf.createEntityManager(); // JPQL CITY -> CASE SENSITIVE jer ovde radimo sa nazivom klasa
		List<City> cities = em.createNamedQuery("City.findAllOrderByName").getResultList();
		for (City city : cities) {
			System.out.println(city);
		}
		
		em.close();
	}
}
