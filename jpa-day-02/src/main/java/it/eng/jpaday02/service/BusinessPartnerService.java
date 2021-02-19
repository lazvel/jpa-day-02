package it.eng.jpaday02.service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import it.eng.jpaday02.entity.partner.BusinessPartner;

public class BusinessPartnerService {
private EntityManagerFactory emf;
	
	public BusinessPartnerService(EntityManagerFactory emf) {
		this.emf = emf;
	}
	
	public BusinessPartner saveOrUpdate(BusinessPartner businessPartner) throws Exception {
		EntityManager em = emf.createEntityManager();
		
		try {
			// ako poslovni partner ima ID i ako postoji radimo merge
			if (businessPartner.getId() != null) {
				BusinessPartner existingPartner = em.find(BusinessPartner.class, businessPartner.getId());
				if (existingPartner == null) throw new Exception("U sistemu ne postoji Partner sa tim ID-jem");
			}
			em.getTransaction().begin();
			businessPartner = em.merge(businessPartner);
			em.getTransaction().commit();
			
			return businessPartner;
		} catch (Exception e) {
			throw e;
		} finally {
			em.close();
		}
		
	}
}
