package it.eng.jpaday02;

import javax.persistence.Persistence;

import it.eng.jpaday02.entity.City;
import it.eng.jpaday02.service.CityService;

public class StartCity {
	private final CityService cityService;
	
	public StartCity() {
		cityService = new CityService(Persistence.createEntityManagerFactory("JPADay02"));
	}
	
    public static void main( String[] args ) {
    	StartCity startCity = new StartCity();
    	//startCity.save(11000L, "Beograd");
    	startCity.printAll();
    }

	private void save(long number, String name) {
		try {
			cityService.save(new City(number, name));
			System.out.println("Main: uspesno izvrsena save metoda...");
		} catch (Exception e) {
			System.out.println("Main: greska -> " + e.getMessage());
		}
	}
	
	private void printAll() {
		cityService.printAllNativeQuery();
		System.out.println("================================");
		cityService.printAllNativeQueryMap();
		System.out.println("================================");
		cityService.printAll();
		System.out.println("================================");
		cityService.printAllNamedQuery();
	}
}
