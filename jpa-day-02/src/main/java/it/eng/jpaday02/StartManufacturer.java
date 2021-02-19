package it.eng.jpaday02;

import javax.persistence.Persistence;

import it.eng.jpaday02.entity.City;
import it.eng.jpaday02.entity.ContactPerson;
import it.eng.jpaday02.entity.Manufacturer;
import it.eng.jpaday02.service.ManufacturerService;

public class StartManufacturer {
	private final ManufacturerService manufacturerService;
	
	public StartManufacturer() {
		manufacturerService = new ManufacturerService(Persistence.createEntityManagerFactory("JPADay02"));
	}
	
	public static void main(String[] args) {
		StartManufacturer startManufacturer = new StartManufacturer();
		//startManufacturer.save("proizvodjac - 2", 37000L, "Krusevac");
		
		startManufacturer.saveWithContactPersons(); //  ovu metodu prostudirati
		
		//  startManufacturer.findById();
	}

	private void save(String manufacturerName, long cityNumber, String cityName) {
		City city = new City(cityNumber, cityName);
		Manufacturer manufacturer = new Manufacturer();
		
		manufacturer.setName(manufacturerName);
		manufacturer.setCity(city);
		
		try {
			manufacturer = manufacturerService.save(manufacturer);
			System.out.println("Proizvodjac je sacuvan");
			System.out.println(manufacturer);
		} catch (Exception e) {
			System.out.println("MAIN greska: " + e.getMessage());
		}
		
	}

	private void saveWithContactPersons() {
		City city = new City();
		city.setNumber(11000L);
		Manufacturer manufacturer = new Manufacturer();
		//manufacturer.setId(20L);
		manufacturer.setName("Proizvodjac sa kontakt osobama");
		manufacturer.setCity(city);
		//manufacturer.getContactPersons().clear();
		//System.out.println("MAIN: broj kontakt osoba nakon brisanja: " + manufacturer.getContactPersons().size());
		
		manufacturer.getContactPersons().add(new ContactPerson("Zozi", "Zox"));
		manufacturer.getContactPersons().add(new ContactPerson("Jano", "Janoh"));
		manufacturer.getContactPersons().add(new ContactPerson("Sofi", "Sofix"));
		
		try {
			manufacturer = manufacturerService.save(manufacturer);
			System.out.println("Sacuvan je proizvodjac sa svim kontakt osobama");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void findById() {
		try {
			Manufacturer manufacturer = manufacturerService.findById(20L);
			System.out.println(manufacturer);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
