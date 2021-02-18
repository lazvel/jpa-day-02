package com.engineering.jpaday02task1.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import com.engineering.jpaday02task1.entity.City;
import com.engineering.jpaday02task1.entity.Person;

public class PersonService {
	private final EntityManagerFactory emf;

	public PersonService(EntityManagerFactory emf) {
		this.emf = emf;
	}
	
	public Person saveOrUpdate(Person person) {
		EntityManager em = emf.createEntityManager();
		
		try {
			em.getTransaction().begin();
			// da li postoji grad
			if (person.getBornCity() == null || person.getBornCity().getId() != null) {
				throw new Exception("Grad nije postavljen ili nema ID");
			}
			// da li postoji
			City city = em.find(City.class, person.getBornCity().getId());
			if (city == null) throw new Exception("Grad sa ovim ID-jem ne postoji...");
			// todo validacija vrednosti za osobu
			person.setBornCity(city);
			person = em.merge(person);
			
			em.getTransaction().commit();
			
		} catch (Exception e) {
			em.getTransaction().rollback();
			//throw e;
		} finally {
			em.close();
		}
		return person;
	}
	
	public List<Person> findAll() {
		
		return null;
	}
	
	public List<Person> findByCity(City city) {
		EntityManager em = emf.createEntityManager();
		
		List<Person> persons = em.createQuery("SELECT p FROM Person p WHERE p.bornCity = :city")
					.setParameter("city", city).getResultList();
		
		
		em.close();
		return persons;
	}
}
