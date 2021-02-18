package com.engineering.jpaday02task1.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import com.engineering.jpaday02task1.entity.City;

public class CityService {
	private final EntityManagerFactory emf;
	
	public CityService(EntityManagerFactory emf) {
		this.emf = emf;
	}
	
	public City saveOrUpdate(City city) throws Exception {
		EntityManager em = emf.createEntityManager();
		
		try {
			em.getTransaction().begin();
			if (city.getId() == null) {
				// sacuvaj samo pod uslovom da grad sa tim brojem ne postoji
				List<City> cities = em.createQuery("SELECT c FROM City c WHERE c.number = :number")
					.setParameter("number", city.getNumber()).getResultList();
				if (cities.size() == 0) em.persist(city);
				else throw new Exception("Grad sa tim ptt-om vec postoji!");
			} else {
				City existingCity = em.find(City.class, city.getId());
				if (existingCity == null) throw new Exception("Grad sa ovim ID-jem ne postoji");
				city = em.merge(city);
			}
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
			throw  e;
		} finally {
			em.close();
		}
		return city;
		
	}
}
