package it.eng.jpaday02.service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import it.eng.jpaday02.entity.City;
import it.eng.jpaday02.entity.ContactPerson;
import it.eng.jpaday02.entity.Manufacturer;

public class ManufacturerService {
	private EntityManagerFactory emf;
	
	public ManufacturerService(EntityManagerFactory emf) {
		this.emf = emf;
	}
	
	// manufacturer ima vezu sa city
	public Manufacturer save(Manufacturer manufacturer) {
		EntityManager em = emf.createEntityManager();
		// city postoji
//		try {
//			em.getTransaction().begin();
//			// bolje metoda merge jer sam siguran da obj koji dobijem ima svoj id
//			em.persist(manufacturer);
//			em.getTransaction().commit();
//			System.out.println("ID: " + manufacturer.getId());
//			return manufacturer;
//		} catch (Exception e) {
//			em.getTransaction().getRollbackOnly();
//			throw e;
//		} finally {
//			em.close();
//		}
		// city ne postoji
		try {
			em.getTransaction().begin();
			// bolje metoda merge jer sam siguran da obj koji dobijem ima svoj id
			City city = em.find(City.class, manufacturer.getCity().getNumber());
			if (city == null) {
				em.persist(manufacturer.getCity());
			}
			
			manufacturer = em.merge(manufacturer);
			
			// cuvanje kontakt osoba
			for (ContactPerson contactPerson: manufacturer.getContactPersons()) {
				contactPerson.setManufacturerId(manufacturer.getId());
				em.merge(contactPerson);
			}
			
			em.getTransaction().commit();
			System.out.println("ID: " + manufacturer.getId());
			return manufacturer;
		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().getRollbackOnly();
			throw e;
		} finally {
			em.close();
		}
	}
}
