package it.eng.jpaday02;

import javax.persistence.Persistence;

import it.eng.jpaday02.entity.partner.BusinessPartner;
import it.eng.jpaday02.entity.partner.LegalEntity;
import it.eng.jpaday02.entity.partner.NaturalEntity;
import it.eng.jpaday02.service.BusinessPartnerService;
import it.eng.jpaday02.service.CityService;

public class StartBusinessPartner {
	private final BusinessPartnerService businessPartnerService;
	
	public StartBusinessPartner() {
		businessPartnerService = new BusinessPartnerService(Persistence.createEntityManagerFactory("JPADay02"));
	}

	public static void main(String[] args) {
		StartBusinessPartner startBusinessPartner = new StartBusinessPartner();
		startBusinessPartner.saveOrUpdate();
	}

	private void saveOrUpdate() {
		//BusinessPartner businessPartner = new LegalEntity(null, "12345678", "12345678", "Petak d.o.o");
		BusinessPartner businessPartner = new NaturalEntity(null, "012345678", "Mika", "Mikic");
		
		try {
			businessPartner = businessPartnerService.saveOrUpdate(businessPartner);
			System.out.println("Partner je sacuvan i ima ID: " + businessPartner.getId());
		} catch (Exception e) {
			e.printStackTrace();
		}
				
	}

}
