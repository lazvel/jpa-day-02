package it.eng.jpaday022.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import it.eng.jpaday02.entity.City;
import it.eng.jpaday022.entity.Person;

public class PersonService {
	private EntityManagerFactory emf;

	public PersonService(EntityManagerFactory emf) {
		this.emf = emf;
	}
	
	public void printAll() {
		EntityManager em = emf.createEntityManager();
		List<Person> persons = em.createQuery("SELECT p FROM Person p").getResultList();
		for (Person person : persons) {
			System.out.println(person);
		}
		
		em.close();
	}
}
