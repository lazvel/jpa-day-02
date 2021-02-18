package it.eng.jpaday02;

import javax.persistence.Persistence;

import it.eng.jpaday02.entity.City;
import it.eng.jpaday02.entity.Manufacturer;
import it.eng.jpaday02.service.ManufacturerService;

public class StartManufacturer {
	private final ManufacturerService manufacturerService;
	
	public StartManufacturer() {
		manufacturerService = new ManufacturerService(Persistence.createEntityManagerFactory("JPADay02"));
	}
	
	public static void main(String[] args) {
		StartManufacturer startManufacturer = new StartManufacturer();
		startManufacturer.save("proizvodjac - 2", 37000L, "Krusevac");
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
}
